package com.chengfeng.ne.basedata.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;

import com.chengfeng.common.BaseNeModel;

/**
 * 
 * <p>
 * 功能描述：
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013
 * </p>
 * <p>
 * Company: ThinkJF
 * </p>
 * 
 * @author Freeman
 * @version 1.0 2014-3-7 上午12:42:49
 */
public class User extends BaseNeModel implements UserDetails {

	private static final long serialVersionUID = -5815694677911616853L;

	public enum UserStatus {
		/**正常**/
		N,
		/**锁定**/
		L,
		/**删除**/
		D;
	}

	/**
	 * 用户类型
	 */
	public enum UserType {
		/**普通用户**/
		NORMAL,
		/**管理员**/
		ADMIN,
		/**只读管理员**/
		READONLY;
	}
	private Integer roleCount;
	private Long userId;
	private String userName;
	private String userPwd;
	private Long userType;
	private Long employeeId;
	private String siteName;
	private Boolean blOa;
	private String pdaPwd;
	private Date expireDate;
	private Long failureTimes;
	private Long messageInterval;
	private Date lastOperateTime;
	private String lastOperateIp;
	private String remark;
	private String status;
	private Long createdBy;
	private Date createdTime;
	private Long modifiedBy;
	private Date modifiedTime;
	private Integer rdStatus;

	private String style;
	
	private List<Role> roles = new ArrayList<Role>();
	private List<Resource> resources = new ArrayList<Resource>();

	private String employeeCode;
	private String employeeNo;
	private String employeeName;
	private String employeePinyin;
	private Integer blUse;
	private Long siteId;
	private String siteCode;
	
	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String userPwd, Long userType,
			Long employeeId, Boolean blOa, Date expireDate,
			Long messageInterval, String status, Long createdBy,
			Date createdTime, Integer rdStatus) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
		this.employeeId = employeeId;
		this.blOa = blOa;
		this.expireDate = expireDate;
		this.messageInterval = messageInterval;
		this.status = status;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.rdStatus = rdStatus;
	}

	/** full constructor */
	public User(String userName, String userPwd, Long userType,
			Long employeeId, Boolean blOa, String pdaPwd, Date expireDate,
			Long failureTimes, Long messageInterval, Date lastOperateTime,
			String lastOperateIp, String remark, String status, Long createdBy,
			Date createdTime, Long modifiedBy, Date modifiedTime,
			Integer rdStatus) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
		this.employeeId = employeeId;
		this.blOa = blOa;
		this.pdaPwd = pdaPwd;
		this.expireDate = expireDate;
		this.failureTimes = failureTimes;
		this.messageInterval = messageInterval;
		this.lastOperateTime = lastOperateTime;
		this.lastOperateIp = lastOperateIp;
		this.remark = remark;
		this.status = status;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
		this.rdStatus = rdStatus;
	}

	// Property accessors

	public Integer getRoleCount() {
		return roleCount;
	}

	public String getStyle() {
		style = "";
		if(roleCount!=null){
		if(status.equals("N")){
			if(roleCount>0)
				style = "color:red";
			else
				style = "color:#2780EC";
		}
		}
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setRoleCount(Integer roleCount) {
		this.roleCount = roleCount;
	}
	
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Long getUserType() {
		return this.userType;
	}

	public void setUserType(Long userType) {
		this.userType = userType;
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Boolean getBlOa() {
		return this.blOa;
	}

	public void setBlOa(Boolean blOa) {
		this.blOa = blOa;
	}

	public String getPdaPwd() {
		return this.pdaPwd;
	}

	public void setPdaPwd(String pdaPwd) {
		this.pdaPwd = pdaPwd;
	}

	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Long getFailureTimes() {
		return this.failureTimes;
	}

	public void setFailureTimes(Long failureTimes) {
		this.failureTimes = failureTimes;
	}

	public Long getMessageInterval() {
		return this.messageInterval;
	}

	public void setMessageInterval(Long messageInterval) {
		this.messageInterval = messageInterval;
	}

	public Date getLastOperateTime() {
		return this.lastOperateTime;
	}

	public void setLastOperateTime(Date lastOperateTime) {
		this.lastOperateTime = lastOperateTime;
	}

	public String getLastOperateIp() {
		return this.lastOperateIp;
	}

	public void setLastOperateIp(String lastOperateIp) {
		this.lastOperateIp = lastOperateIp;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Long getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public GrantedAuthority[] getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(
				roles.size());
		for (Role role : roles) {
			grantedAuthorities.add(new GrantedAuthorityImpl(Role.ROLE_PREFIX
					+ role.getRoleId()));
		}
		grantedAuthorities.add(new GrantedAuthorityImpl(Role.ROLE_PREFIX
				+ Role.ROLE_DEFAULT));
		return grantedAuthorities
				.toArray(new GrantedAuthority[roles.size() + 1]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return userPwd;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {

		return userName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.userdetails.UserDetails#isAccountNonExpired
	 * ()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.userdetails.UserDetails#isCredentialsNonExpired
	 * ()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the resources
	 */
	public List<Resource> getResources() {
		return resources;
	}

	/**
	 * @param resources
	 *            the resources to set
	 */
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public Integer getRdStatus() {
		return rdStatus;
	}

	public void setRdStatus(Integer rdStatus) {
		this.rdStatus = rdStatus;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePinyin() {
		return employeePinyin;
	}

	public void setEmployeePinyin(String employeePinyin) {
		this.employeePinyin = employeePinyin;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Integer getBlUse() {
		return blUse;
	}

	public void setBlUse(Integer blUse) {
		this.blUse = blUse;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	
}