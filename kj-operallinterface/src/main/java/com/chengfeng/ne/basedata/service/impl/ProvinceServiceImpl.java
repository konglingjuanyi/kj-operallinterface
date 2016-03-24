package com.chengfeng.ne.basedata.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chengfeng.common.service.BaseNeService;
import com.chengfeng.ne.basedata.dao.ICityDao;
import com.chengfeng.ne.basedata.dao.IProvinceDao;
import com.chengfeng.ne.basedata.domain.BasicCityVO;
import com.chengfeng.ne.basedata.domain.BasicProvinceVO;
import com.chengfeng.ne.basedata.service.IProvinceService;
import com.thinkjf.service.ServiceException;

/**
 * <p>
 * 功能描述：省份服务类
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
@Service("provinceService")
public class ProvinceServiceImpl implements IProvinceService, BaseNeService {

	@Resource(name = "provinceDao")
	private IProvinceDao provinceDao;

	/**
	 * 按所属国家ID和名称查询省份
	 * @param countryId
	 * @param provinceName
	 * @return BasicProvinceVO
	 * @throws ServiceException
	 */
	@Override
	public BasicProvinceVO queryProvinceByName(Long countryId, String provinceName)
			throws ServiceException {
		return provinceDao.queryProvinceByName(countryId, provinceName);
	}

	@Override
	public Date getCurrentTime() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
