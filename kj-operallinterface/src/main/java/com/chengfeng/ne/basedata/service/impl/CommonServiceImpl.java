package com.chengfeng.ne.basedata.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chengfeng.ne.basedata.dao.ICityDao;
import com.chengfeng.ne.basedata.dao.ICountyDao;
import com.chengfeng.ne.basedata.dao.IProvinceDao;
import com.chengfeng.ne.basedata.dao.ISiteDao;
import com.chengfeng.ne.basedata.domain.BasicCityVO;
import com.chengfeng.ne.basedata.domain.BasicCountyVO;
import com.chengfeng.ne.basedata.domain.BasicProvinceVO;
import com.chengfeng.ne.basedata.domain.BasicSiteVO;
import com.chengfeng.ne.basedata.service.ICommonService;
import com.thinkjf.service.ServiceException;

@Service("commonService")
public class CommonServiceImpl implements ICommonService{
	
	@Resource(name = "cityDao")
	private ICityDao cityDao; // 城市管理接口
	@Resource(name = "countyDao")
	private ICountyDao countyDao; // 城市管理接口
	@Resource(name = "provinceDao")
	private IProvinceDao provinceDao; // 城市管理接口
	@Resource(name = "siteDao")
	private ISiteDao siteDao; // 城市管理接口
	
	@Override
	public List<BasicCityVO> queryCityListByName(Map<String, Object> map)
			throws ServiceException {
		return cityDao.queryCityListByName(map);
	}


	@Override
	public BasicCountyVO queryCountyByName(Long cityId, String countyName)
			throws ServiceException {
		BasicCountyVO county = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cityId", cityId);
		map.put("countyName", countyName);
		county = countyDao.queryCountyByNameAndId(map);
		return county;
	}

	@Override
	public BasicSiteVO querySiteById(Long siteId) {
		return siteDao.querySiteById(siteId);
	}
	@Override
	public Date getCurrentTime() {
		return siteDao.getCurrentTime();
	}


	@Override
	public List<BasicProvinceVO> queryProvinceListByName(Map<String, Object> map)
			throws ServiceException {
		return provinceDao.queryProvinceListByName(map);
	}
}
