package com.sh.manage.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;


/**
 * Title. <br>
 * 此类主要用来取得本地系统的系统时间并用下面5种格式显示 1. YYMMDDHH 8位 2. YYMMDDHHmm 10位 3. YYMMDDHHmmss
 * 12位 4. YYYYMMDDHHmmss 14位 5. YYMMDDHHmmssxxx 15位 (最后的xxx 是毫秒).
 * <p>
 * Copyright: Copyright (c) 
 * <p>
 * Company: 
 * <p>
 * Author: 
 * <p>
 * Version: 1.0
 * <p>
 */
public class TimeUtil {

	/** 8位时间 */
	public static final int YYMMDDhh = 8;

	/** 10位时间 */
	public static final int YYMMDDhhmm = 10;

	/** 12位时间 */
	public static final int YYMMDDhhmmss = 12;

	/** 15位时间 */
	public static final int YYMMDDhhmmssxxx = 15;

	/** 14位时间 */
	public static final int YYYYMMDDhhmmss = 14;

	/**
	 * 去除月份及日子之前的0
	 * 
	 * @param data
	 *            传进来的字符串
	 * @return
	 */
	private static String formatString(String data) {
		if (!StringUtil.isEmpty(data) && data.startsWith("0")) {
			data = data.substring(1);
		}
		return data;
	}

	/**
	 * 格式化时间
	 * 
	 * @param time
	 *            时间 可为6位、8位、12位、15位
	 * @return 格式化后的时间 #6位 YY年MM月DD日 #8位 YYYY年MM月DD日 #12位 YY年MM月DD日 HH:II:SS
	 *         #15位 YY年MM月DD日
	 */
	public static String formattime(String time) {
		int length = 0;
		if (time == null || time.length() < 6) {
			return "";
		}
		length = time.length();
		String renstr = "";
		switch (length) {
			case 6:
				renstr = time.substring(0, 2) + "-" + time.substring(2, 4) + "-" + time.substring(4) + "";
				break;
			case 8:
				renstr = time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8) + "";
				break;
			case 12:
				renstr = time.substring(0, 2) + "-" + time.substring(2, 4) + "-" + time.substring(4, 6) + " " + time.substring(6, 8) + ":"
				        + time.substring(8, 10) + ":" + time.substring(10, 12) + "";
				break;
			case 14:
				renstr = time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8) + " " + time.substring(8, 10) + ":"
				        + time.substring(10, 12) + ":" + time.substring(12, 14) + "";
				break;
			case 15:
				renstr = time.substring(0, 2) + "-" + time.substring(2, 4) + "-" + time.substring(4, 6) + " " + time.substring(6, 8) + ":"
				        + time.substring(8, 10) + ":" + time.substring(10, 12) + ":" + time.substring(12);
				break;
			default:
				renstr = time.substring(0, 2) + "-" + time.substring(2, 4) + "-" + time.substring(4) + "";
				break;
		}
		return renstr;
	}

	/**
	 * 格式化用户的时间
	 * 
	 * @param time
	 *            输入的时间
	 * @return mm月dd日 hh:mm
	 */
	public static String formatTimeMore(String time) {
		// 格式化时间后返回的值
		String returnStr = "";
		if (!StringUtil.isEmpty(time) && time.length() >= 14) {
			returnStr = formatString(time.substring(4, 6)) + "月" + formatString(time.substring(6, 8)) + "日" + " " + time.substring(8, 10) + ":"
			        + time.substring(10, 12);
		}
		return returnStr;

	}

	/**
	 * 格式化用户的时间
	 * 
	 * @param time   20130114221828
	 *            输入的时间
	 * @return yyyy年mm月dd日 hh:mm:ss
	 */
	public static String formatTimeMore2(String time) {
		// 格式化时间后返回的值
		String returnStr = "";
		if (!StringUtil.isEmpty(time) && time.length() >= 14) {
			returnStr = formatString(time.substring(0, 4)) +"年"+formatString(time.substring(4, 6)) + "月" + formatString(time.substring(6, 8)) + "日" + " " + time.substring(8, 10) + ":"
			        + time.substring(10, 12)+ ":" + time.substring(12, 14);
		}else if(!StringUtil.isEmpty(time) && time.length() < 14){
			returnStr = formatString(time.substring(0, 4)) +"年"+formatString(time.substring(4, 6)) + "月" + formatString(time.substring(6, 8)) + "日";
		}
		return returnStr;

	}
//	public static void main(String[] args) {
//		String ss = "20130114221828";
//		String sTime = CTime.formatTimeMore2(ss);
//		
//		System.out.println(sTime);
//	}
	
	/**
	 * 补0函数
	 * 
	 * @param iT
	 *            int
	 * @return 补0后的值
	 */
	public static String get00String(int iT) {
		if (iT >= 10) {
			return String.valueOf(iT);
		} else {
			return "0" + String.valueOf(iT);
		}

	}

	/**
	 * 当前天数
	 * 
	 * @return 当前天数
	 */
	public static String getDay() {
		Calendar time = Calendar.getInstance();
		int day = time.get(Calendar.DAY_OF_MONTH);
		String djday = "";
		if (day < 10) {
			djday = "0" + Integer.toString(day);
		} else {
			djday = Integer.toString(day);
		}
		return djday;
	}

	/**
	 * 格式化时间
	 * 
	 * @param time
	 *            时间
	 * @param format
	 *            格式
	 * @return 格式化后的时间
	 */
	private static String getFormatTime(int time, int format) {
		StringBuffer numm = new StringBuffer(format);
		int length = String.valueOf(time).length();

		if (format < length)
			return null;

		for (int i = 0; i < format - length; i++) {
			numm.append("0");
		}
		numm.append(time);
		return numm.toString().trim();
	}

	/**
	 * 当前小时
	 * 
	 * @return 当前小时
	 */
	public static String getHour() {
		Calendar time = Calendar.getInstance();
		int hour = time.get(Calendar.HOUR_OF_DAY);
		String djhour = "";
		if (hour < 10) {
			djhour = "0" + Integer.toString(hour);
		} else {
			djhour = Integer.toString(hour);
		}
		return djhour;
	}

	/**
	 * 当前分钟
	 * 
	 * @return 当前分钟
	 */
	public static String getMin() {
		Calendar time = Calendar.getInstance();
		int min = time.get(Calendar.MINUTE);
		String djmin = "";
		if (min < 10) {
			djmin = "0" + Integer.toString(min);
		} else {
			djmin = Integer.toString(min);
		}
		return djmin;
	}

	/**
	 * 当前月份
	 * 
	 * @return 当前月份（2位)
	 */
	public static String getMonth() {
		Calendar time = Calendar.getInstance();
		int month = time.get(Calendar.MONTH) + 1;
		String djmonth = "";
		if (month < 10) {
			djmonth = "0" + Integer.toString(month);
		} else {
			djmonth = Integer.toString(month);
		}
		return djmonth;
	}

	/**
	 * 根据系统时间得到n天以后的日期
	 * 
	 * @param int
	 *            n 天数
	 * @return 得到的时间 YYYYMMDD
	 */
	public static String getNDayLater(int n) {
		String time = null;
		String dayStr = null;
		String monthStr = null;
		String yearStr = null;
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.add(java.util.Calendar.DAY_OF_MONTH, n);
		int day = cal.get(java.util.Calendar.DATE);
		int month = cal.get(java.util.Calendar.MONTH) + 1;
		int year = cal.get(java.util.Calendar.YEAR);
		if (day < 10)
			dayStr = "0" + Integer.toString(day);
		else
			dayStr = Integer.toString(day);
		if (month < 10)
			monthStr = "0" + Integer.toString(month);
		else
			monthStr = Integer.toString(month);
		yearStr = Integer.toString(year);
		time = yearStr.substring(2) + monthStr + dayStr;
		dayStr = null;
		monthStr = null;
		yearStr = null;
		return time;
	}

	/**
	 * 根据系统时间得到n天以后的日期
	 * 
	 * @param int
	 *            n 天数
	 * @return 得到的时间 YYYYMMDD
	 */
	public static String getNDayLaterNew(int n) {
		String time = null;
		String dayStr = null;
		String monthStr = null;
		String yearStr = null;
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.add(java.util.Calendar.DAY_OF_MONTH, n);
		int day = cal.get(java.util.Calendar.DATE);
		int month = cal.get(java.util.Calendar.MONTH) + 1;
		int year = cal.get(java.util.Calendar.YEAR);
		if (day < 10)
			dayStr = "0" + Integer.toString(day);
		else
			dayStr = Integer.toString(day);
		if (month < 10)
			monthStr = "0" + Integer.toString(month);
		else
			monthStr = Integer.toString(month);
		yearStr = Integer.toString(year);
		time = yearStr + monthStr + dayStr;
		dayStr = null;
		monthStr = null;
		yearStr = null;
		return time;
	}

	/**
	 * 当前时间
	 * 
	 * @return 当前时间
	 */
	public static String getNowInMillisString() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return new Long(cal.getTimeInMillis()).toString();
	}

	/**
	 * 取得本地系统的时间，时间格式由参数决定
	 * 
	 * @param format
	 *            时间格式由常量决定
	 * @return 具有format格式的字符串
	 */
	public static String getTime(int format) {
		StringBuffer cTime = new StringBuffer(15);
		Calendar time = Calendar.getInstance();
		int miltime = time.get(Calendar.MILLISECOND);
		int second = time.get(Calendar.SECOND);
		int minute = time.get(Calendar.MINUTE);
		int hour = time.get(Calendar.HOUR_OF_DAY);
		int day = time.get(Calendar.DAY_OF_MONTH);
		int month = time.get(Calendar.MONTH) + 1;
		int year = time.get(Calendar.YEAR);
		time = null;
		if (format != 14) {
			if (year >= 2000)
				year = year - 2000;
			else
				year = year - 1900;
		}
		if (format >= 2) {
			if (format == 14)
				cTime.append(year);
			else
				cTime.append(getFormatTime(year, 2));
		}
		if (format >= 4)
			cTime.append(getFormatTime(month, 2));
		if (format >= 6)
			cTime.append(getFormatTime(day, 2));
		if (format >= 8)
			cTime.append(getFormatTime(hour, 2));
		if (format >= 10)
			cTime.append(getFormatTime(minute, 2));
		if (format >= 12)
			cTime.append(getFormatTime(second, 2));
		if (format >= 15)
			cTime.append(getFormatTime(miltime, 3));
		return cTime.toString().trim();
	}

	/**
	 * 返回两个14位长度格式的时间（YYYY MMDD HHMM SS）的距离
	 * 
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @param type
	 *            0返回毫秒；1返回秒；2返回分钟；3返回小时；4返回天
	 * @return 时间之间的距离，如果end 时间在start之前，则返回 带减号的“负值”
	 */
	public static String getTimeDistance(String start, String end, int type) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String distance = "";
		try {
			Date Start = myFormatter.parse(start);
			Date End = myFormatter.parse(end);
			long day = (End.getTime() - Start.getTime());
			switch (type) {
				case 0:
					distance = Long.toString(day);
					break;
				case 1:
					distance = Long.toString(day / 1000);
					break;
				case 2:
					distance = Long.toString(day / (1000 * 60));
					break;
				case 3:
					distance = Long.toString(day / (1000 * 60 * 60));
					break;
				case 4:
					distance = Long.toString(day / (1000 * 60 * 60 * 24));
					break;
				default:
					distance = Long.toString(day);
					break;
			}
		}
		catch (ParseException e) {
		}
		return distance;
	}

	/**
	 * 返回给定时间内按周（周一至周日为一个单位）划分得到的时间数组
	 * 
	 * @param stime
	 *            String YYYYMMDD
	 * @param etime
	 *            String YYYYMMDD
	 * @return Vector 给定时间内按周
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector getWeekArray(String stime, String etime) {
		if (stime == null || stime.equals("") || etime == null || etime.equals("") || stime.length() < 8 || etime.length() < 8
		        || stime.compareTo(etime) > 0) {
			return null;
		}

		Vector v = new Vector();
		String[] s = null;
		if (stime.equals(etime)) {
			s = new String[2];
			s[0] = stime;
			s[1] = etime;
			v.add(s);
		} else {
			int year = 0;
			int month = 0;
			int date = 0;

			year = Integer.parseInt(stime.substring(0, 4));
			month = Integer.parseInt(stime.substring(4, 6));
			date = Integer.parseInt(stime.substring(6, 8));

			Calendar c = Calendar.getInstance();
			c.set(year, month - 1, date);

			int week = c.get(Calendar.DAY_OF_WEEK);
			int temp = 0;
			@SuppressWarnings("unused")
			int i = 0;
			if (week != 2) {
				i++;
				s = new String[2];
				if (week == 1) {
					temp = 0;
				} else {
					temp = 8 - week;
				}
				s = new String[2];
				year = c.get(Calendar.YEAR);
				month = c.get(Calendar.MONTH) + 1;
				date = c.get(Calendar.DATE);
				s[0] = year + TimeUtil.get00String(month) + TimeUtil.get00String(date);

				c.add(Calendar.DAY_OF_MONTH, temp);

				year = c.get(Calendar.YEAR);
				month = c.get(Calendar.MONTH) + 1;
				date = c.get(Calendar.DATE);
				s[1] = year + TimeUtil.get00String(month) + TimeUtil.get00String(date);

				v.add(s);
				c.add(Calendar.DAY_OF_MONTH, 1);
				stime = year + TimeUtil.get00String(month) + TimeUtil.get00String(date);
			}

			while (!stime.equals(etime)) {
				i++;
				s = new String[2];
				year = c.get(Calendar.YEAR);
				month = c.get(Calendar.MONTH) + 1;
				date = c.get(Calendar.DATE);
				s[0] = year + TimeUtil.get00String(month) + TimeUtil.get00String(date);

				c.add(Calendar.DAY_OF_MONTH, 6);
				year = c.get(Calendar.YEAR);
				month = c.get(Calendar.MONTH) + 1;
				date = c.get(Calendar.DATE);
				s[1] = year + TimeUtil.get00String(month) + TimeUtil.get00String(date);

				stime = year + TimeUtil.get00String(month) + TimeUtil.get00String(date);
				if (stime.compareTo(etime) > 0) {
					s[1] = etime;
					v.add(s);
					break;
				}

				v.add(s);

				c.add(Calendar.DAY_OF_MONTH, 1);
				stime = year + TimeUtil.get00String(month) + TimeUtil.get00String(date);
			}
		}
		return v;
	}

	/**
	 * 当前年份
	 * 
	 * @param len
	 *            返回位数，2位 4位
	 * @return 返回当前年份
	 */
	public static String getYear(int len) {
		Calendar time = Calendar.getInstance();
		int year = time.get(Calendar.YEAR);
		String djyear = Integer.toString(year);
		if (len == 2) {
			djyear = djyear.substring(2);
		}
		return djyear;
	}

	/**
	 * 产生任意位的字符串
	 * 
	 * @param time
	 *            int 要转换格式的时间
	 * @param format
	 *            int 转换的格式
	 * @return 转换的时间
	 */

	public synchronized static String getYearAdd(int format, int iyear) {
		StringBuffer cTime = new StringBuffer(10);
		Calendar time = Calendar.getInstance();
		time.add(Calendar.YEAR, iyear);
		int miltime = time.get(Calendar.MILLISECOND);
		int second = time.get(Calendar.SECOND);
		int minute = time.get(Calendar.MINUTE);
		int hour = time.get(Calendar.HOUR_OF_DAY);
		int day = time.get(Calendar.DAY_OF_MONTH);
		int month = time.get(Calendar.MONTH) + 1;
		int year = time.get(Calendar.YEAR);
		if (format != 14) {
			if (year >= 2000)
				year = year - 2000;
			else
				year = year - 1900;
		}
		if (format >= 2) {
			if (format == 14)
				cTime.append(year);
			else
				cTime.append(getFormatTime(year, 2));
		}
		if (format >= 4)
			cTime.append(getFormatTime(month, 2));
		if (format >= 6)
			cTime.append(getFormatTime(day, 2));
		if (format >= 8)
			cTime.append(getFormatTime(hour, 2));
		if (format >= 10)
			cTime.append(getFormatTime(minute, 2));
		if (format >= 12)
			cTime.append(getFormatTime(second, 2));
		if (format >= 15)
			cTime.append(getFormatTime(miltime, 3));
		return cTime.toString();
	}

	/**
	 * 将14位日期格式转换成yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param srcDate
	 *            String
	 * @return 格式化后的日期
	 */
	public static String transDate(String srcDate) {
		if (srcDate != null) {
			if (srcDate.trim().length() == 14)
				return transDateTime(srcDate.trim(), "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
			if (srcDate.trim().length() <= 8)
				return transDateTime(srcDate.trim(), "yyyyMMdd", "yyyy-MM-dd");
			return "";
		} else
			return "";
	}

	/**
	 * 将日期时间从一种格式转换为另一种格式
	 * 
	 * @param srcTime
	 *            源串
	 * @param srcPattern
	 *            源串格式
	 * @param destPattern
	 *            目标串格式
	 * @return String 目标串
	 */
	public static String transDateTime(String srcTime, String srcPattern, String destPattern) {
		if (srcTime == null)
			return "";
		try {
			SimpleDateFormat fmt = new SimpleDateFormat();
			fmt.applyPattern(srcPattern);
			Date date = fmt.parse(srcTime);
			fmt.applyPattern(destPattern);
			return fmt.format(date);
		}
		catch (Exception exp) {
		}
		return srcTime;
	}
	/**
	 * 生成格式时间
	 * 输入:"yyyyMMdd"
	 * return :20140721
	 */
	public static String getDate(String pattern){
		SimpleDateFormat myFormatter = new SimpleDateFormat(pattern);
		Date date = new Date();
		return myFormatter.format(date);
	}
	public static String now()
	  {
	    return now("yyyyMMddHHmmss");
	  }

	  public static String nowDate()
	  {
	    return now("yyyyMMdd");
	  }

	  public static String now(String fmt)
	  {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(fmt);
	    return sdf.format(cal.getTime());
	  }

	  public static int getWeek()
	  {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    return cal.get(7);
	  }
	
	public static void main(String[] args) {
		System.out.println(getDate("yyyyMMdd"));
		System.out.println(getTime(14));
	}
}
