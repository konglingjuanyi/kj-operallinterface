package com.chengfeng.ne.opt.orders.dao.impl;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.opt.orders.dao.IOrdOrderDao;
import com.chengfeng.ne.opt.orders.domain.OrdOrderVO;
import com.thinkjf.dao.DaoException;

@Repository("opt_ordOrderDao")
public class OrdOrderDaoImpl extends BaseNeDaoImpl implements IOrdOrderDao {
	public OrdOrderDaoImpl() {
        super();
    }

    public Long insert(OrdOrderVO record)  throws DaoException{
        return insertRecord("Opt_OrdOrderVO.insert", record);
    }
    public OrdOrderVO getOrderInfoByOrderId(Long oldOrderId) throws DaoException{
    	return queryForObject("Opt_OrdOrderVO.getOrderInfoByOrderId", oldOrderId);
    }
}