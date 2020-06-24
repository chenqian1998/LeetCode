package zuo;

import org.junit.Test;
import structure.TreeNode;
import utils.TreeUtils;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/19
 * @description
 *
 *  这个太经典了，说到平衡，就是AVL树。
 *  就是每个节点的左子树的高度，和右子树的高度之间的关系，就是对任意一个节点来说
 *
 */
public class p9_是否是平衡二叉树 {

	// 和高度相关的，可以考虑2个问题
	// 最大深度怎么算的？？
	// 最小深度怎么算的
	public int getMinDepth(TreeNode root){
		if(root == null){
			return 1;
		}
			return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
	}

	public int getMaxDepth(TreeNode root){
		if (root == null){
			return 1;
		}
		int leftDepth = getMaxDepth(root.left);
		int rightDepth = getMaxDepth(root.right);
		return Math.max(leftDepth, rightDepth) + 1;
	}

	@Test
	public void test01(){
		System.out.println(getMaxDepth(TreeUtils.getExsample()));
	}

	public static class ReturnData {
		// 这个节点是否平衡
		public boolean isBalacned;
		// 这个节点的高度，高度你想一下，意思其实是从最低点开始向上，h = max(left.h, right.h)
		public int h;
		public ReturnData(boolean isB, int h){
			this.isBalacned = isB;
			this.h = h;
		}
	}

	public static ReturnData process(TreeNode root){
		if (root == null){
			return new ReturnData(true, 0);
		}
		ReturnData leftData = process(root.left);
		if(!leftData.isBalacned){
			return new ReturnData(false, 0);
		}
		ReturnData rightData = process(root.right);
		if(!rightData.isBalacned){
			return new ReturnData(false, 0);
		}
		if(Math.abs(leftData.h - rightData.h) > 1){
			return new ReturnData(false, 0);
		}
		// 一个树
		return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);

	}

	public static boolean checkBalance(TreeNode root){
		return process(root).isBalacned;
	}








}
