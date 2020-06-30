package basic.StringQ;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/27
 * @description
 */
public class Q3_整数字符串转整数 {
	/**
	 * 检查字符串是否符合条件
	 * <p>
	 * 只能是数字，而且不能以0开头，而且范围是int，如果不行就返回false
	 * 也有可能是负数, "-"开头的
	 *
	 * @param s
	 * @return
	 */
	public boolean checkString(char[] chars) {
		if (chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')) {
			return false;
		}
		if (chars[0] == '-' && (chars.length == 1 || chars[1] == '0')) {
			return false;
		}
		if (chars[0] == '0' && chars.length > 1) {
			return false;
		}
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] < '0' || chars[i] > '9') {
				return false;
			}
		}
		return true;
	}

	public int convert(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		char[] chas = s.toCharArray();
		if (!checkString(chas)) {
			return 0;
		}

		boolean posi = chas[0] == '-' ? false : true;

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);

		// "2147483648" ? 溢出
		// "-2147483649" ?
		int res = 0;
		// -214748364，如果某次乘之前，基础值就已经小于这个值了，而且后面还要继续乘。那说明肯定已经溢出了
		int min_base = Integer.MIN_VALUE/10;
		//  9,末位数字
		int minr = Integer.MIN_VALUE%10;

		for (int i = posi?1:0; i <chas.length; i++) {
			int cur = chas[i] - '0'; // 这个是负数
			if(res<min_base || (res == min_base && cur<minr)){
				// 不能转
				return 0;
			}
			res = res*10 + cur;
		}
		if(posi && res == Integer.MIN_VALUE){
			return 0;
		}
		return posi?-res:res;
	}

	@Test
	public void test() {
		String s = "123";
		convert(s);
		System.out.println( -5 % 2);
	}


}
