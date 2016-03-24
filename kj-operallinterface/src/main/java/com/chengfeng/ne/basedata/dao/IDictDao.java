package com.chengfeng.ne.basedata.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.BasicDictVO;
import com.thinkjf.dao.DaoException;


/**
 * 
 * <p>功能描述：数据字典数据访问层接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2013-12-23 上午10:21:59
 */
public interface IDictDao {
	
	/**
	 * 新增
	 * @param dict
	 */
	public Long doCreateDict(BasicDictVO dict);
	
	/**
	 * 修改
	 * @param dict
	 */
	public void doModifyDict(BasicDictVO dict);
	
	/**
	 * 保存
	 * @param dict
	 */
	public void doSaveDict(BasicDictVO dict);
	
	/**
	 * 删除
	 * @param dict
	 */
	public void doDeleteDict(BasicDictVO dict);
	
	/**
	 * 按Id查询
	 * @return BasicDict
	 */
	public BasicDictVO queryDictById(Long dictId);

	
	/**
	 * 按类型查询
	 * @return List<BasicDict>
	 */
	public List<BasicDictVO> queryDictByType(String typeCode);
	
	/**
	 * 根据字典类型和时间获取问题类型
	 * @param searchMap
	 * @return List
	 * @throws DaoException
	 */
	public List<BasicDictVO> queryDictByTypeAndDate(Map<String, Object> searchMap) throws DaoException;
	
	/**
	 * 按编号和名称查询 
	 * @return BasicDict
	 */
	public BasicDictVO queryDictByIdAndName(BasicDictVO dict);
	
	/**
	 * 按编号模糊查询 
	 * @return List<BasicDict>
	 */
	public List<BasicDictVO> queryDictByCode(String typeCode);
	
	/**
	 * 按名称查询 
	 * @return List<BasicDict>
	 */
	public List<BasicDictVO> queryDictByName(String typeName);
	
	/**
	 * 按名称查询 
	 * @return List<BasicDict>
	 */
	public BasicDictVO queryDictByNameAndTypeCode(String typeName,String typeCode);

	/**
	 * 按字典类型和编号查询 
	 * @return BasicDict
	 */
	public BasicDictVO getDictByCode(BasicDictVO dict);
	
	/**
	 * 按字典类型和名称查询 
	 * @return BasicDict
	 */
	public BasicDictVO getDictByName(BasicDictVO dict);
	
	/**
	 * 获取数据字典自定义顺序最大值
	 * @return Long
	 */
	public Long getMaxDictOrder();
	
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<BasicDictVO> queryDicts() throws DaoException;
	
	/**
	 * 获取时间
	 * @return
	 */
	public Date getCurrentTime();

	/**
	 * 根据拼音 编号 名称 模糊查询
	 * @param pnc
	 * @return
	 * @throws DaoException
	 */
	List<BasicDictVO> queryDictByPNC(String pnc,String typeCode) throws DaoException;

	/**
	 * @desc:根据条件查询数据字典id集合
	 * @param map
	 * @return
	 */
	List<Long> queryDictIdsByLike(Map<String, Object> map) throws DaoException;
	
	/**
	 * 按类型查询
	 * @return List<BasicDict>
	 */
	@SuppressWarnings("rawtypes")
	public List<BasicDictVO> queryDictByMap(Map map);

}
