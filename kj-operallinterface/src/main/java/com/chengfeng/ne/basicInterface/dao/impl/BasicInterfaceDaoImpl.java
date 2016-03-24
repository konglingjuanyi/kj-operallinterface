package com.chengfeng.ne.basicInterface.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.domain.BasicDeptVO;
import com.chengfeng.ne.basedata.domain.BasicEmployeeVO;
import com.chengfeng.ne.basedata.domain.BasicJobVO;
import com.chengfeng.ne.basedata.domain.BasicSiteDetailVO;
import com.chengfeng.ne.basedata.domain.BasicSiteVO;
import com.chengfeng.ne.basedata.domain.User;
import com.chengfeng.ne.basicInterface.dao.IBasicInterfaceDao;
import com.thinkjf.dao.DaoException;
@Repository("basicInterfaceDao")
public class BasicInterfaceDaoImpl extends BaseNeDaoImpl implements IBasicInterfaceDao {
    
	/**
	 * 根据岗位名称查询岗位信息
	 * @author 旷娣
	 * @param jobName
	 * @return List<BasicJobVO>
	 * @throws DaoException
	 */
	@Override
	public List<BasicJobVO> queryJobByName(String jobName) throws DaoException {
		return queryForList("BasicJobVO.queryJobByName",jobName);
	}


	/**
	 * 新增用户
	 * @author 旷娣
	 * @param user
	 * @throws DaoException
	 */
	@Override
	public void doCreateUser(User user) throws DaoException {
		insertRecord("User.insert",user);
	}

	/**
	 * 获得账户ID
	 */
	@Override
	public Long getAccountIdBySeq() throws DaoException {
		Long seq=69000000L;
		Object obj = queryForObject("Fin_AccountVO.getAccountId");
		if(obj!=null&&!obj.equals("")){
			seq= seq.longValue()+((Long) obj).longValue();
		}
		return seq;
	}


}
