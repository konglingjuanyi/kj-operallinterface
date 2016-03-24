package com.chengfeng.ne.basedata.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.ICountyDao;
import com.chengfeng.ne.basedata.domain.BasicCountyVO;
import com.thinkjf.dao.DaoException;


/**
 * <p>功能描述：区县数据访问类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
@Repository("countyDao")
public class CountyDaoImpl extends BaseNeDaoImpl implements ICountyDao {
	
	/**
	 * 按名称、所属城市查询区县
	 * @param map
	 * @return BasicCountyVO
	 * @throws DaoException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public BasicCountyVO queryCountyByNameAndId(Map map) throws DaoException{
			return (BasicCountyVO) queryForObject("BasicCountyVO.queryCountyByNameAndId", map);
	}
	
}
