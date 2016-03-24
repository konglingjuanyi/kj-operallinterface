package com.chengfeng.ne.opt.orders.domain;

public class OrdMetaVO {
	
	/**片区名称**/
	private String areaName;
	/**省**/
	private String sendProvince;
	/**城市**/
	private String sendCity;
	/**所属片区**/
	private String arName;
	/**应收票数**/
	private Integer yingShou;
	/**接单成功票数**/
	private Integer jieDanChengGong;
	/**超时接单**/
	private Integer chaoShiJieDan;
	/**未接单**/
	private Integer weiJieDan;
	/**接单失败**/
	private Integer jieDanShiBai;
	/**揽件成功**/
	private Integer lanJianChengGong;
	/**超时揽件**/
	private Integer chaoShiLanJian;
	/**未揽件**/
	private Integer weiLanJian;
	/**揽件失败**/
	private Integer lanJianShiBai;
	/**派件成功**/
	private Integer paiJianChengGong;
	/**未签收**/
	private Integer weiQianShou;
	/**录单件数**/
	private Integer luDan;
	/**未录单件数**/
	private Integer weiLuDan;
	/**接单网点**/
	private Long sendSiteId;
	
	public Long getSendSiteId() {
		return sendSiteId;
	}
	public void setSendSiteId(Long sendSiteId) {
		this.sendSiteId = sendSiteId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
	public String getArName() {
		return arName;
	}
	public void setArName(String arName) {
		this.arName = arName;
	}
	public Integer getYingShou() {
		return yingShou;
	}
	public void setYingShou(Integer yingShou) {
		this.yingShou = yingShou;
	}
	public Integer getJieDanChengGong() {
		return jieDanChengGong;
	}
	public void setJieDanChengGong(Integer jieDanChengGong) {
		this.jieDanChengGong = jieDanChengGong;
	}
	public Integer getChaoShiJieDan() {
		return chaoShiJieDan;
	}
	public void setChaoShiJieDan(Integer chaoShiJieDan) {
		this.chaoShiJieDan = chaoShiJieDan;
	}
	public Integer getWeiJieDan() {
		return weiJieDan;
	}
	public void setWeiJieDan(Integer weiJieDan) {
		this.weiJieDan = weiJieDan;
	}
	public Integer getJieDanShiBai() {
		return jieDanShiBai;
	}
	public void setJieDanShiBai(Integer jieDanShiBai) {
		this.jieDanShiBai = jieDanShiBai;
	}
	public Integer getLanJianChengGong() {
		return lanJianChengGong;
	}
	public void setLanJianChengGong(Integer lanJianChengGong) {
		this.lanJianChengGong = lanJianChengGong;
	}
	public Integer getChaoShiLanJian() {
		return chaoShiLanJian;
	}
	public void setChaoShiLanJian(Integer chaoShiLanJian) {
		this.chaoShiLanJian = chaoShiLanJian;
	}
	public Integer getWeiLanJian() {
		return weiLanJian;
	}
	public void setWeiLanJian(Integer weiLanJian) {
		this.weiLanJian = weiLanJian;
	}
	public Integer getLanJianShiBai() {
		return lanJianShiBai;
	}
	public void setLanJianShiBai(Integer lanJianShiBai) {
		this.lanJianShiBai = lanJianShiBai;
	}
	public Integer getPaiJianChengGong() {
		return paiJianChengGong;
	}
	public void setPaiJianChengGong(Integer paiJianChengGong) {
		this.paiJianChengGong = paiJianChengGong;
	}
	public Integer getWeiQianShou() {
		return weiQianShou;
	}
	public void setWeiQianShou(Integer weiQianShou) {
		this.weiQianShou = weiQianShou;
	}
	public Integer getLuDan() {
		return luDan;
	}
	public void setLuDan(Integer luDan) {
		this.luDan = luDan;
	}
	public Integer getWeiLuDan() {
		return weiLuDan;
	}
	public void setWeiLuDan(Integer weiLuDan) {
		this.weiLuDan = weiLuDan;
	}
	
	
}
