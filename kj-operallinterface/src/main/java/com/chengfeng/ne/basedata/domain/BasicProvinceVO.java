package com.chengfeng.ne.basedata.domain;

import java.util.Date;

import com.chengfeng.common.BaseNeModel;

/**
 * <p>功能描述：省份实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
public class BasicProvinceVO extends BaseNeModel {
	
	/** 省份自动编号 **/
	private Long provinceId;
	/** 省份编号 **/
	private String provinceCode;
	/** 省份名称 **/
	private String provinceName;
	/** 省份名称拼音 **/
	private String provincePinyin;
	/** 省份排列顺序 **/
	private Long provinceOrder;	
	/** 所属国家自动编号 **/
	private Long countryId;	
	/** 备注 **/
	private String remark;
	/** 创建人 **/
	private Long createdBy;	
	/** 创建时间 **/
	private Date createdTime;
	/** 修改人 **/
	private Long modifiedBy;
	/** 修改时间 **/
	private Date modifiedTime;
	/** 数据状态(0：删除  1：正常) **/
	private Integer rdStatus;
	
	public BasicProvinceVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BasicProvinceVO(Long provinceId, String provinceCode,
			String provinceName, String provincePinyin, Long provinceOrder,
			Long countryId, String remark, Long createdBy, Date createdTime,
			Long modifiedBy, Date modifiedTime, Integer rdStatus) {
		super();
		this.provinceId = provinceId;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
		this.provincePinyin = provincePinyin;
		this.provinceOrder = provinceOrder;
		this.countryId = countryId;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
		this.rdStatus = rdStatus;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvincePinyin() {
		return provincePinyin;
	}

	public void setProvincePinyin(String provincePinyin) {
		this.provincePinyin = provincePinyin;
	}

	public Long getProvinceOrder() {
		return provinceOrder;
	}

	public void setProvinceOrder(Long provinceOrder) {
		this.provinceOrder = provinceOrder;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
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

	@Override
	public String toString() {
		return "BasicProvinceVO [provinceId=" + provinceId + ", provinceCode="
				+ provinceCode + ", provinceName=" + provinceName
				+ ", provincePinyin=" + provincePinyin + ", provinceOrder="
				+ provinceOrder + ", countryId=" + countryId + ", remark="
				+ remark + ", createdBy=" + createdBy + ", createdTime="
				+ createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", rdStatus=" + rdStatus
				+ "]";
	}
	
}
