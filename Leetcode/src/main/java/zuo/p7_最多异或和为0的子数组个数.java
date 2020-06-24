package zuo;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/17
 * @description
 *
 * 经典DP结构，因为连续子数组有一个技巧，就是考虑以以每个位置结尾的情况。
 * 结尾有两种情况，[....i] 这个i如果是0，就直接dp[i-1]+1
 * 如果不为0，	—— 如果arr[i]不组成异或的子数组， dp[i] = dp[i-1]
 * 						—— 以arr[i]结尾的元素会组成异或和为0的子数组，那就向左边找j(第一可以使得【j:i]异或和为0）,dp[j-1] + 1
 * 					比较两者，选出最大的
 *
 * 			问题是第二步中的这个细节，找到位置j，使得异或和[j:i]为0，有没有比较快的方法？？
 * 			加快速度，往往都是空间换时间的做法==..==
 *
 * 		到位置i时候，一直记录着0-i的异或和sum, 如果（j-i）是异或和为0，那只要找到j前面，(0 - j-1)的异或和是不是sum，是的话就可以了
 * 	所以需要有一个map记录每个位置的sum信息
 * 	map< sum, index>
 *
 */
public class p7_最多异或和为0的子数组个数 {
	public int solve(int[] arr) {
		int length = arr.length;
		int count = 0;
		int sum = 0;
		int[] dp = new int[length];
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0,-1);

		// 任然是遍历整个数组
		for (int i = 0; i < length; i++) {
			// 记录 (0-i)的sum
			sum = sum ^ arr[i];

			// 找前面距离i最近的异或和为sum的是那个位置，拿到下标再去找dp
			// 开头是0的话，dp[0] = 1
			//
			if (map.containsKey(sum)){
				int index = map.get(sum);
				dp[i] = index == -1 ? 1:(dp[index] + 1);
			}
			if (i>0){
				// 默认 dp[i] = dp[i-1],也就是arr[i]元素不再能组成异或和的数组里
				// 比大小
				dp[i] = Math.max(dp[i],dp[i-1]);
			}
		}
		return count;
	}


	/**
	 *
	 * 寻找和为sum的连续子数组，而且要找出这些子数组中长度最大的
	 *  【7，1，3，2，7，-1，-6，7】 sum = 7
	 *  比如这里【1，3，2，7，-1，-6】，最长的6
	 *
	 *  这也是老经典的一道题了
	 *  思考一下如果暴力枚举就有点蠢了，一个方法是遇到连续子数组这个特征，考虑以这个数字结尾
	 * @param target
	 * @return
	 */
	public int longestSubArr(int[] arr, int target){
		int length = arr.length;
		int sum = 0;
		int maxLen = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		// 这个初始化的原因和上一题一样的，考虑第一个为7的时候咋办的
		map.put(0,-1);

		for (int i = 0; i< length; i++){
			sum += arr[i];
			// (0-i)和为sum, 我们的目标是寻找是不是target的连续子数组
			// 只要找到前面有没有和为（sum-target)的子数组
			if (map.containsKey(sum - target)){
				int index = map.get(sum - target);
				maxLen = Math.max(maxLen,i - index);

				// 一个非常容易出错的点就是，如果存在sum - target，
				// 我们是不需要map.put(sum,i)的
				// 为啥的还不是很理解，周末再写下
				// TODO：周末ccc
			}else {
				map.put(sum,i);
			}

		}
		return maxLen;
	}

	@Test
	public void test01(){
		int[] arr = {7,1,3,3,7,-1,-6,7};
		System.out.println(longestSubArr(arr,7));
	}

}
