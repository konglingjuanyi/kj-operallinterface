package com.chengfeng.ne.basedata.dao;

import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.BasicProvinceVO;
import com.thinkjf.dao.DaoException;

/**
 * <p>功能描述：省份数据访问接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
public interface IProvinceDao {
	/**
	 * 按省份名称集合查询省份
	 * @param countryId
	 * @return List
	 * @throws DaoException
	 */
	List<BasicProvinceVO> queryProvinceListByName(Map<String, Object> map)
			throws DaoException;
	
	/**
	 * 按所属国家ID和名称查询省份
	 * @param countryId
	 * @param provinceName
	 * @return BasicProvinceVO
	 * @throws DaoException
	 */
	public BasicProvinceVO queryProvinceByName(Long countryId, String provinceName) throws DaoException;
}
