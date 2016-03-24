package com.chengfeng.ne.basedata.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.AccountVO;
import com.chengfeng.ne.basedata.domain.BasicSiteDetailVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;
/** 
 * <p>功能描述：开户管理数据访问层接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2014-1-22 下午2:10:30
 */
public interface AccountDAO {
	
    /**
     * 增加财务帐户
     * @param record
     * @throws DaoException
     */
	void insert(AccountVO record) throws DaoException;
	

	/**
	 * 判断开户行下是否已经存在此帐号
	 * true 表示存在 false 表示不存在
	 * @param record
	 * @return
	 * @throws DaoException
	 */
	Boolean isExistsAccountVO(AccountVO record) throws DaoException;
	
	
}