package com.chengfeng.ne.basedata.domain;

import java.util.Date;

import com.chengfeng.common.BaseNeModel;

/**
 * <p>功能描述：区县实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
public class BasicCountyVO extends BaseNeModel {
	
	private static final long serialVersionUID = -3120403943891992827L;
	
	/** 区县自动编号 **/
	private Long countyId;
	/** 区县编号 **/
	private String countyCode;
	/** 区县名称 **/
	private String countyName;
	/** 区县名称拼音 **/
	private String countyPinyin;
	/** 区县排列顺序 **/
	private Long countyOrder;
	/** 所属城市自动编号 **/
	private Long cityId;
	/** 邮政编码 **/
	private String postcode;
	/** 是否全境派送(0：否，1：是，2:盲区) **/
	private Integer overallFlag;
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
	
	public BasicCountyVO() {
		super();
	}

	public Long getCountyId() {
		return countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getCountyPinyin() {
		return countyPinyin;
	}

	public void setCountyPinyin(String countyPinyin) {
		this.countyPinyin = countyPinyin;
	}

	public Long getCountyOrder() {
		return countyOrder;
	}

	public void setCountyOrder(Long countyOrder) {
		this.countyOrder = countyOrder;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Integer getOverallFlag() {
		return overallFlag;
	}

	public void setOverallFlag(Integer overallFlag) {
		this.overallFlag = overallFlag;
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
