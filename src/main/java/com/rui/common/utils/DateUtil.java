package com.rui.common.utils;


import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/*
	* 方法1：(10分)
	* 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	*/

	public static Date getDateByInitMonth(Date date){
		//获取当前的系统时间的日历类
		Calendar c = Calendar.getInstance();
		
		//用传入的日期构建日历类
		c.setTime(date);
		
		//月的第一天  天的第0个小时  每时第0分钟 每分钟第0秒
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		return c.getTime();
	}
	
	/*
	* 方法2：(10分)
	* 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	*/

	public static Date getDateByFullMonth(Date src){
		//获取日历类
		Calendar c = Calendar.getInstance();
		
		//传入的日期作为日期类
		c.setTime(src);
		
		//月份要+1
		c.add(Calendar.MONTH, 1);
		//传入的日期如2010/02/02 12:23:25 变成 2010/03/02 00:00:00
		Date date = getDateByInitMonth(c.getTime());
		
		//重新覆盖  并-1秒
		c.setTime(date);
		c.add(Calendar.SECOND, -1);//日期减去一秒
		
		return c.getTime();
	}
}
