package com.chengfeng.ne.basedata.domain;

import java.util.Date;

import com.chengfeng.common.BaseNeModel;

/**
 * 
 * 功能描述：系统参数实体类
 *
 * Copyright: Copyright (c) 2016
 *
 * Company: 丞风智能科技有限公司
 * 
 * @author Pippo
 *
 * @version 2016-1-7
 */
public class GlobalConfigVO extends BaseNeModel implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1780741210912352942L;
	/** 全局设置ID  */
	private Long globalConfigId;
	
	/** 全局设置编号 */
    private String globalConfigCode;
    
    /** 全局设置名称 */
    private String globalConfigName;
    
    /** 全局设置值 */
    private String globalConfigValue;
    
    /** 维护显示（是否可以交由客户去维护） */
    private Short blUser;
    
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
    
    /** 记录数据状态（0：删除  1：正常）  */
    private Short rdStatus;

	public GlobalConfigVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GlobalConfigVO(Long globalConfigId, String globalConfigCode,
			String globalConfigName, String globalConfigValue, Short blUser,
			String remark, Long createdBy, Date createdTime, Long modifiedBy,
			Date modifiedTime, Short rdStatus) {
		super();
		this.globalConfigId = globalConfigId;
		this.globalConfigCode = globalConfigCode;
		this.globalConfigName = globalConfigName;
		this.globalConfigValue = globalConfigValue;
		this.blUser = blUser;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
		this.rdStatus = rdStatus;
	}

	public Long getGlobalConfigId() {
		return globalConfigId;
	}

	public void setGlobalConfigId(Long globalConfigId) {
		this.globalConfigId = globalConfigId;
	}

	public String getGlobalConfigCode() {
		return globalConfigCode;
	}

	public void setGlobalConfigCode(String globalConfigCode) {
		this.globalConfigCode = globalConfigCode;
	}

	public String getGlobalConfigName() {
		return globalConfigName;
	}

	public void setGlobalConfigName(String globalConfigName) {
		this.globalConfigName = globalConfigName;
	}

	public String getGlobalConfigValue() {
		return globalConfigValue;
	}

	public void setGlobalConfigValue(String globalConfigValue) {
		this.globalConfigValue = globalConfigValue;
	}

	public Short getBlUser() {
		return blUser;
	}

	public void setBlUser(Short blUser) {
		this.blUser = blUser;
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

	public Short getRdStatus() {
		return rdStatus;
	}

	public void setRdStatus(Short rdStatus) {
		this.rdStatus = rdStatus;
	}

	@Override
	public String toString() {
		return "GlobalConfigVO [globalConfigId=" + globalConfigId
				+ ", globalConfigCode=" + globalConfigCode
				+ ", globalConfigName=" + globalConfigName
				+ ", globalConfigValue=" + globalConfigValue + ", blUser="
				+ blUser + ", remark=" + remark + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", rdStatus=" + rdStatus
				+ "]";
	} 
}