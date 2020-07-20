package basic.BinaryTree;

import structure.TreeNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q8_是否是平衡二叉树 {

	class ReturnType {
		public boolean isBalanced;
		public int height;

		public ReturnType(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}

	/**
	 * 尼玛的，说的是平衡，也就是任何一个节点到任意的叶子节点的高度差距不超过1,我老是把这个问题想成搜索二叉树
	 */
	public boolean isBST(TreeNode root) {
		return process(root).isBalanced;
	}

	public ReturnType process(TreeNode root) {
		if (root == null) {
			return new ReturnType(true, 0);
		}
		ReturnType leftData = process(root.left);
		ReturnType rightData = process(root.right);
		int height = Math.max(leftData.height, rightData.height) + 1;
		boolean isBalanced = leftData.isBalanced && rightData.isBalanced && (Math.abs(leftData.height - rightData.height) <= 1);
		return new ReturnType(isBalanced, height);
	}


}
