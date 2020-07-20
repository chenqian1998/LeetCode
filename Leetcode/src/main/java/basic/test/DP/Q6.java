package basic.test.DP;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/2
 * @description
 */
public class Q6 {
	/**
	 * 大气球的最大分数
	 *
	 * @param arr
	 * @param L   左边界
	 * @param R   右边界
	 * @return 打爆 [L..R]区域内能得到的最大值,而且要保证[L-1,...,R+1]
	 */
	public int process(int[] arr, int L, int R) {
		// 边界
		if (L == R) {
			return arr[L - 1] * arr[L] * arr[R + 1];
		}
		int res = -1;

		// 最后一个被打爆的是边界
		int left = process(arr, L + 1, R) + arr[L - 1] * arr[L] * arr[R + 1];
		int right = process(arr, L, R - 1) + arr[L - 1] * arr[R] * arr[R + 1];
		res = Math.max(left, right);

		// 打爆的是中间[L+1,R-1],
		for (int i = L + 1; i <= R - 1; i++) {
			res = Math.max(res, process(arr, L, i - 1) + process(arr, i + 1, R) + arr[L - 1] * arr[i] * arr[R + 1]);
		}
		return res;
	}

	/**
	 * @param arr
	 * @return
	 */
	public int solve2(int[] arr) {
		int length = arr.length;
		int[] newArr = new int[arr.length + 2];
		newArr[0] = 1;
		newArr[arr.length + 1] = 1;
		for (int i = 0; i < arr.length; i++) {
			newArr[i + 1] = arr[i];
		}

		//  1<=L<=arr.length
		//  1<=R<=arr.length
		// 打爆区间[i..j]得到的最大分数
		int[][] dp = new int[length + 2][length + 2];
		// init
		// L == R
		for (int i = 1; i <= length; i++) {
			dp[i][i] = newArr[i - 1] * newArr[i] * newArr[i + 1];
		}

		for (int L = length - 1; L >= 1; L--) {
			for (int R = L + 1; R <= length; R++) {
				int left = dp[L + 1][R] + arr[L - 1] * arr[L] * arr[R + 1];
				int right = dp[L][R - 1] + arr[L - 1] * arr[R] * arr[R + 1];
				dp[L][R] = Math.max(left, right);

				for (int k = L + 1; k <= R - 1; k++) {
					dp[L][R] = Math.max(dp[L][R], dp[L][k - 1] + dp[k + 1][R] + arr[L - 1] * arr[k] * arr[R + 1]);
				}
			}
		}
		return dp[1][length];


	}


	@Test
	public void solve() {
		int[] arr = {3, 2, 5};
		int[] newArr = new int[arr.length + 2];
		newArr[0] = 1;
		newArr[arr.length + 1] = 1;
		for (int i = 0; i < arr.length; i++) {
			newArr[i + 1] = arr[i];
		}
		System.out.println(Arrays.toString(newArr));
		System.out.println(process(newArr, 1, arr.length));
	}
}
