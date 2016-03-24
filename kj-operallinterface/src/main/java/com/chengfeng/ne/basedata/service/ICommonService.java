package com.chengfeng.ne.basedata.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.BasicCityVO;
import com.chengfeng.ne.basedata.domain.BasicCountyVO;
import com.chengfeng.ne.basedata.domain.BasicProvinceVO;
import com.chengfeng.ne.basedata.domain.BasicSiteVO;
import com.thinkjf.service.ServiceException;

public interface ICommonService {
	List<BasicCityVO> queryCityListByName(Map<String, Object> map)throws ServiceException;
	
	public BasicCountyVO  queryCountyByName(Long cityId, String countyName) throws ServiceException;
	
	List<BasicProvinceVO> queryProvinceListByName(Map<String, Object> map)throws ServiceException;
	
	public BasicSiteVO querySiteById(Long siteId);
	public Date getCurrentTime() throws ServiceException;

}
