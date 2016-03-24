package com.chengfeng.ne.basedata.dao;

import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.BasicCountyVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;

/**
 * <p>功能描述：区县数据访问接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
public interface ICountyDao {

	/**
	 * 按名称、所属城市查询区县
	 * @param map
	 * @return BasicCountyVO
	 * @throws DaoException
	 */
	@SuppressWarnings("rawtypes")
	public BasicCountyVO queryCountyByNameAndId(Map map) throws DaoException;
	
}
