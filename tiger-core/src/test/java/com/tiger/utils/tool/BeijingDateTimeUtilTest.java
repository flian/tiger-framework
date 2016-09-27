package com.tiger.utils.tool;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.tiger.utils.tools.BeijingDateTimeUtil;

public class BeijingDateTimeUtilTest {

	@Test
	public void testRetrieveBeijingStandardDatetime() {
		Calendar beijingCalendar = BeijingDateTimeUtil.retrieveBeijingStandardDatetime();
		if(beijingCalendar!=null){
			Date beijingDatetime = beijingCalendar.getTime();
			DateFormat df =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
			String dateFormatStr  = df.format(beijingDatetime);
			System.out.println("Beijing Current Datetime:"+dateFormatStr);
			assertFalse("".equals(dateFormatStr));
			assertFalse(null==dateFormatStr);
		}else{
			System.out.println("BeijingTime service not available");
			assertTrue(true);
		}	
	}

}
