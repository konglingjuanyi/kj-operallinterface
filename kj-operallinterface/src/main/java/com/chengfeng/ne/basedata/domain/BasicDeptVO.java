package com.chengfeng.ne.basedata.domain;

import java.util.Date;

import com.chengfeng.common.BaseNeModel;

/**
 * <p>功能描述：部门实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
public class BasicDeptVO extends BaseNeModel  implements java.io.Serializable  {

	private static final long serialVersionUID = -1420007170186259041L;
	private Long deptId;			//部门自动编号
	private String deptCode;		//部门编号
	private String deptName;		//部门名称
	private String deptFullName;	//部门全称
	private String deptPinyin;		//部门名称拼音
	private Long deptOrder;			//部门排列顺序
	private Long siteTypeId;		//站点类型ID
	private Long parentDeptId;		//上级部门ID
	private Integer areaLevel;			//层级
	private Long managerEmployeeId;//经理自动编号
	private String linkPhone;		//联系电话
	private String fax;				//传真
	private String remark;			//备注
	private Long createdBy;		//创建人
	private Date createdTime;		//创建时间
	private Long modifiedBy;		//修改人
	private Date modifiedTime;		//修改时间
	private	Integer rdStatus;		//记录数据状态（0：删除 1：正常）
	
	public BasicDeptVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptFullName() {
		return deptFullName;
	}

	public void setDeptFullName(String deptFullName) {
		this.deptFullName = deptFullName;
	}

	public String getDeptPinyin() {
		return deptPinyin;
	}

	public void setDeptPinyin(String deptPinyin) {
		this.deptPinyin = deptPinyin;
	}

	public Long getDeptOrder() {
		return deptOrder;
	}

	public void setDeptOrder(Long deptOrder) {
		this.deptOrder = deptOrder;
	}

	public Long getSiteTypeId() {
		return siteTypeId;
	}

	public void setSiteTypeId(Long siteTypeId) {
		this.siteTypeId = siteTypeId;
	}

	public Long getParentDeptId() {
		return parentDeptId;
	}

	public void setParentDeptId(Long parentDeptId) {
		this.parentDeptId = parentDeptId;
	}

	

	public Integer getAreaLevel() {
		return areaLevel;
	}

	public void setAreaLevel(Integer areaLevel) {
		this.areaLevel = areaLevel;
	}

	public Integer getRdStatus() {
		return rdStatus;
	}

	public void setRdStatus(Integer rdStatus) {
		this.rdStatus = rdStatus;
	}

	public Long getManagerEmployeeId() {
		return managerEmployeeId;
	}

	public void setManagerEmployeeId(Long managerEmployeeId) {
		this.managerEmployeeId = managerEmployeeId;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	public Integer getRdStstus() {
		return rdStatus;
	}

	public void setRdStstus(Integer rdStatus) {
		this.rdStatus = rdStatus;
	}

	public BasicDeptVO(Long deptId, String deptCode, String deptName,
			String deptFullName, String deptPinyin, Long deptOrder,
			Long siteTypeId, Long parentDeptId, int areaLevel,
			Long managerEmployeeId, String linkPhone, String fax,
			String remark, Long createdBy, Date createdTime, Long modifiedBy,
			Date modifiedTime, Integer rdStatus) {
		super();
		this.deptId = deptId;
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.deptFullName = deptFullName;
		this.deptPinyin = deptPinyin;
		this.deptOrder = deptOrder;
		this.siteTypeId = siteTypeId;
		this.parentDeptId = parentDeptId;
		this.areaLevel = areaLevel;
		this.managerEmployeeId = managerEmployeeId;
		this.linkPhone = linkPhone;
		this.fax = fax;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
		this.rdStatus = rdStatus;
	}

	@Override
	public String toString() {
		return "BasicDept [deptId=" + deptId + ", deptCode=" + deptCode
				+ ", deptName=" + deptName + ", deptFullName=" + deptFullName
				+ ", deptPinyin=" + deptPinyin + ", deptOrder=" + deptOrder
				+ ", siteTypeId=" + siteTypeId + ", parentDeptId="
				+ parentDeptId + ", areaLevel=" + areaLevel
				+ ", managerEmployeeId=" + managerEmployeeId + ", linkPhone="
				+ linkPhone + ", fax=" + fax + ", remark=" + remark
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", modifiedBy=" + modifiedBy + ", modifiedTime="
				+ modifiedTime + ", rdStatus=" + rdStatus + "]";
	}

}
