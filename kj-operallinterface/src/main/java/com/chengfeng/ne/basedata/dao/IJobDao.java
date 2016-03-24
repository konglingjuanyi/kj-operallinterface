package com.chengfeng.ne.basedata.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.BasicDeptJobVO;
import com.chengfeng.ne.basedata.domain.BasicJobVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;


/**
 * 
 * <p>功能描述：岗位管理数据访问层接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2013-12-23 上午10:21:59
 */
public interface IJobDao {
	/**
	 * 新增岗位
	 * @param job
	 * @return
	 */
	public Long doCreateJob(BasicJobVO job);
	
	/**
	 * 新增岗位部门到部门岗位关系表
	 * @param deptJob
	 */
	public Long doCreateDeptJob(BasicDeptJobVO deptJob);
	
	/**
	 * 获取数据字典自定义顺序最大值
	 * @return Long
	 */
	public Long getMaxJobOrder();
	
	/**
	 * 获取时间
	 * @return
	 */
	public Date getCurrentTime();

	/**
	 * 根据对象查询部门岗位关系
	 * @return BasicDeptJobVO
	 */
	public BasicDeptJobVO queryDeptJobByEntity(BasicDeptJobVO entity) throws  DaoException;
}
