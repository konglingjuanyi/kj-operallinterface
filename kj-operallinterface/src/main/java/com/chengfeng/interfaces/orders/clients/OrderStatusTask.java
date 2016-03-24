/**
 * 文件名: OrderStatus.java
 * 版 权: Copyright © 2013 - 2016 ThinkJF, Inc. All Rights Reserved
 * 描 述: <描述>
 * 修改人: Bin.Zhang
 * 修改时间: 2016-3-19
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.chengfeng.interfaces.orders.clients;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

import com.thinkjf.core.config.GlobalConfig;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author Bin.Zhang
 * @version 1.0 2016-3-19
 */
public class OrderStatusTask
{
    private static final String oracleDriverUrl = GlobalConfig.getPropertyValue("common.kj.ordstatus.db.oracleDriverUrl");
    private static final String oracleUrl = GlobalConfig.getPropertyValue("common.kj.ordstatus.db.oracleUrl");

    private static final String kjName = GlobalConfig.getPropertyValue("common.kj.ordstatus.db.name");
    private static final String kjPassword = GlobalConfig.getPropertyValue("common.kj.ordstatus.db.password");
    
    public void mergeIntoTask() throws ClassNotFoundException, SQLException
    {
        Class.forName(oracleDriverUrl);
        Connection cn = DriverManager.getConnection(oracleUrl, kjName, kjPassword);
        CallableStatement c = null;

        int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hours >= 12 && hours < 20)
        {
            // 调用第一张表的mergerinto的存取过程
            c = cn.prepareCall("{call P_BI_REPORT_ORD_STAT01_MERGE()}");

        }

        if (hours >= 20 && hours < 24 || hours >= 0 && hours < 4)
        {
            // 调用第二张表的mergerinto的存取过程
            c = cn.prepareCall("{call P_BI_REPORT_ORD_STAT02_MERGE}");

        }

        if (hours >= 4 && hours < 12)
        {
            // 调用第三张表的mergerinto的存取过程
            c = cn.prepareCall("{call P_BI_REPORT_ORD_STAT03_MERGE()}");

        }

        boolean execute = c.execute();
        cn.close();
    }
}
