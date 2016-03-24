package com.chengfeng.ne.basedata.domain;


import java.util.Date;

import com.chengfeng.common.BaseNeModel;

/**
 * 
 * <p>功能描述：岗位实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2013-12-23 下午2:54:52
 */

public class BasicJobVO extends BaseNeModel  implements java.io.Serializable {

	private static final long serialVersionUID = -43314036321883303L;
	
	 /**
	  * ID标识
	  * 对应数据库序列 SEQ_BASIC_JOB
	  */
	 private Long jobId;		//数据自动编号
     private String jobCode;	//数据编号 
     private String jobName;	//数据名称
     private String jobPinyin;	//数据名称拼音
     private Long jobOrder;		//数据排列顺序
     private String remark;		//备注
     private Long createdBy;	//创建人  
     private Date createdTime;	//创建时间
     private Long modifiedBy;	//修改人
     private Date modifiedTime;	 //修改时间
 	 private Integer rdStatus;		//记录数据状态（0：删除 1：正常）
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobPinyin() {
		return jobPinyin;
	}
	public void setJobPinyin(String jobPinyin) {
		this.jobPinyin = jobPinyin;
	}
	public Long getJobOrder() {
		return jobOrder;
	}
	public void setJobOrder(Long jobOrder) {
		this.jobOrder = jobOrder;
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
	public BasicJobVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BasicJobVO(Long jobId, String jobCode, String jobName,
			String jobPinyin, Long jobOrder, String remark, Long createdBy,
			Date createdTime, Long modifiedBy, Date modifiedTime,
			Integer rdStatus) {
		super();
		this.jobId = jobId;
		this.jobCode = jobCode;
		this.jobName = jobName;
		this.jobPinyin = jobPinyin;
		this.jobOrder = jobOrder;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
		this.rdStatus = rdStatus;
	}
	@Override
	public String toString() {
		return "BasicJob [jobId=" + jobId + ", jobCode=" + jobCode
				+ ", jobName=" + jobName + ", jobPinyin=" + jobPinyin
				+ ", jobOrder=" + jobOrder + ", remark=" + remark
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", modifiedBy=" + modifiedBy + ", modifiedTime="
				+ modifiedTime + ", rdStatus=" + rdStatus + "]";
	}
 	 
}