package com.chengfeng.ne.basedata.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chengfeng.common.service.BaseNeService;
import com.chengfeng.ne.basedata.dao.ICountryDao;
import com.chengfeng.ne.basedata.dao.IProvinceDao;
import com.chengfeng.ne.basedata.domain.BasicCountryVO;
import com.chengfeng.ne.basedata.domain.BasicProvinceVO;
import com.chengfeng.ne.basedata.service.ICountryService;
//import com.thinkjf.apps.dict.service.SystemCacheService;
import com.thinkjf.service.ServiceException;

/**
 * <p>
 * 功能描述：国家服务类
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
@Service("nationService")
public class CountryServiceImpl implements ICountryService, BaseNeService {

	@Resource(name = "countryDao")
	private ICountryDao countryDao;


	/**
	 * 按名称查询国家
	 * @param countryName
	 * @return BasicCountryVO
	 * @throws ServiceException
	 */
	@Override
	public BasicCountryVO queryCountryByName(String countryName)
			throws ServiceException {
		return countryDao.queryCountryByName(countryName);

	}


	@Override
	public Date getCurrentTime() {
		return null;
	}

	
}
