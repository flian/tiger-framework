package com.tiger.utils.tool;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.tiger.utils.tools.DateUtil;

public class DateUtilTest {

	@Test
	public void testParseDate() throws Exception{
		String dateString = "2014-12-22 14:23:54.234";
		Date date  = DateUtil.parseDate(dateString);
		System.out.println("date:"+date);
		assertTrue(date!=null);
	}

	@Test
	public void testAddDays() throws Exception {
		String date1 = "2014-12-22 14:23:54";
		int daysToAdd = 3;
		Date date = DateUtil.addDays(date1, daysToAdd);
		System.out.println("date:"+date);
		assertTrue(date!=null);
		
	}

	@Test
	public void testAddHoursStringInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddHoursDateInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testFormatStandardDatetime() {
		fail("Not yet implemented");
	}

	@Test
	public void testFormatPureDatetime() {
		fail("Not yet implemented");
	}

	@Test
	public void testFormatCommonDatetime() {
		fail("Not yet implemented");
	}

	@Test
	public void testFormatPureLongDatetime() {
		fail("Not yet implemented");
	}

	@Test
	public void testFormatStandardDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFormatPureLongDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFormatChineseCommonDatetime() {
		fail("Not yet implemented");
	}

	@Test
	public void testFormatChineseCommonNoYearDatetime() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompare() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSpecifiedHourAfter() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSpecifiedDayAfter() {
		fail("Not yet implemented");
	}

}
