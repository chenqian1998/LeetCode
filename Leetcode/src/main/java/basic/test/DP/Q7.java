package basic.test.DP;

import org.junit.Test;
import org.junit.jupiter.api.io.TempDir;

import java.util.Arrays;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/2
 * @description
 */
public class Q7 {
	// 最长递增子序列
	public int[] getDP(int[] arr) {
		int length = arr.length;

		// dp[i] : [0..i]区域内，以i结尾的子序列中，最长递增子序列的长度
		int[] dp = new int[length];

		for (int i = 0; i < length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}

	public int[] getPath(int[] arr, int[] dp){
		int maxLen = -1;
		int maxIndex = -1;
		for(int i=0; i<dp.length; i++){
			if(dp[i] > maxLen){
				maxLen = dp[i];
				maxIndex = i;
			}
		}

		// 其实就是最后找到了以maxIndex作为最后节点，然后长度为maxLen的
		int[] path = new int[maxLen];
		path[maxLen-1] = arr[maxIndex];
		maxLen--;


		for(int i = maxIndex; i>=0; i--){
			if((arr[i] < arr[maxIndex]) && dp[i] == dp[maxIndex]-1){
				path[maxLen-1] = arr[maxIndex];
				maxIndex = i;
				maxLen--;
			}
		}
		return path;
	}

	@Test
	public void test() {
		int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
		int[] dp = getDP(arr);
		System.out.println(Arrays.toString(getPath(arr,dp)));
	}
}
