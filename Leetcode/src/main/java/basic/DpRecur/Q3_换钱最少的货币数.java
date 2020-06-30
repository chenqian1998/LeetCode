package basic.DpRecur;

import java.util.List;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/27
 * @description 就是一个数组，每个位置上的元素都可以任意选择，然后能不能组成大小为aim，找出方案中需要个数最少的。
 * 这个题目还是很经典的。
 * 一个数组，每个位置上都有选和不选2种可能，而且选择次数不限。
 * 这个一看就是要递归来解决，因为选择的余地太大，不光是选或不选2种，连每个位置上选择的个数都是不确定的。
 * <p>
 * 递归 ==》 设计参数
 */
public class Q3_换钱最少的货币数 {
	public int minCoinsl(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		return solve2(arr, 0, aim);
	}

	/**
	 * 到达i位置的时候
	 *
	 * @param arr
	 * @param i
	 * @param sum
	 * @return
	 */
	public void solve(int[] arr, int n, int i, int sum, int aim, int count, List<Integer> res) {
		if (sum == aim) {
			Integer val = res.get(0);
			if (count < val) {
				res.add(count);
			}
		}
		// 每个位置上都有选、不选
		solve(arr, n, i + 1, sum, aim, count, res);
		solve(arr, n, i, sum + arr[i], aim, count + 1, res);
	}


	// 考虑用如果是用返回值的方法，递归怎么写
	// 到达位置i,还剩下rest面额的钱要凑
	// 返回值代表到达位置i的要凑rest钱需要多少个货币
	public int solve2(int[] arr, int i, int rest) {
		if (i == arr.length) {
			// 最后要凑的钱是0,直接返回0
			// 如果不是，因为现在已经是最后，没有面额可以使用，已经凑不出来了，直接返回-1，代表前面那种凑法不行
			return rest == 0 ? 0 : -1;
		}
		// 在位置i上，要凑剩下的rest，需要的最少纸币个数是rest
		int res = -1;
		// 每个位置上可以选0 , n个
		for (int k = 0; k * arr[i] <= rest; k++) {
			// next其实很简单，这个函数的返回结果其实就说嘛
			int next = solve2(arr, i + 1, rest - (k * arr[i]));
			if (next != -1) {
				// res代表的含义就是剩下rest能使用最少的纸币个数
				// 如果res == -1,代表这个i位置上的面额没有使用，
				if (res == -1) {
					// 第一次找到有效的解
					res = next + k;
				} else {
					// 找到这个位置上的最小解
					res = Math.min(res, next + k);
				}
			}
		}
		return res;
	}

	/**
	 * 优化：暴力递归 ====》 DP
	 * 前提条件 ： 暴力递归中参数的设计，要对应到DP，组成二维数组或者一维数组
	 * <p>
	 * DP最大的好处就是可以利用之前的计算结果，当问题转换成DP数组的求解时，寻找DP优化的方法
	 *
	 * @param arr
	 * @return
	 */
	public int solve3(int[] arr, int target) {
		// 1、最重要的就是根据暴力递归，找出核心的参数，以此为基准，设计DP，二维数组
		// 这里是走到第i的位置  0<=i<=N , 是可以到达N的，
		// 剩下要攒的面额     0<=rest<=target
		int length = arr.length;
		int[][] dp = new int[length + 1][target + 1];
		// dp init, 这部分的信息其实也是来源于上面 i == length的启发,这个时候除了rest==0,其他都有问题

		for (int rest = 1; rest < target + 1; rest++) {
			dp[length][rest] = -1;
		}
		dp[length + 1][0] = 0;

		// 2、求dp[i][j]的过程。 明确含义
		// 明确含义： 这里是 dp[i][rest] 到达i这个位置的时候，攒出rest需要的个数
		// 之前我们在递归中的做法是怎么样的？？ ==》应该是观察下一行的结果
		// dp[i][rest] = max( dp[i+1][rest-0]+1, dp[i+1][rest-arr[i]] + 1, dp[i+1][rest-2*arr[i]] + 2)
		// DP最主要的优化就是上面的枚举，dp[i][rest]与相邻元素之间的关系是核心
		// dp[i][rest-arr[i]] , 这个是dp[i][rest]的左边一个，观察这个位置得求法，可以发现其实和dp[i][rest]一样的，
		// 所以相当于在左边已经求过一次了，这个时候就可以直接通过 dp[i][rest-arr[i]] + 1 得到dp[i][rest]的值
		// 当然这个位置也可以跳过去不选，dp[i+1][rest]
		for (int i = length - 1; i >= 0; i--) {
			for (int rest = 0; rest <= target; rest++) {
				dp[i][rest] = -1;
				if (dp[i + 1][rest] != -1) {
					dp[i][rest] = dp[i + 1][rest];
				}
				if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
					if (dp[i][rest] == -1) {
						dp[i][rest] = dp[i][rest - arr[i]] + 1;
					} else {
						dp[i][rest] = Math.min(dp[i][rest], dp[i][rest - arr[i]] + 1);
					}
				}
			}
		}
		return dp[0][target];
	}
}
