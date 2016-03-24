package com.chengfeng.ne.basedata.dao;

import com.chengfeng.ne.basedata.domain.BasicSiteDetailVO;
import com.thinkjf.dao.DaoException;

/**
 * <p>功能描述：网点详细信息数据访问层接口</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2014-8-21 下午6:01:35
 */
public interface ISiteDetailDao {

	/**
	 * 新增站点详细信息
	 * @param siteDetail
	 * @throws DaoException
	 */
	void doCreateSiteDetail(BasicSiteDetailVO siteDetail) throws DaoException;

	/**
	 * 修改站点详细信息
	 * @param siteDetail
	 * @throws DaoException
	 */
	void doModifySiteDetail(BasicSiteDetailVO siteDetail) throws DaoException;
}
