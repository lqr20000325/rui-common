package com.rui.common.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {
	/*
	 * 方法1：批量关闭流，参数能无限个
	 */
	public static void closeAll(AutoCloseable ...autoCloseables) {
		if(null != autoCloseables && autoCloseables.length>0) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
	//方法2：传入一个传入对象，默认为UTF-8格式，返回该文件内容，要求方法内部调用第一个方法关闭流
	public static String readTextFile(InputStream inputStream) {
		int i = 0;
		byte[] arr = new byte[1024];

		String str = "";
		try {
			while ((i=inputStream.read(arr))!=-1) {
				str = str + new String(arr, 0, i, "UTF-8");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(inputStream);
		}
		
		return str;
	}
	
	//方法3：传入文本文件对象，返回该文件内容，并且要求内部调用第2个方法
	public static String readTxtFile(File file) throws FileNotFoundException {
		return readTextFile(new FileInputStream(file));
	}
	
	public static List<String> readTextLineFile(File file) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String str = null;
			while((str=br.readLine())!=null) {
				list.add(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
