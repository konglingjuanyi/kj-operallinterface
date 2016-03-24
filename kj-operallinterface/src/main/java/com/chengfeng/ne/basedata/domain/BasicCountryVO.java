package com.chengfeng.ne.basedata.domain;

import java.util.Date;

import com.chengfeng.common.BaseNeModel;

/**
 * <p>功能描述：国家实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
public class BasicCountryVO extends BaseNeModel {
	/** 国家自动编号 **/
	private Long countryId;	
	/** 国家编号 **/
	private String countryCode;
	/** 国家名称 **/
	private String countryName;	
	/** 国家名称拼音 **/
	private String countryPinyin;
	/** 国家排列顺序 **/
	private Long countryOrder;
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
	
	public BasicCountryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BasicCountryVO(Long countryId, String countryCode, String countryName,
			String countryPinyin, Long countryOrder, String remark,
			Long createdBy, Date createdTime, Long modifiedBy,
			Date modifiedTime, Integer rdStatus) {
		super();
		this.countryId = countryId;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.countryPinyin = countryPinyin;
		this.countryOrder = countryOrder;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
		this.rdStatus = rdStatus;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryPinyin() {
		return countryPinyin;
	}

	public void setCountryPinyin(String countryPinyin) {
		this.countryPinyin = countryPinyin;
	}

	public Long getCountryOrder() {
		return countryOrder;
	}

	public void setCountryOrder(Long countryOrder) {
		this.countryOrder = countryOrder;
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
}
