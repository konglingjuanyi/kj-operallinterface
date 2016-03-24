package com.chengfeng.ne.basicInterface.dao;

import java.util.Date;
import java.util.List;

import com.chengfeng.ne.basedata.domain.BasicJobVO;
import com.chengfeng.ne.basedata.domain.User;
import com.thinkjf.dao.DaoException;

public interface IBasicInterfaceDao {
	/**
	 * 根据岗位名称查询岗位信息
	 * @author 旷娣
	 * @param jobName
	 * @return List<BasicJobVO>
	 * @throws DaoException
	 */
	public List<BasicJobVO> queryJobByName(String jobName) throws DaoException;
	
	public Date getCurrentTime();


	/**
	 * 修改网点和网点明细成功
	 * @param siteVO
	 * @param detailSiteVO
	 * @throws DaoException
	 * @author FengQing
	 * @date 2015-8-22 下午8:30:36
	 */
//	public void doUpdateSiteVO(BasicSiteVO siteVO,BasicSiteDetailVO detailSiteVO) throws DaoException;

//	/**
//	 * 新增员工
//	 * @param employee
//	 * @throws DaoException
//	 */
//	public Long doCreateEmployee(BasicEmployeeVO employee) throws DaoException;
//	
//	/**
//	 * 修改员工
//	 * @param employee
//	 * @throws DaoException
//	 */
//	public void doModifyEmployee(BasicEmployeeVO employee) throws DaoException;

	/**
	 * 新增部门
	 * @author 旷娣
	 * @param dept
	 * @throws DaoException
	 */
//	public void doCreateDept(BasicDeptVO dept) throws DaoException;
	
	/**
	 * 新增岗位
	 * @author 旷娣
	 * @param job
	 * @throws DaoException
	 */
//	public void doCreateJob(BasicJobVO job) throws DaoException;
	
	/**
	 * 新增用户
	 * @author 旷娣
	 * @param user
	 * @throws DaoException
	 */
	public void doCreateUser(User user) throws DaoException;
	/**
	 * 获得开户ID
	 * @return
	 * @throws DaoException
	 * @author FengQing
	 * @date 2015-12-26 下午3:34:00
	 */
	public Long getAccountIdBySeq() throws DaoException;
}
