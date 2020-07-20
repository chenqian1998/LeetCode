package basic.test.DP;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/1
 * @description
 */
public class Q3 {
	public int solve(int[] arr, int aim) {
		int res = process(arr, aim, 0);
		return res;
	}

	/**
	 * @param arr  货币数组
	 * @param rest 走到i这个位置，还需要rest的面额要凑
	 * @param i
	 * @return 走到i这个位置上，凑出剩下rest钱的最少需要的货币数
	 */
	private int process(int[] arr, int rest, int i) {
//		if(rest == 0){
//			return 1;
//		}
		// 超过了范围，如果rest不为0，根本凑不出来，-1代表
		// 如果等于0，其实可以凑的，就是返回凑出来的最少的货币数目0
		if (i == arr.length) {
			return rest == 0 ? 0 : -1;
		}

		int minCount = -1;

		// 这个位置上能取0...K
		for (int k = 0; k * arr[i] <= rest; k++) {
			int res = process(arr, rest - k * arr[i], i + 1);
			if (res != -1) {
				if (minCount == -1) {
					minCount = res + k;
				} else {
					minCount = Math.min(minCount, res + k);
				}
			}
		}

		return minCount;
	}


	public int solve2(int[] arr, int aim) {
		// dp[cur][resr] 到达cur位置的时候,还剩下rest要凑，这个时候的凑出这么多钱的最小货币数是dp[cur][rest]
		int length = arr.length;
		int[][] dp = new int[length + 1][aim + 1];

		// dp init
		// rest ==0

		// cur == length
		for (int rest = 0; rest < aim + 1; rest++) {
			if(rest ==0){
				dp[length][rest] = 0;
			}else {
				dp[length][rest] = -1;
			}
		}

		for (int cur = length-1; cur>=0; cur--){
			for(int rest = 0; rest<= aim; rest++){
				// 其实就是比较 dp[cur][rest-arr[cur]] 和 dp[cur+1][rest]
				dp[cur][rest] = dp[cur+1][rest];

				if((rest-arr[cur])>=0 && dp[cur][rest-arr[cur]]!=-1){
					if(dp[cur][rest] == -1){
						dp[cur][rest] = dp[cur][rest-arr[cur]] + 1;
					}else {
						dp[cur][rest] = Math.min(dp[cur][rest-arr[cur]] + 1, dp[cur][rest]);
					}
				}
			}
		}
		return dp[0][aim];

	}

	@Test
	public void test() {
		int[] arr = {5, 2, 3};
		int solve = solve2(arr, 20);
		System.out.println(solve);

	}
}
