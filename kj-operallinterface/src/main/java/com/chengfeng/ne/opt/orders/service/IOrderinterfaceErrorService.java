package com.chengfeng.ne.opt.orders.service;

import java.util.List;
import java.util.Map;

import com.chengfeng.ne.opt.orders.domain.OrderinterfaceErrorVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;
import com.thinkjf.service.ServiceException;

/**
 * 
 * 功能描述：订单接口异常数据处理服务层
 *
 * Copyright: Copyright (c) 2013
 *
 * Company: 丞风智能科技有限公司
 * 
 * @author Pippo
 *
 * @version 2015-12-17
 */
public interface IOrderinterfaceErrorService {
	/**
	 * 新增接口异常数据
	 * @param orderinterfaceErrorVO
	 * @throws DaoException   
	 * @author Pippo
	 */
	public void doCreateOrderinterfaceError(OrderinterfaceErrorVO orderinterfaceErrorVO) throws ServiceException;
	
	/**
	 * 删除接口异常数据
	 * @param deleteMap
	 * @return
	 * @throws DaoException   
	 * @author Pippo
	 */
	public void doDeleteOrderinterfaceError(Map<String,Object> deleteMap) throws ServiceException;
	
	/**
	 * 查询异常数据列表
	 * @param searchMap 
	 * (rownum获取记录数\orderDatatype数据类型\orderStatus数据状态)
	 * @return
	 * @throws DaoException   
	 * @author Pippo
	 */
	public List<OrderinterfaceErrorVO> queryOrderinterfaceErrorList(Map<String,Object> searchMap) throws ServiceException;
	
	/**
	 * 通过接口订单ID获取异常数据
	 * @param orderId
	 * @return
	 * @throws DaoException   
	 * @author Pippo
	 */
	public OrderinterfaceErrorVO getOrderinterfaceErrorByOrderId(Long orderId) throws ServiceException;
	
	/**
	 * 接口同步新增订单数据（订单接口正常接收数据业务处理）
	 * @param json
	 * @param orderId 订单接口数据ID
	 * @param false为订单接口获取数据，true为异常数据获取
	 * @param orderId(非空时表示为订单数据来源异常处理，业务数据处理成功后需要删除异常表数据)
	 * @return
	 * @throws ServiceException   
	 * @author Pippo
	 */
	public boolean orderCreatedToInterFace(String json,Long orderId,boolean falg) throws ServiceException;
	/**
	 * 分页查询错误订单信息
	 * 
	 */
	public PaginationVO<OrderinterfaceErrorVO> queryPagedListError(Map<String, Object> map,int pageIndex, int pageSize) throws ServiceException;
	/**
	 * 统计错误订单总记录
	 */
	public int recordCount(Map<String, Object> map)throws ServiceException;
}
