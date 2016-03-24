package com.chengfeng.ne.opt.orders.domain;

import java.math.BigDecimal;

public class OrdItemsVO extends OrdItemsVOKey {
    private Integer goodsType;

    private String goodsName;

    private BigDecimal piece;

    private String remark;

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getPiece() {
        return piece;
    }

    public void setPiece(BigDecimal piece) {
        this.piece = piece;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}