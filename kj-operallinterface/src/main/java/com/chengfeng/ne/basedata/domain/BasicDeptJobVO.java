package com.chengfeng.ne.basedata.domain;

import java.io.Serializable;

import com.chengfeng.common.BaseNeModel;

/**
 * <p>功能描述：岗位部门关系实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2013-12-25 上午10:50:23
 */
public class BasicDeptJobVO extends BaseNeModel  implements Serializable {

	private static final long serialVersionUID = 1991457568127649038L;
	private Long deptJobId; //部门岗位ID
	private Long jobId; //岗位ID
	private Long deptId;//部门ID
	private String deptJobName; //部门岗位名称
	
	public Long getDeptJobId() {
		return deptJobId;
	}
	public void setDeptJobId(Long deptJobId) {
		this.deptJobId = deptJobId;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptJobName() {
		return deptJobName;
	}
	public void setDeptJobName(String deptJobName) {
		this.deptJobName = deptJobName;
	}
	public BasicDeptJobVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BasicDeptJobVO(Long deptJobId, Long jobId, Long deptId,
			String deptJobName) {
		super();
		this.deptJobId = deptJobId;
		this.jobId = jobId;
		this.deptId = deptId;
		this.deptJobName = deptJobName;
	}
	@Override
	public String toString() {
		return "BasicDeptJob [deptJobId=" + deptJobId + ", jobId=" + jobId
				+ ", deptId=" + deptId + ", deptJobName=" + deptJobName + "]";
	}
	
}
