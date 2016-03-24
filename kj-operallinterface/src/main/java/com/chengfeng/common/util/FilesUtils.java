package com.chengfeng.common.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.thinkjf.core.config.GlobalConfig;

public class FilesUtils {
	
	public static String writeFile(String content) throws IOException {
		//已时间为文件名
		String tempfileName = DateFormatUtils
		.format(System.currentTimeMillis(), "yyyyMMddHHmmss");
		// 当前处理文件名
		StringBuilder tempFileName = new StringBuilder(tempfileName).append(".").append("txt");

		File tempDir = FileUtils.getFile(GlobalConfig.getPropertyValue("common.kj.ordorder.web.filePath"));//目录路径

		// 当前工作目录(每天生成一个文件夹)
		File workDir = FileUtils.getFile(tempDir, DateFormatUtils
				.format(System.currentTimeMillis(), "yyyyMMdd"));

		// 每小时一个目录
		File hDir = FileUtils.getFile(workDir,
				DateFormatUtils.format(System.currentTimeMillis(), "HH"));
		
		File destFile = FileUtils.getFile(hDir, tempFileName.toString());
		int pointIndex = StringUtils.lastIndexOf(destFile.getName(), ".");
		String fileName = StringUtils.substring(destFile.getName(), 0,
				pointIndex);

		// 若存在同名文件,则重命名文件
		while (destFile.exists()) {
			destFile = FileUtils
					.getFile(
							destFile.getParentFile(),
							new StringBuilder(fileName = new StringBuilder(
									fileName).append("_1").toString())
									.append(".")
									.append("txt")
									.toString());

		}

		FileUtils.writeStringToFile(destFile, content, "UTF-8", false);
		return destFile.getName();
	}
}
