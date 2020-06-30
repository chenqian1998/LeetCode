package basic.DpRecur;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/28
 * @description
 */
public class Q6_打气球的最大分数 {
	public int solve(int[] arr) {
		return process(arr, 1, arr.length - 1);
	}

	/**
	 * 返回 arr[L..R]范围内，打爆气球能得到的最大分数
	 * 并且 arr[L-1] 和 arr[R+1] 一定没有被打爆
	 **/
	public int process(int[] arr, int L, int R) {
		if (L == R) {
			return arr[L - 1] * arr[L] * arr[R + 1];
		}
		// 核心是，最后被打爆的是哪一个？？
		// 最后被打爆的真的这么重要吗？？以至于这个是最后分割的条件
		int max = Math.max(arr[L - 1] * arr[L] * arr[R + 1] + process(arr, L + 1, R), arr[L - 1] * arr[R] * arr[R + 1] + process(arr, L, R - 1));

		for (int i = L + 1; i < R; i++) {
			max = Math.max(max, process(arr, L, i - 1) + process(arr, i + 1, R) + arr[L - 1] * arr[i] * arr[R + 1]);
		}
		return max;
	}

	public int solve2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int N = arr.length;
		int[] help = new int[N + 2];
		help[0] = 1;
		help[N + 1] = 1;
		for (int i = 1; i < N; i++) {
			help[i] = arr[i - 1];
		}

		int[][] dp = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			dp[i][i] = help[i - 1] * help[i] * help[i + 1];
		}

		for (int L = N; L >= 1; L--) {
			for (int R = L + 1; R <= N; R++) {
				int finalL = help[L - 1] * help[L] * help[R + 1] + dp[L + 1][R];
				int finalR = help[L - 1] * help[R] * help[R + 1] + dp[L][R - 1];
				dp[L][R] = Math.max(finalL, finalR);

				// 在中间尝试
				for (int i = L + 1; i < R; i++) {
					dp[L][R] = Math.max(dp[L][R], help[L - 1] * help[i] * help[R + 1] + dp[L][i - 1] + dp[i + 1][R]);
				}

			}
		}
		return dp[1][N];
	}


	@Test
	public void test() {
		List<String> strings = Arrays.asList("a", "b", "c");
		int d = strings.indexOf("d");
		System.out.println(d);
	}

}
