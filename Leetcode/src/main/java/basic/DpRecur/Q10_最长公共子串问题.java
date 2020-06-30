package basic.DpRecur;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/30
 * @description
 */
public class Q10_最长公共子串问题 {
	public int[][] getDP(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return null;
		}
		// dp[i][j] 不是！！！ 代表s1[0..i] s2[0..j] 最长的公共子串
		// 子串这种东西，总是代表这s1以i结尾的字符串中，与s2以j结尾的字符串中，最长的公共子串的长度
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i < s1.length() + 1; i++) {
			for (int j = 1; j < s2.length() + 1; j++) {
				if(s1.charAt(i) == s2.charAt(j)){
					dp[i][j] = dp[i-1][j-1] + 1;
				}
			}
		}
		return dp;
	}

	public String getPath(int[][] dp, String s1, String s2){
		return null;
	}
}
