package com.shinhan.crud.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    //string->util.date
	public static Date getUtilDate(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date result = null;
		try {
			result = sdf.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//string->sql.date
	public static java.sql.Date getSQLDate(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	 
		java.sql.Date result = null;
		try {
			Date d2 = sdf.parse(d);
			result = new java.sql.Date(d2.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//string->sql.Timestamp
	public static java.sql.Timestamp getSQLDateTime(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.sql.Timestamp result = null;
		try {
			Date date=sdf.parse(d);
			result = new java.sql.Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// time: timestamp->string 변환
	public static String timestampToString(Timestamp ts) {
		String timeStr = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(ts);
		return timeStr;
	}
	
}