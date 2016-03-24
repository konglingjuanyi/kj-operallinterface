package com.chengfeng.ne.opt.orders.domain;

public class OrdCountyVO {

    private String sendProvince;

    private String sendCity;

    private String sendCounty;
    
    private Long sendSiteId;
    
    private Integer count;

	public Long getSendSiteId() {
		return sendSiteId;
	}

	public void setSendSiteId(Long sendSiteId) {
		this.sendSiteId = sendSiteId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getSendProvince() {
		return sendProvince;
	}

	public void setSendProvince(String sendProvince) {
		this.sendProvince = sendProvince;
	}

	public String getSendCity() {
		return sendCity;
	}

	public void setSendCity(String sendCity) {
		this.sendCity = sendCity;
	}

	public String getSendCounty() {
		return sendCounty;
	}

	public void setSendCounty(String sendCounty) {
		this.sendCounty = sendCounty;
	}

	public OrdCountyVO(String sendProvince, String sendCity, String sendCounty,
			Long sendSiteId, Integer count) {
		super();
		this.sendProvince = sendProvince;
		this.sendCity = sendCity;
		this.sendCounty = sendCounty;
		this.sendSiteId = sendSiteId;
		this.count = count;
	}

	public OrdCountyVO() {
		super();
	}
    
}