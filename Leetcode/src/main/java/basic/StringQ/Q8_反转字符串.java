package basic.StringQ;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/16
 * @description
 */
public class Q8_反转字符串 {
	// "i love you" == > "you love i"
	public String reverse(String s){
		int length = s.length();
		char[] chas = s.toCharArray();
		reverse(chas, 0, length-1);

		// 部分反转
		int start = 0;
		for(int i=0; i<length; i++){
			if(chas[i] == ' '){
				reverse(chas,start,i-1);
				start = i+1;
			}
		}
		reverse(chas, start,length-1);
		return String.valueOf(chas);
	}

	public void reverse(char[] chas, int start, int end){
		char temp;
		while(start < end){
			temp = chas[start];
			chas[start] =  chas[end];
			chas[end] = temp;
			start++;
			end--;
		}
	}


	@Test
	public void test(){
		String s = "i love you";
		System.out.println(reverse(s));
	}
}
