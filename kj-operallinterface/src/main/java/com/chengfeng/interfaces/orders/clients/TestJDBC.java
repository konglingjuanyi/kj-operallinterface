/**
 * 文件名: testJDBC.java
 * 版    权: Copyright © 2013 - 2016 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 修改人: Bin.Zhang
 * 修改时间: 2016-3-19
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.chengfeng.interfaces.orders.clients;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author Bin.Zhang
 * @version 1.0 2016-3-19
 */
public class TestJDBC
{

    private static final String oracleDriverUrl = "oracle.jdbc.driver.OracleDriver";
    private static final String oracleUrl = "jdbc:oracle:thin:@192.168.0.180:csdb";

    private static final String mysqlDriverUrl = "com.mysql.jdbc.Driver";
    private static final String mysqlUrl = "jdbc:mysql://192.168.0.85:3306/BISTORE?user=root&password=mysql";
    /**
     * @param args
     * @throws ClassNotFoundException 
     * @throws SQLException 
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Class.forName(mysqlDriverUrl);
        Connection cn = DriverManager.getConnection(mysqlUrl);
        //CallableStatement c = cn.prepareCall("{call }");
        //c.execute();
        Statement statement = cn.createStatement();
        ResultSet rs = statement.executeQuery("select * from TETS_DATA");
        System.out.println(rs);
        rs.close();
        statement.close();
        cn.close();

    }

}
