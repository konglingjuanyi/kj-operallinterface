package com.chengfeng.ne.basedata.domain;

import com.chengfeng.common.BaseNeModel;

/**
 * <p>功能描述：网点结算路由实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2014-5-26 下午6:07:19
 */
public class BasicSitePropVO extends BaseNeModel {

	private static final long serialVersionUID = -6974303425711671811L;
	/** 数据自动编号 **/
	private Long siteId;
	/** 属性类型 班次   class
		货物类型   goods_type **/
	private String typeCode;
	/** 数据ID **/
	private Long dataId;
	
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public Long getDataId() {
		return dataId;
	}
	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}
	@Override
	public String toString() {
		return "BasicSitePropVO [siteId=" + siteId + ", typeCode=" + typeCode
				+ ", dataId=" + dataId + "]";
	}

	
}
