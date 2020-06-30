package basic.DpRecur;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/27
 * @description
 */
public class Q5_换钱的方法数 {
	public int solve(int[] arr, int index, int rest) {
		if (index == arr.length) {
			return rest == 0 ? 1 : 0;
		}
		int res = 0;
		for (int i = 0; i * arr[index] <= rest; i++) {
			int result = solve(arr, index + 1, rest - i * arr[index]);
			res += result;
		}
		return res;
	}

	/**
	 *  solve in dp!
	 * @param arr
	 * @param aim
	 * @return
	 */
	public int solve2(int[] arr, int aim){
		if(arr == null || arr.length == 0 || aim <0){
			return -1;
		}
		int length = arr.length;
		// dp[cost][cur] = x
		// 语义：arr[0:cur] 构成 cost 有几种方法
		// 0<=cur<length
		// 0<=cost<=aim
		int[][] dp = new int[aim+1][length];

		// init
		// cost = 0
		for(int i=0; i<length; i++){
			dp[0][i] =1;
		}
		// cur = 0
		for(int k=0; k*arr[0] <= aim; k++){
			dp[k*arr[0]][0] = 1;
		}

		// 填DP
		for(int cost=1; cost<=aim; cost++){
			for(int cur=1; cur<length; cur++){
				int num = 0;
				for(int k=0; cost - k*arr[cur]>=0; k++){
					num += dp[cost-k*arr[cur]][cur-1];
				}
				dp[cost][cur] = num;
			}
		}
		return dp[aim][arr.length-1];
	}

	public int solve3(int[] arr, int aim){
		if(arr == null || arr.length == 0 || aim <0){
			return -1;
		}
		int length = arr.length;
		// dp[cost][cur] = x
		// 语义：arr[0:cur] 构成 cost 有几种方法
		// 0<=cur<length
		// 0<=cost<=aim
		int[][] dp = new int[aim+1][length];

		// init
		// cost = 0
		for(int i=0; i<length; i++){
			dp[0][i] =1;
		}
		// cur = 0
		for(int k=0; k*arr[0] <= aim; k++){
			dp[k*arr[0]][0] = 1;
		}

		// 填DP
		for(int cost=1; cost<=aim; cost++){
			for(int cur=1; cur<length; cur++){
				// 优化
				dp[cost][cur] = dp[cost][cur-1];
				dp[cost][cur] += cost-arr[cur]>=0 ? 0 : dp[cost-arr[cur]][cur];
			}
		}
		return dp[aim][arr.length-1];
	}
}
