/**
 * 文件名: IpValid.java
 * 版    权: Copyright © 2013 - 2016 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 修改人: Bin.Zhang
 * 修改时间: 2016-3-18
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.chengfeng.kj.basicInterface.http;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author Bin.Zhang
 * @version 1.0 2016-3-18
 */
public class VisitWhiteList
{
    private static final List<String> IPLIST = new ArrayList<String>();
    
    public VisitWhiteList(){
        IPLIST.add("192.168.0.85");
        IPLIST.add("192.168.0.155");
        IPLIST.add("127.0.0.1");
        IPLIST.add("192.168.0.115");
    }

    /**
     * @return the iplist
     */
    public static List<String> getIplist()
    {
        return IPLIST;
    }
    
}
