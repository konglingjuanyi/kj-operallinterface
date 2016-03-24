package com.chengfeng.ne.basedata.domain;


import java.util.Date;

import com.chengfeng.common.BaseNeModel;
/**
 * 
 * <p>功能描述：站点收派范围</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2013-12-23 下午8:15:09
 */
public class BasicSiteRangeVO extends BaseNeModel  implements java.io.Serializable {

	private static final long serialVersionUID = -3663316606317155504L;
	/**
	 * ID标识
	 * 对应序列 SEQ_SITE_RANGE
	 */
	 private Long siteRangeId;		//数据自动编号
	 private Long siteId;			//站点id
     private Integer rangeType;		//范围类型（1：收派范围0:不派送范围2:特殊派送范围）
     private String rangeName;		//范围名称范围名称（弄名、路名、大厦名、园区名）
     private Integer startNo;		//开始号（路、弄的号码）
     private Integer endNo;			//结束号（路、弄的号码）
     private String remark;			//备注
     private Long createdBy;		//创建人 
     private Date createdTime;		//创建时间
     private Long modifiedBy;		//修改人
     private Date modifiedTime;		//修改时间
     private Integer rdStatus;		//记录数据状态（0：删除 1：正常）
	
   
	public Long getSiteRangeId() {
		return siteRangeId;
	}
	public void setSiteRangeId(Long siteRangeId) {
		this.siteRangeId = siteRangeId;
	}
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public Integer getRangeType() {
		return rangeType;
	}
	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}
	public String getRangeName() {
		return rangeName;
	}
	public void setRangeName(String rangeName) {
		this.rangeName = rangeName;
	}
	public Integer getStartNo() {
		return startNo;
	}
	public void setStartNo(Integer startNo) {
		this.startNo = startNo;
	}
	public Integer getEndNo() {
		return endNo;
	}
	public void setEndNo(Integer endNo) {
		this.endNo = endNo;
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
	public BasicSiteRangeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BasicSiteRangeVO(Long siteRangeId, Long siteId, Integer rangeType,
			String rangeName, Integer startNo, Integer endNo, String remark,
			Long createdBy, Date createdTime, Long modifiedBy,
			Date modifiedTime, Integer rdStatus) {
		super();
		this.siteRangeId = siteRangeId;
		this.siteId = siteId;
		this.rangeType = rangeType;
		this.rangeName = rangeName;
		this.startNo = startNo;
		this.endNo = endNo;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
		this.rdStatus = rdStatus;
	}
	@Override
	public String toString() {
		return "BasicSiteRange [siteRangeId=" + siteRangeId + ", siteId="
				+ siteId + ", rangeType=" + rangeType + ", rangeName="
				+ rangeName + ", startNo=" + startNo + ", endNo=" + endNo
				+ ", remark=" + remark + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", rdStatus=" + rdStatus
				+ "]";
	}

}