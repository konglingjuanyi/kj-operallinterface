package com.chengfeng.ne.opt.orders.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrdOrderVO {

	private Long orderId;

	private Long oldOrderId;
	
    private String orderNo;

    private Long ecId;

    private String ewbNo;

    private String logisticNo;

    private Long sendSiteId;
    
    private Long dispatchSiteId;

    private Integer orderStatus;

	private Integer totalPiece;

    private BigDecimal totalWeight;

    private BigDecimal totalVol;

    private Long paySideId;

    private Long payModeId;

    private BigDecimal freightCharge1;

    private BigDecimal freightCharge;

    private BigDecimal insuredAmount;

    private BigDecimal codCharge;

    private Long ecWarehouseId;

    private Integer receiveFlag;

    private Integer smsFlag;

    private Integer serviceType;

    private Integer packageFlag;

    private String packageDesc;

    private Integer ewbFlag;

    private Long receiveEmployeeId;

    private String sendCompanyName;

    private String sendLinkMan;

    private String sendPhoneSms;

    private String sendPhone;

    private String sendAddress;

    private String sendPostcode;

    private String sendProvince;

    private String sendCity;

    private String sendCounty;

    private String sendStartTime;

    private String sendEndTime;

    private String dispatchCompanyName;

    private String dispatchLinkMan;

    private String dispatchPhoneSms;

    private String dispatchPhone;

    private String dispatchAddress;

    private String dispatchPostcode;

    private String dispatchProvince;

    private String dispatchCity;

    private String dispatchCounty;

    private String dispatchStartTime;

    private String dispatchEndTime;

    private Date createdTime;

    private Date newCreatedTime;
    
    private Long createdBy;
    
    private Long modifiedBy;

    private Date modifiedTime;

    private Integer rdStatus;

    private String coupon;
    
    private String returnTime;
    
    private Integer returnTarget;
    
    private OrdStatusVO ordStatusVO;  
    /**原始运单号*/
    private String oldEwbNo;
    
    /**采购单号**/
    private String subOrderId;
    
    /**订单银行信息*/
    private OrdBankVO ordBankVO;
    
	/** 订单明细集合  */
    private List<OrdItemsVO> ordItemsList;
    
    /** CXT: 诚信通;PT：普通会员;POW：实力商家;**/
    private String memberType;
    
    //add lei.zhao
    private String deliveryType;
    
    private Date dispartTime;
    
    private String dispatchTown;
    
    private String inputDispatchSiteId;
    
    private String inputSendSiteId;
    
    private Integer orderBizType;
    
    private String sellerid;
    
    private String sendTown;
    
    private Integer ordStatuId;
    
	public Long getOldOrderId() {
		return oldOrderId;
	}
	public void setOldOrderId(Long oldOrderId) {
		this.oldOrderId = oldOrderId;
	}
	public Integer getOrdStatuId() {
		return ordStatuId;
	}
	public void setOrdStatuId(Integer ordStatuId) {
		this.ordStatuId = ordStatuId;
	}
	public String getOldEwbNo() {
		return oldEwbNo;
	}
	public void setOldEwbNo(String oldEwbNo) {
		this.oldEwbNo = oldEwbNo;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getSubOrderId() {
		return subOrderId;
	}
	public void setSubOrderId(String subOrderId) {
		this.subOrderId = subOrderId;
	}
	public List<OrdItemsVO> getOrdItemsList() {
		return ordItemsList;
	}

	public Date getNewCreatedTime() {
		return newCreatedTime;
	}
	public void setNewCreatedTime(Date newCreatedTime) {
		this.newCreatedTime = newCreatedTime;
	}
	public void setOrdItemsList(List<OrdItemsVO> ordItemsList) {
		this.ordItemsList = ordItemsList;
	}
	
	public OrdBankVO getOrdBankVO() {
		return ordBankVO;
	}

	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public void setOrdBankVO(OrdBankVO ordBankVO) {
		this.ordBankVO = ordBankVO;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdOrderVO other = (OrdOrderVO) obj;
		if (codCharge == null) {
			if (other.codCharge != null)
				return false;
		} else if (!codCharge.equals(other.codCharge))
			return false;
		if (coupon == null) {
			if (other.coupon != null)
				return false;
		} else if (!coupon.equals(other.coupon))
			return false;
		if (createdTime == null) {
			if (other.createdTime != null)
				return false;
		} else if (!createdTime.equals(other.createdTime))
			return false;
		if (dispatchAddress == null) {
			if (other.dispatchAddress != null)
				return false;
		} else if (!dispatchAddress.equals(other.dispatchAddress))
			return false;
		if (dispatchCity == null) {
			if (other.dispatchCity != null)
				return false;
		} else if (!dispatchCity.equals(other.dispatchCity))
			return false;
		if (dispatchCompanyName == null) {
			if (other.dispatchCompanyName != null)
				return false;
		} else if (!dispatchCompanyName.equals(other.dispatchCompanyName))
			return false;
		if (dispatchCounty == null) {
			if (other.dispatchCounty != null)
				return false;
		} else if (!dispatchCounty.equals(other.dispatchCounty))
			return false;
		if (dispatchEndTime == null) {
			if (other.dispatchEndTime != null)
				return false;
		} else if (!dispatchEndTime.equals(other.dispatchEndTime))
			return false;
		if (dispatchLinkMan == null) {
			if (other.dispatchLinkMan != null)
				return false;
		} else if (!dispatchLinkMan.equals(other.dispatchLinkMan))
			return false;
		if (dispatchPhone == null) {
			if (other.dispatchPhone != null)
				return false;
		} else if (!dispatchPhone.equals(other.dispatchPhone))
			return false;
		if (dispatchPhoneSms == null) {
			if (other.dispatchPhoneSms != null)
				return false;
		} else if (!dispatchPhoneSms.equals(other.dispatchPhoneSms))
			return false;
		if (dispatchPostcode == null) {
			if (other.dispatchPostcode != null)
				return false;
		} else if (!dispatchPostcode.equals(other.dispatchPostcode))
			return false;
		if (dispatchProvince == null) {
			if (other.dispatchProvince != null)
				return false;
		} else if (!dispatchProvince.equals(other.dispatchProvince))
			return false;
		if (dispatchSiteId == null) {
			if (other.dispatchSiteId != null)
				return false;
		} else if (!dispatchSiteId.equals(other.dispatchSiteId))
			return false;
		if (dispatchStartTime == null) {
			if (other.dispatchStartTime != null)
				return false;
		} else if (!dispatchStartTime.equals(other.dispatchStartTime))
			return false;
		if (ecId == null) {
			if (other.ecId != null)
				return false;
		} else if (!ecId.equals(other.ecId))
			return false;
		if (ecWarehouseId == null) {
			if (other.ecWarehouseId != null)
				return false;
		} else if (!ecWarehouseId.equals(other.ecWarehouseId))
			return false;
		if (ewbFlag == null) {
			if (other.ewbFlag != null)
				return false;
		} else if (!ewbFlag.equals(other.ewbFlag))
			return false;
		if (ewbNo == null) {
			if (other.ewbNo != null)
				return false;
		} else if (!ewbNo.equals(other.ewbNo))
			return false;
		if (freightCharge == null) {
			if (other.freightCharge != null)
				return false;
		} else if (!freightCharge.equals(other.freightCharge))
			return false;
		if (freightCharge1 == null) {
			if (other.freightCharge1 != null)
				return false;
		} else if (!freightCharge1.equals(other.freightCharge1))
			return false;
		if (insuredAmount == null) {
			if (other.insuredAmount != null)
				return false;
		} else if (!insuredAmount.equals(other.insuredAmount))
			return false;
		if (logisticNo == null) {
			if (other.logisticNo != null)
				return false;
		} else if (!logisticNo.equals(other.logisticNo))
			return false;
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
			return false;
		if (modifiedTime == null) {
			if (other.modifiedTime != null)
				return false;
		} else if (!modifiedTime.equals(other.modifiedTime))
			return false;
		if (ordStatusList == null) {
			if (other.ordStatusList != null)
				return false;
		} else if (!ordStatusList.equals(other.ordStatusList))
			return false;
		if (orderCanceId == null) {
			if (other.orderCanceId != null)
				return false;
		} else if (!orderCanceId.equals(other.orderCanceId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderNo == null) {
			if (other.orderNo != null)
				return false;
		} else if (!orderNo.equals(other.orderNo))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (packageDesc == null) {
			if (other.packageDesc != null)
				return false;
		} else if (!packageDesc.equals(other.packageDesc))
			return false;
		if (packageFlag == null) {
			if (other.packageFlag != null)
				return false;
		} else if (!packageFlag.equals(other.packageFlag))
			return false;
		if (payModeId == null) {
			if (other.payModeId != null)
				return false;
		} else if (!payModeId.equals(other.payModeId))
			return false;
		if (paySideId == null) {
			if (other.paySideId != null)
				return false;
		} else if (!paySideId.equals(other.paySideId))
			return false;
		if (rdStatus == null) {
			if (other.rdStatus != null)
				return false;
		} else if (!rdStatus.equals(other.rdStatus))
			return false;
		if (receiveEmployeeId == null) {
			if (other.receiveEmployeeId != null)
				return false;
		} else if (!receiveEmployeeId.equals(other.receiveEmployeeId))
			return false;
		if (receiveFlag == null) {
			if (other.receiveFlag != null)
				return false;
		} else if (!receiveFlag.equals(other.receiveFlag))
			return false;
		if (sendAddress == null) {
			if (other.sendAddress != null)
				return false;
		} else if (!sendAddress.equals(other.sendAddress))
			return false;
		if (sendCity == null) {
			if (other.sendCity != null)
				return false;
		} else if (!sendCity.equals(other.sendCity))
			return false;
		if (sendCompanyName == null) {
			if (other.sendCompanyName != null)
				return false;
		} else if (!sendCompanyName.equals(other.sendCompanyName))
			return false;
		if (sendCounty == null) {
			if (other.sendCounty != null)
				return false;
		} else if (!sendCounty.equals(other.sendCounty))
			return false;
		if (sendEndTime == null) {
			if (other.sendEndTime != null)
				return false;
		} else if (!sendEndTime.equals(other.sendEndTime))
			return false;
		if (sendLinkMan == null) {
			if (other.sendLinkMan != null)
				return false;
		} else if (!sendLinkMan.equals(other.sendLinkMan))
			return false;
		if (sendPhone == null) {
			if (other.sendPhone != null)
				return false;
		} else if (!sendPhone.equals(other.sendPhone))
			return false;
		if (sendPhoneSms == null) {
			if (other.sendPhoneSms != null)
				return false;
		} else if (!sendPhoneSms.equals(other.sendPhoneSms))
			return false;
		if (sendPostcode == null) {
			if (other.sendPostcode != null)
				return false;
		} else if (!sendPostcode.equals(other.sendPostcode))
			return false;
		if (sendProvince == null) {
			if (other.sendProvince != null)
				return false;
		} else if (!sendProvince.equals(other.sendProvince))
			return false;
		if (sendSiteId == null) {
			if (other.sendSiteId != null)
				return false;
		} else if (!sendSiteId.equals(other.sendSiteId))
			return false;
		if (sendStartTime == null) {
			if (other.sendStartTime != null)
				return false;
		} else if (!sendStartTime.equals(other.sendStartTime))
			return false;
		if (serviceType == null) {
			if (other.serviceType != null)
				return false;
		} else if (!serviceType.equals(other.serviceType))
			return false;
		if (smsFlag == null) {
			if (other.smsFlag != null)
				return false;
		} else if (!smsFlag.equals(other.smsFlag))
			return false;
		if (totalPiece == null) {
			if (other.totalPiece != null)
				return false;
		} else if (!totalPiece.equals(other.totalPiece))
			return false;
		if (totalVol == null) {
			if (other.totalVol != null)
				return false;
		} else if (!totalVol.equals(other.totalVol))
			return false;
		if (totalWeight == null) {
			if (other.totalWeight != null)
				return false;
		} else if (!totalWeight.equals(other.totalWeight))
			return false;
		if (returnTarget == null) {
			if (other.returnTarget != null)
				return false;
		} else if (!returnTarget.equals(other.returnTarget))
			return false;
		if (returnTime == null) {
			if (other.returnTime != null)
				return false;
		} else if (!returnTime.equals(other.returnTime))
			return false;
		return true;
	}

	/** 撤销原因Id  wws 2014/12/20**/
    private Long orderCanceId;
    
    /** 状态表信息**/
    private List<OrdStatusVO> ordStatusList;

	public OrdStatusVO getOrdStatusVO() {
		return ordStatusVO;
	}

	public void setOrdStatusVO(OrdStatusVO ordStatusVO) {
		this.ordStatusVO = ordStatusVO;
	}

	
	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public Integer getReturnTarget() {
		return returnTarget;
	}

	public void setReturnTarget(Integer returnTarget) {
		this.returnTarget = returnTarget;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getEcId() {
		return ecId;
	}

	public void setEcId(Long ecId) {
		this.ecId = ecId;
	}

	public String getEwbNo() {
		return ewbNo;
	}

	public void setEwbNo(String ewbNo) {
		this.ewbNo = ewbNo;
	}

	public String getLogisticNo() {
		return logisticNo;
	}

	public void setLogisticNo(String logisticNo) {
		this.logisticNo = logisticNo;
	}

	public Long getSendSiteId() {
		return sendSiteId;
	}

	public void setSendSiteId(Long sendSiteId) {
		this.sendSiteId = sendSiteId;
	}

	public Long getDispatchSiteId() {
		return dispatchSiteId;
	}

	public void setDispatchSiteId(Long dispatchSiteId) {
		this.dispatchSiteId = dispatchSiteId;
	}

	public Integer getTotalPiece() {
		return totalPiece;
	}

	public void setTotalPiece(Integer totalPiece) {
		this.totalPiece = totalPiece;
	}

	public BigDecimal getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight = totalWeight;
	}

	public BigDecimal getTotalVol() {
		return totalVol;
	}

	public void setTotalVol(BigDecimal totalVol) {
		this.totalVol = totalVol;
	}

	public Long getPaySideId() {
		return paySideId;
	}

	public void setPaySideId(Long paySideId) {
		this.paySideId = paySideId;
	}

	public Long getPayModeId() {
		return payModeId;
	}

	public void setPayModeId(Long payModeId) {
		this.payModeId = payModeId;
	}

	public BigDecimal getFreightCharge1() {
		return freightCharge1;
	}

	public void setFreightCharge1(BigDecimal freightCharge1) {
		this.freightCharge1 = freightCharge1;
	}

	public BigDecimal getFreightCharge() {
		return freightCharge;
	}

	public void setFreightCharge(BigDecimal freightCharge) {
		this.freightCharge = freightCharge;
	}

	public BigDecimal getInsuredAmount() {
		return insuredAmount;
	}

	public void setInsuredAmount(BigDecimal insuredAmount) {
		this.insuredAmount = insuredAmount;
	}

	public BigDecimal getCodCharge() {
		return codCharge;
	}

	public void setCodCharge(BigDecimal codCharge) {
		this.codCharge = codCharge;
	}

	public Long getEcWarehouseId() {
		return ecWarehouseId;
	}

	public void setEcWarehouseId(Long ecWarehouseId) {
		this.ecWarehouseId = ecWarehouseId;
	}

	public Integer getReceiveFlag() {
		return receiveFlag;
	}

	public void setReceiveFlag(Integer receiveFlag) {
		this.receiveFlag = receiveFlag;
	}

	public Integer getSmsFlag() {
		return smsFlag;
	}

	public void setSmsFlag(Integer smsFlag) {
		this.smsFlag = smsFlag;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getPackageFlag() {
		return packageFlag;
	}

	public void setPackageFlag(Integer packageFlag) {
		this.packageFlag = packageFlag;
	}

	public String getPackageDesc() {
		return packageDesc;
	}

	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	public Integer getEwbFlag() {
		return ewbFlag;
	}

	public void setEwbFlag(Integer ewbFlag) {
		this.ewbFlag = ewbFlag;
	}

	public Long getReceiveEmployeeId() {
		return receiveEmployeeId;
	}

	public void setReceiveEmployeeId(Long receiveEmployeeId) {
		this.receiveEmployeeId = receiveEmployeeId;
	}

	public String getSendCompanyName() {
		return sendCompanyName;
	}

	public void setSendCompanyName(String sendCompanyName) {
		this.sendCompanyName = sendCompanyName;
	}

	public String getSendLinkMan() {
		return sendLinkMan;
	}

	public void setSendLinkMan(String sendLinkMan) {
		this.sendLinkMan = sendLinkMan;
	}

	public String getSendPhoneSms() {
		return sendPhoneSms;
	}

	public void setSendPhoneSms(String sendPhoneSms) {
		this.sendPhoneSms = sendPhoneSms;
	}

	public String getSendPhone() {
		return sendPhone;
	}

	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}

	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public String getSendPostcode() {
		return sendPostcode;
	}

	public void setSendPostcode(String sendPostcode) {
		this.sendPostcode = sendPostcode;
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

	public String getSendStartTime() {
		return sendStartTime;
	}

	public void setSendStartTime(String sendStartTime) {
		this.sendStartTime = sendStartTime;
	}

	public String getSendEndTime() {
		return sendEndTime;
	}

	public void setSendEndTime(String sendEndTime) {
		this.sendEndTime = sendEndTime;
	}

	public String getDispatchCompanyName() {
		return dispatchCompanyName;
	}

	public void setDispatchCompanyName(String dispatchCompanyName) {
		this.dispatchCompanyName = dispatchCompanyName;
	}

	public String getDispatchLinkMan() {
		return dispatchLinkMan;
	}

	public void setDispatchLinkMan(String dispatchLinkMan) {
		this.dispatchLinkMan = dispatchLinkMan;
	}

	public String getDispatchPhoneSms() {
		return dispatchPhoneSms;
	}

	public void setDispatchPhoneSms(String dispatchPhoneSms) {
		this.dispatchPhoneSms = dispatchPhoneSms;
	}

	public String getDispatchPhone() {
		return dispatchPhone;
	}

	public void setDispatchPhone(String dispatchPhone) {
		this.dispatchPhone = dispatchPhone;
	}

	public String getDispatchAddress() {
		return dispatchAddress;
	}

	public void setDispatchAddress(String dispatchAddress) {
		this.dispatchAddress = dispatchAddress;
	}

	public String getDispatchPostcode() {
		return dispatchPostcode;
	}

	public void setDispatchPostcode(String dispatchPostcode) {
		this.dispatchPostcode = dispatchPostcode;
	}

	public String getDispatchProvince() {
		return dispatchProvince;
	}

	public void setDispatchProvince(String dispatchProvince) {
		this.dispatchProvince = dispatchProvince;
	}

	public String getDispatchCity() {
		return dispatchCity;
	}

	public void setDispatchCity(String dispatchCity) {
		this.dispatchCity = dispatchCity;
	}

	public String getDispatchCounty() {
		return dispatchCounty;
	}

	public void setDispatchCounty(String dispatchCounty) {
		this.dispatchCounty = dispatchCounty;
	}

	public String getDispatchStartTime() {
		return dispatchStartTime;
	}

	public void setDispatchStartTime(String dispatchStartTime) {
		this.dispatchStartTime = dispatchStartTime;
	}

	public String getDispatchEndTime() {
		return dispatchEndTime;
	}

	public void setDispatchEndTime(String dispatchEndTime) {
		this.dispatchEndTime = dispatchEndTime;
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

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getOrderCanceId() {
		return orderCanceId;
	}

	public void setOrderCanceId(Long orderCanceId) {
		this.orderCanceId = orderCanceId;
	}

	public List<OrdStatusVO> getOrdStatusList() {
		return ordStatusList;
	}

	public void setOrdStatusList(List<OrdStatusVO> ordStatusList) {
		this.ordStatusList = ordStatusList;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public Date getDispartTime() {
		return dispartTime;
	}
	public void setDispartTime(Date dispartTime) {
		this.dispartTime = dispartTime;
	}
	public String getDispatchTown() {
		return dispatchTown;
	}
	public void setDispatchTown(String dispatchTown) {
		this.dispatchTown = dispatchTown;
	}
	public String getInputDispatchSiteId() {
		return inputDispatchSiteId;
	}
	public void setInputDispatchSiteId(String inputDispatchSiteId) {
		this.inputDispatchSiteId = inputDispatchSiteId;
	}
	public String getInputSendSiteId() {
		return inputSendSiteId;
	}
	public void setInputSendSiteId(String inputSendSiteId) {
		this.inputSendSiteId = inputSendSiteId;
	}
	public Integer getOrderBizType() {
		return orderBizType;
	}
	public void setOrderBizType(Integer orderBizType) {
		this.orderBizType = orderBizType;
	}
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}
	public String getSendTown() {
		return sendTown;
	}
	public void setSendTown(String sendTown) {
		this.sendTown = sendTown;
	}

	public String toString(){
		StringBuffer str = new StringBuffer();
		str.append("oldEwbNo:").append(this.oldEwbNo)
		.append("  orderNo:").append(this.orderNo)
		.append("  dispatchPostcode:").append(this.dispatchPostcode);
		return str.toString();
	}
	
}