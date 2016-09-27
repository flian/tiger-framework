package com.pharmacodia.dg.utils.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 * 工具类：提供了操作各种时间格式的工具方法
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class DateUtil {

    private static final String STANDARD_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

    private static final String COMMON_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm";

    private static final String PURE_LONG_DATE_TIME_FORMAT_STR = "yyyyMMddHHmmssSSS";

    private static final String STANDARD_LONG_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss.SSS";

    private static final String STANDARD_DATE_FORMAT_STR = "yyyy-MM-dd";

    private static final String PURE_LONG_DATE_FORMAT_STR = "yyyyMMdd";
    
    private static final String PURE_DATE_TIME_FORMAT_STR = "yyyyMMddHHmmss";

    private static final String CHINESE_COMMON_DATE_TIME_FORMAT_STR = "yyyy年MM月dd日HH:mm";

    private static final String CHINESE_COMMON_DATE_TIME_NO_YEAR_FORMAT_STR = "MM月dd日HH:mm";

    /**
     * Define common date formatss
     */
    private static final String[] GENERIC_DATE_PATTERNS = { STANDARD_DATE_TIME_FORMAT_STR, STANDARD_DATE_FORMAT_STR,
            PURE_LONG_DATE_FORMAT_STR, STANDARD_LONG_DATE_TIME_FORMAT_STR, COMMON_DATE_TIME_FORMAT_STR,
            PURE_LONG_DATE_TIME_FORMAT_STR, CHINESE_COMMON_DATE_TIME_FORMAT_STR,
            CHINESE_COMMON_DATE_TIME_NO_YEAR_FORMAT_STR };

    private DateUtil() {
    }

    /**
     * Parse data from a datestring 
     * @param str given datestring
     * @return date object
     */
    public static Date parseDate(String str) {
        if (str == null || str.equals("")) {
            return null;
        }

        if (str.lastIndexOf(".") != -1) {
            if (str.length() - str.lastIndexOf(".") >= 3) {
                int dotIndex = str.lastIndexOf(".");
                str = str.substring(0, dotIndex) + str.substring(dotIndex, dotIndex + 4);
            }
        }

        try {
            return DateUtils.parseDate(str, GENERIC_DATE_PATTERNS);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * Given a datestring , and the number of days to add ,return a constructed Date object
     * @param   date the date string 
     * @param   days num of days to add
     * @return  Date Object
     */
    public static Date addDays(String date, int days) throws ParseException {
        if (date == null || ("".equals(date.trim())))
            return null;
        return DateUtils.addDays(parseDate(date), days);
    }
    
    /**
     * Given a datestring ,and the number of hours to add ,return  a constructed Date object
     * @param date the date string
     * @param hour num of hours to add
     * @return Date object
     */
    public static Date addHours(String date, int hourNum){
    	Date d = null;
        if (StringUtils.isNotBlank(date)){
        	try {
				d = DateUtils.addHours(parseDate(date), hourNum);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return d;
    }
    
    /**
     * Given a date object ,and the number of hours to add ,return  a constructed Date object
     * 
     * @param date  the date object
     * @param hourNum the number of hours to add
     * @return the new Date object
     */
    public static Date addHours(Date date, int hourNum){
        if (null == date){
        	return null;
        }
        return DateUtils.addHours(date, hourNum);
    }

    /**
     * Format the given date object to "yyyy-MM-dd HH:mm:ss" string pattern
     * @param date given date object
     * @return "yyyy-MM-dd HH:mm:ss" string pattern 
     */
    public static String formatStandardDatetime(Date date) {
        if (date == null)
            return null;
        return DateFormatUtils.format(date, STANDARD_DATE_TIME_FORMAT_STR);
    }
    
    
    /**
     * Format the given date object to "yyyyMMddHHmmss" string pattern
     * @param date given date object
     * @return "yyyyMMddHHmmss" string pattern
     */
    public static String formatPureDatetime(Date date){
    	if(date == null)
    		return null;
    	return DateFormatUtils.format(date, PURE_DATE_TIME_FORMAT_STR);
    }

    
    /**
     * Format the given date object to "yyyy-MM-dd HH:mm" string pattern
     * @param date given date object
     * @return"yyyy-MM-dd HH:mm" string pattern
     */
    public static String formatCommonDatetime(Date date) {
        if (date == null)
            return null;
        return DateFormatUtils.format(date, COMMON_DATE_TIME_FORMAT_STR);
    }
    

    /**
     * Format the given date object to "yyyyMMddHHmmssSSS" string pattern
     * @param date given date object
     * @return "yyyyMMddHHmmssSSS" string pattern
     */
    public static String formatPureLongDatetime(Date date) {
        if (date == null)
            return null;
        return DateFormatUtils.format(date, PURE_LONG_DATE_TIME_FORMAT_STR);
    }

    /**
     * Format the given date object to "yyyy-MM-dd" string pattern
     * @param date given date object
     * @return"yyyy-MM-dd" string pattern
     */
    public static String formatStandardDate(Date date) {
        if (date == null)
            return null;
        return DateFormatUtils.format(date, STANDARD_DATE_FORMAT_STR);
    }
    
    /**
     * Format the given date object to "yyyyMMdd" string pattern
     * @param date  given date object
     * @return "yyyyMMdd" string pattern
     */
    public static String formatPureLongDate(Date date) {
        if (date == null)
            return null;
        return DateFormatUtils.format(date, PURE_LONG_DATE_FORMAT_STR);
    }
    
    

    /**
     * Format the given date object to "yyyy年MM月dd日HH:mm" string pattern
     * @param date given date object
     * @return "yyyy年MM月dd日HH:mm" string pattern
     */
    public static String formatChineseCommonDatetime(Date date) {
        if (date == null)
            return null;
        return DateFormatUtils.format(date, CHINESE_COMMON_DATE_TIME_FORMAT_STR);
    }

    /**
     * Format the given date object to "MM月dd日HH:mm" string pattern
     * @param date given date object
     * @return "MM月dd日HH:mm" string pattern
     */
    public static String formatChineseCommonNoYearDatetime(Date date) {
        if (date == null)
            return null;
        return DateFormatUtils.format(date, CHINESE_COMMON_DATE_TIME_NO_YEAR_FORMAT_STR);
    }
    
    

    /**
     * Compare the date gap between two given dates
     * @param date1 the first date
     * @param date2 the second date
     * @return the date gap between date1 and date2 in milliseconds
     */
    public static Long compare(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return null;
        } else {
            return date1.getTime() - date2.getTime();
        }
    }
    
    /** 
     * Given a date ,calculate the date that is several hours after that ,then format the date in given date pattern
     * @param date given date
     * @param hourNum number of hours that after given date
     * @param format the date pattern
     * @return  the date string in given format
     */  
    public static String getSpecifiedHourAfter (Date date,int hourNum,String format) {
    	String result = null;
    	if(null!=date){
			Calendar c = Calendar.getInstance();
    		c.setTime(date);
    		int hour = c.get(Calendar.HOUR);
    		c.set(Calendar.HOUR, hour + hourNum);
    		return DateFormatUtils.format(c, StringUtils.isNotBlank(format) ? format.trim() : STANDARD_DATE_TIME_FORMAT_STR);
    	}
    	return result;
    }  
  
    /** 
     * Given a date ,calculate the date that is several days after that ,then format the date in given date pattern
     * @param date given date
     * @param dayNum number of days that after given date
     * @param format the date pattern
     * @return  the date string in given format
     */ 
    public static String getSpecifiedDayAfter (Date date,int dayNum, String format) {  
    	String result = null;
    	if(null!=date){
			Calendar c = Calendar.getInstance();  
    		c.setTime(date);  
    		int day = c.get(Calendar.DATE);
    		c.set(Calendar.DATE, day + dayNum);
    		return DateFormatUtils.format(c, StringUtils.isNotBlank(format) ? format.trim() : STANDARD_DATE_TIME_FORMAT_STR);
    	}
    	return result;
    }


   
}
