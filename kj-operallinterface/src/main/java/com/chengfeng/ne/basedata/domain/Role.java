package com.chengfeng.ne.basedata.domain;

import java.io.Serializable;
import java.util.Date;

import com.chengfeng.common.BaseNeModel;

/**
 * 
 * <p>功能描述：</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: ThinkJF</p>
 * @author Freeman
 * @version 1.0 2014-2-6 上午1:24:05
 */
public class Role  extends BaseNeModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -416640620517200138L;
	
	public static final String ROLE_PREFIX = "ROLE_";//角色前缀
	public static final String ROLE_DEFAULT = "DEFAULT";//所有用户默认的拥有的角色
	/**角色ID*/
    private Integer roleId;
    /**角色代码*/
    private String roleCode;
    /**角色名称*/
    private String roleName;
    /**角色拼音*/
    private String rolePinyin;

    private Integer roleOrder;

    private Integer blUse;

    private Integer siteTypeId;

    private Integer blBasic;

    private Integer blOwe;

    private String remark;

    private Integer createdBy;

    private Date createdTime;

    private Integer modifiedBy;

    private Date modifiedTime;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRolePinyin() {
        return rolePinyin;
    }

    public void setRolePinyin(String rolePinyin) {
        this.rolePinyin = rolePinyin == null ? null : rolePinyin.trim();
    }

    public Integer getRoleOrder() {
        return roleOrder;
    }

    public void setRoleOrder(Integer roleOrder) {
        this.roleOrder = roleOrder;
    }

    public Integer getBlUse() {
        return blUse;
    }

    public void setBlUse(Integer blUse) {
        this.blUse = blUse;
    }

    public Integer getSiteTypeId() {
        return siteTypeId;
    }

    public void setSiteTypeId(Integer siteTypeId) {
        this.siteTypeId = siteTypeId;
    }

    public Integer getBlBasic() {
        return blBasic;
    }

    public void setBlBasic(Integer blBasic) {
        this.blBasic = blBasic;
    }

    public Integer getBlOwe() {
        return blOwe;
    }

    public void setBlOwe(Integer blOwe) {
        this.blOwe = blOwe;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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