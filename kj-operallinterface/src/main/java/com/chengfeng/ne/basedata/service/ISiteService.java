package com.chengfeng.ne.basedata.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.BasicSitePropVO;
import com.chengfeng.ne.basedata.domain.BasicSiteVO;
import com.chengfeng.ne.basedata.domain.BasicSiteDetailVO;
import com.thinkjf.dao.entity.PaginationVO;
import com.thinkjf.service.ServiceException;

/**
 * 
 * <p>功能描述：站点服务层接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2013-12-24 上午10:11:51
 */
public interface ISiteService {

	/**
	 * 按编号模糊查询
	 * @return List<BasicSite>
	 */
	public List<BasicSiteVO> querySiteByCode(String siteId) throws ServiceException;
	
	
	
	/**
	 * 按条件进行动态查询
	 * @return List<BasicSite>
	 */
	public List<BasicSiteVO> querySiteByTotal(Map<String, String> map) throws ServiceException;
	
	/**
	 * 获取最大站点自定义顺序
	 * @return Long
	 */
	public Long getMaxSiteOrder() throws ServiceException;
}	
