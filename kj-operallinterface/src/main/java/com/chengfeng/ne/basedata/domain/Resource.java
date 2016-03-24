package com.chengfeng.ne.basedata.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Resource implements Serializable {
	
	
    private Integer resId;

    private String resName;

    private String resCode;

    private String resType;

    private String resDesc;

    private Integer parentResId;

    private String resSeq;

    private Integer resLevel;

    private Integer createdBy;

    private Date createdTime;

    private Integer modifiedBy;

    private Date modifiedTime;

    private String applicationCode;

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode == null ? null : resCode.trim();
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType == null ? null : resType.trim();
    }

    public String getResDesc() {
        return resDesc;
    }

    public void setResDesc(String resDesc) {
        this.resDesc = resDesc == null ? null : resDesc.trim();
    }

    public Integer getParentResId() {
        return parentResId;
    }

    public void setParentResId(Integer parentResId) {
        this.parentResId = parentResId;
    }

    public String getResSeq() {
        return resSeq;
    }

    public void setResSeq(String resSeq) {
        this.resSeq = resSeq == null ? null : resSeq.trim();
    }

    public Integer getResLevel() {
        return resLevel;
    }

    public void setResLevel(Integer resLevel) {
        this.resLevel = resLevel;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}