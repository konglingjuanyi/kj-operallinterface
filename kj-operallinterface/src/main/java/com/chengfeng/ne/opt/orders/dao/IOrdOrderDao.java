package com.chengfeng.ne.opt.orders.dao;

import com.chengfeng.ne.opt.orders.domain.OrdOrderVO;
import com.thinkjf.dao.DaoException;

public interface IOrdOrderDao {

	Long insert(OrdOrderVO record)  throws DaoException;

	public OrdOrderVO getOrderInfoByOrderId(Long oldOrderId) throws DaoException;
}