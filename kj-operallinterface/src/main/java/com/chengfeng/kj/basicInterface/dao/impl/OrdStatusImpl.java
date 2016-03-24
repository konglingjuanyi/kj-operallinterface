/**
 * 文件名: OrdStatuImpl.java
 * 版 权: Copyright © 2013 - 2016 ThinkJF, Inc. All Rights Reserved
 * 描 述: <描述>
 * 修改人: Bin.Zhang
 * 修改时间: 2016-3-18
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.chengfeng.kj.basicInterface.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.chengfeng.kj.basicInterface.dao.OrdStatusDao;
import com.chengfeng.kj.opt.orders.domain.OrdStatuVO;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.thinkjf.dao.DaoException;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author Bin.Zhang
 * @version 1.0 2016-3-18
 */
@Repository("ordStatusDao")
public class OrdStatusImpl implements OrdStatusDao
{
    @Resource
    private SqlMapClient sqlMapClient;

    private static final int PAGENUM = 500;

    /**
     * @param tableName
     * @param ordStatusVos
     */
    public boolean insertBatch(String tableName, List<OrdStatuVO> ordStatusVos) throws DaoException
    {
         boolean result = false;
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("tableName", tableName);
        
        int MaxSize = ordStatusVos.size();
        if (MaxSize <= 0)
        {
            return result;
        }

        try
        {
            int page =  (int) Math.ceil((MaxSize / (double)PAGENUM));
            long singleSum = 0;
            sqlMapClient.startTransaction();
            sqlMapClient.startBatch();

            for (int i = 0; i < page; i++)
            {
                for (int j = 0; j< (i < (page-1) ?  500 : MaxSize - i*PAGENUM); j++)
                {
                    paramMap.put("ordStatus", ordStatusVos.get(i * PAGENUM + j));
                    sqlMapClient.insert("KjOpt_OrdStatusVO.insertByTabName", paramMap);
                    singleSum = j;
                }
                sqlMapClient.executeBatch();
                System.out.println("插入数据库条数:" + (i*500 + singleSum + 1));
            }
            
            sqlMapClient.commitTransaction();
            
            result = true;
        }
        catch (SQLException e)
        {
            result = false;
            e.printStackTrace();
        }finally{
            sqlMapClient.flushDataCache();
            try
            {
                sqlMapClient.endTransaction();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        
        return result;
    }
}
