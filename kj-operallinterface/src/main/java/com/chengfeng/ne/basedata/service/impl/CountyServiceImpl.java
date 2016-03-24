package com.chengfeng.ne.basedata.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chengfeng.common.service.BaseNeService;
import com.chengfeng.ne.basedata.dao.ICountyDao;
import com.chengfeng.ne.basedata.domain.BasicCityVO;
import com.chengfeng.ne.basedata.domain.BasicCountyVO;
import com.chengfeng.ne.basedata.service.ICountyService;
//import com.thinkjf.apps.dict.service.SystemCacheService;
import com.thinkjf.dao.entity.PaginationVO;
import com.thinkjf.service.ServiceException;

/**
 * <p>
 * 功能描述：区县服务类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013
 * </p>
 * <p>
 * Company: 丞风智能科技有限公司
 * </p>
 * 
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
@Service("countyService")
public class CountyServiceImpl implements ICountyService, BaseNeService {

	@Resource(name = "countyDao")
	private ICountyDao countyDao;
	

	/**
	 * 按所属城市ID、名称查询区县
	 * @param countyName
	 * @param cityId
	 * @return BasicCountyVO
	 * @throws ServiceException
	 */
	@Override
	public BasicCountyVO queryCountyByNameAndCityId(Long cityId, String countyName)
			throws ServiceException {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cityId", cityId);
		map.put("countyName", countyName);
		return countyDao.queryCountyByNameAndId(map);
	}


	@Override
	public Date getCurrentTime() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
