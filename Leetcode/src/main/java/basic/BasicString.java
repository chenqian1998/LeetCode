package basic;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/20
 * @description 熟悉String的API
 */
public class BasicString {
	@Test
	public void testSubString() {
		String s = "http://localhost:8080";
		String str = "123456789abcde";

		int length = str.length();

		// 1、下标肯定都是从0开始计数,
		// substring(startIndex , endIndex)  就和python中切片的一样
		System.out.println(str.substring(2,2));
		// 左闭右开的，这个和python都一样的
		System.out.println(str.substring(2,3));

		// substring(startIndex)
		System.out.println(str.substring(3));

		// 14
		System.out.println(length);
		System.out.println(str.substring(13));
		// 这个是null
		System.out.println(str.substring(14));
		// 这个就报空指针异常
		System.out.println(str.substring(0,4));
	}

}
