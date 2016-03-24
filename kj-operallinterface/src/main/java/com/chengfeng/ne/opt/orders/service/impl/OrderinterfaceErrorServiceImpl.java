package com.chengfeng.ne.opt.orders.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.chengfeng.ne.basedata.domain.BasicCityVO;
import com.chengfeng.ne.basedata.domain.BasicCountyVO;
import com.chengfeng.ne.basedata.domain.BasicProvinceVO;
import com.chengfeng.ne.basedata.domain.BasicSiteVO;
import com.chengfeng.ne.basedata.service.ICommonService;
import com.chengfeng.ne.opt.orders.dao.IOrdOrderDao;
import com.chengfeng.ne.opt.orders.dao.IOrdStatusDao;
import com.chengfeng.ne.opt.orders.dao.IOrderAddressLibraryDao;
import com.chengfeng.ne.opt.orders.dao.IOrderinterfaceErrorDao;
import com.chengfeng.ne.opt.orders.domain.OrdOrderVO;
import com.chengfeng.ne.opt.orders.domain.OrdStatusVO;
import com.chengfeng.ne.opt.orders.domain.OrderAddressLibraryVO;
import com.chengfeng.ne.opt.orders.domain.OrderinterfaceErrorVO;
import com.chengfeng.ne.opt.orders.service.IOrderinterfaceErrorService;
import com.thinkjf.dao.entity.PaginationVO;
import com.thinkjf.service.ServiceException;

@Service("opt_orderinterfaceErrorService")
public class OrderinterfaceErrorServiceImpl implements
		IOrderinterfaceErrorService {

	@Resource(name = "opt_orderinterfaceErrorDao")
	private IOrderinterfaceErrorDao opt_orderinterfaceErrorDao;

	@Resource(name = "opt_ordOrderDao")
	private IOrdOrderDao ordOrderDao;

	@Resource(name = "opt_OrderAddressLibraryDao")
	private IOrderAddressLibraryDao OrderAddressLibraryDao;

	@Resource(name = "commonService")
	private ICommonService commonService;

	@Resource(name = "opt_ordStatusDao")
	private IOrdStatusDao ordStatusDao;
	@Override
	public boolean orderCreatedToInterFace(String json, Long errorOrderId,boolean falg)
			throws ServiceException {
		String orderNo = "";
		try {
			OrdOrderVO orders =ordOrderDao.getOrderInfoByOrderId(errorOrderId);
			if(null!=orders){
			}else{
				JSONObject obj = JSONObject.fromObject(json);
				OrdOrderVO ordOrder = new OrdOrderVO();
				ordOrder.setOldOrderId(errorOrderId);
				orderNo = StringUtils.isEmpty(obj.getString("orderNo")) ? ""
						: obj.getString("orderNo");
				ordOrder.setOrderNo(orderNo);
				ordOrder.setEcId(Long.parseLong(StringUtils.isEmpty(obj
						.getString("ecId")) ? "0" : obj.getString("ecId")));
				ordOrder.setEwbNo(StringUtils.isEmpty(obj.getString("ewbNo")) ? "0"
						: obj.getString("ewbNo"));
				ordOrder.setLogisticNo(StringUtils.isEmpty(obj
						.getString("logisticNo")) ? "" : obj
						.getString("logisticNo"));
				ordOrder.setSendSiteId(Long.parseLong(StringUtils.isEmpty(obj
						.getString("sendSiteId"))
						|| obj.getString("sendSiteId").equals("0") ? "-1" : obj
						.getString("sendSiteId")));
				ordOrder.setDispatchSiteId(Long.parseLong(StringUtils.isEmpty(obj
						.getString("dispatchSiteId")) ? "0" : obj
						.getString("dispatchSiteId")));
				ordOrder.setOrderStatus(Integer.parseInt(StringUtils.isEmpty(obj
						.getString("orderStatus")) ? "0" : obj
						.getString("orderStatus")));
				ordOrder.setTotalPiece(Integer.parseInt(StringUtils.isEmpty(obj
						.getString("totalPiece")) ? "0" : obj
						.getString("totalPiece")));
				ordOrder.setTotalWeight(new BigDecimal(StringUtils.isEmpty(obj
						.getString("totalWeight")) ? "0" : obj
						.getString("totalWeight")));
				ordOrder.setTotalVol(new BigDecimal(StringUtils.isEmpty(obj
						.getString("totalVol")) ? "0" : obj.getString("totalVol")));
				ordOrder.setPaySideId(Long.parseLong(StringUtils.isEmpty(obj
						.getString("paySideId")) ? "0" : obj.getString("paySideId")));
				ordOrder.setPayModeId(Long.parseLong(StringUtils.isEmpty(obj
						.getString("payModeId")) ? "0" : obj.getString("payModeId")));
				ordOrder.setFreightCharge1(new BigDecimal(StringUtils.isEmpty(obj
						.getString("freightCharge1")) ? "0" : obj
						.getString("freightCharge1")));
				ordOrder.setFreightCharge(new BigDecimal(StringUtils.isEmpty(obj
						.getString("freightCharge")) ? "0" : obj
						.getString("freightCharge")));
				ordOrder.setInsuredAmount(new BigDecimal(StringUtils.isEmpty(obj
						.getString("insuredAmount")) ? "0" : obj
						.getString("insuredAmount")));
				ordOrder.setCodCharge(new BigDecimal(StringUtils.isEmpty(obj
						.getString("codCharge")) ? "0" : obj.getString("codCharge")));
				ordOrder.setEcWarehouseId(Long.parseLong(StringUtils.isEmpty(obj
						.getString("ecWarehouseId")) ? "0" : obj
						.getString("ecWarehouseId")));
				if (obj.getString("receiveFlag").equals("true")) {
					ordOrder.setReceiveFlag(1);
				} else if (obj.getString("receiveFlag").equals("false")) {
					ordOrder.setReceiveFlag(0);
				}
				if (obj.getString("smsFlag").equals("true")) {
					ordOrder.setSmsFlag(1);
				} else if (obj.getString("smsFlag").equals("false")) {
					ordOrder.setSmsFlag(0);
				}
				ordOrder.setServiceType(Integer.parseInt(StringUtils.isEmpty(obj
						.getString("serviceType")) ? "0" : obj
						.getString("serviceType")));
				if (obj.getString("packageFlag").equals("true")) {
					ordOrder.setPackageFlag(1);
				} else if (obj.getString("packageFlag").equals("false")) {
					ordOrder.setPackageFlag(0);
				}
				ordOrder.setPackageDesc(StringUtils.isEmpty(obj
						.getString("packageDesc")) ? "" : obj
						.getString("packageDesc"));
				if (obj.getString("ewbFlag").equals("true")) {
					ordOrder.setEwbFlag(1);
				} else if (obj.getString("ewbFlag").equals("false")) {
					ordOrder.setEwbFlag(0);
				}
				ordOrder.setReceiveEmployeeId(Long.parseLong(StringUtils
						.isEmpty(obj.getString("receiveEmployeeId")) ? "0" : obj
						.getString("receiveEmployeeId")));
				ordOrder.setSendCompanyName(StringUtils.isEmpty(obj
						.getString("sendCompanyName")) ? "/" : obj
						.getString("sendLinkMan"));
				ordOrder.setSendLinkMan(StringUtils.isEmpty(obj
						.getString("sendLinkMan")) ? "/" : obj
						.getString("sendLinkMan"));
				ordOrder.setSendPhoneSms(StringUtils.isEmpty(obj
						.getString("sendPhoneSms")) ? "" : obj
						.getString("sendPhoneSms"));
				ordOrder.setSendPhone(StringUtils.isEmpty(obj
						.getString("sendPhone")) ? "/" : obj.getString("sendPhone"));
				ordOrder.setSendAddress(StringUtils.isEmpty(obj
						.getString("sendAddress")) ? "/" : obj
						.getString("sendAddress"));
				ordOrder.setSendPostcode(StringUtils.isEmpty(obj
						.getString("sendPostcode")) ? "" : obj
						.getString("sendPostcode"));
				ordOrder.setSendProvince(StringUtils.isEmpty(obj
						.getString("sendProvince")) ? "无" : obj
						.getString("sendProvince"));
				if (StringUtils.isEmpty(obj.getString("sendCity"))
						|| "null".equals(obj.getString("sendCity"))) {
					ordOrder.setSendCity("无");
					ordOrder.setSendCounty("无");
				} else {
					String sendCitys[] = obj.getString("sendCity").split(",");
					if (sendCitys.length > 1) {
						ordOrder.setSendCity(sendCitys[0]);
						ordOrder.setSendCounty(sendCitys[1]);
					} else {
						ordOrder.setSendCity(sendCitys[0]);
						ordOrder.setSendCounty("无");
					}
				}
				if (!StringUtils.isEmpty(obj.getString("sendCounty"))
						&& !"未知".equals(obj.getString("sendCounty"))) {
					ordOrder.setSendCounty(obj.getString("sendCounty"));
				}
				ordOrder.setSendStartTime(StringUtils.isEmpty(obj
						.getString("sendStartTime")) ? "" : obj
						.getString("sendStartTime"));
				ordOrder.setSendEndTime(StringUtils.isEmpty(obj
						.getString("sendEndTime")) ? "" : obj
						.getString("sendEndTime"));
				ordOrder.setDispatchCompanyName(StringUtils.isEmpty(obj
						.getString("dispatchCompanyName")) ? "" : obj
						.getString("dispatchCompanyName"));
				ordOrder.setDispatchLinkMan(StringUtils.isEmpty(obj
						.getString("dispatchLinkMan")) ? "/" : obj
						.getString("dispatchLinkMan"));
				ordOrder.setDispatchPhoneSms(StringUtils.isEmpty(obj
						.getString("dispatchPhoneSms")) ? "" : obj
						.getString("dispatchPhoneSms"));
				ordOrder.setDispatchPhone(StringUtils.isEmpty(obj
						.getString("dispatchPhone")) ? "/" : obj
						.getString("dispatchPhone"));
				ordOrder.setDispatchAddress(StringUtils.isEmpty(obj
						.getString("dispatchAddress")) ? "/" : obj
						.getString("dispatchAddress"));
				ordOrder.setDispatchPostcode(StringUtils.isEmpty(obj
						.getString("dispatchPostcode")) ? "" : obj
						.getString("dispatchPostcode"));
				ordOrder.setDispatchProvince(StringUtils.isEmpty(obj
						.getString("dispatchProvince")) ? "无" : obj
						.getString("dispatchProvince"));
				if (StringUtils.isEmpty(obj.getString("dispatchCity"))
						|| "null".equals(obj.getString("dispatchCity"))) {
					ordOrder.setDispatchCity("无");
					ordOrder.setDispatchCounty("无");
				} else {
					String dispatchCitys[] = obj.getString("dispatchCity").split(
							",");
					if (dispatchCitys.length > 1) {
						ordOrder.setDispatchCity(dispatchCitys[0]);
						ordOrder.setDispatchCounty(dispatchCitys[1]);
					} else {
						ordOrder.setDispatchCity(dispatchCitys[0]);
						ordOrder.setDispatchCounty("无");
					}
				}
				if (!StringUtils.isEmpty(obj.getString("dispatchCounty"))
						&& !"未知".equals(obj.getString("dispatchCounty"))) {
					ordOrder.setDispatchCounty(obj.getString("dispatchCounty"));
				}
				ordOrder.setDispatchStartTime(StringUtils.isEmpty(obj
						.getString("dispatchStartTime")) ? "" : obj
						.getString("dispatchStartTime"));
				ordOrder.setDispatchEndTime(StringUtils.isEmpty(obj
						.getString("dispatchEndTime")) ? "" : obj
						.getString("dispatchEndTime"));
				ordOrder.setModifiedBy(Long.parseLong(StringUtils.isEmpty(obj
						.getString("modifiedBy")) ? "0" : obj
						.getString("modifiedBy")));
				if (obj.getString("modifiedTime") != null
						&& !"null".equals(obj.getString("modifiedTime"))) {
					ordOrder.setModifiedTime(parseToDate(
							obj.getString("modifiedTime"), "yyyy-MM-dd HH:mm:ss"));
				}
				ordOrder.setReturnTime(StringUtils.isEmpty(obj
						.getString("returnTime")) ? "" : obj
						.getString("returnTime"));
				if (obj.getString("rdStatus").equals("true")) {
					ordOrder.setRdStatus(1);
				} else if (obj.getString("rdStatus").equals("false")) {
					ordOrder.setRdStatus(0);
				}
				ordOrder.setCoupon(obj.getString("coupon"));
				// add
				if (obj.getString("returnTarget").equals("true")) {
					ordOrder.setReturnTarget(1);
				} else if (obj.getString("returnTarget").equals("false")) {
					ordOrder.setReturnTarget(0);
				}
				ordOrder.setReturnTime(StringUtils.isEmpty(obj
						.getString("returnTime")) ? "" : obj
						.getString("returnTime"));
				if (!StringUtils.isEmpty(obj.getString("createdTime"))
						&& !"null".equals(obj.getString("createdTime"))) {
					ordOrder.setCreatedTime(parseToDate(
							obj.getString("createdTime"), "yyyy-MM-dd HH:mm:ss"));
				} else {
					ordOrder.setCreatedTime(new Date());
				}
				ordOrder.setDeliveryType(StringUtils.isEmpty(obj
						.getString("deliveryType")) ? "" : obj
						.getString("deliveryType"));
				if (!StringUtils.isEmpty(obj.getString("dispartTime"))
						&& !"null".equals(obj.getString("dispartTime"))) {
					ordOrder.setDispartTime(parseToDate(
							obj.getString("dispartTime"), "yyyy-MM-dd HH:mm:ss"));
				} else {
					ordOrder.setDispartTime(new Date());
				}
				ordOrder.setDispatchTown(StringUtils.isEmpty(obj
						.getString("dispatchTown")) ? "" : obj
						.getString("dispatchTown"));
				ordOrder.setInputDispatchSiteId(StringUtils.isEmpty(obj
						.getString("inputDispatchSiteId")) ? "" : obj
						.getString("inputDispatchSiteId"));
				ordOrder.setInputSendSiteId(StringUtils.isEmpty(obj
						.getString("inputSendSiteId")) ? "" : obj
						.getString("inputSendSiteId"));
				ordOrder.setOrderBizType(Integer.parseInt(StringUtils.isEmpty(obj
						.getString("orderBizType")) ? "0" : obj
						.getString("orderBizType")));
				ordOrder.setSellerid(StringUtils.isEmpty(obj.getString("sellerid")) ? ""
						: obj.getString("sellerid"));
				ordOrder.setSendTown(StringUtils.isEmpty(obj.getString("sendTown")) ? ""
						: obj.getString("sendTown"));
				if (StringUtils.isEmpty(ordOrder.getSendCounty())
						|| "null".equals(ordOrder.getSendCounty())) {
					ordOrder.setSendCounty("无");
				}
				if (StringUtils.isEmpty(ordOrder.getDispatchCounty())
						|| "null".equals(ordOrder.getDispatchCounty())) {
					ordOrder.setDispatchCounty("无");
				}
				if ("null".equals(ordOrder.getSendProvince())) {
					ordOrder.setSendProvince("无");
				}
				if ("null".equals(ordOrder.getDispatchProvince())) {
					ordOrder.setDispatchProvince("无");
				}

				/** 地址匹配 **/
				// 省
				Map<String, Object> mapPro = new HashMap<String, Object>();
				List<String> provinceNameList = new ArrayList<String>();
				provinceNameList.add(ordOrder.getSendProvince());
				mapPro.put("provinceNameList", provinceNameList);
				List<BasicProvinceVO> proList = commonService
						.queryProvinceListByName(mapPro);
				// 市
				Map<String, Object> mapCity = new HashMap<String, Object>();
				List<String> cityNameList = new ArrayList<String>();
				cityNameList.add(ordOrder.getSendCity());
				mapCity.put("cityNameList", cityNameList);
				List<BasicCityVO> cityList = commonService
						.queryCityListByName(mapCity);
				// 区(县)
				BasicCountyVO countyVO;
				if (null == cityList || cityList.size() <= 0) {
					countyVO = commonService.queryCountyByName(0L,
							ordOrder.getSendCounty());
				} else {
					countyVO = commonService.queryCountyByName(cityList.get(0)
							.getCityId(), ordOrder.getSendCounty());
				}

				// 将匹配条件封装成map
				Map<String, Object> mapPiPei = new HashMap<String, Object>();
				if (proList.size() > 0) {
					mapPiPei.put("provinceId",
							proList.get(0).getProvinceId() == null ? 0L : proList
									.get(0).getProvinceId());
				} else {
					mapPiPei.put("provinceId", 0L);
				}
				if (cityList.size() > 0) {
					mapPiPei.put("cityId", cityList.get(0).getCityId() == null ? 0L
							: cityList.get(0).getCityId());
				} else {
					mapPiPei.put("cityId", 0L);
				}
				if (null != countyVO) {
					mapPiPei.put("countyId", countyVO.getCountyId() == null ? 0L
							: countyVO.getCountyId());
				} else {
					mapPiPei.put("cityId", 0L);
				}
				mapPiPei.put("address", ordOrder.getSendAddress() == null ? "无"
						: ordOrder.getSendAddress());
				List<OrderAddressLibraryVO> addreList = OrderAddressLibraryDao
						.queryOrderAddressLibraryListByTotal(mapPiPei);

				
				
				if (null != addreList && addreList.size() > 0) {
					// 匹配成功
					ordOrder.setSendSiteId(addreList.get(0).getSiteId());
					Long orderId = ordOrderDao.insert(ordOrder);
					if (null != orderId) {
						OrdStatusVO statusVO = new OrdStatusVO();
						statusVO.setOrderId(orderId);
						statusVO.setOrderStatus(0);
						statusVO.setSiteId(ordOrder.getSendSiteId());
						statusVO.setCreatedBy(0L);
						statusVO.setCreatedTime(commonService.getCurrentTime());
						ordStatusDao.insertSelective(statusVO);
					}
				} else {// 匹配不成功
					if (ordOrder.getSendSiteId().longValue() != -1) {
						// 给了寄件网点
						BasicSiteVO basicVO = commonService.querySiteById(ordOrder
								.getSendSiteId());
						if (null == basicVO) {
							// 寄件网点不存在
							ordOrder.setSendSiteId(-1L);
							ordOrderDao.insert(ordOrder);
						} else {
							// 寄件网点存在
							Long orderId = ordOrderDao.insert(ordOrder);
							if (null != orderId) {
								OrdStatusVO statusVO = new OrdStatusVO();
								statusVO.setOrderId(orderId);
								statusVO.setOrderStatus(0);
								statusVO.setSiteId(ordOrder.getSendSiteId());
								statusVO.setCreatedBy(0L);
								statusVO.setCreatedTime(commonService
										.getCurrentTime());
								ordStatusDao.insertSelective(statusVO);
							}
						}
					} else {
						ordOrderDao.insert(ordOrder);
					}
					if (falg) {
						if(errorOrderId != null){
							Map<String, Object> deleteMap = new HashMap<String, Object>();
							deleteMap.put("orderId", errorOrderId);
							opt_orderinterfaceErrorDao
									.doDeleteOrderinterfaceError(deleteMap);
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			OrderinterfaceErrorVO orderinterfaceErrorVO = new OrderinterfaceErrorVO();
			orderinterfaceErrorVO.setOrderId(errorOrderId);
			orderinterfaceErrorVO.setOrderDatatype(1);
			orderinterfaceErrorVO.setOrderStatus(0);
			orderinterfaceErrorVO.setOrderErrorMessage(e.getMessage());
			orderinterfaceErrorVO.setOrderContent(json);
			orderinterfaceErrorVO.setOrderNo(orderNo);
			opt_orderinterfaceErrorDao.doCreateOrderinterfaceError(orderinterfaceErrorVO);
		}
		return true;

	}

	public static Date parseToDate(String strDate, String format) {
		try {
			if (strDate == null || strDate.trim().length() == 0) {
				return new Date();
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(strDate);
		} catch (ParseException e) {
			return new Date();
		}
	}
    /**
     * 分页查询错误订单
     */
	@Override
	public PaginationVO<OrderinterfaceErrorVO> queryPagedListError(
			Map<String, Object> map, int pageIndex, int pageSize)
			throws ServiceException {
		return opt_orderinterfaceErrorDao.queryPagedListError(map, pageIndex, pageSize);
	}
    /**
     * 统计错误订单总记录
     */
	@Override
	public int recordCount(Map<String, Object> map) throws ServiceException {
		// TODO Auto-generated method stub
		return opt_orderinterfaceErrorDao.recordCount(map);
	}

	@Override
	public void doCreateOrderinterfaceError(
			OrderinterfaceErrorVO orderinterfaceErrorVO)
			throws ServiceException {
		opt_orderinterfaceErrorDao
				.doCreateOrderinterfaceError(orderinterfaceErrorVO);
	}

	@Override
	public void doDeleteOrderinterfaceError(Map<String, Object> deleteMap)
			throws ServiceException {
		opt_orderinterfaceErrorDao.doDeleteOrderinterfaceError(deleteMap);
	}

	@Override
	public List<OrderinterfaceErrorVO> queryOrderinterfaceErrorList(
			Map<String, Object> searchMap) throws ServiceException {
		return opt_orderinterfaceErrorDao
				.queryOrderinterfaceErrorList(searchMap);
	}

	@Override
	public OrderinterfaceErrorVO getOrderinterfaceErrorByOrderId(Long orderId)
			throws ServiceException {
		return opt_orderinterfaceErrorDao
				.getOrderinterfaceErrorByOrderId(orderId);
	}

}
