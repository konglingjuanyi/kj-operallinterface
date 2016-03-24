package com.chengfeng.ne.opt.orders.dao;

import java.util.List;
import java.util.Map;

import com.chengfeng.ne.opt.orders.domain.OrderinterfaceErrorVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;

/**
 * 
 * 功能描述：订单接口异常数据处理数据层
 *
 * Copyright: Copyright (c) 2013
 *
 * Company: 丞风智能科技有限公司
 * 
 * @author Pippo
 *
 * @version 2015-12-16
 */
public interface IOrderinterfaceErrorDao {
	
	/**
	 * 新增接口异常数据
	 * @param orderinterfaceErrorVO
	 * @throws DaoException   
	 * @author Pippo
	 */
	public void doCreateOrderinterfaceError(OrderinterfaceErrorVO orderinterfaceErrorVO) throws DaoException;
	
	/**
	 * 删除接口异常数据
	 * @param deleteMap
	 * @return
	 * @throws DaoException   
	 * @author Pippo
	 */
	public void doDeleteOrderinterfaceError(Map<String,Object> deleteMap) throws DaoException;
	
	/**
	 * 查询异常数据列表
	 * @param searchMap 
	 * (rownum获取记录数\orderDatatype数据类型\orderStatus数据状态)
	 * @return
	 * @throws DaoException   
	 * @author Pippo
	 */
	public List<OrderinterfaceErrorVO> queryOrderinterfaceErrorList(Map<String,Object> searchMap) throws DaoException;
	
	/**
	 * 通过接口订单ID获取异常数据
	 * @param orderId
	 * @return
	 * @throws DaoException   
	 * @author Pippo
	 */
	public OrderinterfaceErrorVO getOrderinterfaceErrorByOrderId(Long orderId) throws DaoException;
	/**
	 * 分页查询错误订单信息
	 * 
	 */
	public PaginationVO<OrderinterfaceErrorVO> queryPagedListError(Map<String, Object> map,int pageIndex, int pageSize) throws DaoException;
	/**
	 * 统计错误订单总记录
	 */
	public int recordCount(Map<String, Object> map)throws DaoException;
	
	
}
