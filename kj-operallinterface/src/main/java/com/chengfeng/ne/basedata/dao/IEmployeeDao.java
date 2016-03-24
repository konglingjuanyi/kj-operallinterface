package com.chengfeng.ne.basedata.dao;

import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.BasicEmployeeVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;

/**
 * <p>功能描述：员工数据访问接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-23 下午3:01:47
 */
public interface IEmployeeDao {

	/**
	 * 新增员工
	 * @param employee
	 * @throws DaoException
	 */
	public Long doCreateEmployee(BasicEmployeeVO employee) throws DaoException;

	/**
	 * 修改员工
	 * @param employee
	 * @throws DaoException
	 */
	public void doSaveEmployee(BasicEmployeeVO employee) throws DaoException;

	/**
	 * 删除员工
	 * @param employee
	 * @throws DaoException
	 */
	public void doDeleteEmployee(BasicEmployeeVO employee) throws DaoException;

	/**
	 * 查询员工的ID和姓名
	 * @return List
	 * @throws DaoException
	 */
	public List<BasicEmployeeVO> queryEmployeeIdAndName() throws DaoException;
	
	/**
	 * 获取网点下最小员工编号
	 * @param siteCode
	 * @return String
	 * @throws DaoException
	 */
	public String getMinEmployeeCode(String siteCode) throws DaoException;
	
	/**
	 * 获取自定义顺序最大值
	 * @return Integer
	 * @throws DaoException
	 */
	public Integer getMaxOrder() throws DaoException;
	
	/**
	 * 根据编号查询员工
	 * @param employeeCode
	 * @return BasicEmployeeVO
	 * @throws DaoException
	 */
	public BasicEmployeeVO queryEmploreeByCode(String employeeCode) throws DaoException;
	
	/**
	 * 根据ID查询员工
	 * @param employeeId
	 * @return BasicEmployeeVO
	 * @throws DaoException
	 */
	public BasicEmployeeVO queryEmploreeById(Long employeeId) throws DaoException;

	

	

	/**
	 * 根据条件精确查询员工
	 * @param title
	 * @return List
	 * @throws DaoException
	 */
	public List<BasicEmployeeVO> queryEmpBy(String title) throws DaoException;
	
	/**
	 * 根据所属网点查询员工信息
	 * @param siteId
	 * @return List
	 * @throws DaoException
	 */
	public List<BasicEmployeeVO> queryEmpBySiteId(Long siteId) throws DaoException;
	
	/**
	 * 根据所属网点和时间查询员工信息
	 * @param map
	 * @return List
	 * @throws DaoException
	 */
	@SuppressWarnings("rawtypes")
	public List<BasicEmployeeVO> queryEmpBySiteIdAndTime(Map map) throws DaoException;
	
	/**
	 * 根据用户Id查询部门岗位Id
	 * @param userId
	 * @return Long
	 * @throws DaoException
	 */
	public Long getDeptJobIdByUserId(Long userId) throws DaoException;
	
	
	/**
	 * 根据员工ID查询用户ID
	 * @param employeeId
	 * @return Long
	 * @throws DaoException
	 */
	public Long getUserIdByEmpId(Long employeeId) throws DaoException;
	
	/**
	 * 分页查询
	 * @param searchMap
	 * @param pageIndex
	 * @param pageSize
	 * @return PaginationVO
	 * @throws DaoException
	 */
	@SuppressWarnings({ "rawtypes" })
	public  PaginationVO<BasicEmployeeVO> queryPagedList(Map searchMap, int pageIndex,
			int pageSize) throws DaoException;
	
	/**
	 * 分页查询员工姓名、员工编号
	 * @param searchMap
	 * @param pageIndex
	 * @param pageSize
	 * @return PaginationVO
	 * @throws DaoException
	 */
	@SuppressWarnings({ "rawtypes" })
	public  PaginationVO<BasicEmployeeVO> queryPagedEmpInfoList(Map searchMap, int pageIndex,
			int pageSize) throws DaoException;

	/**
	 * 根据条件模糊查询开户户名为员工的数据
	 * @param title
	 * @return List
	 * @throws DaoException
	 */
	List<BasicEmployeeVO> queryEmpAccountByPNC(String title, Long siteId)
			throws DaoException;

	
	/**
	 * 根据条件模糊查询开户户名为员工(销户用)
	 * @param title
	 * @return List
	 * @throws DaoException
	 */
	List<BasicEmployeeVO> queryXHEmpAccountByPNC(String title, Long siteId)
			throws DaoException;

	/**
	 * 根据条件模糊查询开户户名为员工
	 * @param title
	 * @return List
	 * @throws DaoException
	 */
	List<BasicEmployeeVO> queryEmpAccountByPNC(String title, Long siteId,
			String accountStatus) throws DaoException;


	/**
	 *  根据查询员工
	 * @param params
	 * @return
	 * @throws DaoException
	 */
	public List<BasicEmployeeVO> queryEmployeeByCondition(
			Map<String, Object> params) throws DaoException;
	
	/**
	 * 缓存专用  加载所有员工信息
	 * @return
	 * @throws DaoException
	 * add by Jeff 2015.07.15
	 */
	public List<BasicEmployeeVO> queryEmploreeList() throws DaoException;
	/**
	 * 根据员工姓名与所属网点查询
	 * @param map
	 * @return
	 * @throws DaoException
	 * @author FengQing
	 * @date 2015-12-21 下午5:50:25
	 */
	public List<BasicEmployeeVO> queryEmpBySiteIdAndEmpName(Map<String,Object> map) throws DaoException;
}
