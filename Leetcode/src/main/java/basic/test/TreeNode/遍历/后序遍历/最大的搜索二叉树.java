package basic.test.TreeNode.遍历.后序遍历;

import structure.TreeNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/9
 * @description
 */
public class 最大的搜索二叉树 {

	public TreeNode getMaxSubBST(TreeNode root){
		return process(root).BSTHead;
	}

	class ReturnType{
		/** 到达某个节点，返回这个节点最大二叉树的  */
		TreeNode  BSTHead;
		/* 这个最大二叉树的大小*/
		int size;

		// 因为要判断是不是二叉搜索树，所以很需要这个节点下面最小值和最大值
		int min;
		int max;

		public ReturnType(TreeNode BSTHead, int size, int min, int max){
			this.BSTHead = BSTHead;
			this.size = size;
			this.min = min;
			this.max = max;
		}
	}

	public ReturnType process(TreeNode root){
		if(root == null){
			return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		ReturnType left = process(root.left);
		ReturnType rigth = process(root.right);

		TreeNode BSTHead = null;
		int size = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		BSTHead = left.size >= rigth.size ? left.BSTHead : rigth.BSTHead;
		size = Math.max(left.size, rigth.size);

		if(root.left == left.BSTHead && root.right == rigth.BSTHead && root.val > left.max && root.val < rigth.min) {
			BSTHead = root;
			size = left.size + rigth.size + 1;
		}

		min = Math.min(root.val , Math.min(left.min, rigth.min) );
		max = Math.max(root.val , Math.max(left.max, rigth.max) );

		return new ReturnType(BSTHead, size, min, max);
	}
}
