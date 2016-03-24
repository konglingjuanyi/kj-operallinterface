package com.chengfeng.ne.basedata.service;

import java.util.Date;
import java.util.List;

import com.chengfeng.ne.basedata.domain.BasicCountryVO;
import com.thinkjf.service.ServiceException;

/**
 * <p>功能描述：国家服务接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
public interface ICountryService {

	/**
	 * 按名称查询国家
	 * @param countryName
	 * @return BasicCountryVO
	 * @throws ServiceException
	 */
	public BasicCountryVO queryCountryByName(String countryName) throws ServiceException;
	
	
}
