package basic.StringQ;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/16
 * @description
 */
public class Q7_字符串的调整与替换 {
	public static char[] chas = "a b  c".toCharArray();

	// 把 * 都移动到左边去
	public String s = "12**4**5";


	public void replace(char[] chas) {
		// 1、需要知道左边有效的长度，我们替换空格后需要的长度是 len + 2*空格数
		int length = chas.length;
		int len = 0;
		int count = 0;
		while (len < length && chas[len] != 0) {
			if (chas[len] == ' ') {
				count++;
			}
			len++;
		}
		int j = len + count * 2 - 1;

		// 确定好需要多大的区域后，是从后面开始写，但是写的内容是取决于原来大小的对应位置，是一起向前逆序的走
		//
		for (int i = len - 1; i >= 0; i--) {
			if (chas[i] != ' ') {
				chas[j] = chas[i];
				j--;
			} else {
				chas[j--] = '0';
				chas[j--] = '2';
				chas[j--] = '%';
			}
		}
	}

	public void modify(char[] chas) {
		int length = chas.length;
		int count = 0;
		int j = length - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (chas[i] == '*') {
				count++;
			} else {
				chas[j--] = chas[i];
			}
		}
		for(int i=0; i<count; i++){
			chas[i] = '*';
		}

		System.out.println("j : " + j + "count: "+count);
		System.out.println(String.valueOf(chas));
	}

	@Test
	public void test(){
		modify(s.toCharArray());
	}

}
