package com.chengfeng.ne.opt.orders.domain;

import java.math.BigDecimal;

public class OrdItemsVOKey {
    private Long orderId;

    private BigDecimal goodsOrder;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getGoodsOrder() {
        return goodsOrder;
    }

    public void setGoodsOrder(BigDecimal goodsOrder) {
        this.goodsOrder = goodsOrder;
    }
}