package com.chengfeng.ne.basedata.domain;

import java.util.Date;

import com.chengfeng.common.BaseNeModel;

/** 
 * <p>功能描述：站点详细信息实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2013-12-23 下午8:11:48
 */

public class BasicSiteDetailVO extends BaseNeModel  implements java.io.Serializable {

	private static final long serialVersionUID = 4015040960751129508L;
	 /**
	  * ID标识
	  * 对应数据库序列 SEQ_BASIC_SITE
	  */
	 private Long siteId;				//数据自动编号
     private Long managerEmployeeId;	//经理自动编号
     private String managerPhone;		//经理电话
     private Long qryEmployeeId;		//查件负责人自动编号
     private String qryPhone;			//查件处理电话
     private Long taobaoEmployeeId;		//电商负责人自动编号
     private String taobaoPhone;		//电商处理电话
     private Long problemEmployeeId;	//问题处理负责人自动编号
     private String problemPhone;		//问题处理电话
     private Long saleEmployeeId;		//业务负责人自动编号
     private String salePhone;			//业务联系电话
     private Long sosEmployeeId;		//紧急事务处理人自动编号
     private String sosPhone;			//紧急事务联系电话
     private String phoneSms;			//短信通知号码
     private String fax;				//传真号码
     private String postCode;			//邮编
     private String address;			//地址
     private Long countryId;			//国家自动编号
     private Long provinceId;			//省份自动编号
     private Long cityId;				//城市自动编号
     private Long countyId;				//区县自动编号
     private Long areaId;				//片区自动编号
     private String siteExplain;		//站点说明
     private Long siteExplainId;		//站点说明id
     private Date startDate;			//合同开始日期
     private Date endDate;				//合同结束日期
     private Integer blWeb;					//网站显示
     private Long webParentSiteId;		//网站所属站点自动编号
     private String webName;			//网站显示名称
     private Long bankId;				//银行自动编号
     private String remark;				//备注
     private Long bankAccountId;		//银行开户行ID
     private String bankAccountName;	//银行开户户名
     private String bankAccountNo;		//银行开户帐号
     private Long normalTeuIn;			//正常货物吞吐量（入）
     private Long maxTeuIn;				//最大货物吞吐量（入）
     private Long normalTeuOut;			//正常货物吞吐量（出）
     private Long maxTeuOut;			//最大货物吞吐量（出）
     private Float maxStayRatio;		//最大留仓件比例
     private Float maxProblemRatio;		//最大问题件比例
     
     private Long interfaceSiteId;		//对接结算网点
     
     /** 网站名称 */
     private String empName;
     /**   */
     private Long depositCurrencyId;
     /**   */
     private Double depositAmount;
     /**   */
     private Long joinCurrencyId;
     /**   */
     private Double joinAmount;
     /** 货量统计所属分拨中心  */
     private Long cargoCenterSiteId;
     
     /** 派送范围ID  */
     private Long rangeClobId;
     /** 不派送范围ID  */
     private Long outRangeClobId;
     /** 特殊范围ID  */
     private Long specialRangeClobId;
     /** 派送范围  */
     private String rangeClob;
     /** 不派送范围  */
     private String outRangeClob;
     /** 特殊范围  */
     private String specialRangeClob;
     /**网点服务类型（1：寄件服务   2：派件服务   3：寄派服务）  */
     private Integer siteServicesType;
     
     /** 省份名称 **/
     private String provinceName;
     /** 城市名称 **/
     private String cityName;
    
     /** 经理 **/
     private String managerEmployeeName;
     /** 查件负责人 **/
     private String qryEmployeeName;
     /** 电商负责人 **/
     private String taobaoEmployeeName;
     /** 问题处理负责人 **/
     private String problemEmployeeName;
     /** 业务负责人 **/
     private String saleEmployeeName;
     /** 紧急事务处理人 **/
     private String sosEmployeeName;
     
     
    public String getManagerEmployeeName() {
		return managerEmployeeName;
	}

	public void setManagerEmployeeName(String managerEmployeeName) {
		this.managerEmployeeName = managerEmployeeName;
	}

	public String getQryEmployeeName() {
		return qryEmployeeName;
	}

	public void setQryEmployeeName(String qryEmployeeName) {
		this.qryEmployeeName = qryEmployeeName;
	}

	public String getTaobaoEmployeeName() {
		return taobaoEmployeeName;
	}

	public void setTaobaoEmployeeName(String taobaoEmployeeName) {
		this.taobaoEmployeeName = taobaoEmployeeName;
	}

	public String getProblemEmployeeName() {
		return problemEmployeeName;
	}

	public void setProblemEmployeeName(String problemEmployeeName) {
		this.problemEmployeeName = problemEmployeeName;
	}

	public String getSaleEmployeeName() {
		return saleEmployeeName;
	}

	public void setSaleEmployeeName(String saleEmployeeName) {
		this.saleEmployeeName = saleEmployeeName;
	}

	public String getSosEmployeeName() {
		return sosEmployeeName;
	}

	public void setSosEmployeeName(String sosEmployeeName) {
		this.sosEmployeeName = sosEmployeeName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getRangeClobId() {
		return rangeClobId;
	}

	public void setRangeClobId(Long rangeClobId) {
		this.rangeClobId = rangeClobId;
	}

	public Long getOutRangeClobId() {
		return outRangeClobId;
	}

	public void setOutRangeClobId(Long outRangeClobId) {
		this.outRangeClobId = outRangeClobId;
	}

	public Long getSpecialRangeClobId() {
		return specialRangeClobId;
	}

	public void setSpecialRangeClobId(Long specialRangeClobId) {
		this.specialRangeClobId = specialRangeClobId;
	}

	public String getRangeClob() {
		return rangeClob;
	}

	public void setRangeClob(String rangeClob) {
		this.rangeClob = rangeClob;
	}

	public String getOutRangeClob() {
		return outRangeClob;
	}

	public void setOutRangeClob(String outRangeClob) {
		this.outRangeClob = outRangeClob;
	}

	public String getSpecialRangeClob() {
		return specialRangeClob;
	}

	public void setSpecialRangeClob(String specialRangeClob) {
		this.specialRangeClob = specialRangeClob;
	}

	public BasicSiteDetailVO() {
    }
    
	public Long getCargoCenterSiteId() {
		return cargoCenterSiteId;
	}

	public void setCargoCenterSiteId(Long cargoCenterSiteId) {
		this.cargoCenterSiteId = cargoCenterSiteId;
	}

	public Long getDepositCurrencyId() {
		return depositCurrencyId;
	}

	public void setDepositCurrencyId(Long depositCurrencyId) {
		this.depositCurrencyId = depositCurrencyId;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Long getJoinCurrencyId() {
		return joinCurrencyId;
	}

	public void setJoinCurrencyId(Long joinCurrencyId) {
		this.joinCurrencyId = joinCurrencyId;
	}

	public Double getJoinAmount() {
		return joinAmount;
	}

	public void setJoinAmount(Double joinAmount) {
		this.joinAmount = joinAmount;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Long getSiteExplainId() {
		return siteExplainId;
	}

	public void setSiteExplainId(Long siteExplainId) {
		this.siteExplainId = siteExplainId;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getManagerEmployeeId() {
		return managerEmployeeId;
	}

	public void setManagerEmployeeId(Long managerEmployeeId) {
		this.managerEmployeeId = managerEmployeeId;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public Long getQryEmployeeId() {
		return qryEmployeeId;
	}

	public void setQryEmployeeId(Long qryEmployeeId) {
		this.qryEmployeeId = qryEmployeeId;
	}

	public String getQryPhone() {
		return qryPhone;
	}

	public void setQryPhone(String qryPhone) {
		this.qryPhone = qryPhone;
	}

	public Long getTaobaoEmployeeId() {
		return taobaoEmployeeId;
	}

	public void setTaobaoEmployeeId(Long taobaoEmployeeId) {
		this.taobaoEmployeeId = taobaoEmployeeId;
	}

	public String getTaobaoPhone() {
		return taobaoPhone;
	}

	public void setTaobaoPhone(String taobaoPhone) {
		this.taobaoPhone = taobaoPhone;
	}

	public Long getProblemEmployeeId() {
		return problemEmployeeId;
	}

	public void setProblemEmployeeId(Long problemEmployeeId) {
		this.problemEmployeeId = problemEmployeeId;
	}

	public String getProblemPhone() {
		return problemPhone;
	}

	public void setProblemPhone(String problemPhone) {
		this.problemPhone = problemPhone;
	}

	public Long getSaleEmployeeId() {
		return saleEmployeeId;
	}

	public void setSaleEmployeeId(Long saleEmployeeId) {
		this.saleEmployeeId = saleEmployeeId;
	}

	public String getSalePhone() {
		return salePhone;
	}

	public void setSalePhone(String salePhone) {
		this.salePhone = salePhone;
	}

	public Long getSosEmployeeId() {
		return sosEmployeeId;
	}

	public void setSosEmployeeId(Long sosEmployeeId) {
		this.sosEmployeeId = sosEmployeeId;
	}

	public String getSosPhone() {
		return sosPhone;
	}

	public void setSosPhone(String sosPhone) {
		this.sosPhone = sosPhone;
	}

	public String getPhoneSms() {
		return phoneSms;
	}

	public void setPhoneSms(String phoneSms) {
		this.phoneSms = phoneSms;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getSiteExplain() {
		return siteExplain;
	}

	public void setSiteExplain(String siteExplain) {
		this.siteExplain = siteExplain;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	

	public Integer getBlWeb() {
		return blWeb;
	}




	public void setBlWeb(Integer blWeb) {
		this.blWeb = blWeb;
	}




	public Long getWebParentSiteId() {
		return webParentSiteId;
	}

	public void setWebParentSiteId(Long webParentSiteId) {
		this.webParentSiteId = webParentSiteId;
	}

	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}


	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public Long getNormalTeuIn() {
		return normalTeuIn;
	}

	public void setNormalTeuIn(Long normalTeuIn) {
		this.normalTeuIn = normalTeuIn;
	}

	public Long getMaxTeuIn() {
		return maxTeuIn;
	}

	public void setMaxTeuIn(Long maxTeuIn) {
		this.maxTeuIn = maxTeuIn;
	}

	public Long getNormalTeuOut() {
		return normalTeuOut;
	}

	public void setNormalTeuOut(Long normalTeuOut) {
		this.normalTeuOut = normalTeuOut;
	}

	public Long getMaxTeuOut() {
		return maxTeuOut;
	}

	public void setMaxTeuOut(Long maxTeuOut) {
		this.maxTeuOut = maxTeuOut;
	}

	public Float getMaxStayRatio() {
		return maxStayRatio;
	}

	public void setMaxStayRatio(Float maxStayRatio) {
		this.maxStayRatio = maxStayRatio;
	}

	public Float getMaxProblemRatio() {
		return maxProblemRatio;
	}

	public void setMaxProblemRatio(Float maxProblemRatio) {
		this.maxProblemRatio = maxProblemRatio;
	}

	public Long getInterfaceSiteId() {
		return interfaceSiteId;
	}


	public void setInterfaceSiteId(Long interfaceSiteId) {
		this.interfaceSiteId = interfaceSiteId;
	}

	public Integer getSiteServicesType() {
		return siteServicesType;
	}

	public void setSiteServicesType(Integer siteServicesType) {
		this.siteServicesType = siteServicesType;
	}

	@Override
	public String toString() {
		return "BasicSiteDetailVO [siteId=" + siteId + ", managerEmployeeId="
				+ managerEmployeeId + ", managerPhone=" + managerPhone
				+ ", qryEmployeeId=" + qryEmployeeId + ", qryPhone=" + qryPhone
				+ ", taobaoEmployeeId=" + taobaoEmployeeId + ", taobaoPhone="
				+ taobaoPhone + ", problemEmployeeId=" + problemEmployeeId
				+ ", problemPhone=" + problemPhone + ", saleEmployeeId="
				+ saleEmployeeId + ", salePhone=" + salePhone
				+ ", sosEmployeeId=" + sosEmployeeId + ", sosPhone=" + sosPhone
				+ ", phoneSms=" + phoneSms + ", fax=" + fax + ", postCode="
				+ postCode + ", address=" + address + ", countryId="
				+ countryId + ", provinceId=" + provinceId + ", cityId="
				+ cityId + ", countyId=" + countyId + ", areaId=" + areaId
				+ ", siteExplain=" + siteExplain + ", siteExplainId="
				+ siteExplainId + ", startDate=" + startDate + ", endDate="
				+ endDate + ", blWeb=" + blWeb + ", webParentSiteId="
				+ webParentSiteId + ", webName=" + webName + ", bankId="
				+ bankId + ", remark=" + remark + ", bankAccountId="
				+ bankAccountId + ", bankAccountName=" + bankAccountName
				+ ", bankAccountNo=" + bankAccountNo + ", normalTeuIn="
				+ normalTeuIn + ", maxTeuIn=" + maxTeuIn + ", normalTeuOut="
				+ normalTeuOut + ", maxTeuOut=" + maxTeuOut + ", maxStayRatio="
				+ maxStayRatio + ", maxProblemRatio=" + maxProblemRatio
				+ ", interfaceSiteId=" + interfaceSiteId + ", empName="
				+ empName + ", depositCurrencyId=" + depositCurrencyId
				+ ", depositAmount=" + depositAmount + ", joinCurrencyId="
				+ joinCurrencyId + ", joinAmount=" + joinAmount
				+ ", cargoCenterSiteId=" + cargoCenterSiteId + ", rangeClobId="
				+ rangeClobId + ", outRangeClobId=" + outRangeClobId
				+ ", specialRangeClobId=" + specialRangeClobId + ", rangeClob="
				+ rangeClob + ", outRangeClob=" + outRangeClob
				+ ", specialRangeClob=" + specialRangeClob + "]";
	}

	

}