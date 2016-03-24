package com.chengfeng.ne.opt.orders.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.opt.orders.dao.IOrderinterfaceErrorDao;
import com.chengfeng.ne.opt.orders.domain.OrderinterfaceErrorVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;

@Repository("opt_orderinterfaceErrorDao")
public class OrderinterfaceErrorDaoImpl extends BaseNeDaoImpl implements IOrderinterfaceErrorDao{

	@Override
	public void doCreateOrderinterfaceError(
			OrderinterfaceErrorVO orderinterfaceErrorVO) throws DaoException {
		insertRecord("Opt_OrderinterfaceErrorVO.insert", orderinterfaceErrorVO);
	}

	@Override
	public void doDeleteOrderinterfaceError(Map<String, Object> deleteMap)
			throws DaoException {
		deleteRecord("Opt_OrderinterfaceErrorVO.delete", deleteMap);
	}

	@Override
	public List<OrderinterfaceErrorVO> queryOrderinterfaceErrorList(
			Map<String, Object> searchMap) throws DaoException {
		// TODO Auto-generated method stub
		return super.queryForList("Opt_OrderinterfaceErrorVO.queryOrderinterfaceError", searchMap);
	}

	@Override
	public OrderinterfaceErrorVO getOrderinterfaceErrorByOrderId(Long orderId)
			throws DaoException {
		// TODO Auto-generated method stub
		return super.queryForObject("Opt_OrderinterfaceErrorVO.getOrderinterfaceErrorByOrderId",orderId);
	}
    /**
     * 分页查询错误订单信息
     */
	@Override
	public PaginationVO<OrderinterfaceErrorVO> queryPagedListError(
			Map<String, Object> map,int pageIndex, int pageSize) throws DaoException {
		return super.queryPagedList(OrderinterfaceErrorVO.class, map, pageIndex, pageSize);
	}
    /**
     * 统计错误订单总记录
     */
	@Override
	public int recordCount(Map<String, Object> map) throws DaoException {
		return queryForObject("Opt_OrderinterfaceErrorVO.recordCount",map);
	}

}
