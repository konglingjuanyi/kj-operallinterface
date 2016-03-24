package com.chengfeng.ne.opt.orders.dao;

import com.chengfeng.ne.opt.orders.domain.OrdStatusVO;
import com.thinkjf.dao.DaoException;

public interface IOrdStatusDao {


    void insertSelective(OrdStatusVO record)  throws DaoException;

}