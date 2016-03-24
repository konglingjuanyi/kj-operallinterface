package com.chengfeng.ne.opt.orders.dao;

import java.util.List;
import java.util.Map;

import com.chengfeng.ne.opt.orders.domain.OrderAddressLibraryVO;
import com.thinkjf.dao.DaoException;

public interface IOrderAddressLibraryDao {

	/**
	 * 按条件查询信息
	 * @param map
	 * @return
	 * @throws DaoException
	 */
	public List<OrderAddressLibraryVO> queryOrderAddressLibraryListByTotal(
			Map<String, Object> map) throws DaoException ;
}
