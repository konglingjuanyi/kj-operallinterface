package com.chengfeng.ne.opt.orders.domain;

import java.util.Date;

import com.chengfeng.common.BaseNeModel;

/**
 * <p>功能描述：订单地址库实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Snug.Chu
 * @version 1.0 2014-2-12 下午5:10:49
 */
public class OrderAddressLibraryVO extends BaseNeModel {
	private static final long serialVersionUID = 5454155825314635342L;
	/** 地址库ID */
	private Long libraryId;
	/** 收件客户名称 */
	private String customerName;
	/** 客户手机 */
	private String customerPhone;
	/** 客户电话 */
	private String customerTel;
	/** 国家 */
	private Long countryId;
	/** 省份 */
	private Long provinceId;
	/** 城市 */
	private Long cityId;
	/** 区/县 */
	private Long countyId;
	/** 邮编 */
	private String postcode;
	/** 地址 */
	private String address;
	/** 接单网点ID */
	private Long siteId;
	/** 备注 */
	private String remark;
	/** 创建人 */
	private Long createdBy;
	/** 创建时间 */
	private Date createdTime;
	/** 修改人 */
	private Long modifiedBy;
	/** 修改时间 */
	private Date modifiedTime;
	public Long getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
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
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
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
}
