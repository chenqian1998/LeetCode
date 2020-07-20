package basic.test.DP;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/2
 * @description
 */
public class Q5 {

	// 换钱的方法数，之前有一个是啥，换指定数目钱，最少的纸币数目,最少的纸币数，这个显然
	// （1）递归终止返回的结果不一样
	// （2）递归结构不一样

	public int process(int[] arr, int rest, int cur) {
		if (cur == arr.length) {
			return rest == 0 ? 1 : 0;
		}

		int count = 0;
		for (int k = 0; k * arr[cur] <= rest; k++) {
			count += process(arr, rest - k * arr[cur], cur + 1);
		}
		return count;
	}

	public int process2(int[] arr, int cur, int sum, int aim) {
		if (cur == arr.length) {
			return sum == aim ? 1 : 0;
		}
		int count = 0;
		for (int k = 0; arr[cur] * k <= aim; k++) {
			count += process2(arr, cur + 1, sum + k * arr[cur], aim);
		}
		return count;
	}

	public int solve2(int[] arr, int aim) {
		int length = arr.length;

		// dp[cur][sum] 到达cur，组成sum的有几种
		// 		0<=cur<=length
		// 			0<=sum<=aim
		int[][] dp = new int[length + 1][aim + 1];

		// init
		// cur == length
		dp[length][0] = 0;

		// cur=0 仅仅只用第一个位置的元素组成之
		for (int k = 0; arr[0] * k <= aim; k++) {
			dp[0][arr[0] * k] = 1;
		}
		// sum=0
		for (int cur = 0; cur < length; cur++) {
			dp[cur][0] = 1;
		}


		for (int cur = 1; cur < length; cur++) {
			for (int sum = 1; sum <= aim; sum++) {
				dp[cur][sum] = dp[cur - 1][sum];
				if ((sum - arr[cur]) >= 0) {
					dp[cur][sum] += dp[cur][sum - arr[cur]];
				}
			}
		}
		return dp[length-1][aim];

	}

	@Test
	public void test() {
		int[] arr = {5, 10, 25, 1,100,9,16,2,3,4,5};
		int aim = 15;
		System.out.println(process(arr, aim, 0));
		System.out.println(process2(arr, 0, 0, aim));
		System.out.println(solve2(arr,aim));
	}


}
