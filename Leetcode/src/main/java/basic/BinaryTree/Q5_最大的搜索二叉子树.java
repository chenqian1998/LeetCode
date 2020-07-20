package basic.BinaryTree;

import structure.TreeNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q5_最大的搜索二叉子树 {

	/**
	 * 解决这个问题我们势必是需要遍历所有的节点一次
	 * 而且父节点的结果是依赖左右子节点问题的答案
	 */

	class ReturnType {
		public TreeNode maxBSTHead;
		public int maxBSTSize;
		public int min;
		public int max;

		public ReturnType(TreeNode maxBSTHead, int maxBSTSize, int min, int max) {

		}
	}

	public ReturnType process(TreeNode X) {
		if (X == null) {
			return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		ReturnType leftData = process(X.left);
		ReturnType rightData = process(X.right);

		// 信息整合
		int min = Math.min(X.val, Math.min(leftData.min, rightData.min));

		int max = Math.max(X.val, Math.max(leftData.max, rightData.max));

		int maxBSTSize = Math.max(leftData.maxBSTSize, rightData.maxBSTSize);

		TreeNode maxBSTHead = leftData.maxBSTSize >= rightData.maxBSTSize ? leftData.maxBSTHead : rightData.maxBSTHead;

		if (leftData.maxBSTHead == X.left && rightData.maxBSTHead == X.right && X.val < rightData.min && X.val > leftData.max) {
			maxBSTSize = 1 + leftData.maxBSTSize + rightData.maxBSTSize;
			maxBSTHead = X;
		}
		return new ReturnType(maxBSTHead, maxBSTSize, min, max);
	}

	public TreeNode getMaxBST(TreeNode root){
		return process(root).maxBSTHead;
	}
}
