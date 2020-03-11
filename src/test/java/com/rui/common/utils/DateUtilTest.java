package com.rui.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void textSql() {
		//替换掉sql中1和2  分别用月首时间和月尾时间
		String sql = "select * from user where time > {1} and time < {2}";
		
		Date date1 = DateUtil.getDateByInitMonth(new Date());
		Date date2 = DateUtil.getDateByFullMonth(new Date());
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd dd:mm:ss");
		String d1 = format.format(date1);
		String d2 = format.format(date2);
		
		String replace = sql.replace("{1}", d1).replace("{2}", d2);
		
		System.out.println(replace);
	}
	
}





















