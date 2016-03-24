package com.chengfeng.ne.basedata.domain;

import java.io.Serializable;
import java.util.Date;

import com.chengfeng.common.BaseNeModel;

/**
 * <p>功能描述：区域管理业务开发实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * 对应数据库 表:HS_BASIC_AREA 
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong 
 * @version 1.0 2013-12-23 上午9:50:03 
 */
public class BasicAreaVO extends BaseNeModel implements Serializable  {
	
	private static final long serialVersionUID = 5797260015663529880L;
	/**
	 * ID标识
	 * 对应数据库序列SEQ_BASIC_AREA
	 */   
	private Long areaId; 			//片区自动编号
	private String areaCode;		//片区编号 
	private String areaName;		//片区名称
	private String areaPinyin;		//片区名称拼音
	private Long areaOrder;			//片区排列顺序
	private Long parentAreaId;		//上级片区ID
	private Integer areaLevel;		//层级
	private String remark;			//备注
	private Long createdBy;			//创建人
	private Date createdTime;		//创建时间
	private Long modifiedBy;		//修改人
	private Date modifiedTime;		//修改时间
	private Integer rdStatus;		//记录数据状态（0：删除  1：正常）
	
	public Integer getRdStatus() {
		return rdStatus;
	}
	public void setRdStatus(Integer rdStatus) {
		this.rdStatus = rdStatus;
	}
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaPinyin() {
		return areaPinyin;
	}
	public void setAreaPinyin(String areaPinyin) {
		this.areaPinyin = areaPinyin;
	}
	public Long getAreaOrder() {
		return areaOrder;
	}
	public void setAreaOrder(Long areaOrder) {
		this.areaOrder = areaOrder;
	}
	public Long getParentAreaId() {
		return parentAreaId;
	}
	public void setParentAreaId(Long parentAreaId) {
		this.parentAreaId = parentAreaId;
	}
	public Integer getAreaLevel() {
		return areaLevel;
	}
	public void setAreaLevel(Integer areaLevel) {
		this.areaLevel = areaLevel;
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
	public BasicAreaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BasicAreaVO(Long areaId, String areaCode, String areaName,
			String areaPinyin, Long areaOrder, Long parentAreaId,
			Integer areaLevel, String remark, Long createdBy, Date createdTime,
			Long modifiedBy, Date modifiedTime) {
		super();
		this.areaId = areaId;
		this.areaCode = areaCode;
		this.areaName = areaName;
		this.areaPinyin = areaPinyin;
		this.areaOrder = areaOrder;
		this.parentAreaId = parentAreaId;
		this.areaLevel = areaLevel;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
	}
	@Override
	public String toString() {
		return "BasicArea [areaId=" + areaId + ", areaCode=" + areaCode
				+ ", areaName=" + areaName + ", areaPinyin=" + areaPinyin
				+ ", areaOrder=" + areaOrder + ", parentAreaId=" + parentAreaId
				+ ", areaLevel=" + areaLevel + ", remark=" + remark
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", modifiedBy=" + modifiedBy + ", modifiedTime="
				+ modifiedTime + ", rdStatus=" + rdStatus + "]";
	}

}
