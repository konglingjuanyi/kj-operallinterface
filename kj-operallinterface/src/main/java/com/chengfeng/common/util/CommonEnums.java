package com.chengfeng.common.util;


/**
 * <p>
 * 功能描述：公用枚举类型
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * <p>
 * Company: 丞风智能科技有限公司
 * </p>
 * 
 * @author Jeanie
 * @version 1.0 2014-4-3 下午5:36:29
 */
public class CommonEnums {

	public enum ApplicationCode{
		/**基础数据**/
		BASIC,
		/**财务**/
		FIN,
		/**运营**/
		OPS,
		/**综合**/
		INTE
	}
	/**
	 * 统计分析--财务中心统计，特殊处理的网点，广东财务中心、潮汕财务中心、国际
	 */
	public enum SpecialHandlerSite {
		GDFINANCEID("2202"), CSFINANCEID("2234"), NATIONAL("0");

		public String siteId;

		private SpecialHandlerSite(String id) {
			this.siteId = id;
		}
	}

	/**
	 * 页面状态 ADD 添加 , EDIT 编辑, EDITTABLE 可编辑
	 */
	public enum PageStatus {
		ADD, EDIT, EDITTABLE
	}

	/**
	 * 查询类型
	 * @author Clyde
	 */
	public enum QueryType {
		// 网点 员工 城市 区县 客户 承包区
		SITE, EMPLOYEE, CITY, COUNTY, CUSTOMER, PART
	}

	/**
	 * 扫描类型
	 */
	public enum ScanType {
		// 收件 发件 到件 派件 留仓 自提 转件 问题 签收
		RECEIVE("1"), SEND("2"), ARRIVE("3"), DELIVERY("4"), STAY("5"), 
		SELF("6"), TURN("7"), PROBLEM("8"), SIGN("9");

		public String value;

		ScanType(String arg0) {
			this.value = arg0;
		}
	}

	/**
	 * 完成率类型
	 */
	public enum RateType {
		// 签收率 到件率 录单率
		SIGNRATE("1"), ARRIVERATE("2"), EWBRATE("3");

		public String value;

		RateType(String arg0) {
			this.value = arg0;
		}
	}

	/**
	 * 数据字典类型
	 */
	public enum DictType {
		ACCOUNT("account_type"), CLASS("class"), EWB("ewb_type"), GOOD_TYPE(
				"goods_type"), SERVICES_TYPE("services_type"), PICK_GOODS_MODE(
				"pick_goods_mode"), BIG_GOODS_TYPE("big_goods_type"), DISBURSEMENT(
				"cod_ poundage_type"), PAYMENT("pod_ poundage_type"), PAY_MODE(
				"pay_mode"), CURRENCY("currency"), POS_TYPE("pos_type"),Bank("bank"),
				OPERATION_TYPE("operation_type"),EC("ec"),COD_TIMELINESS("cod_timeliness"),
				COD_PAY_MODE("cod_pay_mode");
				
		public String value;

		DictType(String arg0) {
			this.value = arg0;
		}
	}

	/**
	 * 提货方式
	 */
	public enum PickGoodsMode {
		SELF_PICK(112L), DISPATICH(111L);

		public Long id;

		PickGoodsMode(Long arg0) {
			this.id = arg0;
		}
	}

	/**
	 * 产品类型 
	 */
	public enum ProductType{
		//定时达 、标准快运、小包
		TIMING_ARRIVE(23L),STANDARD_EXPRESS(24L),MINI_BAG(95L);
		
		public Long id;

		ProductType(Long arg0) {
			this.id = arg0;
		}
	}
	
	/**
	 * 费用功能名称（财务手工输入、费用申请、仲裁输入、差错输入）
	 */
	public enum ChargeFunc {
		FINANCE_INPUT("finance_input"), CHARGE_APPLY("charge_apply"), ARB_INPUT(
				"arb_input"), SLIP_INPUT("slip_input");

		public String value;

		ChargeFunc(String arg0) {
			this.value = arg0;
		}
	}
	
	/**
	 * 差错处理费用项目
	 */
	public enum SlipHandleChargeId {
		SLIP_PUNISH(101L), SLIP_REWARD(1360L),SLIP_SERVICE(102L);

		public Long id;

		SlipHandleChargeId(Long arg0) {
			this.id = arg0;
		}
	}
	
	/**
	 * 差错申报类型（多货、少货上报）
	 */
	public enum SlipTypeId {
		/**多货**/
		SLIP_TYPE_DUOHUO(333L),
		/**整票无货**/
		SLIP_TYPE_ZPWH(324L),
		/**单票少件**/
		SLIP_TYPE_DPSJ(323L);

		public Long id;

		SlipTypeId(Long arg0) {
			this.id = arg0;
		}
	}
	
	/**
	 * 财付通充值、手续费
	 */
	public enum CFTPayChargeId {
		CFT_TENPAY(30L), CFT_COLLECT(14L),CFT_TENPAYCOLLECT(30);

		public Long id;
		public Integer type;

		CFTPayChargeId(Integer type) {
			this.type = type;
		}

		CFTPayChargeId(Long arg0) {
			this.id = arg0;
		}
	}

	/**
	 * 到付货款手续费
	 */
	public enum PODPoundageType {
		// 收寄站手续费 ,付派站手续费, 跨中心手续费
		SENDCOLLECT(198L), DISPATCHCOLLECT(199L), CENTERCOLLECT(200L);
		public Long dictId;

		private PODPoundageType(Long id) {
			this.dictId = id;
		}
	}

	/**
	 * 代收货款手续费
	 */
	public enum CODPoundageType {
		// 收寄站手续费 ,付派站手续费, 跨中心手续费
		SENDCOLLECT(201L), DISPATCHCOLLECT(202L), CENTERCOLLECT(203L);
		public Long dictId;

		private CODPoundageType(Long id) {
			this.dictId = id;
		}
	}

	/**
	 * 账户类型 Id
	 */
	public enum AccountType {
		// 普通 寄件货款 派件货款 业务员 承包区 客户
		NORMAL(10L), SEND(11L), RECEIPT(12L), SALEMAN(13L), 
		CONTRACT_AREA(14L), CUSTOMER(15L);
		
		public Long dictId;

		AccountType(Long id) {
			this.dictId = id;
		}
	}

	/**
	 * 操作类型
	 */
	public enum OperationType {
		// 录单 收件 发件 到件 派件 留仓 自提 转件 签收 问题 发放 账单 装袋
		EWB(1L), RECEIVE(2L), SEND(3L), ARRIVE(4L), DISPATCH(5L), STAY(6L), SELF(
				7L), TRANS(8L), SIGN(9L), PROBLEM(16L), STORAGE(20L), BILL(21L), MANUAL(
				22L), INPUT(187L), RECON(188L),PACK_IN(134L);
		public Long operationTypeId;

		OperationType(Long id) {
			this.operationTypeId = id;
		}
	}
	/**
	 * 转件原因:超区
	 * 
	 */
	public enum TransType{
		TRANSTYPE(1L);
		public Long transTypeId;

		TransType(Long id) {
			this.transTypeId = id;
		}
	}
	/**
	 * 费用类型
	 */
	public enum ChargeItem {
				// 中转费 、扫描费、车线费、二级中转费
				TRANS_FER_AMOUNT(1L), SCAN_AMOUNT(2L), CAR_LINE_CHARGE(3L), TWOLEVEL_TRANS_FERFEE(4L), 
				// 全网派费 、收寄站派件费、往返派件费
				SEND_FEE(5L), DISPATCH_FEE(6L), RETURN_DISPATCHER(7L), 
				// 运费、到付款手续费、代收货款	手续费、大货费
				FREIGHT(9L), COLLECT_FRIEGHT(11L), COD_FRIEGHT(12L), BIG_GOODS(13L),
				// 付派站派件费、寄件到付款、 寄件代收货款
				PAY_DISPATCHER(15L), SEND_COLLECT_CAPITAL(16L), SEND_COD_CAPITAL(17L), 
				// 派件到付款、派件代收货款
				DISPATCH_COLLECT_CAPITAL(18L), DISPATCH_COD_CAPITAL(19L), 
				// 收寄站操作费、付派站操作费、到付操作费
				RECEIVING_SENDING_OPERATION_FEE(20L), PAY_SEND_OPERATION_FEE(21L), ARRIVE_PAY_SEND_OPERATION_FEE(27L), 
				// 保费、付派站保费、收超重费、付超重费、回单费、燃油费
				PREMIUM(10L), PAY_PREMIUM(26L), RECIVE_OVER_WEIGHT(22L), PAY_OVER_WEIGHT(23L), RECEIPT_FEES(24L), FUEL_COSTS(25L), 
				// 到付款收寄站手续费、到付款付派站手续费、到付款跨中心手续费、
				RECEIVE_SEND_COLLECT_FREIGHT(198L), PAY_DISPATCH_COLLECT_FREIGHT(199L), STRIDE_CENTER_COLLECT_FREIGHT(200L), 
				// 代收货款收寄站手续费、代收货款付派站手续费、代收货款跨中心手续费
				RECEIVE_SEND_COD_FREIGHT(201L), PAY_DISPATCH_COD_FREIGHT(202L), STRIDE_CENTER_COD_FREIGHT(203L), 
				// 国际部中转费、香港入仓费、转出、转入
				NATIONAL_TRANSIT_FEES(14L), HK_WAREHOUSING_FEE(29L), OUT(30L), IN(31L), 
				// 网点中转费、网点收派件费、网点付派件费                                                                                                                   承包区中转费(145)                    承包区付派件费(146)
				SITE_TRANS_FEE(28L), SITE_RE_DISPACH_FEE(29L), SITE_PAY_DISPATCH_FEE(80L), CONTRACTAREA_TRANS_FEE(145L),CONTRACTAREA_PAY_DISPATCH_FEE(146L),
				// 网点收到付款手续费、网点付到付款手续费
				SITE_RE_ARRIVE_PAY_FEE(81L), SITE_DIS_ARRIVE_PAY_FEE(82L),
				//扣寄件客户代收货款手续费（费用ID：83）
				RECIVE_SEND_CUSTOMER_COD_FEE(83L),
				//收上楼费、付上楼费
				RECIVE_STAIRS(84L),PAY_STAIRS(85L),
				//提货费、派送费、保险费、燃油附加费、制单费
				PUC_PICK_UP_CHARGE(119L),DELIVERY_CHARGE(120L),CUSTOMER_PREMIUM(122L),FUEL_ADD_COSTS(123L),DOCUMENT_CHARGE(124L),
				//专线费
				ZHUAN_XIAN_CHARGE(90L),
				//付派件员派件费
				PAY_DISPATCHER_EMPLOYEE(143L),
				//整车费
				ZHENG_CHE_CHARGE(93L);
				
		public Long chargeItemId;

		ChargeItem(Long id) {
			this.chargeItemId = id;
		}
	}

	/**
	 * 物品类型
	 */
	public enum GoodsType {
		// 物品、文件
		GOODS(85L), FILES(84L);
		public Long goodsTypeId;

		GoodsType(Long id) {
			this.goodsTypeId = id;
		}
	}

	/**
	 * 回单状态ID
	 */
	public enum RewbStatusId{
		/** 未登记 **/
		UNREGISTERED(0),
		/** 派站已收 **/
		DISPATCHARRIVE(1),
		/** 派站已退 **/
		DISPATCHSEND(2),
		/** 派中心已收 **/
		DISPATCHCENTERARRIVE(3),
		/** 派中心已退 **/
		DISPATCHCENTERSEND(4),
		/** 寄中心已收**/
		SENDCENTERARRIVE(5),
		/** 寄中心已退  **/
		SENDCENTERSEND(6),
		/** 寄站已收 **/
		SENDARRIVE(7);
		
		/** 回单状态ID **/
		public Integer id;

		RewbStatusId(Integer id) {
			this.id = id;
		}
	}
	
	/**
	 * 回单状态 VALUE
	 */
	public enum RewbStatusValue{
		/** 未登记 **/
		UNREGISTERED("未登记"),
		/** 派站已收 **/
		DISPATCHARRIVE("派站已收"),
		/** 派站已退 **/
		DISPATCHSEND("派站已退"),
		/** 派中心已收 **/
		DISPATCHCENTERARRIVE("派中心已收"),
		/** 派中心已退 **/
		DISPATCHCENTERSEND("派中心已退"),
		/** 寄中心已收**/
		SENDCENTERARRIVE("寄中心已收"),
		/** 寄中心已退  **/
		SENDCENTERSEND("寄中心已退"),
		/** 寄站已收 **/
		SENDARRIVE("寄站已收");
		
		/** 回单状态 VALUE **/
		public String value;

		RewbStatusValue(String value) {
			this.value = value;
		}
	}
	
	/**
	 * 扫描数据来源
	 */
	public enum ScanSource {
		// 电脑、销邦PDA
		COMPUTER(118L), PDA(119L);
		public Long scanSourceId;

		ScanSource(Long id) {
			this.scanSourceId = id;
		}
	}

	/**
	 * 运单类型
	 */
	public enum EwbTypeRull {
		// 包号 袋号 主单 子单 回单
		BAGNO(213L), PKGNO(83L), HEWB(79L), REWB(81L), MEWB(77L);

		public Long ewbTypeRuleId;

		EwbTypeRull(Long id) {
			this.ewbTypeRuleId = id;
		}
	}

	/**
	 * 网点类型
	 */
	public enum SiteType {
		/**
		 * 一级直营网点
		 */
		FIRSTDIRECTSITE(146L),
		/**
		 * 二级直营网点
		 */
		SECONDDIRECTSITE(147L), 
		/**
		 * 三级直营网点
		 */
		THIRDDIRECTSITE(148L), 
		/**
		 * 四级直营网点
		 */
		FOURTHDIRECTSITE(149L), 
		/**
		 * 一级财务中心
		 */
		FIRSTCENTERSITE(137L), 
		/**
		 * 二级财务中心
		 */
		SECONDCENTERSITE(138L), 
		/**
		 * 营业部
		 */
		SALES_DEPARTMENT(25L), 
		/**
		 * 同行
		 */
		UNION(154L), 
		/**
		 * 一级加盟网点
		 */
		FIRST_JOIN_SITE(139L), 
		/**
		 * 二级加盟网点
		 */
		SECOND_JOIN_SITE(140L), 
		/**
		 * 一级分拨中心
		 */
		FIRST_SCAN_SITE(143L), 
		/**
		 * 二级分拨中心
		 */
		SECOND_SCAN_SITE(144L), 
		/**
		 * 三级分拨中心
		 */
		THREE_SCAN_SITE(145L), 
		/**
		 * 总部
		 */
		HEADQUARTERS(155L);

		public Long siteTypeId;

		SiteType(Long id) {
			this.siteTypeId = id;
		}
	}

	/**
	 * 网点id
	 */
	public enum SiteID{
		//安能物流；直营财务中心;
		ROOT(2001L), DIRECT(2002L);
		
		public Long id;
		
		SiteID(Long id){
			this.id=id;
		}
	}
	
	/**
	 * 电商来源
	 */
	public enum EcSource{
		//网厅，阿里巴巴,淘宝
		NETHALL(62L),ALI(63L),TAOBAO(59L),WEIXIN(60L);
		
		public Long id;
		
		EcSource(Long id){
			this.id=id;
		}
	}
	
	/**
	 * 付款方
	 */
	public enum PaySide {
		// 寄付;到付;第三方
		PAYSEND(105L), PAYARRIVE(106L), THIRDPARTY(107L);

		public Long paySideId;

		PaySide(Long id) {
			this.paySideId = id;
		}
	}
	
	/**
	 * 支付方式
	 */
	public enum PayMode {
		// 现金 到付现金 月结,到付月结；109返款到付；110回单付
		CASH(102L), COLLECT(103L), MONTHLY(104L), COLMON(239L),
		RETURNARRIVEPAY(109L),RECEIPT(110L);
		public Long payModeId;

		PayMode(Long id) {
			this.payModeId = id;
		}
	}

	/**
	 * 支付方式
	 */
	public enum CodPayMode {
		// 现金 POS 支票 
		CASH(40L), POS(41L), CHECK(42L);
		
		public Long codPayModeId;

		CodPayMode(Long id) {
			this.codPayModeId = id;
		}
	}

	/**
	 * 新闻消息默认新闻类型
	 * 
	 * @author Clyde
	 */
	public enum NewsType {
		// 内部消息
		INTERNAL(1L);

		public Long newsTypeId;

		NewsType(Long id) {
			this.newsTypeId = id;
		}
	}

	/**
	 * 创建路由时 网点上限
	 */
	public enum SiteCount {
		ROUTE(1000);
		public Integer count;

		private SiteCount(Integer count) {
			this.count = count;
		}
	}

	public enum SiteStatus {
		/**
		 * 正常
		 */
		NORMAL(1),
		/**
		 * 暂停
		 */
		PAUSE(0),
		/**
		 * 失效
		 */
		INVALIDATION(-1);

		public Integer status;

		private SiteStatus(Integer status) {
			this.status = status;
		}
	}

	/**
	 * 直辖市、特别行政区
	 * 
	 * @author wws
	 */
	public enum City {
		// 北京、天津、重庆、上海、香港、澳门
		BEIJING("北京"), TIANJING("天津"), CHONGQING("重庆"), SHANGHAI("上海"), HONGKONG(
				"香港特别行政区"), MACAO("澳门特别行政区");

		public String value;

		City(String arg0) {
			this.value = arg0;
		}
	}

	/**
	 * 可以做报关的省
	 * 
	 * @author Clyde
	 */
	public enum CustomsProvince {
		HONGKONG("香港特别行政区"), MACAO("澳门特别行政区"), TAIWAN("台湾省");

		public String value;

		CustomsProvince(String value) {
			this.value = value;
		}
	}

	public enum LocalCountry {
		CHINA("中国");

		public String value;

		LocalCountry(String value) {
			this.value = value;
		}
	}

	/**
	 * 短信公司
	 */
	public enum SMSCompany {
		CF(1);
		
		public Integer companyId;
		
		SMSCompany(Integer companyId){
			this.companyId = companyId;
		}
	}
	
	/**
	 * 短信通知
	 */
	public enum SmsMode {
		// 不通知(156);全程通知(159);签收通知(157L)
		NotNotice(156L), AllNotice(159L),SignNotice(157L);

		public Long dictId;

		SmsMode(Long id) {
			this.dictId = id;
		}
	}
	
	/**
	 * 返款时效
	 */
	public enum ReturnTime {
		T1(72L,"T+1"), T2(78L,"T+2"),T3(80L,"T+3");
		
		public Long dictId;
		
		public String detailName;
		
		ReturnTime(Long id,String detail) {
			this.dictId = id;
			this.detailName=detail;
		}
	}

	/**
	 * 基础物料
	 * 
	 * @author Clyde
	 */
	public enum Material {

		// 12位主单(1L)、8位主单(918L)、 10位子单(2L)、电子面单-子单(4L)、回单(3L)
		EWBNO_TWELVE(1L), EWBNO_EIGHT(918L), HEWBNO_TEN(2L), HEWBNO_ELECTRON(4L), RECEIPT_EWBNO(3L);

		public Long materialId;

		Material(Long id) {
			this.materialId = id;
		}
	}

	/**
	 * 用来判断数据来源
	 * 
	 * @author Clyde
	 */
	public enum InputSource {
		Null, Boolean, String, Integer, Double, Long, Site, // 网点
		Dict, // 数据字典
		Employee, // 员工
		Customer, // 客户
		User, // 用户
		County, // 区县
		City, // 城市
		Province, // 省份
		Country// 国家
	}

	/**
	 * 只读必填样式
	 */
	public enum InputSclass {
		Forbidden("forbidden"), Readonly("readonly"), Required("required"), Null(
				"");

		public String sclass;

		InputSclass(String sclass) {
			this.sclass = sclass;
		}
	}

	/**
	 * 两分钟
	 */
	public enum SendMon {

		TWOMINUTES(0.0013888889);

		public Double twoMin;

		private SendMon(Double twoMin) {
			this.twoMin = twoMin;
		}
	}

	/**
	 * 导出类型
	 */
	public enum ExportDateType {
		/**
		 * 少件查询
		 */
		LESS_MAIN_QUERY("LessMainVO"),
		/**
		 * 少件中心处理
		 */
		LESS_HANDLE("LessMainVO"),
		/**
		 * 少件审核查询
		 */
		LESS_VERIFY_QUERY("LessVerifyVO"),
		/**
		 * 网点预订仓查询
		 */
		PREPARE_SITE_ISSUE("PrepareIssueVO"),
		/**
		 * 中心预订仓查询
		 */
		PREPARE_CENTER_ISSUE("PrepareIssueVO"),
		/**
		 * 电子面单库存信息
		 */
		EEWBS_MAIN_QUERY("EewbsMainVO"),
		/**
		 * 电子面单库存明细
		 */
		EEWBS_DETAIL_QUERY("EewbsDetailVO"),
		/**
		 * 网点订仓查询
		 */
		SITE_ISSUE_QUERY("BookingIssueAndOrderVO"),
		/**
		 * 中心订仓查询
		 */
		CENTER_ISSUE_QUERY("BookingIssueVO"),
		/**
		 * 代收货款查询
		 */
		EWB_COLLECTION_QUERY("OptEwbVO"),
		/**
		 * 承诺时效、分拨中心时效(按城市)
		 */
		PRODUCT_CITY_OPTTIME("BasicProductCityOpttimeVO"),
		/**
		 * 承诺时效、分拨中心时效(按城市)错误信息
		 */
		PRODUCT_CITY_OPTTIME_ERROR("BasicProductCityOpttimeErrorVO"),
		/**
		 * GIS地图监控
		 */
		GIS_MAP_SYSTEM("OptEwbAddressVO"),
		/**
		 * 网点账单管理(寄件信息)
		 */
		BILL_SITE_SEND("AccountsMainVO"),
		/**
		 * 网点账单管理(派件信息)
		 */
		BILL_SITE_DISPATCH("AccountsMainVO"),
		/**
		 *  区域查询
		 */
		SITE_AREA_QUERY("BasicSiteVO"),
		/**
		 * 发车清单
		 */
		SEND_EWB_LIST("OptSendEwbListVo"),
		/**
		 * 中心发件扫描率-汇总信息
		 */
		CENTER_SEND_SUMMARY("RateSendVO"),
		/**
		 * 中心发件扫描率-明细信息
		 */
		CENTER_SEND_DETAIL("RateSendDetailVO"),
		/**
		 * 中心到件扫描率-汇总信息
		 */
		CENTER_ARRIVE_SUMMARY("RateSendVO"),
		/**
		 * 中心到件扫描率-明细信息
		 */
		CENTER_ARRIVE_DETAIL("RateSendDetailVO"),
		/**
		 * 自派、自提异常查询
		 */
		SELF_ERROR_EWBS("SErrEwbsVO"),
		/**
		 * 寄件回单汇总
		 */
		RECEIPT_SEND_PIECE("SendPieceVO"),
		/**
		 * 派件回单汇总
		 */
		RECEIPT_DISPATCH_PIECE("DispatchPieceVO"),
		/**
		 * 寄件回单明细
		 */
		RECEIPT_CENTER_SEND("SendReceiptVO"),
		/**
		 * 派件回单明细
		 */
		RECEIPT_CENTER_DISPATCH("SendReceiptVO"),
		/**
		 * 寄方回单查询
		 */
		RECEIPT_SEND("SendReceiptVO"),
		/**
		 * 派方回单查询
		 */
		RECEIPT_DISPATCH("SendReceiptVO"),
		/**
		 * 中心回单查询
		 */
		RECEIPT_CENTER("SendReceiptVO"),
		/**
		 * 未收费用监控(汇总数据)  
		 */
		NO_CHARGE_MONITOR_SUMARY("Monitor"),
		/**
		 * 未收费用监控(明细数据)
		 */
		NO_CHARGE_MONITOR_DETAIL("KpiEwbVO"),
		/**
		 * 分拨中心错发件给网点明细
		 */
		CENTER_WRONG_DETAIL("MonitorPlus"),
		/**
		 * 扫描记录查询--收件
		 */
		SCAN_RECEIVE("OptReceiveVO"),
		/**
		 * 扫描记录查询--到件
		 */
		SCAN_ARRIVE("OptArriveVO"),
		/**
		 * 扫描记录查询--发件
		 */
		SCAN_SEND("OptSendVO"),
		/**
		 * 扫描记录查询--派件
		 */
		SCAN_DISPATCH("OptDispatchVO"),
		/**
		 * 扫描记录查询--留仓
		 */
		SCAN_STAY("OptStayVO"),
		/**
		 * 扫描记录查询--自提
		 */
		SCAN_SELF("OptSelfVO"),
		/**
		 * 扫描记录查询--转件
		 */
		SCAN_TRANS("OptTransVO"),
		/**
		 * 扫描记录查询--问题件
		 */
		SCAN_PROBLEM("OptProblemVO"),
		/**
		 * 收件
		 */
		RECEIVE("OptReceiveVO"),
		/**
		 * 到件
		 */
		ARRIVE("OptArriveVO"),
		/**
		 * 发件
		 */
		SEND("OptSendVO"),
		/**
		 * 派件
		 */
		DISPATCH("OptDispatchVO"),
		/**
		 * 留仓
		 */
		STAY("OptStayVO"),
		/**
		 * 自提
		 */
		SELF("OptSelfVO"),
		/**
		 * 转件
		 */
		TRANS("OptTransVO"),
		/**
		 * 问题件
		 */
		PROBLEM("OptProblemVO"),
		/**
		 * 签收
		 */
		SIGN("OptSignVO"),
		/**
		 * 中心运单
		 */
		EWB_CENTER("OptEwbVO"),
		/**
		 * 派件运单
		 */
		EWB_DISPATCH("OptEwbVO"),
		/**
		 * 寄件运单
		 */
		EWB_SEND("OptEwbVO"),
		/**
		 * 中心到发统计计
		 */
		CENTER_TOARR("OptArriveVO"),
		/**
		 * 业务员收派统计
		 */
		SALE_SISPATCH_SEND("OptEwbVO"),
		/**
		 * 业务员收派统计(寄件明细)
		 */
		SALE_SISPATCH_SEND_DETAIL("OptEwbVO"),
		/**
		 * 业务员收派统计(派件明细)
		 */
		SALE_SISPATCH_RECEIVE_DETAIL("OptEwbVO"),
		/**
		 * 业务员收派统计全部明细
		 */
		SALE_SISPATCH_DETAIL_ALL("OptEwbVO"),
		/**
		 * 区域货量统计报表
		 */
		AREA_USER_QUERY("StatisticsVO"),
		/**
		 * 保价金额
		 */
		INSURANCE_FEE("StatisticsVO"),
		/**
		 * 全国重量统计
		 */
		NATIONAL_SITE_WEIGHT("OptArriveVO"),
		/**
		 * 营销日报表
		 */
		MARKETING_REPORT("OptEwbVO"),
		/**
		 * 营销日报表(详细)
		 */
		MARKETING_REPORT_DETAIL("OptEwbVO"),
		/**
		 * 运单监控
		 */
		EWB_MONITOR("KpiEwbVO"),
		/**
		 * 运单监控(明细)
		 */
		EWB_MONITOR_DETAIL("KpiEwbVO"),
		/**
		 * 报关件统计
		 */
		CUSTOMS("OptCustomsVO"),
		/**
		 * 用户管理
		 */
		USER_MGR("User"),
		/**
		 * 交易查询
		 */
		TRANS_ENQUIRY("DetailVO"),
		/**
		 * 交易查询汇总
		 */
		TRANS_ENQUIRY_SUM("DetailVO"),
		/**
		 * 交易查询部分
		 */
		TRANS_ENQUIRY_PARTS("DetailVO"),
		/**
		 * 交易查询汇总通过费用
		 */
		TRANS_ENQUIRY_SUM_CHARGE("DetailVO"),
		/**
		 * 截止余额
		 */
		CLOSING_BALANCE("AccountVO"),
		/**
		 * 网点管理
		 */
		SITE_MGR("BasicSiteVO"),
		/**
		 * 全网络查询(
		 * 
		 */
		QUERY_ALL_SITE("BasicSiteVO"),
		/**
		 * 营销统计
		 */
		MARKETING_STATISTICS("StatisticsVO"),
		/**
		 * 全国有到未签
		 */
		COUNTRY_NOT_SIGNED("OptArriveVO"),
		/**
		 * 账单查询
		 */
		FIN_BILL("FinSumBillVO"),
		/**
		 * 客户管理
		 */
		CUSTOMER_MGR("BasicCustomerVO"),
		/**
		 * 员工管理
		 */
		EMPLOYEE_MGR("BasicEmployeeVO"),

		/**
		 * 操作时间管理
		 */
		OPERATION_TIME("OperationTimeVO"),
		/**
		 * 货款处理--核销
		 */
		PAYMENT_PROCESS("OptEwbDto"),

		/**
		 * 货款处理-- 请款
		 */
		PAYMENT_PROCESS_GET("OptEwbDto"),

		/**
		 * 调账审批查询
		 */
		RECONCILE_AUDIT_SEARCH("InputVO"),
		/**
		 * 全国未及时发件
		 */
		COUNTRY_FIAL_SEND("Monitor"),
		/**
		 * 合票监控汇总
		 */
		VOTE_MONITOR("GlobalTaskVO"),
		/**
		 * 合票监控明细
		 */
		VOTE_MONITOR_DETAIL("KpiMergerErrVO"),
		/**
		 * 全国未录单
		 */
		NOT_RECORD("OptEwbVO"),

		/**
		 * 签回单监控
		 */
		MONITOR_SIGN_BACK("OptSignDto"),
		/**
		 * 调账审批管理
		 */
		FINANCE_AUDIT_MANAGER("InputVO"),
		/**
		 * PDA错误监控
		 */
		PDA_ERROR("OptErrVO"),
		/**
		 * KPI 签收率
		 */
		KPI_SIGN("RateReportVO"),
		/**
		 * KPI 到件率
		 */
		KPI_ARR("RateReportVO"),
		/**
		 * KPI 录单率
		 */
		KPI_EWB("RateReportVO"),
		/**
		 * KPI 签收率明细
		 */
		KPI_SIGN_DETAIL("RateReportVO"),
		/**
		 * 	KPI 签收率，有效问题件，无效问题件
		 */
		KPI_SIGN_PROBLEM("RateReportVO"),
		/**
		 * 	KPI 所有问题件
		 */
		KPI_SIGN_PROBLEM_ALL("RateReportVO"),
		/**
		 * KPI 未签收明细
		 */
		KPI_NOT_SIGN_DETAIL("RateReportVO"),
		/**
		 * KPI 所有未签收
		 */
		KPI_NOT_SIGN_DETAIL_ALL("RateReportVO"),		
		/**
		 * KPI 到件率
		 */
		KPI_ARR_DETAIL("RateReportVO"),
		/**
		 * KPI 录单率--录单、未及时录单
		 */
		KPI_EWB_DETAIL("RateReportVO"),
		/**
		 * KPI 未录单、总票数、未录单与未及时录单
		 */
		KPI_EWB_NOT_DETAIL("RateReportVO"),
		/**
		 * 到件发件监控
		 */
		MIN_SITENOTSENT("OptArriveVO"), // 本站有到本站未发
		MIN_PRESITENOTSENT("OptArriveVO"), // 本站有到上站未发
		MIN_SITENOTTO("OptArriveVO"), // 本站有发本站未到
		MIN_NEXTSITENOTTO("OptArriveVO"), // 本站有发下站未到

		/**
		 * 扫描签收监控
		 */
		MIN_SIGN_TOSITE("OptArriveVO"), // 本站有到本站未签
		MIN_SIGN_SITESEND("OptDispatchVO"), // 本站有派本站未签
		MIN_SIGN_SITESIGN("OptSignVO"), // 本站有签本站未到，本站有签本站未派

		/**
		 * 录单扫描监控
		 */
		SITE_NOSEND_NORECORDED("OptEwbVO"), // 本站有录单本站未发
		SEND_NORECORDED("OptSendVO"), // 本站有发本站未录单、本站有发未录单
		ARRIVE_NORECORDED("OptArriveVO"), // 本站有到未录单

		/**
		 * 运单发放查询
		 */
		WAYBILL_QUERY("StoreEwbIssueVO"),
		/**
		 * 运单发放查询
		 */
		WAYBILL_MGR("StoreEwbIssueVO"),

		/**
		 * 网点银行充值查询
		 */
		SITE_BILL_QUERY("FinBankQueryVO"),

		/**
		 * 重量差异监控
		 */
		MON_DIFFERENCE_WEIGHT("OptArriveVO"),
		/**
		 * 开户管理
		 */
		FIN_ACCOUNT("AccountVO"),
		/**
		 * 交易查询(账户信息)
		 */
		FIN_ACCOUNT_TRANS("AccountVO"),
		/**
		 * 交易查询(销户)(账户信息)
		 */
		FIN_ACCOUNT_CLOSE("AccountVO"),
		/**
		 * 网点代收货款统计
		 */
		SITE_COLLECTION("ToPaySumVO"),
		/**
		 * 网点代收货款统计(明细)
		 */
		SITE_COLLECTION_DETAIL("OptEwbVO"),
		/**
		 * 应到件监控
		 */
		MON_DUEARRIVE("OptSendVO"),
		/**
		 * 应到件监控(明细)
		 */
		MON_DUEARRIVE_DE("OptSendVO"),
		/**
		 * 应到件监控明细
		 */
		MON_DUEARRIVE_DETAIL("OptSendVO"),
		/**
		 * 网点到付款统计
		 */
		FIN_SITECOD("OptEwbVO"),
		/**
		 * 网点到付款统计(明细)
		 */
		FIN_SITECOD_DETAIL("OptEwbVO"),
		/**
		 * 发件下一站
		 */
		NEXT_SITE("BasicNextSiteVO"),
		/**
		 * 到件上一站
		 */
		PRIOR_SITE("BasicPriorSiteVO"),
		/**
		 * 网点运费统计
		 */
		NET_FREIGHT_STATISTICS("OptEwbVO"),
		/**
		 * 应收中转费
		 */
		CHARGE_GET_CHART("OptArriveVO"),
		/**
		 * 应付中转费
		 */
		CHARGE_PAY_CHART("OptArriveVO"),
		/**
		 * 网点对账单(派件信息)
		 */
		RECONCILIATION_SITE_DISPATCH("ReconciliationSiteVO"),
		/**
		 * 网点对账单(寄件信息)
		 */
		RECONCILIATION_SITE_SEND("ReconciliationSiteVO"),
		/**
		 * 客户出货统计(汇总数据)
		 */
		CUSTOMER_SHIPMENT("Monitor"),
		/**
		 * 客户出货统计(详细数据)
		 */
		CUSTOMER_SHIPMENT_DETAIL("Monitor"),
		/**
		 * 账单中心
		 */
		ACCOUNTS_MAIN("AccountsMainVO"),
		/**
		 * 账单中心管理
		 */
		BILL_CENTER_MGR("AccountsMainVO"),
		/**
		 * 分拨中心跨省未称重明细
		 */
		NOTWEIGHT_BY_ACROSSPRO("OptEwbVO"),
		/**
		 * 站点漏做到件明细
		 */
		SITE_OMIT_ARRIVE("OptSendVO"),
		/**
		 * 产品分重量段统计
		 */
		PRODUCT_WEIGHT_REPORT("OptSendVO"),
		/**
		 * 财务中心统计
		 */
		FIN_CENTER_REPORT("OptSendVO"),
		/**
		 * 问题件查询
		 */
		PROBLEM_QUERY("ProblemMainVO"),
		/**
		 * 中心问题件查询
		 */
		CENTER_PROBLEM_QUERY("ProblemMainVO"),
		/**
		 * 定时调帐
		 */
		FIN_TIMER("FinTimerVO"),
		/**
		 * 差错数据导出
		 */
		SLIP_MAIN("SlipMainVO"),
		/**
		 * 差错处理过程明细导出
		 */
		SLIP_PROCESS("SlipMainVO"),
		/**
		 * 差错历史状态数据导出
		 */
		SLIP_HISTORY("SlipHistoryHandleVO"),
		/**
		 * 客服记录查询导出
		 */
		SERVICE_QUERY("ServiceQueryVO"),

		/**
		 * 网点银行账户管理
		 */
		SITE_ACCOUNT_MGR("SiteBankAccountVO"),
		
		/**
		 * 网点出站交接单管理、中心出站交接单管理、进站交接单查询下交接单明细
		 */
		EWBS_LIST_DETAIL("EwbsListDetailVO"),
		/**
		 * 网点出站交接单管理
		 */
		EWBS_LIST_SITE("EwbsListVO"),
		/**
		 * 中心出站交接单管理
		 */
		EWBS_LIST_CENTER("EwbsListVO"),
		/**
		 * 进站交接单查询
		 */
		EWBS_LIST_IN_SITE("EwbsListVO"),
		/**
		 * 是否签收统计汇总
		 */
		SIGN_STATISTICS_SUMARY("SignStatisticsVO"),
		/**
		 * 是否签收统计汇总
		 */
		SIGN_STATISTICS_DETAIL("OptEwbVO"),
		/**
		 * 进出站差异确认
		 */
		EWBS_LIST_ERR_INTO("EwbsListErrVO"), EWBS_LIST_ERR_OUT("EwbsListErrVO"),

		/**
		 * 运单库存查询汇总
		 */
		OPS_STOCK_SEARCH("OpsReceiptVO"),

		/**
		 * 运单库存查询明细
		 */
		OPS_STOCK_SEARCH_DETAIL("EwbsDetailVO"),
		/**
		 * 运单库存审批查询
		 */
		OPS_ADJUST_AUDIT_SEARCH("EwbsInputVO"),
		
		/**
		 * 自派件核销
		 */
		SELF_DISPATCH_VERIFICATION("SdCarAndEwbDetailVO"),
		
		/**
		 * 自提件核销
		 */
		SELF_GET_VERIFICATION("SdCarAndEwbDetailVO"),
		
		/**
		 * 交接单号管理
		 */
		EWBS_LIST_NO("EwbsListNoVO"),
		/**
		 * 运单库存审批查询
		 */
		OPS_ADJUST_AUDIT("EwbsInputVO"),
		/**
		 * 物料管理
		 */
		STORE_APPLY("StoreApplyVO"),
		/**
		 * 物料管理查询
		 */
		STORE_APPLY_QUERY("StoreApplyVO"),
		/**
		 * 物料管理查询(站点)
		 */
		STORE_APPLY_QUERY_STATION("StoreApplyVO"),
		/**
		 * 中心订单查询
		 */
		CENTER_ORDER_QUERY("OrdOrderVO"),
		/**
		 * 网点进站确认
		 */
		SITE_INTO_STATION("EwbsListDetailVO"),
		/**
		 * 费用查询
		 */
		FEE_QUERY("AppfreeMainVO"),
		/**
		 * 费用审核
		 */
		FEE_AUDITING("AppfreeMainVO"),
		/**
		 * 中心预货量查询汇总
		 */
		PRO_STOCK_SEARCH("PreStockVO"),
		/**
		 * 中心预货量查询库存明细
		 */
		PRO_STOCK_DETAIL("PreStockVO"),
		/**
		 * 中心预货量查询交接单明细
		 */
		PRO_EWBLIST_DETAIL("PreStockVO"),
		/**
		 * 仲裁查询
		 */
		ABR_SEARCH("ArbMainVO"),
		/**
		 * 自派件查询
		 */
		SELFDISPATCH_QUERY("SdCarVO"),
		/**
		 *自提件查询 
		 */
		SELFGET_QUERY("SgetCarVO"),
		/**
		 * 回单清单查询
		 */
		RECEIPT_QUERY_LIST("OptSendVO"),
		/**
		 * 回单扫描监控
		 */
		RECEIPT_SCAN_MONITOR("OptSendVO"),
		/**
		 * 缺少报价
		 */
		LACK_QUOTE("QuoteLackExportVO"),
		/**
		 * 重复报价导出
		 */
		REPEAT_QUOTE("RepeatQuoteExportVO"),
		/**
		 * 回单扫描监控明细
		 */
		RECEIPT_SCAN_MONITOR_DETAIL("OptSendVO"),
		/**
		 * 派方已收中心未收监控汇总
		 */
		RECEIPT_RECEIVED_MONITOR("DispatchPieceVO"),
		/**
		 * 派方已收中心未收监控明细
		 */
		RECEIPT_RECEIVED_MONITOR_DETAIL("DispatchPieceVO"),
		/**
		 * 网点打卡查询
		 */
		CLOCK_SITE_SEARCH("ClockSite"),
		/**
		 * 签收统计报表
		 */
		EWB_SIGN_REPORT("OptSignVO"),
		/**
		 * 签收统计报表详细
		 */
		EWB_SIGN_REPORT_DETAIL("OptSignVO"),
		/**
		 * 到件清单 
		 */
		ARRIVE_DETAIL_LIST("OptArriveVO"), 
		/**
		 * 发件清单
		 */
		SEND_DETAIL_LIST("OptSendVO"), 
		/**
		 * 总部库存查询汇总
		 */
		HQ_STOCK_TOTAL("OpsReceiptVO"),
		/**
		 * 总部库存查询明细
		 */
		HQ_STOCK_DETAIL("OpsReceiptVO"),
		/**
		 * 总部库存查询所有明细
		 */
		HQ_STOCK_ALL_DETAIL("OpsReceiptVO"),
		/**
		 * 中心运单修改审批(共3个页面)
		 */
		EWB_CHANGE("OptAdEwbVO"), 
		/**
		 * 网络派费报表
		 */
		NETWORK_FEE_REPORT("NetWorkDisFeeVO"),
		/**
		 * 货量预报查询
		 */
		VOLUMN_PRE_QUERY("StatisticsVO"), 
		/**
		 * 综合查询
		 */
		APPRAISAL_QUERY("EwbAppraisalVO"), 
		/**
		 * 理赔申报
		 */
		CLAIMS_MAIN("ClaimsMainVO"),
		/**
		 * 理赔查询
		 */
		CLAIMS_QUERY("ClaimsMainVO"),
		/**
		 * 理赔处理完成
		 */
		CLAIMS_FINISH("ClaimsMainVO"),
		/**
		 * 转件查询
		 */
		SP_TRANS("SpTransVO"),
		/**
		 * 退件查询
		 */
		SP_RETURN("SpecialReturnVO"),
		/**
		 * 物料调拨登记
		 */
		MTL_ALLOCATE_REGISTER("MtlOrderVO"),
		/**
		 * 物料申购查询
		 */
		MTL_SITE_APPLY_QUERY("MtlOrderVO"),
		/**
		 * 网点退货入库
		 */
		MTL_MATERIAL_RETURN_INPUT("MtlOrderVO"),
		/**
		 * 仓库库存查询（左）
		 */
		MTL_MATERIAL_INVE_MAIN("MtlMainVO"),
		/**
		 * 仓库库存查询（右）
		 */
		MTL_MATERIAL_INVE_DETAIL("MtlDetailVO"),
		/**
		 * 物管审核
		 */
		MTL_MANAGER_VERIFY("MtlOrderVO"),
		/**
		 * 总裁办审核
		 */
		MTL_PRESIDENTS_OFFICE_VERIFY("MtlOrderVO"),
		/**
		 * 采购申请
		 */
		MTL_SHOP_APPLY("MtlOrderVO"),
		/**
		 * 车辆称重扫描
		 */
		CAR_WEIGHT("OptCarWeightVO"),
		/**
		 * 结算对账
		 */
		FIN_SUM_OTP("FinSumOptVO"),
		/**
		 * 账单中心汇总
		 */
		BILL_CENTER_SUMMARY_MGR("AccountsMainVO");
		
		public String beanName;

		ExportDateType(String beanName) {
			this.beanName = beanName;
		}
	}
}
