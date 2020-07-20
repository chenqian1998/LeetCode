package basic.test.TreeNode.遍历.先序遍历;

import structure.TreeNode;

import java.util.HashMap;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/9
 * @description
 */
public class 累加和为指定num的最长路径长度 {
	public int process(TreeNode root, int targetSum, int level, int preSum, int maxLen, HashMap<Integer, Integer> map){
		if(root == null){
			return maxLen;
		}

		int curSum = preSum + root.val;
		if(!map.containsKey(curSum)){
			map.put(curSum, level);
		}

		if(map.containsKey(curSum - targetSum)){
			maxLen = Math.max(maxLen, level - map.get(curSum-targetSum));
		}

		maxLen = process(root.left,targetSum,level+1,curSum, maxLen, map);
		maxLen = process(root.right,targetSum,level+1,curSum, maxLen, map);

		return maxLen;
	}
}
