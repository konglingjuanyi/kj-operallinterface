package com.chengfeng.ne.basedata.service;

import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.BasicCountyVO;
import com.thinkjf.dao.entity.PaginationVO;
import com.thinkjf.service.ServiceException;

/**
 * <p>功能描述：区县服务接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
public interface ICountyService {

	/**
	 * 按所属城市ID、名称查询区县
	 * @param countyName
	 * @param cityId
	 * @return BasicCountyVO
	 * @throws ServiceException
	 */
	public BasicCountyVO queryCountyByNameAndCityId(Long cityId, String countyName) throws ServiceException;
	
}