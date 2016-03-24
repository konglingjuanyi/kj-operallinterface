package com.chengfeng.ne.basedata.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.IProvinceDao;
import com.chengfeng.ne.basedata.domain.BasicProvinceVO;
import com.thinkjf.dao.DaoException;

/**
 * <p>功能描述：省份数据访问类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
@Repository("provinceDao")
public class ProvinceDaoImpl extends BaseNeDaoImpl implements IProvinceDao {
	/**
	 * 按省份名称集合查询省份
	 * @param countryId
	 * @return List
	 * @throws DaoException
	 */
	@Override
	public List<BasicProvinceVO> queryProvinceListByName(Map<String,Object> map) throws DaoException{
		return queryForList("BasicProvinceVO.queryProvinceListByName",map);
	}
	
	/**
	 * 按所属国家ID和名称查询省份
	 * @param countryId
	 * @param provinceName
	 * @return BasicProvinceVO
	 * @throws DaoException
	 */
	@Override
	public BasicProvinceVO queryProvinceByName(Long countryId, String provinceName) 
			throws DaoException{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("countryId", countryId);
			map.put("provinceName", provinceName);
			return (BasicProvinceVO) queryForObject("BasicProvinceVO.queryProvinceByName", map);
	}
}
