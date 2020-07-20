package basic.test.TreeNode.遍历.后序遍历;

import structure.TreeNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/9
 * @description
 */
public class 平衡二叉树 {

	public boolean solve(TreeNode root){
		return process(root).isBalanced;
	}

	class ReturnType{
		boolean isBalanced;
		int height;

		public ReturnType(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}

	public ReturnType process(TreeNode root){
		if(root == null){
			return new ReturnType(true, 0);
		}

		ReturnType left = process(root.left);
		ReturnType right = process(root.right);

		if(!left.isBalanced || !right.isBalanced || Math.abs(left.height - right.height) > 1){
			return new ReturnType(false,left.height+1);
		}

		return new ReturnType(true, Math.max(left.height + 1, right.height + 1));

	}

}
