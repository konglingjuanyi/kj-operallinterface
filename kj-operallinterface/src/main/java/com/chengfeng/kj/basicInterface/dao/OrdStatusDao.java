/**
 * 文件名: OrdStatu.java
 * 版    权: Copyright © 2013 - 2016 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 修改人: Bin.Zhang
 * 修改时间: 2016-3-18
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.chengfeng.kj.basicInterface.dao;

import java.util.List;

import com.chengfeng.kj.opt.orders.domain.OrdStatuVO;
import com.thinkjf.dao.DaoException;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author Bin.Zhang
 * @version 1.0 2016-3-18
 */
public interface OrdStatusDao
{
    /**
     * 动态插入数据（不同的表名）
     * @param tableName
     * @param ordStatusVos
     * @return
     * @throws DaoException
     */
    public boolean insertBatch(String tableName, List<OrdStatuVO> ordStatusVos) throws DaoException;
    
}
