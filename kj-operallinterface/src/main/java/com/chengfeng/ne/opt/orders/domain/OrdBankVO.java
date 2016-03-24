package com.chengfeng.ne.opt.orders.domain;

import com.chengfeng.common.BaseNeModel;

/**
 * 
 * <p>网上营业厅之订单银行信息表</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Sunships
 * @version 1.0 2015-1-31 下午3:26:53
 */
public class OrdBankVO extends BaseNeModel{
	private static final long serialVersionUID = 7565110955420144309L;
	
	/** 订单ID */
	private Long orderId;
	/** 开户银行名称 */
	private String accountBankName;
	/** 开户行账号 */
	private String accountCode;
	/** 开户行户名 */
	private String accountName;
	/** 银行地区 */
	private String bankarea;
	/** 省份名称 */
	private String provinceName;
	/** 城市名称 */
	private String cityName;
	/** 联行号 */
	private String combinenum;
	/** 1是个人  2是事业单位  3 是公司 */
	private Integer accountType;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getAccountBankName() {
		return accountBankName;
	}

	public void setAccountBankName(String accountBankName) {
		this.accountBankName = accountBankName;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBankarea() {
		return bankarea;
	}

	public void setBankarea(String bankarea) {
		this.bankarea = bankarea;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCombinenum() {
		return combinenum;
	}

	public void setCombinenum(String combinenum) {
		this.combinenum = combinenum;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	
}
