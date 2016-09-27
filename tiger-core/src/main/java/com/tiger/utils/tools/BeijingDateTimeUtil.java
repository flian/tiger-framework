
package com.tiger.utils.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 工具类，获取标准的北京时间
 * <p/>
 * <p><b>User:</b> charles.wang <a href="mailto:charles.wang0@pactera.com">charles.wang0@pactera.com</a></p>
 * <p><b>Date:</b> 2015-01-06 </p>
 *
 * @author charles.wang
 */
public class BeijingDateTimeUtil {
	
	private BeijingDateTimeUtil(){}
	
	
	public static final String BEIJING_TIME_SERVICE_URL="http://www.beijing-time.org/time.asp";
	public static final String BEIJING_TIME_ZONE = "GMT+8";
	
	
	/**
	 * retrieve the standard beijing time by beijing time service
	 * @return Calendar which stands for current beijing time
	 */
	public static Calendar retrieveBeijingStandardDatetime() {
		
		try{
			
			
		//access the webpage which can provide precise beijing-time	
		URL url = new URL(BEIJING_TIME_SERVICE_URL);
		HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		uc.connect();
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		
		String line;
		while ((line = br.readLine()) != null) {
            sb.append(line);
        }
		
		String beijingTimeInfoString = sb.toString();
		String[] infos = beijingTimeInfoString.split(";");
		
		//split information which can stand for year/month/day/dayOfWeek/hour/minute/second
		int year         = Integer.parseInt(infos[1].substring(infos[1].indexOf("=")+1));
		int month        = Integer.parseInt(infos[2].substring(infos[2].indexOf("=")+1));
		int day          = Integer.parseInt(infos[3].substring(infos[3].indexOf("=")+1));
		int dayOfWeek    = Integer.parseInt(infos[4].substring(infos[4].indexOf("=")+1));
		int hour         = Integer.parseInt(infos[5].substring(infos[5].indexOf("=")+1));
		int minute       = Integer.parseInt(infos[6].substring(infos[6].indexOf("=")+1));
		int second       = Integer.parseInt(infos[7].substring(infos[7].indexOf("=")+1));
		
		//create a calendar object 
		//make sure that (1)using Beijing timezone
		//               (2)month starts from 0 instead of 1
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(BEIJING_TIME_ZONE));
		cal.set(year,month-1,day,hour,minute,second);
		return cal;
		
		}catch(MalformedURLException ex){
			ex.printStackTrace();
			return null;
		}catch(IOException ex){
			ex.printStackTrace();
			return null;
		}

		
	}
	

}
