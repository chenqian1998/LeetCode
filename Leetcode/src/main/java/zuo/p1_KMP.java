package zuo;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/3
 * @description KMP算法及其扩展
 */
public class p1_KMP {
	@Test
	public void test01() {
		String str1 = "abcdef";
		String str2 = "bcd";

		int index = str1.indexOf(str2);
		System.out.println(index);
	}

	@Test
	public void test02() {
		int[] a1 = new int[]{1, 2, 3};
		int[] a2 = {1, 2, 3};
		int[] a3 = {1, 2, 3};
		System.out.println(a1 == a2);
		System.out.println(a2 == a3);

	}


	/**
	 * s1 中是否包含 s2
	 *
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int indexOf(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() < s2.length()) {
			return -1;
		}
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		int i1 = 0, i2 = 0;
		int[] next = getNextArray(str2);

		while (i1 < str1.length && i2 < str2.length) {
			if (str1[i1] == str2[i2]) {
				i1++;
				i2++;
			} else {
				if (next[i2] == -1) {
					i1++;
				} else {
					i2 = next[i2];
				}
			}
		}
		return i2 == str2.length ? i1 - i2 : -1;

	}

	private static int[] getNextArray(char[] str2) {
		if (str2.length == 1) {
			return new int[]{-1};
		}
		int[] next = new int[str2.length];
		next[0] = -1;
		next[1] = 0;
		int i = 2;
		int cn = 0;
		while (i < next.length) {
			if (str2[i - 1] == str2[cn]) {
				next[i++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[i++] = 0;
			}
		}
		return next;
	}
}
