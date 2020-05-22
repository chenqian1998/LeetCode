package Leetcode.左的课堂练习;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/21
 * @description
 */
public class BasicNumber {
	@Test
	public void test01() throws InterruptedException, ParseException {
		long timeMillis = System.currentTimeMillis();
		Date date = new Date(2020, 5, 21, 14, 44, 0);
		System.out.println("currentTimeMillis: " + timeMillis);
		System.out.println("date gettime:   " + date.getTime());

//		Thread.sleep(1000);
//
//		long timeMillis2 = System.currentTimeMillis();
//		System.out.println(timeMillis2);
	}

	@Test
	public void testCalendar() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss.SSS");
		Date d = sdf.parse("20200521 15:00:00.000");

		Calendar c = Calendar.getInstance();
		c.setTime(d);
		//获取时间值
		System.out.println(c.getTime().getTime());
		System.out.println(System.currentTimeMillis());
		Long aLong = Long.valueOf(100);
	}


	@Test
	public void test02() {
		OutputStream outputStream = new OutputStream() {
			@Override
			public void write(int b) throws IOException {

			}
		};
	}

	@Test
	public void test04() {
		float a = 0.1f;
		double b = 0.1;
		double c = 0.1;
		System.out.println(a == b);
		System.out.println(b == c);

		float a1 = 0f;
		double b1 = 0;
		System.out.println(a1 == b1);

		BigDecimal bigDecimal = new BigDecimal(a);

		float zeroFloat = 0.0f;
		System.out.println(zeroFloat == 0);

	}

	@Test
	public void test03() {
		// 11
		int a = 3;
		// 4: 100
		System.out.println(a | 4);
	}

	@Test
	public void testBooleanInit(){
		boolean flag = false;
		System.out.println(flag);
	}


}
