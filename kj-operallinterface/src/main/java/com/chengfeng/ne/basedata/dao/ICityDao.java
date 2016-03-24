package com.chengfeng.ne.basedata.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.BasicCityVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;

/**
 * <p>功能描述：城市数据访问接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
public interface ICityDao {
	
	

	/**
	 * 按名称集合查询城市
	 * @param cityName
	 * @return BasicCityVO
	 * @throws DaoException
	 */
	List<BasicCityVO> queryCityListByName(Map<String, Object> map)
			throws DaoException;

	/**
	 * 按名称查询城市
	 * @param cityName
	 * @return BasicCityVO
	 * @throws DaoException
	 */
	public List<BasicCityVO> queryCityByName(String cityName) throws DaoException;
}
