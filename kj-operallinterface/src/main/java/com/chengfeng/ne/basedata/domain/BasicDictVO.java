package com.chengfeng.ne.basedata.domain;

import java.io.Serializable;
import java.util.Date;

import com.chengfeng.common.BaseNeModel;

/**
 * <p>功能描述：数据字典实体类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * 对应数据库表 表名：HS_BASIC_DICT 
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong 
 * @version 1.0 2013-12-23 上午9:50:03 
 */
public class BasicDictVO extends BaseNeModel implements Serializable{

	private static final long serialVersionUID = 5969415334799277802L;
	/**
	 * ID标识
	 * 对应数据库序列SEQ_BASIC_DICT
	 */  
	private Long dictId;			//字典ID	
	private String dictCode;		//字典编号
	private String dictName;		//字典名称
	private String dictPinyin;		//名称拼音
	private Long dictOrder;			//数据排列顺序
	private String typeCode;		//字典类型
	private String remark;			//备注
	private Long createdBy;			//创建人

	private Date createdTime;		//创建时间
	private Long modifiedBy;		//修改人

	private Date modifiedTime;		//修改时间
	private Integer rdStatus;		//记录数据状态（0：删除 1：正常）
	public Long getDictId() {
		return dictId;
	}
	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}
	public String getDictCode() {
		return dictCode;
	}
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public String getDictPinyin() {
		return dictPinyin;
	}
	public void setDictPinyin(String dictPinyin) {
		this.dictPinyin = dictPinyin;
	}
	public Long getDictOrder() {
		return dictOrder;
	}
	public void setDictOrder(Long dictOrder) {
		this.dictOrder = dictOrder;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public Integer getRdStatus() {
		return rdStatus;
	}
	public void setRdStatus(Integer rdStatus) {
		this.rdStatus = rdStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BasicDictVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BasicDictVO(Long dictId, String dictCode, String dictName,
			String dictPinyin, Long dictOrder, String typeCode, String remark,
			Long createdBy, Date createdTime, Long modifiedBy,
			Date modifiedTime, Integer rdStatus) {
		super();
		this.dictId = dictId;
		this.dictCode = dictCode;
		this.dictName = dictName;
		this.dictPinyin = dictPinyin;
		this.dictOrder = dictOrder;
		this.typeCode = typeCode;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdTime = createdTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
		this.rdStatus = rdStatus;
	}
	@Override
	public String toString() {
		return "BasicDict [dictId=" + dictId + ", dictCode=" + dictCode
				+ ", dictName=" + dictName + ", dictPinyin=" + dictPinyin
				+ ", dictOrder=" + dictOrder + ", typeCode=" + typeCode
				+ ", remark=" + remark + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", rdStatus=" + rdStatus
				+ "]";
	}
	
}
