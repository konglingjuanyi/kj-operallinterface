package com.chengfeng.ne.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.ISiteDetailDao;
import com.chengfeng.ne.basedata.domain.BasicSiteDetailVO;
import com.thinkjf.dao.DaoException;


/**
 * <p>功能描述：站点数据访问类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-22 下午5:57:04
 */
@Repository("siteDetailDao")
public class SiteDetailDaoImpl extends BaseNeDaoImpl implements ISiteDetailDao {
	

	/**
	 * 新增站点详细信息
	 * @param BasicSiteDetailVO
	 */
	@Override
	public void doCreateSiteDetail(BasicSiteDetailVO siteDetail) throws DaoException {
			insertRecord("BasicSiteDetailVO.doCreateSiteDetail",siteDetail);		
	}
	
	/**
	 * 保存站点详细信息
	 * @param BasicSiteDetailVO
	 */
	@Override
	public void doModifySiteDetail(BasicSiteDetailVO siteDetail) throws DaoException {
			updateRecord("BasicSiteDetailVO.doModifySiteDetail", siteDetail);
	}
}
