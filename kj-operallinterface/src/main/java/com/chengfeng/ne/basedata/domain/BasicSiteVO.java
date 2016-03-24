package com.chengfeng.ne.basedata.domain;

import java.util.Date;
import java.util.List;

import com.chengfeng.common.BaseNeModel;

/**
 * <p>功能描述：站点实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
public class BasicSiteVO extends BaseNeModel implements java.io.Serializable {

	private static final long serialVersionUID = -9078807317311102046L;

	private Long siteId;				//站点自动编号
	private String siteCode;			//站点编号
	private String siteName;			//站点名称
	private String sitePinyin;			//站点名称拼音
	private Long siteOrder;				//站点排列顺序
	private Long parentSiteId;			//所属站点自动编号
	private Long scanCenterSiteId;		//扫描结算中心自动编号
	private Long billCenterSiteId;		//运单财务中心自动编号
	private Long siteTypeId;			//站点类型自动编号
	private Integer blFinance;			//开通站点财务功能
	private Double podLimitAmount;		//货到付款金额上限
	private Double codLimitAmount;		//代收货款金额上限
	private Double airplaneLimitAmount;	//航空件金额上限
	private Integer siteState;			//站点状态（1：正常、0：暂停、-1：失效）
	private Long moneyTypeId;			//货币类型ID
	private Integer starLevel;			//网点星级
	private Long sameSiteSite;			//相同站点自动编号
	private String remark;				//备注
	private Long createdBy;				//创建人
	private Date createdTime;			//创建时间
	private Long modifiedBy;			//修改人	
	private Date modifiedTime;			//修改时间
	private Integer rdStatus;			//记录数据状态（0：删除  1：正常）
	private BasicSiteDetailVO basicSiteDetail; //站点详细信息对象
	private BasicSiteRangeVO siteRange; //站点详细信息对象
	private String siteType;			//站点类型  类型判断用到
	private Long firstCenterSiteId; 	//首分拨中心
	private Long interfaceSiteId; 		//对接结算网点
	
	private Long countryId;				//网点所属国家
	private Long provinceId;			//网点所属省份
	private Long cityId;				//网点所属城市
	private Long countyId;				//网点所属区县
	private String parentSiteCode;		//所属网点编号
    private Integer siteServicesType;  //网点服务类型（1：寄件服务   2：派件服务   3：寄派服务)
    private Integer selfPermissions;   //自提权限（0：无权限  1：有权限）
    private Integer productPermissions;//产品类型权限（0：无权限  1：有权限）
    private Long dispSiteId; //20150807所属目的网点添加
    private Long mtlSiteId; //20150812物料申请网点添加
    
	private List<BasicSitePropVO> propArr; //网点属性
	private List<BasicSiteServicesVO> siteService; //网点属性
	
	/** 所属充值账户ID(网点所属子公司)-add-2015-07-01 **/
	private Long parentSiteBankId;
	
	public Long getMtlSiteId() {
		return mtlSiteId;
	}

	public void setMtlSiteId(Long mtlSiteId) {
		this.mtlSiteId = mtlSiteId;
	}

	public Long getDispSiteId() {
		return dispSiteId;
	}

	public void setDispSiteId(Long dispSiteId) {
		this.dispSiteId = dispSiteId;
	}

	public List<BasicSiteServicesVO> getSiteService() {
		return siteService;
	}

	public void setSiteService(List<BasicSiteServicesVO> siteService) {
		this.siteService = siteService;
	}

	public BasicSiteVO() {
		super();
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSitePinyin() {
		return sitePinyin;
	}

	public void setSitePinyin(String sitePinyin) {
		this.sitePinyin = sitePinyin;
	}

	public Long getSiteOrder() {
		return siteOrder;
	}

	public void setSiteOrder(Long siteOrder) {
		this.siteOrder = siteOrder;
	}

	public Long getParentSiteId() {
		return parentSiteId;
	}

	public void setParentSiteId(Long parentSiteId) {
		this.parentSiteId = parentSiteId;
	}

	public Long getScanCenterSiteId() {
		return scanCenterSiteId;
	}

	public void setScanCenterSiteId(Long scanCenterSiteId) {
		this.scanCenterSiteId = scanCenterSiteId;
	}

	public Long getBillCenterSiteId() {
		return billCenterSiteId;
	}

	public void setBillCenterSiteId(Long billCenterSiteId) {
		this.billCenterSiteId = billCenterSiteId;
	}

	public Long getSiteTypeId() {
		return siteTypeId;
	}

	public void setSiteTypeId(Long siteTypeId) {
		this.siteTypeId = siteTypeId;
	}

	public Integer getBlFinance() {
		return blFinance;
	}

	public void setBlFinance(Integer blFinance) {
		this.blFinance = blFinance;
	}

	public Double getPodLimitAmount() {
		return podLimitAmount;
	}

	public void setPodLimitAmount(Double podLimitAmount) {
		this.podLimitAmount = podLimitAmount;
	}

	public Double getCodLimitAmount() {
		return codLimitAmount;
	}

	public void setCodLimitAmount(Double codLimitAmount) {
		this.codLimitAmount = codLimitAmount;
	}

	public Double getAirplaneLimitAmount() {
		return airplaneLimitAmount;
	}

	public void setAirplaneLimitAmount(Double airplaneLimitAmount) {
		this.airplaneLimitAmount = airplaneLimitAmount;
	}

	public Integer getSiteState() {
		return siteState;
	}

	public void setSiteState(Integer siteState) {
		this.siteState = siteState;
	}

	public Long getMoneyTypeId() {
		return moneyTypeId;
	}

	public void setMoneyTypeId(Long moneyTypeId) {
		this.moneyTypeId = moneyTypeId;
	}

	public Integer getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(Integer starLevel) {
		this.starLevel = starLevel;
	}

	public Long getSameSiteSite() {
		return sameSiteSite;
	}

	public void setSameSiteSite(Long sameSiteSite) {
		this.sameSiteSite = sameSiteSite;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Integer getRdStatus() {
		return rdStatus;
	}

	public void setRdStatus(Integer rdStatus) {
		this.rdStatus = rdStatus;
	}

	public BasicSiteDetailVO getBasicSiteDetail() {
		return basicSiteDetail;
	}

	public void setBasicSiteDetail(BasicSiteDetailVO basicSiteDetail) {
		this.basicSiteDetail = basicSiteDetail;
	}

	public BasicSiteRangeVO getSiteRange() {
		return siteRange;
	}

	public void setSiteRange(BasicSiteRangeVO siteRange) {
		this.siteRange = siteRange;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public Long getFirstCenterSiteId() {
		return firstCenterSiteId;
	}

	public void setFirstCenterSiteId(Long firstCenterSiteId) {
		this.firstCenterSiteId = firstCenterSiteId;
	}

	public Long getInterfaceSiteId() {
		return interfaceSiteId;
	}

	public void setInterfaceSiteId(Long interfaceSiteId) {
		this.interfaceSiteId = interfaceSiteId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCountyId() {
		return countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

	public String getParentSiteCode() {
		return parentSiteCode;
	}

	public void setParentSiteCode(String parentSiteCode) {
		this.parentSiteCode = parentSiteCode;
	}

	public Integer getSiteServicesType() {
		return siteServicesType;
	}

	public void setSiteServicesType(Integer siteServicesType) {
		this.siteServicesType = siteServicesType;
	}

	public Integer getSelfPermissions() {
		return selfPermissions;
	}

	public void setSelfPermissions(Integer selfPermissions) {
		this.selfPermissions = selfPermissions;
	}

	public Integer getProductPermissions() {
		return productPermissions;
	}

	public void setProductPermissions(Integer productPermissions) {
		this.productPermissions = productPermissions;
	}

	public List<BasicSitePropVO> getPropArr() {
		return propArr;
	}

	public void setPropArr(List<BasicSitePropVO> propArr) {
		this.propArr = propArr;
	}

	public Long getParentSiteBankId() {
		return parentSiteBankId;
	}

	public void setParentSiteBankId(Long parentSiteBankId) {
		this.parentSiteBankId = parentSiteBankId;
	}
	
}
