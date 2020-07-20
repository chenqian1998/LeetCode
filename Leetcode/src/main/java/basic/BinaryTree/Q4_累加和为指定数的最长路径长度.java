package basic.BinaryTree;

import structure.TreeNode;

import java.util.HashMap;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q4_累加和为指定数的最长路径长度 {
	/*
		说实话，这个问题就是数组问题的衍生，原问题：找一个数组中和为val的最长子数组的长度
		时间复杂度 O(N)
	 */
	public int solve1(int[] arr, int aim){
		int sum = 0;
		int maxLen = 0;
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		hashMap.put(0,0);

		for(int i=0; i<arr.length; i++){
			sum += arr[i];
			if(hashMap.containsKey(sum - aim)){
				maxLen = Math.max(maxLen, i - hashMap.get(sum - aim));
			}else {
				hashMap.put(sum, i);
			}
		}
		return maxLen;
	}


	public int solve(TreeNode root, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap){
		if(root == null){
			return maxLen;
		}
		int curSum = preSum + root.val;
		if(!sumMap.containsKey(curSum)){
			sumMap.put(curSum,level);
		}
		if(sumMap.containsKey(curSum - sum)){
			maxLen = Math.max(level-sumMap.get(curSum-sum), maxLen);
		}
		// 这里是前序遍历？？
		maxLen = solve(root.left, sum, curSum, level+1, maxLen, sumMap);
		maxLen = solve(root.right, sum, curSum, level+1, maxLen, sumMap);

		if(level == sumMap.get(curSum)){
			sumMap.remove(curSum);
		}
		return maxLen;
	}
}
