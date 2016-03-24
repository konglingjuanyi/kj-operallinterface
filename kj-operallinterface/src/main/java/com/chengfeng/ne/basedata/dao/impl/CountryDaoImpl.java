package com.chengfeng.ne.basedata.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.ICountryDao;
import com.chengfeng.ne.basedata.domain.BasicCountryVO;
import com.thinkjf.core.config.GlobalConfig;
import com.thinkjf.dao.DaoException;

/**
 * <p>功能描述：国家数据访问类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
@Repository("countryDao")
public class CountryDaoImpl extends BaseNeDaoImpl implements ICountryDao {

	/**
	 * 按名称查询国家
	 * @param countryName
	 * @return BasicCountryVO
	 * @throws DaoException
	 */
	@Override
	public BasicCountryVO queryCountryByName(String countryName)throws DaoException {
		return (BasicCountryVO) queryForObject("BasicCountryVO.queryCountryByName", countryName);
	}

	
}
