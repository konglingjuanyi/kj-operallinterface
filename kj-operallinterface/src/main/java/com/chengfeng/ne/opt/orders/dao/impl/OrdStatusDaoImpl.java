package com.chengfeng.ne.opt.orders.dao.impl;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.opt.orders.dao.IOrdStatusDao;
import com.chengfeng.ne.opt.orders.domain.OrdStatusVO;
import com.thinkjf.dao.DaoException;

@Repository("opt_ordStatusDao")
public class OrdStatusDaoImpl extends BaseNeDaoImpl implements IOrdStatusDao {

    public OrdStatusDaoImpl() {
        super();
    }

    

    public void insertSelective(OrdStatusVO record)  throws DaoException{
    	insertRecord("Opt_OrdStatusVO.insertSelective", record);
    }

    
}