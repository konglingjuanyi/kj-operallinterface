package com.chengfeng.ne.basicInterface.service.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.binding.corba.wsdl.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chengfeng.common.util.CommonEnums.SiteID;
import com.chengfeng.common.util.PinYinUtil;
import com.chengfeng.common.util.ValidateUtil;
import com.chengfeng.ne.basedata.dao.AccountDAO;
import com.chengfeng.ne.basedata.dao.IAreaDao;
import com.chengfeng.ne.basedata.dao.ICityDao;
import com.chengfeng.ne.basedata.dao.IDeptDao;
import com.chengfeng.ne.basedata.dao.IDictDao;
import com.chengfeng.ne.basedata.dao.IEmployeeDao;
import com.chengfeng.ne.basedata.dao.IJobDao;
import com.chengfeng.ne.basedata.dao.ISiteDao;
import com.chengfeng.ne.basedata.dao.ISiteDetailDao;
import com.chengfeng.ne.basedata.domain.AccountVO;
import com.chengfeng.ne.basedata.domain.BasicAreaVO;
import com.chengfeng.ne.basedata.domain.BasicCityVO;
import com.chengfeng.ne.basedata.domain.BasicCountryVO;
import com.chengfeng.ne.basedata.domain.BasicCountyVO;
import com.chengfeng.ne.basedata.domain.BasicDeptJobVO;
import com.chengfeng.ne.basedata.domain.BasicDeptVO;
import com.chengfeng.ne.basedata.domain.BasicDictVO;
import com.chengfeng.ne.basedata.domain.BasicEmployeeVO;
import com.chengfeng.ne.basedata.domain.BasicJobVO;
import com.chengfeng.ne.basedata.domain.BasicProvinceVO;
import com.chengfeng.ne.basedata.domain.BasicSiteDetailVO;
import com.chengfeng.ne.basedata.domain.BasicSiteVO;
import com.chengfeng.ne.basedata.domain.User;
import com.chengfeng.ne.basedata.service.ICountryService;
import com.chengfeng.ne.basedata.service.ICountyService;
import com.chengfeng.ne.basedata.service.IProvinceService;
import com.chengfeng.ne.basedata.service.ISiteService;
import com.chengfeng.ne.basicInterface.dao.IBasicInterfaceDao;
import com.chengfeng.ne.basicInterface.service.IBasicInterfaceService;
import com.thinkjf.service.ServiceException;
/**
 * 接口测试
 * <p>功能描述：</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author FengQing
 * @version 1.0 2015-8-21 下午6:05:31
 */
@Service("basicInterfaceService")
public class BasicInterfaceServiceImpl implements IBasicInterfaceService {

	@Autowired
	private ICountryService countryService;
	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private ICountyService countyService;
	@Autowired
	private ISiteService siteService;
	@Resource
	private IDictDao dictDao;
	@Resource 
	private ICityDao cityDao;
	@Resource
	private IAreaDao areaDao;
	@Autowired
	private IBasicInterfaceDao basicInterfaceDao;
	@Resource(name = "jobDao")
	private IJobDao jobDao;
	@Resource(name = "fin_accountDAO")
	private AccountDAO accountDAO;
	/**
	 * @content:add redis mechanism
	 * @author :add by Jeff on 2016-01-12
	 * -------start-------
	 */
	@Resource(name = "siteDao")
	private ISiteDao siteDao;
	
	@Resource(name = "siteDetailDao")
	private ISiteDetailDao siteDetailDao;
	
	@Resource(name = "deptDao")
	private IDeptDao deptDao;
	
	@Resource(name = "employeeDao")
	private IEmployeeDao employeeDao;

	/**
	 * --------end----------
	 */
	
	private final Log log= LogFactory.getLog(getClass());
	
	/**
	 * 发送请求
	 */
	@Override
	public String sendRequest(String data, String url) throws ServiceException {
		final List<NameValuePair> nameValueList = new ArrayList<NameValuePair>();
		// 接口调用的请求格式
		nameValueList.add(new NameValuePair(
				"param", data));
		HttpClientParams httpClientParams = new HttpClientParams();
		httpClientParams.setConnectionManagerTimeout(1000);
		final HttpClient httpClient = new HttpClient(httpClientParams, new SimpleHttpConnectionManager(true));
		final PostMethod postMethod = new PostMethod(url);
		postMethod.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		postMethod.setRequestBody(nameValueList
				.toArray(new NameValuePair[nameValueList.size()]));
		postMethod.addRequestHeader("Connection", "close");
		String result = "";
		try {
			try {
				httpClient.executeMethod(postMethod);
				result = postMethod.getResponseBodyAsString();
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String str = result;
			log.info("返回结果："+str);
			return str;
		} finally {
			postMethod.releaseConnection();
		}

	}

	/**
	 * 解析网点数据
	 */
	public List<String> parserSiteInfo(String params) throws ServiceException{
		//如果响应成功则解析，否则返回信息
		JSONArray jsonArray = JSONArray.fromObject(params);
		Map<String,String> map = new HashMap<String,String>();
		List<String> errList = new ArrayList<String>(); 
		String siteCode = "";
		for(int i=0;i<jsonArray.size();i++){
			try {
			JSONObject info=jsonArray.getJSONObject(i);
			//创建网点和网点明细对象
			BasicSiteVO site = new BasicSiteVO();
			BasicSiteDetailVO detailSite = new BasicSiteDetailVO();
			//获取网点信息
			siteCode = info.getString("SITE_CODE");
			String siteName = info.getString("SITE_NAME");
			String parentSiteCode = info.getString("PARENT_SITE_CODE");
			String scanCenterSiteCode = info.getString("SCAN_CENTER_SITE_CODE");
			String billCenterSiteCode = info.getString("BILL_CENTER_SITE_CODE");
			String siteTypeName = info.getString("SITE_TYPE_NAME");
			Double codLimitAmount = info.getDouble("COD_LIMIT_AMOUNT");
			Double podLimitAmount = info.getDouble("POD_LIMIT_AMOUNT");
			Integer siteStatus = info.getInt("SITE_STATUS");
			String moneyTypeName = info.getString("MONEY_TYPE_NAME");
			String countryName = info.getString("COUNTRY_NAME");
			String provinceName = info.getString("PROVINCE_NAME");
			String cityName = info.getString("CITY_NAME");
			String countyName = info.getString("COUNTY_NAME");
			String address = info.getString("ADDRESS");
			String areaName = info.getString("AREA_NAME");
			Integer siteservicesType = info.getInt("SITE_SERVICES_TYPE");
			Integer rdStatus = info.getInt("RD_STATUS");
			//如果参数中有首分拨中心编号,则设置首分拨中心
			if(info.toString().contains("FIRST_CENTER_SITE_CODE")){
				String firstCenterSiteCode= info.getString("FIRST_CENTER_SITE_CODE");
			   //设置首分拨中心
				map.put("siteCode", firstCenterSiteCode==null?"":firstCenterSiteCode);
				List<BasicSiteVO> firstSiteList = siteDao.querySiteByTotal(map);
				if(firstSiteList!=null && firstSiteList.size()>0 ){
					site.setFirstCenterSiteId(firstSiteList.get(0).getSiteId());
				}
			}
			
			
			//如果是总部，退出本次循环,不进行处理
			if("88888".equals(siteCode)){
				continue;
			}
			
			if(("".equals(siteCode))||("".equals(siteName))){
				continue;
			}
			
			
			//设置网点编号，名称，拼音
			site.setSiteCode(siteCode);
			site.setSiteName(siteName);
			if (!ValidateUtil.isEmpty(siteName)) {
				if (!ValidateUtil.isNumeric(siteName)) {
					String siteNamePinyin = getFirstPinYin(siteName.trim());
					String[] names = siteNamePinyin.split(",");
					if("".equals(names)){
						site.setSitePinyin("/");
					}else{
						site.setSitePinyin(names[0]);
					}
				}else{
					site.setSitePinyin("/");
				}
			}else{
				site.setSitePinyin("/");
			}
			
			
			//设置网点顺序
			Long siteOrder = siteService.getMaxSiteOrder()+1;
			site.setSiteOrder(siteOrder==null?1:siteOrder);
			
			//设置所属站点自动编号
			map.put("siteCode", parentSiteCode);
			List<BasicSiteVO> parentSiteList = siteService.querySiteByTotal(map);
			if(parentSiteList!=null && parentSiteList.size()>0 ){
				site.setParentSiteId(parentSiteList.get(0).getSiteId());
			}else{
				site.setParentSiteId(new Long(0));
			}
			
			//设置扫描结算中心自动编号
			site.setScanCenterSiteId(new Long(2002));
			
			//设置运单财务中心自动编号
			site.setBillCenterSiteId(new Long(2002));
			
			//设置站点类型自动编号
			List<BasicDictVO> dictList = dictDao.queryDictByName(siteTypeName);
			if(dictList!=null && dictList.size()>0){
				site.setSiteTypeId(dictList.get(0).getDictId());
			}else{
				site.setSiteTypeId(new Long(0));
			}
			
			//设置开通站点财务功能
			site.setBlFinance(0);
			
			//设置货到付款，代收付款，航空件金额上限
			site.setPodLimitAmount(podLimitAmount);
			site.setCodLimitAmount(codLimitAmount);
			site.setAirplaneLimitAmount(99999999.99);
			
			//设置站点状态
			site.setSiteState(siteStatus.intValue()==0?1:0);
			
			//设置货币类型ID
			List<BasicDictVO> moneyTypeList = dictDao.queryDictByName(moneyTypeName);
			if(moneyTypeList!=null && moneyTypeList.size()>0){
				site.setMoneyTypeId(moneyTypeList.get(0).getDictId());
			}else{
				site.setMoneyTypeId(new Long(0));
			}
			
			//设置网点星级
			site.setStarLevel(1);
			
			//设置数据状态
			site.setRdStatus(rdStatus);
			
			//设置所属目的网点
			site.setDispSiteId(new Long(0));
			
			
			//设置短信通知号码，传真，邮编，地址
			detailSite.setPhoneSms("/");
			detailSite.setFax("/");
			detailSite.setPostCode("/");
			detailSite.setAddress(address);
			
			//设置国家自动编号
			BasicCountryVO countryVO =  countryService.queryCountryByName(countryName);
			detailSite.setCountryId(countryVO==null?0:countryVO.getCountryId());
			//设置省份自动编号
			BasicProvinceVO provinceVO = provinceService.queryProvinceByName(countryVO==null?0:countryVO.getCountryId(), provinceName);
			if(provinceVO!=null){
				detailSite.setProvinceId(provinceVO.getProvinceId());
			}else{
				detailSite.setProvinceId(new Long(0));
			}
			//设置城市自动编号
			List<BasicCityVO> cityList = cityDao.queryCityByName(cityName);
			Long cityId = null;
			if(cityList.size()>0 && cityList!=null){
				cityId = cityList.get(0).getCityId();
				detailSite.setCityId(cityId==null?0:cityId);
				//设置区县自动编号
				BasicCountyVO countyVO = countyService.queryCountyByNameAndCityId(cityId, countyName);
				detailSite.setCountyId(countyVO==null?0:countyVO.getCountyId());
			}else{
				cityId = new Long(0);
				detailSite.setCityId(cityId);
				//设置区县自动编号
				BasicCountyVO countyVO = countyService.queryCountyByNameAndCityId(cityId, countyName);
				if(countyVO!=null){
					detailSite.setCountyId(countyVO.getCountyId());
				}else{
					detailSite.setCountyId(new Long(0));
				}
			}
		
			//设置片区自动编号
			List<BasicAreaVO> areaList = areaDao.queryAreaByName(areaName);
			if(areaList!=null && areaList.size()>0){
				detailSite.setAreaId(areaList.get(0).getAreaId()==null?0:areaList.get(0).getAreaId());
			}else{
				detailSite.setAreaId(new Long(0));
			}
			
			//设置网站显示
			detailSite.setBlWeb(0);
			//设置正常货物吞吐量(入，出)
			detailSite.setNormalTeuIn(new Long(0));
			detailSite.setNormalTeuOut(new Long(0));
			//设置最大货物吞吐量(入，出)
			detailSite.setMaxTeuIn(new Long(0));
			detailSite.setMaxTeuOut(new Long(0));
			//设置最大留仓件比例
			detailSite.setMaxStayRatio(new Float(0.000));
			//设最大问题件比例
			detailSite.setMaxProblemRatio(new Float(0.000));
			//设置网点服务类型
			detailSite.setSiteServicesType(siteservicesType);
			//货量统计所属分拨中心
			detailSite.setCargoCenterSiteId(new Long(0));
			
			map.put("siteCode", siteCode);
			List<BasicSiteVO> siteList = siteService.querySiteByTotal(map);
			if(siteList!=null && siteList.size()>0){
				//修改数据
				site.setSiteId(siteList.get(0).getSiteId());
				detailSite.setSiteId(siteList.get(0).getSiteId());
				site.setModifiedBy(new Long(0));
				site.setModifiedTime(basicInterfaceDao.getCurrentTime());
//				basicInterfaceDao.doUpdateSiteVO(site, detailSite);
				siteDao.doModifySite(site);
				siteDetailDao.doModifySiteDetail(detailSite);
				
			}else{
				//保存数据到数据库中
				site.setCreatedBy(new Long(0));
				site.setCreatedTime(basicInterfaceDao.getCurrentTime());
				site.setModifiedBy(null);
				site.setModifiedTime(null);
//				basicInterfaceDao.doCreatedSiteVO(site, detailSite);
				Long siteId = siteDao.doCreateSite(site);
				detailSite.setSiteId(siteId);
				siteDetailDao.doCreateSiteDetail(detailSite);
			}
			
			} catch (Exception e) {
				errList.add(siteCode+"原因是："+e.getMessage());
				log.error("[error:网点信息同步失败;]", e);
				continue;
			}
		}
		return errList;
	}
	
	/**
	 * 接收网点信息
	 */
	@Override
	public void getSiteInfo(Date startDate, Date endDate)
			throws ServiceException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //发送请求参数 
		JSONObject obj = new JSONObject();
		obj.put("startDate", sdf.format(startDate));
		obj.put("endDate", sdf.format(endDate));
		String data = obj.toString();
		String url="http://localhost:8080/kj-int/100020.bizservice";
		//接收发送请求后的数据
		String str = sendRequest(data,url);
		
		//定义json对象
		JSONObject  dataJson = JSONObject.fromObject(str);
		//如果响应成功则解析，否则返回信息
		if("200".equals(dataJson.get("code"))){
			Map<String,String> map = new HashMap<String,String>();
			JSONArray jsonArray = dataJson.getJSONArray("data");
			for(int i=0;i<jsonArray.size();i++){
				JSONObject info=jsonArray.getJSONObject(i);
				//获取网点信息
				String siteCode = info.getString("SITE_CODE");
				String siteName = info.getString("SITE_NAME");
				String parentSiteCode = info.getString("PARENT_SITE_CODE");
				String scanCenterSiteCode = info.getString("SCAN_CENTER_SITE_CODE");
				String billCenterSiteCode = info.getString("BILL_CENTER_SITE_CODE");
				String siteTypeName = info.getString("SITE_TYPE_NAME");
				Double codLimitAmount = info.getDouble("COD_LIMIT_AMOUNT");
				Double podLimitAmount = info.getDouble("POD_LIMIT_AMOUNT");
				Integer siteStatus = info.getInt("SITE_STATUS");
				String moneyTypeName = info.getString("MONEY_TYPE_NAME");
				String countryName = info.getString("COUNTRY_NAME");
				String provinceName = info.getString("PROVINCE_NAME");
				String cityName = info.getString("CITY_NAME");
				String countyName = info.getString("COUNTY_NAME");
				String address = info.getString("ADDRESS");
				String areaName = info.getString("AREA_NAME");
				Integer siteservicesType = info.getInt("SITE_SERVICES_TYPE");
				Integer rdStatus = info.getInt("RD_STATUS");
				
				//创建网点和网点明细对象
				BasicSiteVO site = new BasicSiteVO();
				BasicSiteDetailVO detailSite = new BasicSiteDetailVO();
				
				
				//设置网点编号，名称，拼音
				
				site.setSiteCode(siteCode==null?"/":siteCode);
				site.setSiteName(siteName==null?"/":siteName);
				if (!ValidateUtil.isEmpty(siteName)) {
					if (!ValidateUtil.isNumeric(siteName)) {
						String siteNamePinyin = PinYinUtil.getFirstPinYin(siteName.trim());
						String[] names = siteNamePinyin.split(",");
						site.setSitePinyin(names[0]);
					}else{
						site.setSitePinyin("/");
					}
				}else{
					site.setSitePinyin("/");
				}
				
				
				//设置网点顺序
				Long siteOrder = siteService.getMaxSiteOrder()+1;
				site.setSiteOrder(siteOrder==null?1:siteOrder);
				
				//设置所属站点自动编号
				List<BasicSiteVO> parentSiteList = siteService.querySiteByCode(parentSiteCode==null?"/":parentSiteCode);
				if(parentSiteList!=null && parentSiteList.size()>0 ){
					site.setParentSiteId(parentSiteList.get(0).getSiteId());
				}else{
					site.setParentSiteId(new Long(0));
				}
				
				//设置扫描结算中心自动编号
				List<BasicSiteVO> scanCenterSiteList = siteService.querySiteByCode(scanCenterSiteCode==null?"/":scanCenterSiteCode);
				if(scanCenterSiteList!=null && scanCenterSiteList.size()>0){
					site.setScanCenterSiteId(scanCenterSiteList.get(0).getSiteId());
				}else{
					site.setScanCenterSiteId(new Long(0));
				}
				
				//设置运单财务中心自动编号
				List<BasicSiteVO> billCenterSiteList = siteService.querySiteByCode(billCenterSiteCode==null?"/":billCenterSiteCode);
				if(billCenterSiteList!=null && billCenterSiteList.size()>0){
					site.setBillCenterSiteId(billCenterSiteList.get(0).getSiteId());
				}else{
					site.setBillCenterSiteId(new Long(0));
				}
				
				//设置站点类型自动编号
				List<BasicDictVO> dictList = dictDao.queryDictByName(siteTypeName==null?"/":siteTypeName);
				if(dictList!=null && dictList.size()>0){
					site.setSiteTypeId(dictList.get(0).getDictId());
				}else{
					site.setSiteTypeId(new Long(0));
				}
				
				//设置开通站点财务功能
				site.setBlFinance(0);
				
				//设置货到付款，代收付款，航空件金额上限
				site.setPodLimitAmount(podLimitAmount==null?0:podLimitAmount);
				site.setCodLimitAmount(codLimitAmount==null?0:codLimitAmount);
				site.setAirplaneLimitAmount(99999999.99);
				
				//设置站点状态
				site.setSiteState(siteStatus.intValue()==1?0:1);
				
				//设置货币类型ID
				List<BasicDictVO> moneyTypeList = dictDao.queryDictByName(moneyTypeName==null?"/":moneyTypeName);
				if(moneyTypeList!=null && moneyTypeList.size()>0){
					site.setMoneyTypeId(moneyTypeList.get(0).getDictId());
				}else{
					site.setMoneyTypeId(new Long(0));
				}
				
				//设置网点星级
				site.setStarLevel(1);
				
				//设置数据状态
				site.setRdStatus(rdStatus==null?1:rdStatus);
				
				//设置所属目的网点
				site.setDispSiteId(new Long(0));
				
				
				//设置短信通知号码，传真，邮编，地址
				detailSite.setPhoneSms("/");
				detailSite.setFax("/");
				detailSite.setPostCode("/");
				detailSite.setAddress(address==null?"/":address);
				
				//设置国家自动编号
				BasicCountryVO countryVO =  countryService.queryCountryByName(countryName==null?"/":countryName);
				detailSite.setCountryId(countryVO==null?0:countryVO.getCountryId());
				//设置省份自动编号
				BasicProvinceVO provinceVO = provinceService.queryProvinceByName(countryVO==null?0:countryVO.getCountryId(), provinceName==null?"/":provinceName);
				if(provinceVO!=null){
					detailSite.setProvinceId(provinceVO.getProvinceId());
				}else{
					detailSite.setProvinceId(new Long(0));
				}
				//设置城市自动编号
				List<BasicCityVO> cityList = cityDao.queryCityByName(cityName==null?"/":cityName);
				Long cityId = null;
				if(cityList.size()>0 && cityList!=null){
					cityId = cityList.get(0).getCityId();
					detailSite.setCityId(cityId==null?0:cityId);
					//设置区县自动编号
					BasicCountyVO countyVO = countyService.queryCountyByNameAndCityId(cityId, countyName);
					detailSite.setCountyId(countyVO==null?0:countyVO.getCountyId());
				}else{
					cityId = new Long(0);
					detailSite.setCityId(cityId);
					//设置区县自动编号
					BasicCountyVO countyVO = countyService.queryCountyByNameAndCityId(cityId, countyName);
					if(countyVO!=null){
						detailSite.setCountyId(countyVO.getCountyId());
					}else{
						detailSite.setCountyId(new Long(0));
					}
				}
			
				//设置片区自动编号
				List<BasicAreaVO> areaList = areaDao.queryAreaByName(areaName);
				if(areaList!=null && areaList.size()>0){
					detailSite.setAreaId(areaList.get(0).getAreaId()==null?0:areaList.get(0).getAreaId());
				}else{
					detailSite.setAreaId(new Long(0));
				}
				
				//设置网站显示
				detailSite.setBlWeb(0);
				//设置正常货物吞吐量(入，出)
				detailSite.setNormalTeuIn(new Long(0));
				detailSite.setNormalTeuOut(new Long(0));
				//设置最大货物吞吐量(入，出)
				detailSite.setMaxTeuIn(new Long(0));
				detailSite.setMaxTeuOut(new Long(0));
				//设置最大留仓件比例
				detailSite.setMaxStayRatio(new Float(0.000));
				//设最大问题件比例
				detailSite.setMaxProblemRatio(new Float(0.000));
				//设置网点服务类型
				detailSite.setSiteServicesType(siteservicesType==null?1:siteservicesType);
				//货量统计所属分拨中心
				detailSite.setCargoCenterSiteId(new Long(0));
				
				map.put("siteCode", siteCode==null?"/":siteCode);
				List<BasicSiteVO> siteList = siteService.querySiteByTotal(map);
				
				if(siteList!=null && siteList.size()>0){
					//修改数据
					site.setSiteId(siteList.get(0).getSiteId());
					detailSite.setSiteId(siteList.get(0).getSiteId());
					site.setModifiedBy(new Long(0));
					site.setModifiedTime(basicInterfaceDao.getCurrentTime());
//					basicInterfaceDao.doUpdateSiteVO(site, detailSite);
					Long siteId = siteDao.doCreateSite(site);
					detailSite.setSiteId(siteId);
					siteDetailDao.doCreateSiteDetail(detailSite);
					
				}else{
					//保存数据到数据库中
					site.setCreatedBy(new Long(0));
					site.setCreatedTime(basicInterfaceDao.getCurrentTime());
					site.setModifiedBy(null);
					site.setModifiedTime(null);
//					basicInterfaceDao.doCreatedSiteVO(site, detailSite);
					Long siteId = siteDao.doCreateSite(site);
					detailSite.setSiteId(siteId);
					siteDetailDao.doCreateSiteDetail(detailSite);
				}
				
			}
			
		}else{
			String message = (String) dataJson.get("message");
			log.info(message);
		}
	}
	
	/**
	 * 根据参数解析json串得到员工信息
	 * @author 旷娣
	 * @param params
	 */
	public List<String> ParseEmployeeInfo(String params) throws ServiceException{
		//解析json串
		JSONArray jsonArray = JSONArray.fromObject(params);
		Map<String,String> siteMap=new HashMap<String,String>();
		Map<String, Object> deptMap = new HashMap<String, Object>();
		List<String> errList = new ArrayList();
		String employeeCode = "";
		for(int i=0;i<jsonArray.size();i++){
			try {
			JSONObject employeeinfo=jsonArray.getJSONObject(i);
			employeeCode=employeeinfo.getString("EMPLOYEE_CODE");
			String employeeName=employeeinfo.getString("EMPLOYEE_NAME");
			String siteCode=employeeinfo.getString("SITE_CODE");
			String deptName=employeeinfo.getString("DEPT_NAME");
			String jobName=employeeinfo.getString("JOB_NAME");
			String phoneSms="/";
			if(employeeinfo.toString().contains("PHONE_SMS")){
				phoneSms=employeeinfo.getString("PHONE_SMS");
			}
			String phone="/";
			if(employeeinfo.toString().contains("PHONE")){
				phone=employeeinfo.getString("PHONE");
			}
			String pdaPwd="/";
			if(employeeinfo.toString().contains("PDA_PWD")){
				pdaPwd=employeeinfo.getString("PDA_PWD");
			}
			String rdStatus=employeeinfo.getString("RD_STATUS");
			/**20151226新增 支付宝账号 微信账号 实名制认证状态**/
			String alipayNo = "/";
			if(employeeinfo.toString().contains("ALIPAY_NO")){
				alipayNo = employeeinfo.getString("ALIPAY_NO");
			}
			String weChatNo = "/";
			if(employeeinfo.toString().contains("WECHAT_NO")){
				weChatNo = employeeinfo.getString("WECHAT_NO");
			}
			Integer realNameStatus = 0;
			if(employeeinfo.toString().contains("REAL_NAME_STATUS")){
				realNameStatus = employeeinfo.getInt("REAL_NAME_STATUS"); 
			}
			
			
			BasicEmployeeVO emp=new BasicEmployeeVO();
			emp.setEmployeeCode(employeeCode);
			emp.setEmployeeName(employeeName);
			//设置员工拼音
			if (!ValidateUtil.isEmpty(employeeName)) {
				if (!ValidateUtil.isNumeric(employeeName)) {
					String employeePinyin = PinYinUtil.getFirstPinYin(employeeName.trim());
					String[] names = employeePinyin.split(",");
					if("".equals(names[0])){
						emp.setEmployeePinyin("/");
					}else{
						emp.setEmployeePinyin(names[0]);
					}
				}else{
					emp.setEmployeePinyin("/");
				}
			}else{
				emp.setEmployeePinyin("/");
			}
			
			//设置所属网点
			List<BasicSiteVO> siteList;
			siteMap.put("siteCode", siteCode);
			siteList = siteService.querySiteByTotal(siteMap);
			//所属部门
			Long deptId=(long) 0;
			if(siteList!=null&&siteList.size()>0){
				emp.setSiteId(siteList.get(0).getSiteId());
				deptMap.put("siteTypeId", siteList.get(0).getSiteTypeId());
				deptMap.put("deptName", deptName);
				//根据部门名称和网点类型ID查询部门信息
				BasicDeptVO dept=deptDao.getDeptByNameAndSiteTypeId(deptMap);
				if(dept!=null){
					deptId=dept.getDeptId();
				}else{
					//如果由于网点类型ID的原因未查到部门信息，则再根据部门名称查询部门信息
					List<BasicDeptVO> deptList=deptDao.queryDeptByName(deptName);
					if(deptList!=null&&deptList.size()>0){
						deptId=deptList.get(0).getDeptId();
					}else{
						//没有这条部门信息时进行新增操作
						BasicDeptVO deptVO=new BasicDeptVO();
						//获取当前最大自定义顺序+1为新增的deptCode
						long order=deptDao.getMaxDeptOrder()+1;
						deptVO.setDeptCode("A"+order);
						deptVO.setDeptName(deptName);
						deptVO.setDeptFullName(deptName);
						//设置部门拼音
						if (!ValidateUtil.isEmpty(deptName)) {
							if (!ValidateUtil.isNumeric(deptName)) {
								String deptPinyin = PinYinUtil.getFirstPinYin(deptName.trim());
								String[] names = deptPinyin.split(",");
								if("".equals(names[0])){
									deptVO.setDeptPinyin("/");
								}else{
									deptVO.setDeptPinyin(names[0]);
								}
							}else{
								deptVO.setDeptPinyin("/");
							}
						}else{
							deptVO.setDeptPinyin("/");
						}
						deptVO.setDeptOrder(order);
						deptVO.setSiteTypeId((long) 0);
						deptVO.setParentDeptId((long) 0);
						deptVO.setAreaLevel(0);
						deptVO.setManagerEmployeeId((long) 0);
						deptVO.setLinkPhone("/");
						deptVO.setFax("/");
						deptVO.setRemark("/");
						deptVO.setCreatedBy((long) 0);
						deptVO.setCreatedTime(basicInterfaceDao.getCurrentTime());
						deptVO.setModifiedBy((long) 0);
						deptVO.setModifiedTime(basicInterfaceDao.getCurrentTime());
						deptVO.setRdStatus(1);
//						basicInterfaceDao.doCreateDept(deptVO);
						deptDao.doCreateDept(deptVO);
						//将新增的部门ID赋值给deptId
						deptId=deptVO.getDeptId();
					}
				}
				
			}else{
				//如果由于网点的原因未查到部门信息，则再根据部门名称查询部门信息
				List<BasicDeptVO> deptList=deptDao.queryDeptByName(deptName);
				if(deptList!=null&&deptList.size()>0){
					deptId=deptList.get(0).getDeptId();
				}else{
					//没有这条部门信息时进行新增操作
					BasicDeptVO deptVO=new BasicDeptVO();
					//获取当前最大自定义顺序+1为新增的deptCode
					long order=deptDao.getMaxDeptOrder()+1;
					deptVO.setDeptCode("A"+order);
					deptVO.setDeptName(deptName);
					deptVO.setDeptFullName(deptName);
					//设置部门拼音
					if (!ValidateUtil.isEmpty(deptName)) {
						if (!ValidateUtil.isNumeric(deptName)) {
							String deptPinyin = PinYinUtil.getFirstPinYin(deptName.trim());
							String[] names = deptPinyin.split(",");
							if("".equals(names[0])){
								deptVO.setDeptPinyin("/");
							}else{
								deptVO.setDeptPinyin(names[0]);
							}
							
						}else{
							deptVO.setDeptPinyin("/");
						}
					}else{
						deptVO.setDeptPinyin("/");
					}
					deptVO.setDeptOrder(order);
					deptVO.setSiteTypeId((long) 0);
					deptVO.setParentDeptId((long) 0);
					deptVO.setAreaLevel(0);
					deptVO.setManagerEmployeeId((long) 0);
					deptVO.setLinkPhone("/");
					deptVO.setFax("/");
					deptVO.setRemark("/");
					deptVO.setCreatedBy((long) 0);
					deptVO.setCreatedTime(basicInterfaceDao.getCurrentTime());
					deptVO.setModifiedBy((long) 0);
					deptVO.setModifiedTime(basicInterfaceDao.getCurrentTime());
					deptVO.setRdStatus(1);
//					basicInterfaceDao.doCreateDept(deptVO);
					deptDao.doCreateDept(deptVO);
					//将新增的部门ID赋值给deptId
					deptId=deptVO.getDeptId();
				}
				emp.setSiteId((long) 0);
			}
			
			//所属岗位
			Long jobId=(long) 0;
			List<BasicJobVO> jobList=basicInterfaceDao.queryJobByName(jobName);
			if(jobList!=null&&jobList.size()>0){
				jobId=jobList.get(0).getJobId();
			}else{
				//如果没有这条岗位信息则新增一条
				BasicJobVO jobVO=new BasicJobVO();
				//获取当前最大自定义顺序+1为新增的jobCode
				long order=jobDao.getMaxJobOrder()+1;
				jobVO.setJobCode("A"+order);
				jobVO.setJobName(jobName);
				//设置岗位拼音
				if (!ValidateUtil.isEmpty(jobName)) {
					if (!ValidateUtil.isNumeric(jobName)) {
						String jobPinyin = PinYinUtil.getFirstPinYin(jobName.trim());
						String[] names = jobPinyin.split(",");
						if("".equals(names[0])){
							jobVO.setJobPinyin("/");
						}else{
							jobVO.setJobPinyin(names[0]);
						}
					}else{
						jobVO.setJobPinyin("/");
					}
				}else{
					jobVO.setJobPinyin("/");
				}
				jobVO.setJobOrder(order);
				jobVO.setRemark("/");
				jobVO.setCreatedBy((long) 0);
				jobVO.setCreatedTime(basicInterfaceDao.getCurrentTime());
				jobVO.setModifiedBy((long) 0);
				jobVO.setModifiedTime(basicInterfaceDao.getCurrentTime());
				jobVO.setRdStatus(1);
//				basicInterfaceDao.doCreateJob(jobVO);
				jobDao.doCreateJob(jobVO);
				//将新增的岗位ID赋值给jobId
				jobId=jobVO.getJobId();
			}
			
			//根据deptId和jobId得到DeptJob的信息得到deptJobId
			BasicDeptJobVO deptJob=new BasicDeptJobVO();
			deptJob.setDeptId(deptId);
			deptJob.setJobId(jobId);
			
			deptJob.setDeptJobName(deptName+jobName);
			BasicDeptJobVO deptJobVO=jobDao.queryDeptJobByEntity(deptJob);
			if(deptJobVO!=null){
				emp.setDeptJobId(deptJobVO.getDeptJobId());
			}else{
				//如果没有这条部门岗位信息则新增一条
				jobDao.doCreateDeptJob(deptJob);
				emp.setDeptJobId(deptJob.getDeptJobId());
			}
			
			if("".equals(phoneSms)||phoneSms.equals(null)){
				emp.setPhoneSms("/");
			}else{
				emp.setPhoneSms(phoneSms);
			}
			if("".equals(phone)||phone.equals(null)){
				emp.setPhone("/");
			}else{
				emp.setPhone(phone);
				
			}
			
			int resultStatus=0;
			if("".equals(rdStatus)||rdStatus==null){
				resultStatus=1;
			}else{
				if("U".equals(rdStatus)){
					resultStatus=2;
				}else{
					if("I".equals(rdStatus)){
						resultStatus=3;
					}
				} 
			}
			
			emp.setRdStatus(resultStatus);
			
			//查询是否当前数据库中已经有该员工信息
			BasicEmployeeVO employeeVO=employeeDao.queryEmploreeByCode(employeeCode);
			if(employeeVO==null){//没有员工信息就进行新增操作
				emp.setEmployeeOrder((long)0);
				emp.setIdCard("/");
				emp.setSex("/");
				emp.setE_mail("/");
				emp.setBirthday(basicInterfaceDao.getCurrentTime());
				emp.setAddress("/");
				emp.setSelfRemark("/");
				emp.setBlUse(1);
				emp.setStartDate(basicInterfaceDao.getCurrentTime());
				emp.setEndDate(basicInterfaceDao.getCurrentTime());
				emp.setBasicSalar((double) 0);
				emp.setAddSalar((double) 0);
				emp.setLimitSumAmount((double) 0);
				emp.setLimitOneAmount((double) 0);
				emp.setTransportToolId((long) 0);
				emp.setPartId((long) 0);
				emp.setJobRemark("/");
				emp.setDriverLicenseType("/");
				emp.setBankId((long) 0);
				emp.setCreatedBy((long) 0);
				emp.setCreatedTime(basicInterfaceDao.getCurrentTime());
//				emp.setModifiedBy((long) 0);
//				emp.setModifiedTime(basicInterfaceDao.getCurrentTime());
				//emp.setEmployeeNo("/");//统一设置默认值会违反唯一性约束
				emp.setBankAccountId((long) 0);
				emp.setBankAccountName("/");
				emp.setBankAccountNo("/");
				/**20151226新增**/
				emp.setAlipayNo(alipayNo==null?"/":alipayNo);
				emp.setWeChatNo(weChatNo==null?"/":weChatNo);
				emp.setRealNameStatus(realNameStatus==null?0:realNameStatus);
				
				//用户信息
				User user=new User();
				user.setUserName(employeeCode);
				user.setUserPwd(DigestUtils.md5Hex("888888"));
				user.setUserType((long) 0);
				user.setBlOa(true);
				user.setPdaPwd("/");
				user.setExpireDate(basicInterfaceDao.getCurrentTime());
				user.setFailureTimes((long) 0);
				user.setMessageInterval((long) 0);
				user.setLastOperateIp("/");
				user.setLastOperateTime(basicInterfaceDao.getCurrentTime());
				user.setRemark("/");
				user.setStatus("N");
				user.setCreatedBy((long) 0);
				user.setCreatedTime(basicInterfaceDao.getCurrentTime());
				user.setModifiedBy((long) 0);
				user.setModifiedTime(basicInterfaceDao.getCurrentTime());
				user.setRdStatus(1);
				
				if(realNameStatus==3){//实名认证通过，则进行开户
					AccountVO account = new AccountVO();
					account.setAccountId(basicInterfaceDao.getAccountIdBySeq());
					account.setAccountStatus(1);
					account.setRemark("实名认证通过，自动开户");
					account.setCreatedBy((long)0);
					account.setCreatedTime(new Timestamp(System.currentTimeMillis()));
					account.setDelayLockTime(new Timestamp(System.currentTimeMillis()));
					account.setAlarmBalance(0.0);
					account.setLockBalance(0.0);
					account.setBalance(0.0);
					account.setAccountTypeId(13L);
					account.setCenterId(SiteID.ROOT.id);//总部
					//将员工数据插入到数据库
					doCreateEmployeeAndAccount(emp,user,account);
				}else{
					//将员工数据插入到数据库
					doCreateEmployee(emp,user);
				}

			}else{
				emp.setEmployeeId(employeeVO.getEmployeeId());
				emp.setEmployeeOrder(employeeVO.getEmployeeOrder());
				emp.setIdCard(employeeVO.getIdCard());
				emp.setSex(employeeVO.getSex());
				emp.setE_mail(employeeVO.getE_mail());
				emp.setBirthday(employeeVO.getBirthday());
				emp.setAddress(employeeVO.getAddress());
				emp.setSelfRemark(employeeVO.getSelfRemark());
				emp.setBlUse(employeeVO.getBlUse());
				emp.setStartDate(employeeVO.getStartDate());
				emp.setEndDate(employeeVO.getEndDate());
				emp.setBasicSalar(employeeVO.getBasicSalar());
				emp.setAddSalar(employeeVO.getAddSalar());
				emp.setLimitSumAmount(employeeVO.getLimitSumAmount());
				emp.setLimitOneAmount(employeeVO.getLimitOneAmount());
				emp.setTransportToolId(employeeVO.getTransportToolId());
				emp.setPartId(employeeVO.getPartId());
				emp.setJobRemark(employeeVO.getJobRemark());
				emp.setDriverLicenseType(employeeVO.getDriverLicenseType());
				emp.setBankId(employeeVO.getBankId());
				emp.setModifiedBy((long) 0);
				emp.setModifiedTime(basicInterfaceDao.getCurrentTime());
				emp.setEmployeeNo(employeeVO.getEmployeeNo());
				emp.setBankAccountId(employeeVO.getBankAccountId());
				emp.setBankAccountName(employeeVO.getBankAccountName());
				emp.setBankAccountNo(employeeVO.getBankAccountNo());
				/**20151226新增**/
				emp.setAlipayNo(alipayNo==null?"/":alipayNo);
				emp.setWeChatNo(weChatNo==null?"/":weChatNo);
				emp.setRealNameStatus(realNameStatus==null?0:realNameStatus);
				
				if(realNameStatus==3){
					AccountVO account = new AccountVO();
					account.setAccountId(basicInterfaceDao.getAccountIdBySeq());
					account.setAccountStatus(1);
					account.setRemark("实名认证通过，自动开户");
					account.setCreatedBy((long)0);
					account.setCreatedTime(new Timestamp(System.currentTimeMillis()));
					account.setDelayLockTime(new Timestamp(System.currentTimeMillis()));
					account.setAlarmBalance(0.0);
					account.setLockBalance(0.0);
					account.setBalance(0.0);
					account.setAccountTypeId(13L);
					account.setCenterId(SiteID.ROOT.id);//总部
					account.setDataId(employeeVO.getEmployeeId());
					boolean flag = accountDAO.isExistsAccountVO(account);
					if(!flag){//如果不存在账户，新增
						accountDAO.insert(account);
					}
				}
				//有员工信息就进行修改操作操作
//				basicInterfaceDao.doModifyEmployee(emp);
				employeeDao.doSaveEmployee(emp);
			}
			
			} catch (Exception e) {
				errList.add("编号是:"+employeeCode+",错误原因是："+e.getMessage());
				log.error("[error:员工数据同步失败]", e);
				continue;
			}
		}
		return errList;
	}
	
	/**
	 * /**
	 * 根据开始时间和结束时间获取员工信息
	 * @author 旷娣
	 * @param startDate
	 * @param endDate
	 * @throws ServiceException
	 */
	@Override
	public void getEmployeeInfo(Date startDate,Date endDate) throws ServiceException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		JSONObject obj=new JSONObject();
		obj.put("startDate", sdf.format(startDate));
		obj.put("endDate", sdf.format(endDate));
		String data=obj.toString();
		String url="http://localhost:8080/kj-int/100010.bizservice";
		String resultStr=sendRequest(data,url);
		//解析json串
		JSONObject dataJson=new JSONObject();
		dataJson.put("dataJson", resultStr);
		//请求成功
		if(dataJson.get("code").equals(200)){
			JSONArray dataStr=dataJson.getJSONArray("data");
			Map<String,String> siteMap=new HashMap<String,String>();
			Map<String, Object> deptMap = new HashMap<String, Object>();
			for(int i=0;i<dataStr.size();i++){
				JSONObject employeeinfo=dataStr.getJSONObject(i);
				String employeeCode=employeeinfo.getString("EMPLOYEE_CODE");
				String employeeName=employeeinfo.getString("EMPLOYEE_NAME");
				String siteCode=employeeinfo.getString("SITE_CODE");
				String deptName=employeeinfo.getString("DEPT_NAME");
				String jobName=employeeinfo.getString("JOB_NAME");
				String phoneSms="/";
				if(employeeinfo.toString().contains("PHONE_SMS")){
					phoneSms=employeeinfo.getString("PHONE_SMS");
				}
				String phone="/";
				if(employeeinfo.toString().contains("PHONE")){
					phone=employeeinfo.getString("PHONE");
				}
				String pdaPwd="/";
				if(employeeinfo.toString().contains("PDA_PWD")){
					pdaPwd=employeeinfo.getString("PDA_PWD");
				}
				String rdStatus=employeeinfo.getString("RD_STATUS");
				
				BasicEmployeeVO emp=new BasicEmployeeVO();
				emp.setEmployeeCode(employeeCode);
				emp.setEmployeeName(employeeName);
				//设置员工拼音
				if (!ValidateUtil.isEmpty(employeeName)) {
					if (!ValidateUtil.isNumeric(employeeName)) {
						String employeePinyin = PinYinUtil.getFirstPinYin(employeeName.trim());
						String[] names = employeePinyin.split(",");
						if("".equals(names[0])){
							emp.setEmployeePinyin("/");
						}else{
							emp.setEmployeePinyin(names[0]);
						}
					}else{
						emp.setEmployeePinyin("/");
					}
				}else{
					emp.setEmployeePinyin("/");
				}
				
				//设置所属网点
				List<BasicSiteVO> siteList;
				siteMap.put("siteCode", siteCode);
				siteList = siteService.querySiteByTotal(siteMap);
				//所属部门
				Long deptId=(long) 0;
				if(siteList!=null&&siteList.size()>0){
					emp.setSiteId(siteList.get(0).getSiteId());
					deptMap.put("siteTypeId", siteList.get(0).getSiteTypeId());
					deptMap.put("deptName", deptName);
					//根据部门名称和网点类型ID查询部门信息
					BasicDeptVO dept=deptDao.getDeptByNameAndSiteTypeId(deptMap);
					if(dept!=null){
						deptId=dept.getDeptId();
					}else{
						//如果由于网点类型ID的原因未查到部门信息，则再根据部门名称查询部门信息
						List<BasicDeptVO> deptList=deptDao.queryDeptByName(deptName);
						if(deptList!=null&&deptList.size()>0){
							deptId=deptList.get(0).getDeptId();
						}else{
							//没有这条部门信息时进行新增操作
							BasicDeptVO deptVO=new BasicDeptVO();
							//获取当前最大自定义顺序+1为新增的deptCode
							long order=deptDao.getMaxDeptOrder()+1;
							deptVO.setDeptCode("A"+order);
							deptVO.setDeptName(deptName);
							deptVO.setDeptFullName(deptName);
							//设置部门拼音
							if (!ValidateUtil.isEmpty(deptName)) {
								if (!ValidateUtil.isNumeric(deptName)) {
									String deptPinyin = PinYinUtil.getFirstPinYin(deptName.trim());
									String[] names = deptPinyin.split(",");
									if("".equals(names[0])){
										deptVO.setDeptPinyin("/");
									}else{
										deptVO.setDeptPinyin(names[0]);
									}
								}else{
									deptVO.setDeptPinyin("/");
								}
							}else{
								deptVO.setDeptPinyin("/");
							}
							deptVO.setDeptOrder(order);
							deptVO.setSiteTypeId((long) 0);
							deptVO.setParentDeptId((long) 0);
							deptVO.setAreaLevel(0);
							deptVO.setManagerEmployeeId((long) 0);
							deptVO.setLinkPhone("/");
							deptVO.setFax("/");
							deptVO.setRemark("/");
							deptVO.setCreatedBy((long) 0);
							deptVO.setCreatedTime(basicInterfaceDao.getCurrentTime());
							deptVO.setModifiedBy((long) 0);
							deptVO.setModifiedTime(basicInterfaceDao.getCurrentTime());
							deptVO.setRdStatus(1);
//							basicInterfaceDao.doCreateDept(deptVO);
							deptDao.doCreateDept(deptVO);
							//将新增的部门ID赋值给deptId
							deptId=deptVO.getDeptId();
						}
					}
					
				}else{
					//如果由于网点的原因未查到部门信息，则再根据部门名称查询部门信息
					List<BasicDeptVO> deptList=deptDao.queryDeptByName(deptName);
					if(deptList!=null&&deptList.size()>0){
						deptId=deptList.get(0).getDeptId();
					}else{
						//没有这条部门信息时进行新增操作
						BasicDeptVO deptVO=new BasicDeptVO();
						//获取当前最大自定义顺序+1为新增的deptCode
						long order=deptDao.getMaxDeptOrder()+1;
						deptVO.setDeptCode("A"+order);
						deptVO.setDeptName(deptName);
						deptVO.setDeptFullName(deptName);
						//设置部门拼音
						if (!ValidateUtil.isEmpty(deptName)) {
							if (!ValidateUtil.isNumeric(deptName)) {
								String deptPinyin = PinYinUtil.getFirstPinYin(deptName.trim());
								String[] names = deptPinyin.split(",");
								if("".equals(names[0])){
									deptVO.setDeptPinyin("/");
								}else{
									deptVO.setDeptPinyin(names[0]);
								}
								
							}else{
								deptVO.setDeptPinyin("/");
							}
						}else{
							deptVO.setDeptPinyin("/");
						}
						deptVO.setDeptOrder(order);
						deptVO.setSiteTypeId((long) 0);
						deptVO.setParentDeptId((long) 0);
						deptVO.setAreaLevel(0);
						deptVO.setManagerEmployeeId((long) 0);
						deptVO.setLinkPhone("/");
						deptVO.setFax("/");
						deptVO.setRemark("/");
						deptVO.setCreatedBy((long) 0);
						deptVO.setCreatedTime(basicInterfaceDao.getCurrentTime());
						deptVO.setModifiedBy((long) 0);
						deptVO.setModifiedTime(basicInterfaceDao.getCurrentTime());
						deptVO.setRdStatus(1);
//						basicInterfaceDao.doCreateDept(deptVO);
						deptDao.doCreateDept(deptVO);
						//将新增的部门ID赋值给deptId
						deptId=deptVO.getDeptId();
					}
					emp.setSiteId((long) 0);
				}
				
				//所属岗位
				Long jobId=(long) 0;
				List<BasicJobVO> jobList=basicInterfaceDao.queryJobByName(jobName);
				if(jobList!=null&&jobList.size()>0){
					jobId=jobList.get(0).getJobId();
				}else{
					//如果没有这条岗位信息则新增一条
					BasicJobVO jobVO=new BasicJobVO();
					//获取当前最大自定义顺序+1为新增的jobCode
					long order=jobDao.getMaxJobOrder()+1;
					jobVO.setJobCode("A"+order);
					jobVO.setJobName(jobName);
					//设置岗位拼音
					if (!ValidateUtil.isEmpty(jobName)) {
						if (!ValidateUtil.isNumeric(jobName)) {
							String jobPinyin = PinYinUtil.getFirstPinYin(jobName.trim());
							String[] names = jobPinyin.split(",");
							if("".equals(names[0])){
								jobVO.setJobPinyin("/");
							}else{
								jobVO.setJobPinyin(names[0]);
							}
						}else{
							jobVO.setJobPinyin("/");
						}
					}else{
						jobVO.setJobPinyin("/");
					}
					jobVO.setJobOrder(order);
					jobVO.setRemark("/");
					jobVO.setCreatedBy((long) 0);
					jobVO.setCreatedTime(basicInterfaceDao.getCurrentTime());
					jobVO.setModifiedBy((long) 0);
					jobVO.setModifiedTime(basicInterfaceDao.getCurrentTime());
					jobVO.setRdStatus(1);
//					basicInterfaceDao.doCreateJob(jobVO);
					jobDao.doCreateJob(jobVO);
					//将新增的岗位ID赋值给jobId
					jobId=jobVO.getJobId();
				}
				
				//根据deptId和jobId得到DeptJob的信息得到deptJobId
				BasicDeptJobVO deptJob=new BasicDeptJobVO();
				deptJob.setDeptId(deptId);
				deptJob.setJobId(jobId);
				
				deptJob.setDeptJobName(deptName+jobName);
				BasicDeptJobVO deptJobVO=jobDao.queryDeptJobByEntity(deptJob);
				if(deptJobVO!=null){
					emp.setDeptJobId(deptJobVO.getDeptJobId());
				}else{
					//如果没有这条部门岗位信息则新增一条
					jobDao.doCreateDeptJob(deptJob);
					emp.setDeptJobId(deptJob.getDeptJobId());
				}
				
				if("".equals(phoneSms)||phoneSms.equals(null)){
					emp.setPhoneSms("/");
				}else{
					emp.setPhoneSms(phoneSms);
				}
				if("".equals(phone)||phone.equals(null)){
					emp.setPhone("/");
				}else{
					emp.setPhone(phone);
					
				}
				
				int resultStatus=0;
				if("".equals(rdStatus)||rdStatus==null){
					resultStatus=1;
				}else{
					if("U".equals(rdStatus)){
						resultStatus=2;
					}else{
						if("I".equals(rdStatus)){
							resultStatus=3;
						}
					} 
				}
				
				emp.setRdStatus(resultStatus);
				
				//查询是否当前数据库中已经有该员工信息
				BasicEmployeeVO employeeVO=employeeDao.queryEmploreeByCode(employeeCode);
				if(employeeVO==null){//没有员工信息就进行新增操作
					emp.setEmployeeOrder((long)0);
					emp.setIdCard("/");
					emp.setSex("/");
					emp.setE_mail("/");
					emp.setBirthday(basicInterfaceDao.getCurrentTime());
					emp.setAddress("/");
					emp.setSelfRemark("/");
					emp.setBlUse(1);
					emp.setStartDate(basicInterfaceDao.getCurrentTime());
					emp.setEndDate(basicInterfaceDao.getCurrentTime());
					emp.setBasicSalar((double) 0);
					emp.setAddSalar((double) 0);
					emp.setLimitSumAmount((double) 0);
					emp.setLimitOneAmount((double) 0);
					emp.setTransportToolId((long) 0);
					emp.setPartId((long) 0);
					emp.setJobRemark("/");
					emp.setDriverLicenseType("/");
					emp.setBankId((long) 0);
					emp.setCreatedBy((long) 0);
					emp.setCreatedTime(basicInterfaceDao.getCurrentTime());
					emp.setModifiedBy((long) 0);
					emp.setModifiedTime(basicInterfaceDao.getCurrentTime());
					//emp.setEmployeeNo("/");//统一设置默认值会违反唯一性约束
					emp.setBankAccountId((long) 0);
					emp.setBankAccountName("/");
					emp.setBankAccountNo("/");
					
					//用户信息
					User user=new User();
					user.setUserName(employeeCode);
					user.setUserPwd(DigestUtils.md5Hex("888888"));
					user.setUserType((long) 0);
					user.setBlOa(true);
					user.setPdaPwd("/");
					user.setExpireDate(basicInterfaceDao.getCurrentTime());
					user.setFailureTimes((long) 0);
					user.setMessageInterval((long) 0);
					user.setLastOperateIp("/");
					user.setLastOperateTime(basicInterfaceDao.getCurrentTime());
					user.setRemark("/");
					user.setStatus("N");
					user.setCreatedBy((long) 0);
					user.setCreatedTime(basicInterfaceDao.getCurrentTime());
					user.setModifiedBy((long) 0);
					user.setModifiedTime(basicInterfaceDao.getCurrentTime());
					user.setRdStatus(1);
					
					//将员工数据插入到数据库
					doCreateEmployee(emp,user);
				}else{
					emp.setEmployeeId(employeeVO.getEmployeeId());
					emp.setEmployeeOrder(employeeVO.getEmployeeOrder());
					emp.setIdCard(employeeVO.getIdCard());
					emp.setSex(employeeVO.getSex());
					emp.setE_mail(employeeVO.getE_mail());
					emp.setBirthday(employeeVO.getBirthday());
					emp.setAddress(employeeVO.getAddress());
					emp.setSelfRemark(employeeVO.getSelfRemark());
					emp.setBlUse(employeeVO.getBlUse());
					emp.setStartDate(employeeVO.getStartDate());
					emp.setEndDate(employeeVO.getEndDate());
					emp.setBasicSalar(employeeVO.getBasicSalar());
					emp.setAddSalar(employeeVO.getAddSalar());
					emp.setLimitSumAmount(employeeVO.getLimitSumAmount());
					emp.setLimitOneAmount(employeeVO.getLimitOneAmount());
					emp.setTransportToolId(employeeVO.getTransportToolId());
					emp.setPartId(employeeVO.getPartId());
					emp.setJobRemark(employeeVO.getJobRemark());
					emp.setDriverLicenseType(employeeVO.getDriverLicenseType());
					emp.setBankId(employeeVO.getBankId());
					emp.setModifiedBy((long) 0);
					emp.setModifiedTime(basicInterfaceDao.getCurrentTime());
					emp.setEmployeeNo(employeeVO.getEmployeeNo());
					emp.setBankAccountId(employeeVO.getBankAccountId());
					emp.setBankAccountName(employeeVO.getBankAccountName());
					emp.setBankAccountNo(employeeVO.getBankAccountNo());
					//有员工信息就进行修改操作操作
//					basicInterfaceDao.doModifyEmployee(emp);
					employeeDao.doSaveEmployee(emp);
				}
			}
		}else{//请求失败
			log.info("错误信息："+dataJson.get("message").toString());
		}
	}
	
	/**
	 * 新增员工，并同时新增用户
	 * @author 旷娣
	 * @param user
	 * @throws ServiceException
	 */
	public void doCreateEmployee(BasicEmployeeVO emp,User user) throws ServiceException{
		//将员工数据插入数据库
//		basicInterfaceDao.doCreateEmployee(emp);
		employeeDao.doCreateEmployee(emp);
		//同时新增一个用户
		user.setEmployeeId(emp.getEmployeeId());
		basicInterfaceDao.doCreateUser(user);
	}
	/**
	 * 将名字转成拼音
	 * @param str
	 * @return
	 * @author FengQing
	 * @date 2015-8-28 上午11:54:30
	 */
	public String getFirstPinYin(String str) {
		if(ValidateUtil.isNumeric(str))
			return "";
        
		String convert = "";
		for (int j = 0; j < str.length(); j++) {
			char word = str.charAt(j);
			// 提取汉字的首字母
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null) {
				convert += pinyinArray[0].charAt(0);
			} else {
				convert += word;
			}
		}
		String reg = "[^A-Z]+";
		return convert.toUpperCase().replaceAll(reg,"");
	}
	/**
	 * 新增员工，用户，账户
	 */
	@Override
	public void doCreateEmployeeAndAccount(BasicEmployeeVO emp, User user,
			AccountVO account) throws ServiceException {
		//将员工数据插入数据库
//		basicInterfaceDao.doCreateEmployee(emp);
		employeeDao.doCreateEmployee(emp);
		//同时新增一个用户
		user.setEmployeeId(emp.getEmployeeId());
		basicInterfaceDao.doCreateUser(user);
		//新增一个账户
		account.setDataId(emp.getEmployeeId());
		boolean flag = accountDAO.isExistsAccountVO(account);
		if(!flag){//如果不存在账户，新增
			accountDAO.insert(account);
		}
	}
}
