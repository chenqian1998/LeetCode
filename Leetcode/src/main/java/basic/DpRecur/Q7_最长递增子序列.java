package basic.DpRecur;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/29
 * @description
 */
public class Q7_最长递增子序列 {
	/**
	 * 这种方法的时间复杂度是 O(N^2)
	 *
	 * @param arr
	 * @return
	 */
	public int[] getDP1(int[] arr) {
		// dp 代表到达i的时候，dp[i]代表[0...i]中最长的递增子序列的长度是多少
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}

	public int[] getDP2(int[] arr) {
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		// 在所有长度为1的递增序列中，最小的结尾数是arr[0]
		ends[0] = arr[0];
		dp[0] = 1;
		int right = 0;
		int l = 0;
		int r = 0;
		int m = 0;
		for (int i = 1; i < arr.length; i++) {
			l = 0;
			r = right;
			while (l <= r) {
				m = (l + r) / 2;
				// 找到ends中左边
				if (arr[i] > ends[m]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			right = Math.max(right, 1);
			ends[l] = arr[i];
			dp[i] = l+1;
		}
		return dp;
	}

	public int[] generateLIS(int[] arr, int[] dp) {
		int len = 0;
		int index = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}
		int[] list = new int[len];
		list[--len] = arr[index];
		for (int i = index; i >= 0; i--) {
			if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
				list[--len] = arr[i];
				index = i;
			}
		}
		return list;
	}
}
