package com.chengfeng.ne.basedata.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.IEmployeeDao;
import com.chengfeng.ne.basedata.domain.BasicEmployeeVO;
import com.chengfeng.ne.redis.aop.AddToRedis;
import com.chengfeng.ne.redis.aop.GetFromRedis;
import com.chengfeng.ne.redis.aop.ReadCacheType;
import com.chengfeng.ne.redis.aop.UpdateToRedis;
import com.chengfeng.ne.redis.utils.RedisBusinessConstant;
import com.thinkjf.core.config.GlobalConfig;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;

/**
 * <p>功能描述：员工数据访问类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Laughing
 * @version 1.0 2013-12-23 下午3:03:28
 */
@Repository("employeeDao")
public class EmployeeDaoImpl extends BaseNeDaoImpl implements IEmployeeDao {
	
	/**
	 * 新增员工
	 * @param employee
	 * @throws DaoException
	 * modify by Jeff 2015.07.15
	 */	
	@AddToRedis(key=RedisBusinessConstant.BASIC_EMPLOYEE_CACHE_NAME,cacheType=ReadCacheType.Map,classType=BasicEmployeeVO.class)
	@Override
	public Long doCreateEmployee(BasicEmployeeVO employee)  throws DaoException{
		employee.setCreatedBy(0L);
		employee.setCreatedTime(getCurrentTime());
		employee.setRdStatus(1);
		Object obj = insertRecord("BasicEmployeeVO.doCreateEmployee", employee);
		if(null !=obj){
			Long employeeId=(Long) obj;
			return employeeId;
		}else{
			return null;
		}
	}

	/**
	 * 修改员工
	 * @param employee
	 * @throws DaoException
	 * modify by Jeff 2015.07.15
	 */
	@UpdateToRedis(key=RedisBusinessConstant.BASIC_EMPLOYEE_CACHE_NAME,mapKeymethodName="getEmployeeId",cacheType = ReadCacheType.Map,classType=BasicEmployeeVO.class)	
	@Override
	public void doSaveEmployee(BasicEmployeeVO employee) throws DaoException{
		employee.setModifiedBy(0L);
		employee.setModifiedTime(getCurrentTime());
		updateRecord("BasicEmployeeVO.doSaveEmployee", employee);
	}

	/**
	 * 删除员工
	 * @param map
	 * @throws DaoException
	 * modify by Jeff 2015.07.15
	 */
	@UpdateToRedis(key=RedisBusinessConstant.BASIC_EMPLOYEE_CACHE_NAME,mapKeymethodName="getEmployeeId",cacheType = ReadCacheType.Map,classType=BasicEmployeeVO.class)	
	@Override
	public void doDeleteEmployee(BasicEmployeeVO employee) throws DaoException{
		employee.setModifiedBy(0L);
		employee.setModifiedTime(getCurrentTime());
		employee.setRdStatus(0);
		deleteRecord("BasicEmployeeVO.doDeleteEmployee", employee);
	}
	
	/**
	 * 获取网点下最小员工编号
	 * @param siteCode
	 * @return String
	 * @throws DaoException
	 */
	@Override
	public String getMinEmployeeCode(String siteCode) throws DaoException{
		return queryForObject("BasicEmployeeVO.getMinEmployeeCode", siteCode);
}
	
	/**
	 * 获取自定义顺序最大值
	 * @return Integer
	 * @throws DaoException
	 */
	@Override
	public Integer getMaxOrder()throws DaoException {
			Integer maxOrder=(Integer) queryForObject("BasicEmployeeVO.getMaxEmployeeOrder");
			return maxOrder;
	}
	
	/**
	 * 根据编号查询员工
	 * @param employeeCode
	 * @return BasicEmployeeVO
	 * @throws DaoException
	 */
	@Override
	public BasicEmployeeVO queryEmploreeByCode(String employeeCode) throws DaoException{
			return (BasicEmployeeVO)queryForObject("BasicEmployeeVO.queryEmploreeByCode", employeeCode);
	}
	
	/**
	 * 根据ID查询员工
	 * @param employeeId
	 * @return BasicEmployeeVO
	 * @throws DaoException
	 * modify by Jeff 2015.07.15
	 */
	@GetFromRedis(key = RedisBusinessConstant.BASIC_EMPLOYEE_CACHE_NAME,fieldKey = "#employeeId", cacheType = ReadCacheType.Map,  classType = BasicEmployeeVO.class)	
	@Override
	public BasicEmployeeVO queryEmploreeById(Long employeeId) throws DaoException{
			return (BasicEmployeeVO)queryForObject("BasicEmployeeVO.queryEmploreeById", employeeId);
	}
	
	/**
	 * 根据条件模糊查询开户户名为员工
	 * @param title
	 * @return List
	 * @throws DaoException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<BasicEmployeeVO> queryEmpAccountByPNC(String title,Long siteId) throws DaoException {
		String str=GlobalConfig.getPropertyValue("common.search.listbox.datasize");
		Integer rownum=Integer.parseInt(str);
		Map map = new HashMap();
		map.put("title", title);
		map.put("pinyin", title.toUpperCase());
		map.put("siteId", siteId);
		map.put("rownum", rownum);
		return queryForList("BasicEmployeeVO.queryEmpAccountByPNC", map);
	}
	/**
	 * 根据条件模糊查询开户户名为员工
	 * @param title
	 * @return List
	 * @throws DaoException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<BasicEmployeeVO> queryEmpAccountByPNC(String title,Long siteId,String accountStatus) throws DaoException {
		String str=GlobalConfig.getPropertyValue("common.search.listbox.datasize");
		Integer rownum=Integer.parseInt(str);
		Map map = new HashMap();
		map.put("title", title);
		map.put("pinyin", title.toUpperCase());
		map.put("siteId", siteId);
		map.put("rownum", rownum);
		map.put("accountStatus", accountStatus);
		return queryForList("BasicEmployeeVO.queryEmpAccountByPNC", map);
	}
	
	/**
	 * 根据条件模糊查询开户户名为员工(销户用)
	 * @param title
	 * @return List
	 * @throws DaoException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<BasicEmployeeVO> queryXHEmpAccountByPNC(String title,Long siteId) throws DaoException {
		String str=GlobalConfig.getPropertyValue("common.search.listbox.datasize");
		Integer rownum=Integer.parseInt(str);
		Map map = new HashMap();
		map.put("title", title);
		map.put("pinyin", title.toUpperCase());
		map.put("siteId", siteId);
		map.put("rownum", rownum);
		return queryForList("BasicEmployeeVO.queryXHEmpAccountByPNC", map);
	}

	/**
	 * 根据条件精确查询员工
	 * @param title
	 * @return List
	 * @throws DaoException
	 */
	@Override
	public List<BasicEmployeeVO> queryEmpBy(String title)
			throws DaoException {
			return queryForList("BasicEmployeeVO.queryEmpByTitle", title);
	}

	/**
	 * 根据所属网点查询员工信息
	 * @param siteId
	 * @return List
	 * @throws DaoException
	 */
	@Override
	public List<BasicEmployeeVO> queryEmpBySiteId(Long siteId)
			throws DaoException {
			return queryForList("BasicEmployeeVO.queryEmpBySiteId", siteId);
	}

	/**
	 * 根据所属网点和时间查询员工信息
	 * @param map
	 * @return List
	 * @throws DaoException
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public List<BasicEmployeeVO> queryEmpBySiteIdAndTime(Map map)
			throws DaoException{
			return queryForList("BasicEmployeeVO.queryEmpBySiteIdAndTime", map);
	}

	/**
	 * 分页查询
	 * @param searchMap
	 * @param pageIndex
	 * @param pageSize
	 * @return PaginationVO
	 * @throws DaoException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PaginationVO<BasicEmployeeVO> queryPagedList(Map searchMap,
			int pageIndex, int pageSize) throws DaoException {
		
		String titlt = (String) searchMap.get("title");
		if(null != titlt){
			searchMap.put("pinyin", titlt.toUpperCase());
		}
		PaginationVO<BasicEmployeeVO> page = super.queryPagedList(BasicEmployeeVO.class,searchMap, pageIndex, pageSize);
		if(null != page && page.getResult().size()>0){
			return page;
		}else{
			return null;
		}
	}

	/**
	 * 查询员工的ID和姓名
	 * @return List
	 * @throws DaoException
	 */
	@Override
	public List<BasicEmployeeVO> queryEmployeeIdAndName() throws DaoException {
		return queryForList("BasicEmployeeVO.queryEmployeeIdAndName");
	}


	/* (non-Javadoc)
	 * @see com.chengfeng.ne.basedata.dao.IEmployeeDao#queryPagedEmpInfoList(java.util.Map, int, int)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PaginationVO<BasicEmployeeVO> queryPagedEmpInfoList(Map searchMap,
			int pageIndex, int pageSize) throws DaoException {
		pageIndex = pageIndex <= 0 ? 1 : pageIndex;
		pageSize = pageSize <= 0 ? 20 : pageSize;
		List result = queryForPaginatedList("BasicEmployeeVO.queryPagedEmpList",searchMap, pageIndex, pageSize);
		Integer recordCount = queryReocrdTotalCount("BasicEmployeeVO.queryRecordCountByEmp", searchMap);
		return new PaginationVO<BasicEmployeeVO>(result, recordCount, pageIndex, pageSize);
	}

	/**
	 * 根据用户Id查询部门岗位Id
	 * @param userId
	 * @return Long
	 * @throws DaoException
	 */
	@Override
	public Long getDeptJobIdByUserId(Long userId) throws DaoException {
		Object obj = queryForObject("BasicEmployeeVO.getDeptJobIdByUserId", userId);
		if(null != obj){
			return (Long) obj;
		}else{
			return null;
		}
	}



	/**
	 * 根据员工ID查询用户ID
	 * @param empId
	 * @return Long
	 * @throws DaoException
	 */
	@Override
	public Long getUserIdByEmpId(Long employeeId) throws DaoException {
		Object obj = queryForObject("BasicEmployeeVO.getUserIdByEmpId", employeeId);
		if(null != obj){
			return (Long) obj;
		}else{
			return null;
		}
	}
	
	/**
	 *  根据查询员工
	 */
	@Override
	public List<BasicEmployeeVO> queryEmployeeByCondition(
			Map<String, Object> params) throws DaoException {
		return queryForList("BasicEmployeeVO.queryEmployeeByCondition", params);
	}
	
	/**
	 * 缓存专用  加载所有员工信息
	 * @return
	 * @throws DaoException
	 * add by Jeff 2015.07.15
	 */
	@GetFromRedis(key = RedisBusinessConstant.BASIC_EMPLOYEE_CACHE_NAME, cacheType = ReadCacheType.Maps, mapKeymethodName="getEmployeeId",classType = BasicEmployeeVO.class)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BasicEmployeeVO> queryEmploreeList() throws DaoException {
		List<BasicEmployeeVO> list=null;
			List obj=queryForList("BasicEmployeeVO.queryEmploreeList");
			if(obj!=null&&obj.size()>0){
				list=(List<BasicEmployeeVO>)obj;
			}
		return list;
	}

	@Override
	public List<BasicEmployeeVO> queryEmpBySiteIdAndEmpName(Map<String, Object> map)
			throws DaoException {
		return queryForList("BasicEmployeeVO.queryEmpBySiteIdAndEmpName", map);
	}


}
