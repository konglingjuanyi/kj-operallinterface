package com.chengfeng.ne.basedata.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.chengfeng.common.service.BaseNeService;
import com.chengfeng.ne.basedata.dao.ISiteDao;
import com.chengfeng.ne.basedata.domain.BasicSiteDetailVO;
import com.chengfeng.ne.basedata.domain.BasicSitePropVO;
import com.chengfeng.ne.basedata.domain.BasicSiteRangeVO;
import com.chengfeng.ne.basedata.domain.BasicSiteServicesVO;
import com.chengfeng.ne.basedata.domain.BasicSiteVO;
import com.chengfeng.ne.basedata.service.ISiteService;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;
import com.thinkjf.service.ServiceException;


/**
 * 
 * <p>功能描述：站点服务实现类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2013-12-24 上午10:56:03
 */
@Service("siteServiceImpl")
public class SiteServiceImpl implements ISiteService,BaseNeService {
	@Resource(name="siteDao")
	private ISiteDao siteDao;
	
	/**
	 * 按编号模糊查询
	 * @return List<BasicSite>
	 */
	@Override
	public List<BasicSiteVO> querySiteByCode(String siteCode) throws ServiceException {
		List<BasicSiteVO> list=null;
			list=siteDao.querySiteByLikeCode(siteCode);			
		return list;
	}



	/**
	 * 按条件进行动态查询
	 * @return List<BasicSite>
	 */
	@Override
	public List<BasicSiteVO> querySiteByTotal(Map<String, String> map) throws ServiceException {
		List<BasicSiteVO> list=null;
			list=siteDao.querySiteByTotal(map);			
		return list;
	}
	
	
	
	/**
	 * 获取最大站点自定义顺序
	 * @return Long
	 */
	public Long getMaxSiteOrder() throws ServiceException{
		Long order=0l;
			Object obj=siteDao.getMaxSiteOrder();
			if(obj!=null){
				order=(Long)obj;
			}
		
		return order;
	}

	@Override
	public Date getCurrentTime() {
		return null;
	}
	
}
