package com.chengfeng.ne.basedata.dao.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.AccountDAO;
import com.chengfeng.ne.basedata.domain.AccountVO;
import com.chengfeng.ne.basedata.domain.BasicSiteDetailVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;
/**
 * <p>功能描述：财务开户数据访问层实现类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2014-2-13 下午2:23:31
 */
@Repository("fin_accountDAO")
public class AccountDAOImpl extends BaseNeDaoImpl  implements AccountDAO {
  
    /**
     * 增加财务帐户
     * @param record
     * @throws DaoException
     */
    public void insert(AccountVO record)  throws DaoException{    	
        insertRecord("Fin_AccountVO.insert", record);
    }

	/**
	 * 判断开户行下是否已经存在此帐号
	 * 
	 * @param record
	 * @return
	 * @throws DaoException
	 */
	@Override
	public Boolean isExistsAccountVO(AccountVO record) throws DaoException {
		Integer count = queryForObject("Fin_AccountVO.isExistsAccountVO", record);
		if (count > 0) {
			return true;
		}
		return false;
	}
	
	
	
	
}