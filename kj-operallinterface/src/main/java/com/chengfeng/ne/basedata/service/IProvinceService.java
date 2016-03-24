package com.chengfeng.ne.basedata.service;

import java.util.Date;
import java.util.List;

import com.chengfeng.ne.basedata.domain.BasicProvinceVO;
import com.thinkjf.service.ServiceException;

/**
 * <p>功能描述：省份服务接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
public interface IProvinceService {

	/**
	 * 按所属国家ID和名称查询省份
	 * @param countryId
	 * @param provinceName
	 * @return BasicProvinceVO
	 * @throws ServiceException
	 */
	public BasicProvinceVO queryProvinceByName(Long countryId, String provinceName) throws ServiceException;
	
}
