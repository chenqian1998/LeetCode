package basic.BinaryTree;

import org.junit.Test;
import structure.TreeNode;
import utils.TreeUtils;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q2_最小深度 {
//	public int getMaxDepth(TreeNode root) {
//		// 深度 ： 指的是从root到叶子结点的深度，一定明白叶子节点的定义，自己不是null,而且left和right为null
//		return process2(root, 1);
//
//	}
//
//	private int process2(TreeNode root, int level) {
//		if (root.left == null && root.right == null) {
//			return level;
//		}
//		int res = -1;
//		if (root.left != null) {
//			res = Math.max(process2(root.left, level + 1), res);
//		}
//		if (root.right != null) {
//			res = Math.max(process2(root.right, level + 1), res);
//		}
//		return res;
//	}




	public int getMinDepth(TreeNode root){
		return process(root,1);
	}

	/**
	 * 到达root节点，这个节点所属的层次
	 * @param root
	 * @param level
	 * @return
	 */
	public int process(TreeNode root, int level){
		// 一定要是叶子节点，才能
		if(root.left == null && root.right == null){
			return level;
		}

		int res = Integer.MAX_VALUE;
		if(root.left!=null){
			res = Math.min(process(root.left, level+1), res);
		}
		if(root.right!=null){
			res = Math.min(res, process(root.right, level+1));
		}
		return res;
	}

	@Test
	public void test(){
		TreeNode root = TreeUtils.getExsample();
		System.out.println(getMinDepth(root));
	}


	public int getMaxDepth(TreeNode root){
		return process2(root,1);
	}

	/**
	 * 在这个root节点，所在的level
	 * @param root
	 * @param level
	 * @return 返回这个节点的最大深度
	 */
	public int process2(TreeNode root, int level){
		if(root.left == null && root.right == null){
			return level;
		}
		int res = -1;
		if(root.left!=null){
			res = Math.max(res, process2(root.left,level+1));
		}
		if(root.right!=null){
			res = Math.max(res, process2(root.right,level+1));
		}
		return res;
	}

	@Test
	public void test1(){
		TreeNode root = TreeUtils.getExsample();
		System.out.println(getMaxDepth(root));
	}


}
