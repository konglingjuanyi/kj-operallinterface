package com.chengfeng.ne.basedata.domain;

import com.chengfeng.common.BaseNeModel;

/**
 * <p>功能描述：网点服务实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2015-5-12 下午5:10:49
 */
public class BasicSiteServicesVO extends BaseNeModel implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	/** 数据自动编号 */
	private Long siteId;
	/** 服务类型ID */
	private Long servicesTypeId;
	/** 网点服务类型（0：无   1：寄件服务   2：派件服务   3：寄派服务） */
	private Integer siteServicesType;
	/** 派送方式（0：无   1：自提   2：派送   3：自提、派送） */
	private Integer pickGoodsMode;
	public Long getSiteId() {
		return siteId;
	}
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	public Long getServicesTypeId() {
		return servicesTypeId;
	}
	public void setServicesTypeId(Long servicesTypeId) {
		this.servicesTypeId = servicesTypeId;
	}
	public Integer getSiteServicesType() {
		return siteServicesType;
	}
	public void setSiteServicesType(Integer siteServicesType) {
		this.siteServicesType = siteServicesType;
	}
	public Integer getPickGoodsMode() {
		return pickGoodsMode;
	}
	public void setPickGoodsMode(Integer pickGoodsMode) {
		this.pickGoodsMode = pickGoodsMode;
	}

	
	
}
