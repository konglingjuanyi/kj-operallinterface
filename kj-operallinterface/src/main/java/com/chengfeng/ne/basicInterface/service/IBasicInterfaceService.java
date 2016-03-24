package com.chengfeng.ne.basicInterface.service;

import java.util.Date;
import java.util.List;

import com.chengfeng.ne.basedata.domain.AccountVO;
import com.chengfeng.ne.basedata.domain.BasicEmployeeVO;
import com.chengfeng.ne.basedata.domain.BasicSiteDetailVO;
import com.chengfeng.ne.basedata.domain.BasicSiteVO;
import com.chengfeng.ne.basedata.domain.User;
import com.thinkjf.service.ServiceException;

public interface IBasicInterfaceService {
	public String sendRequest(String data,String url) throws ServiceException;
	/**
	 * 接收网点信息
	 * @param startDate
	 * @param endDate
	 * @throws ServiceException
	 * @author FengQing
	 * @date 2015-8-21 上午9:59:13
	 */
	public void getSiteInfo(Date startDate,Date endDate) throws ServiceException;

	/**
	 * 获取员工信息
	 * @author 旷娣
	 * @param startDate
	 * @param endDate
	 * @throws ServiceException
	 */
	public void getEmployeeInfo(Date startDate,Date endDate) throws ServiceException;
	/**
	 * 解析网点数据
	 * @param params
	 * @throws ServiceException
	 * @author FengQing
	 * @date 2015-8-22 下午5:01:00
	 */
	public List<String> parserSiteInfo(String params) throws ServiceException;
	
	/**
	 * 根据参数解析json串得到员工信息
	 * @author 旷娣
	 * @param params
	 */
	public List<String> ParseEmployeeInfo(String params) throws ServiceException;
	
	/**
	 * 新增员工，并同时新增用户
	 * @author 旷娣
	 * @param user
	 * @throws ServiceException
	 */
	public void doCreateEmployee(BasicEmployeeVO emp,User user) throws ServiceException;
	/**
	 * 新增员工，用户，账户
	 * @param emp
	 * @param user
	 * @param account
	 * @throws ServiceException
	 * @author FengQing
	 * @date 2015-12-26 下午2:53:07
	 */
	public void doCreateEmployeeAndAccount(BasicEmployeeVO emp,User user,AccountVO account) throws ServiceException;
}
