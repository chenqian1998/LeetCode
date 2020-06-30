package basic.DpRecur;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/30
 * @description
 */
public class Q10_最长公共子序列的问题 {

	public int[][] getDP(String s1, String s2){
		// dp[i][j]代表s1[0..i]与s2[0..j]中间最长的公共子序列
		int[][] dp = new int[s1.length()+1][s2.length()+1];

		// dp init
		// i==0 ? j==0

		for(int i=1; i<s1.length()+1; i++){
			for(int j=1; j<s2.length()+1; j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp;
	}

	public String getCommonParts(int[][] dp, String s1, String s2){
		List<String> pathes = new ArrayList<>();
		int m = dp.length-1;
		int n = dp[0].length-1;
		int maxLen = dp[m][n];
		String s = "";
		while (maxLen >= 0){
			if(n>0 && dp[m][n] == dp[m][n-1]){
				n--;
			}else if(m>0 && dp[m][n]==dp[m-1][n]){
				m--;
			}else{
				// 倒着
				s = s1.charAt(m) + s;
				m--;
				n--;
				maxLen--;
			}
		}
		return s;
	}


	@Test
	public void test(){
		String s = "a";
		char c = 'b';
		s = s + c;
		System.out.println(s);
	}
}
