package com.chengfeng.ne.basedata.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.ISiteDao;
import com.chengfeng.ne.basedata.domain.BasicSiteVO;
import com.chengfeng.ne.redis.aop.AddToRedis;
import com.chengfeng.ne.redis.aop.GetFromRedis;
import com.chengfeng.ne.redis.aop.ReadCacheType;
import com.chengfeng.ne.redis.aop.UpdateToRedis;
import com.chengfeng.ne.redis.utils.RedisBusinessConstant;
import com.thinkjf.core.config.GlobalConfig;
import com.thinkjf.dao.DaoException;


/**
 * <p>功能描述：站点数据访问类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
@Repository("siteDao")
public class SiteDaoImpl extends BaseNeDaoImpl implements ISiteDao {
	
	/**
	 * 按ID查询站点
	 * @return BasicSite
	 */
	@GetFromRedis(key = RedisBusinessConstant.BASIC_SITE_CACHE_NAME,fieldKey = "#siteId", cacheType = ReadCacheType.Map,  classType = BasicSiteVO.class)
	@Override
	public BasicSiteVO querySiteById(Long siteId) throws DaoException {
		BasicSiteVO site=null;
			Object obj=queryForObject("BasicSiteVO.querySiteById", siteId);
			if(obj!=null&&!obj.equals("")){
				site=(BasicSiteVO)obj;
			}
		return site;
	}
	
	/**
	 * 获取最大站点自定义顺序
	 * @return Long
	 */
	public Long getMaxSiteOrder() throws DaoException{
		Long order=null;
			Object obj=queryForObject("BasicSiteVO.getMaxSiteOrder");;
			if(obj!=null){
				order=(Long)obj;
			}
		return order;
	}
	
	/**
	 * 按条件进行动态查询
	 * @return List<BasicSite>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BasicSiteVO> querySiteByTotal(Map<String, String> map) throws DaoException {
		// TODO Auto-generated method stub
		List<BasicSiteVO> list=null;		
			List obj=queryForList("BasicSiteVO.querySiteByTotal",map);
			if(obj!=null&&obj.size()>0){
				list=(List<BasicSiteVO>)obj;
			}
		return list;
	}
	
	@AddToRedis(key=RedisBusinessConstant.BASIC_SITE_CACHE_NAME,cacheType=ReadCacheType.Map,classType=BasicSiteVO.class)
	@Override
	public Long doCreateSite(BasicSiteVO site) throws DaoException{
		Long l=null;
			site.setCreatedBy(0L);
			site.setCreatedTime(getCurrentTime());
			site.setRdStatus(1);
			Object obj=insertRecord("BasicSiteVO.doCreateSite", site);
			if(obj!=null&&!obj.equals("")){
				l=(Long) obj;
			}
		return l;
	}

	/**
	 * 根据网点编号查询
	 */
	@Override
	public BasicSiteVO getSiteByCode(String siteCode) throws DaoException {
		// TODO Auto-generated method stub
		BasicSiteVO site=null;
			Object obj=queryForObject("BasicSiteVO.getSiteByCode", siteCode);
			if(obj!=null&&!obj.equals("")){
				site=(BasicSiteVO)obj;
			}
		return site;
	}

	/**
	 * 按名称查询
	 * @return List<BasicSite>
	 */
	@Override
	public BasicSiteVO querySiteByName(String siteName) throws DaoException {
		// TODO Auto-generated method stub
		BasicSiteVO site=null;
			Object obj=queryForObject("BasicSiteVO.querySiteByName", siteName);
			if(obj!=null&&!obj.equals("")){
				site=(BasicSiteVO)obj;
			}
		return site;
	}

	/**
	 * 按编号模糊查询
	 * @return List<BasicSite>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BasicSiteVO> querySiteByLikeCode(String siteCode) throws DaoException {
		// TODO Auto-generated method stub
		List<BasicSiteVO> list=null;	
		String str=GlobalConfig.getPropertyValue("common.search.listbox.datasize");
		Integer rownum=Integer.parseInt(str);
		Map map=new HashMap();
		map.put("rownum", rownum);
		map.put("siteCode", siteCode);
			List obj=queryForList("BasicSiteVO.querySiteByLikeCode",map);
			if(obj!=null&&obj.size()>0){
				list=(List<BasicSiteVO>)obj;
			}
		return list;
	}
	
	@UpdateToRedis(key=RedisBusinessConstant.BASIC_SITE_CACHE_NAME,mapKeymethodName="getSiteId",cacheType = ReadCacheType.Map,classType=BasicSiteVO.class)
	@Override
	public void doModifySite(BasicSiteVO site) throws DaoException{
		site.setModifiedBy(0L);
		site.setModifiedTime(getCurrentTime());
		updateRecord("BasicSiteVO.doModifySite", site);
	}
}
