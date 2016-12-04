package com.utils;

import java.util.Calendar;

/**
 * 时间工具类
 * @author yunfeng.cheng
 * @version 2015/10/31
 */
public class TimeUtil {
	
	/**
	 * 获取完全格式的的日期格式
	 * @return 格式如 2015-10-31 10:33:25:012
	 */
	public static String getFullDateTime(){
		StringBuffer sb = new StringBuffer(30);
		Calendar nowtime = Calendar.getInstance();
		int _year = nowtime.get(Calendar.YEAR); //获取年数
		int _month = nowtime.get(Calendar.MONTH) + 1; //获取月数（Java中默认为0-11）
		int _day = nowtime.get(Calendar.DAY_OF_MONTH); //获取天数
		int _hour = nowtime.get(Calendar.HOUR_OF_DAY); //获取小时
		int _minute = nowtime.get(Calendar.MINUTE); //获取分钟
		int _second = nowtime.get(Calendar.SECOND); //获取秒数
		int _millisecond = nowtime.get(Calendar.MILLISECOND); //获取毫秒数

		sb.append(_year);
		sb.append("-");
		if(_month <10){
			sb.append("0");
		}
		sb.append(_month);
		sb.append("-");
		if(_day <10){
			sb.append("0");
		}
		sb.append(_day);
		sb.append(" ");
		if(_hour <10){
			sb.append("0");
		}
		sb.append(_hour);
		sb.append(":");
		if(_minute <10){
			sb.append("0");
		}
		sb.append(_minute);
		sb.append(":");
		if(_second <10){
			sb.append("0");
		}
		sb.append(_second);
		sb.append(":");
		if(_millisecond <10){
			sb.append("00");
		}else if(_millisecond <100){
			sb.append("0");
		}
		sb.append(_millisecond);
		
		return sb.toString();
	}
	
	/**
	 * 获取机器时间
	 * @param c 分隔符
	 * @return 年月日，格式如2015-10-31
	 */
	public static String getPCDate(char c) {
		StringBuffer sb = new StringBuffer(30);
		Calendar nowtime = Calendar.getInstance();
		int _year = nowtime.get(Calendar.YEAR); //获取年数
		int _month = nowtime.get(Calendar.MONTH) + 1; //获取月数（Java中默认为0-11）
		int _day = nowtime.get(Calendar.DAY_OF_MONTH); //获取天数

		sb.append(_year);
		sb.append(c);
		if(_month <10){
			sb.append("0");
		}
		sb.append(_month);
		sb.append(c);
		if(_day <10){
			sb.append("0");
		}
		sb.append(_day);

		return sb.toString();
	}
	
	/**
	 * 获取机器时间
	 * @return 年月日，格式如20151031
	 */
	public static String getPCDate() {
		StringBuffer sb = new StringBuffer(30);
		Calendar nowtime = Calendar.getInstance();
		int _year = nowtime.get(Calendar.YEAR); //获取年数
		int _month = nowtime.get(Calendar.MONTH) + 1; //获取月数（Java中默认为0-11）
		int _day = nowtime.get(Calendar.DAY_OF_MONTH); //获取天数

		sb.append(_year);
		if(_month <10){
			sb.append("0");
		}
		sb.append(_month);
		if(_day <10){
			sb.append("0");
		}
		sb.append(_day);

		return sb.toString();	
	}
	
	/**
	 * 获取当前时间
	 * @return 时分秒，格式如122415，12时24分15秒
	 */
	public static String getCurrTime() {
		StringBuffer sb = new StringBuffer(30);
		Calendar nowtime = Calendar.getInstance();
		int _hour = nowtime.get(Calendar.HOUR_OF_DAY); //获取小时
		int _minute = nowtime.get(Calendar.MINUTE); //获取分钟
		int _second = nowtime.get(Calendar.SECOND); //获取秒数
		if(_hour <10){
			sb.append("0");
		}
		sb.append(_hour);
		if(_minute <10){
			sb.append("0");
		}
		sb.append(_minute);
		if(_second <10){
			sb.append("0");
		}
		sb.append(_second);

		return sb.toString();		
	}

}
