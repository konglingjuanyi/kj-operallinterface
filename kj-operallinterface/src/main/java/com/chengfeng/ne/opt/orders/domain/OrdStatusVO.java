package com.chengfeng.ne.opt.orders.domain;

import java.util.Date;

public class OrdStatusVO extends OrdStatusVOKey {
    private Long siteId;
    
    private Long orderCancelId;

    private Long createdBy;

    private Date createdTime;

    private Integer oldOrderStatus;
    
    public Integer getOldOrderStatus() {
		return oldOrderStatus;
	}

	public void setOldOrderStatus(Integer oldOrderStatus) {
		this.oldOrderStatus = oldOrderStatus;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getOrderCancelId() {
		return orderCancelId;
	}

	public void setOrderCancelId(Long orderCancelId) {
		this.orderCancelId = orderCancelId;
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
}