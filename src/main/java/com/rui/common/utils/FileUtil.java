package com.rui.common.utils;


import java.io.File;

public class FileUtil {
	/*
	 * 方法1：给定一个文件名，返回该文件名的扩展名，例如"aa.jsp" 返回".jsp"
	 * */
	public static String getExtendName(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
}
