package com.chengfeng.common.util;

import com.thinkjf.core.config.GlobalConfig;

public class FileCfgUtils {
	
	/**开启内存队列最大数*/
	public static final int MAXQUEUECOUNT = Integer.parseInt(GlobalConfig.getPropertyValue("common.kj.ordorder.web.maxQueueCount"));
	
	/**内存队列最大消费数量*/
	public static final int MAXMESSAGEQUEUECOUNT = Integer.parseInt(GlobalConfig.getPropertyValue("common.kj.ordorder.web.maxMessageQueueCount"));
	
	/**每次分页数量*/
	public static final int CURRMESSAGECOUNT = Integer.parseInt(GlobalConfig.getPropertyValue("common.kj.ordorder.web.currMessageCount"));
}
