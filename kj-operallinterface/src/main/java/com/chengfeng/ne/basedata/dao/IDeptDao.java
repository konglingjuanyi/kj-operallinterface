package com.chengfeng.ne.basedata.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.BasicDeptVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;



/**
 * <p>功能描述：部门数据访问接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2013-12-22 下午5:57:04
 */
public interface IDeptDao {

	/**
	 * 新增部门
	 * @param dept
	 */
	public Long doCreateDept(BasicDeptVO dept);
	/**
	 * 根据部门名称查询
	 * @return
	 */
	public List<BasicDeptVO> queryDeptByName(String deptName);
	
	/**
	 * 获取部门管理自定义顺序最大值
	 * @return Long
	 */
	public Long getMaxDeptOrder();
	
	/**
	 * 根据名称和网点类型查询部门
	 * @param map
	 * @return BasicDeptVO
	 * @throws DaoException
	 */
	@SuppressWarnings("rawtypes")
	BasicDeptVO getDeptByNameAndSiteTypeId(Map map) throws DaoException;
}
