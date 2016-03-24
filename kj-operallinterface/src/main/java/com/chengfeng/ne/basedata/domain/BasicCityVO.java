package com.chengfeng.ne.basedata.domain;

import java.util.Date;

import com.chengfeng.common.BaseNeModel;

/**
 * <p>功能描述：城市实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
public class BasicCityVO extends BaseNeModel {
	
	private static final long serialVersionUID = -3120413343891992827L;
	/** 城市自动编号 **/
	private Long cityId;
	/** 城市编号 **/
	private String cityCode;
	/** 城市名称 **/
	private String cityName;
	/** 城市名称拼音 **/
	private String cityPinyin;
	/** 城市排列顺序 **/
	private Long cityOrder;	
	/** 所属省份自动编号 **/
	private Long provinceId;
	/** 邮政编码 **/
	private String postcode;
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
	/**数据状态(0：删除  1：正常)**/
	private Integer rdStatus;
	
	public BasicCityVO() {
		super();
	}

	public BasicCityVO(Long cityId, String cityCode, String cityName,
			String cityPinyin, Long cityOrder, Long provinceId,
			String postcode, String remark, Long createdBy, Date createdTime,
			Long modifiedBy, Date modifiedTime, Integer rdStatus) {
		super();
		this.cityId = cityId;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.cityPinyin = cityPinyin;
		this.cityOrder = cityOrder;
		this.provinceId = provinceId;
		this.postcode = postcode;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
		this.rdStatus = rdStatus;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityPinyin() {
		return cityPinyin;
	}

	public void setCityPinyin(String cityPinyin) {
		this.cityPinyin = cityPinyin;
	}

	public Long getCityOrder() {
		return cityOrder;
	}

	public void setCityOrder(Long cityOrder) {
		this.cityOrder = cityOrder;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
