package com.chengfeng.ne.opt.orders.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.opt.orders.dao.IOrderAddressLibraryDao;
import com.chengfeng.ne.opt.orders.domain.OrderAddressLibraryVO;
import com.thinkjf.dao.DaoException;


@Repository("opt_OrderAddressLibraryDao")
public class OrderAddressLibraryDaoImpl extends BaseNeDaoImpl implements IOrderAddressLibraryDao{

	/**
	 * 按条件查询信息
	 */
	@Override
	public List<OrderAddressLibraryVO> queryOrderAddressLibraryListByTotal(
			Map<String, Object> map) throws DaoException {
		return queryForList("Opt_OrderAddressLibraryVO.queryPagedList",map);
	}
	
}
