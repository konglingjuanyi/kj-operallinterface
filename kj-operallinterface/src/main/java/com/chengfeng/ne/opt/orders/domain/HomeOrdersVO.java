package com.chengfeng.ne.opt.orders.domain;

import com.chengfeng.common.BaseNeModel;

/**
 * 首页订单实体类
 * @author wws
 * 2015/5/30
 */
public class HomeOrdersVO extends BaseNeModel{
	/** 寄件网点编号**/
	private Long sendSiteId;
	/** 寄件网点名称**/
	private String sendSiteName;
	/** 统计日期**/
	private Integer day;
	/** 等待接单**/
	private Integer waitOrder;
	/** 撤销订单**/
	private Integer fialdOrder;
	/** 日期**/
	private String operationTime;
	/** 总订单数据**/
	private Integer totalOrder;
		 
	public Integer getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(Integer totalOrder) {
		this.totalOrder = totalOrder;
	}
	public String getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}
	public Long getSendSiteId() {
		return sendSiteId;
	}
	public void setSendSiteId(Long sendSiteId) {
		this.sendSiteId = sendSiteId;
	}
	public String getSendSiteName() {
		return sendSiteName;
	}
	public void setSendSiteName(String sendSiteName) {
		this.sendSiteName = sendSiteName;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getWaitOrder() {
		return waitOrder;
	}
	public void setWaitOrder(Integer waitOrder) {
		this.waitOrder = waitOrder;
	}
	public Integer getFialdOrder() {
		return fialdOrder;
	}
	public void setFialdOrder(Integer fialdOrder) {
		this.fialdOrder = fialdOrder;
	}
	
	public HomeOrdersVO() {
		super();
	}
	
	@Override
	public String toString() {
		return operationTime +"!"+ sendSiteName +"!" + totalOrder +"!"+ waitOrder +"!"+ fialdOrder;
	}
}
