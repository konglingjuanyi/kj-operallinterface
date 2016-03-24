package com.chengfeng.ne.basedata.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.BasicSiteVO;

/**
 * <p>功能描述：站点信息数据访问层接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2013-12-24 上午11:18:56
 */
public interface ISiteDao {
	
	/**
	 * 按ID查询网点
	 * @return BasicSite
	 */
	public BasicSiteVO querySiteById(Long siteId);
	
	/**
	 * 获取时间
	 * @return
	 */
	public Date getCurrentTime();
	/**
	 * 新增站点
	 * @param site
	 */
	public Long doCreateSite(BasicSiteVO site);
	
	/**
	 * 获取最大站点自定义顺序
	 * @return Long
	 */
	public Long getMaxSiteOrder();
	
	/**
	 * 按条件进行动态查询
	 * @return List<BasicSite>
	 */
	public List<BasicSiteVO> querySiteByTotal(Map<String, String> map);
	
	/**
	 * 按编号查询
	 * @return BasicSite
	 */
	public BasicSiteVO getSiteByCode(String siteCode);
	
	/**
	 * 按名称查询
	 * @return BasicSite
	 */
	public BasicSiteVO querySiteByName(String siteName);
	
	/**
	 * 按编号模糊查询
	 * @return List<BasicSite>
	 */
	public List<BasicSiteVO> querySiteByLikeCode(String siteCode);
	/**
	 * 保存站点
	 * @param site
	 */
	public void doModifySite(BasicSiteVO site);
}
