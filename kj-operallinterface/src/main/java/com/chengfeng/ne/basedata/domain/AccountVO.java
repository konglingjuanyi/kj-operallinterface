package com.chengfeng.ne.basedata.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import com.chengfeng.common.BaseNeModel;
import com.chengfeng.ne.basedata.domain.BasicSiteDetailVO;

/**
 * 
 * <p>
 * 功能描述：财务账户表实体类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013
 * </p>
 * <p>
 * Company: 丞风智能科技有限公司
 * </p>
 * 
 * @author Yong
 * @version 1.0 2014-1-22 上午10:08:26
 */
public class AccountVO extends BaseNeModel implements Serializable{

	private static final long serialVersionUID = -9006591671332467981L;
	/**
	 * 帐号ID 对应序列：SEQ_FIN_ACCOUNT
	 */
	private Long accountId;
	/** 开户行ID **/
	private Long centerId;
	/** 开户户名ID **/
	private Long dataId;
	/** 帐户类型 **/
	private Long accountTypeId;
	/** 实际余额 **/
	private Double balance;
	/** 警戒余额 **/
	private Double alarmBalance;
	/** 关闭余额 **/
	private Double lockBalance;
	/** 延迟关闭时间 **/
	private Timestamp delayLockTime;
	/** 帐号状态（-1：销户 1：正常） **/
	private Integer accountStatus;
	/** 销户时间 **/
	private Timestamp closeTime;
	/** 备注 **/
	private String remark;
	/** 创建人 **/
	private Long createdBy;
	/** 创建时间 **/
	private Timestamp createdTime;
	/** 修改人 **/
	private Long modifiedBy;
	/** 修改时间 */
	private Timestamp modifiedTime;

	/** 查询小于的时候用这个值 */
	private Double ceilingBalance;
	/** 查询大于的时候用这个值 */
	private Double floorBalance;
	/** */
	private Double ceilingAlarm;
	/** */
	private Double floorAlarm;
	/** */
	private Double ceilingLock;
	/** */
	private Double floorLock;
	/** 数据名称 */
	private String dataName;
	/** 网点对象增加两列用到  */
	private BasicSiteDetailVO siteDetail;
	/** 临时表序列  */
	private Long finNo; 
	/**  安能增加列 首分拨中心  */
	private String firstCenterSiteName;
	
	
	public String getFirstCenterSiteName() {
		return firstCenterSiteName;
	}
	public void setFirstCenterSiteName(String firstCenterSiteName) {
		this.firstCenterSiteName = firstCenterSiteName;
	}
	public Long getFinNo() {
		return finNo;
	}
	public void setFinNo(Long finNo) {
		this.finNo = finNo;
	}
	public BasicSiteDetailVO getSiteDetail() {
		return siteDetail;
	}
	public void setSiteDetail(BasicSiteDetailVO siteDetail) {
		this.siteDetail = siteDetail;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getCenterId() {
		return centerId;
	}
	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}
	public Long getDataId() {
		return dataId;
	}
	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}
	public Long getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getAlarmBalance() {
		return alarmBalance;
	}
	public void setAlarmBalance(Double alarmBalance) {
		this.alarmBalance = alarmBalance;
	}
	public Double getLockBalance() {
		return lockBalance;
	}
	public void setLockBalance(Double lockBalance) {
		this.lockBalance = lockBalance;
	}
	public Timestamp getDelayLockTime() {
		return delayLockTime;
	}
	public void setDelayLockTime(Timestamp delayLockTime) {
		this.delayLockTime = delayLockTime;
	}
	public Integer getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Timestamp getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Timestamp closeTime) {
		this.closeTime = closeTime;
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
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Timestamp getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public Double getCeilingBalance() {
		return ceilingBalance;
	}
	public void setCeilingBalance(Double ceilingBalance) {
		this.ceilingBalance = ceilingBalance;
	}
	public Double getFloorBalance() {
		return floorBalance;
	}
	public void setFloorBalance(Double floorBalance) {
		this.floorBalance = floorBalance;
	}
	public Double getCeilingAlarm() {
		return ceilingAlarm;
	}
	public void setCeilingAlarm(Double ceilingAlarm) {
		this.ceilingAlarm = ceilingAlarm;
	}
	public Double getFloorAlarm() {
		return floorAlarm;
	}
	public void setFloorAlarm(Double floorAlarm) {
		this.floorAlarm = floorAlarm;
	}
	public Double getCeilingLock() {
		return ceilingLock;
	}
	public void setCeilingLock(Double ceilingLock) {
		this.ceilingLock = ceilingLock;
	}
	public Double getFloorLock() {
		return floorLock;
	}
	public void setFloorLock(Double floorLock) {
		this.floorLock = floorLock;
	}
	public AccountVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountVO(Long accountId, Long centerId, Long dataId,
			Long accountTypeId, Double balance, Double alarmBalance,
			Double lockBalance, Timestamp delayLockTime, Integer accountStatus,
			Timestamp closeTime, String remark, Long createdBy,
			Timestamp createdTime, Long modifiedBy, Timestamp modifiedTime,
			Double ceilingBalance, Double floorBalance, Double ceilingAlarm,
			Double floorAlarm, Double ceilingLock, Double floorLock) {
		super();
		this.accountId = accountId;
		this.centerId = centerId;
		this.dataId = dataId;
		this.accountTypeId = accountTypeId;
		this.balance = balance;
		this.alarmBalance = alarmBalance;
		this.lockBalance = lockBalance;
		this.delayLockTime = delayLockTime;
		this.accountStatus = accountStatus;
		this.closeTime = closeTime;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
		this.ceilingBalance = ceilingBalance;
		this.floorBalance = floorBalance;
		this.ceilingAlarm = ceilingAlarm;
		this.floorAlarm = floorAlarm;
		this.ceilingLock = ceilingLock;
		this.floorLock = floorLock;
	}
	@Override
	public String toString() {
		return "AccountVO [accountId=" + accountId + ", centerId=" + centerId
				+ ", dataId=" + dataId + ", accountTypeId=" + accountTypeId
				+ ", balance=" + balance + ", alarmBalance=" + alarmBalance
				+ ", lockBalance=" + lockBalance + ", delayLockTime="
				+ delayLockTime + ", accountStatus=" + accountStatus
				+ ", closeTime=" + closeTime + ", remark=" + remark
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", modifiedBy=" + modifiedBy + ", modifiedTime="
				+ modifiedTime + ", ceilingBalance=" + ceilingBalance
				+ ", floorBalance=" + floorBalance + ", ceilingAlarm="
				+ ceilingAlarm + ", floorAlarm=" + floorAlarm
				+ ", ceilingLock=" + ceilingLock + ", floorLock=" + floorLock
				+ ", dataName=" + dataName + "]";
	}
	
}