package com.chengfeng.ne.opt.orders.domain;

import java.util.Date;

/**
 * 
 * 功能描述：订单接口错误处理实体
 *
 * Copyright: Copyright (c) 2013
 *
 * Company: 丞风智能科技有限公司
 * 
 * @author Pippo
 *
 * @version 2015-12-16
 */
public class OrderinterfaceErrorVO {
	/**接口订单ID（快捷订单接口订单ID）*/
	private Long orderId;
	/**数据状态 0：正常  1：异常*/
	private Integer orderStatus;
	/**错误信息*/
	private String orderErrorMessage;
	/**创建时间*/
	private Date createdTime;
	/**处理类型 0：接口异常处理  1：数据业务处理*/
	private Integer orderDatatype;
	/**订单信息*/
	private String orderContent;
	/**订单号*/
	private String orderNo;
	/**备用字段*/
	private String remark;
	/**备用字段*/
	private String remark1;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderErrorMessage() {
		return orderErrorMessage;
	}

	public void setOrderErrorMessage(String orderErrorMessage) {
		this.orderErrorMessage = orderErrorMessage;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getOrderDatatype() {
		return orderDatatype;
	}

	public void setOrderDatatype(Integer orderDatatype) {
		this.orderDatatype = orderDatatype;
	}

	public String getOrderContent() {
		return orderContent;
	}

	public void setOrderContent(String orderContent) {
		this.orderContent = orderContent;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	
}
