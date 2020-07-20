package basic.test.TreeNode.遍历.后序遍历;

import structure.TreeNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/9
 * @description
 */
public class 最小大深度 {
	public int minDepth(TreeNode root, int level) {
		return process(root,1);
	}


	public int process(TreeNode root, int level) {
		if (root.left == null && root.right == null) {
			return level;
		}
		int res = Integer.MAX_VALUE;

		// 如果left 和 right 为 null ，确实会出现NPE,所以这一行是必不可少的，
		if (root.left != null) {
			res = Math.min(res, process(root.left, level+1));
		}
		if(root.right!= null){
			res = Math.min(res, process(root.right, level+1));
		}
		return res;
	}

	public int maxDepth(TreeNode root){
		return process2(root,1);
	}

	public int process2(TreeNode root, int level){
		if(root.left == null && root.right == null){
			return level;
		}

		int res = Integer.MIN_VALUE;
		if(root.left != null){
			res = Math.max(res, process2(root.left, level+1));
		}
		if(root.right != null){
			res = Math.max(res, process2(root.right, level+1));
		}

		return res;
	}


}
