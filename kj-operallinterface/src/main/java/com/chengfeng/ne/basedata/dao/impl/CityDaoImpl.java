package com.chengfeng.ne.basedata.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.ICityDao;
import com.chengfeng.ne.basedata.domain.BasicCityVO;
import com.thinkjf.dao.DaoException;

/**
 * <p>功能描述：城市数据访问类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
@Repository("cityDao")
public class CityDaoImpl extends BaseNeDaoImpl implements ICityDao {

	
	/**
	 * 按名称集合查询城市
	 * @param cityName
	 * @return BasicCityVO
	 * @throws DaoException
	 */
	@Override
	public List<BasicCityVO> queryCityListByName(Map<String,Object> map)throws DaoException {
		
		return queryForList("BasicCityVO.queryCityListByName", map);
	}

	/**
	 * 按名称查询城市
	 * @param cityName
	 * @return BasicCityVO
	 * @throws DaoException
	 */
	@Override
	public List<BasicCityVO> queryCityByName(String cityName)throws DaoException {
		
			return queryForList("BasicCityVO.queryCityByName", cityName);
	}
	
}
