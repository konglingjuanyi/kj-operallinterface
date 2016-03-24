package com.chengfeng.common.util;


import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPoolUtils {

	/** 线程池 **/
	private static ThreadPoolExecutor executorService;
	
	private static AtomicInteger runnables = new AtomicInteger(0);
	
//	private static Logger LOGGER = LoggerFactory.getLogger(ThreadPoolUtils.class);

	private static final Log log = LogFactory.getLog(ThreadPoolUtils.class);
	
	private ThreadPoolUtils() {
		
	}

	public static ThreadPoolExecutor getExecutorService() {
		if (executorService == null) {
			// 线程池 初始化threadPoolSize个线程 和JDBC连接池是一个意思 实现重用
			// executor = new ThreadPoolExecutor(threadPoolSize,
			// Integer.MAX_VALUE, 30L, TimeUnit.SECONDS,
			// new LinkedBlockingQueue<Runnable>());
//			executorService = (ThreadPoolExecutor) Executors
//					.newCachedThreadPool();
//			executorService = (ThreadPoolExecutor) Executors
//					.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 3);//设置线程最大数量(CPU核数)
			executorService = (ThreadPoolExecutor) Executors
					.newFixedThreadPool(20);
		}
		// executor.setCorePoolSize(threadPoolSize);
		return executorService;
		// return new ThreadPoolExecutor(threadPoolSize, Integer.MAX_VALUE, 30L,
		// TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		// return (ThreadPoolExecutor) Executors.newCachedThreadPool();

	}

	/**
	 * 使用线程池中的线程来执行任务
	 */
	public static void executeInThreadPool(Runnable task) {
		int k = ThreadPoolUtils.runnables.incrementAndGet();
		log.info("executeInThreadPool current runnable count['" + k + "']");
		getExecutorService().execute(task);
	}

	public static void decrement(){
		int k = ThreadPoolUtils.runnables.decrementAndGet();
		log.info("decrement current runnable count['" + k + "']");
	}


	/**
	 * 关闭线程池
	 */
	public static void shutdownThreadPool() {
		if (executorService != null && !executorService.isShutdown()) {
			executorService.shutdown();
			if (executorService.isShutdown()) {
				executorService = null;
			}
		}
	}

	/**
	 * 关闭当前ExecutorService
	 * 
	 * @param timeout
	 *            以毫秒为单位的超时时间
	 */
	public void shutdownThreadPool(long timeout) {
		if (executorService != null && !executorService.isShutdown()) {
			try {
				executorService
						.awaitTermination(timeout, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			executorService.shutdown();
		}
	}


	static {
		// 程序退出时 ,关闭线程池
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					shutdownThreadPool();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
