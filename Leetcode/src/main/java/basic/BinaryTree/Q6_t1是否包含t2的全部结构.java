package basic.BinaryTree;

import structure.TreeNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description 如果没有理解出错，应该就是判断
 */
public class Q6_t1是否包含t2的全部结构 {


	public boolean contains(TreeNode t1, TreeNode t2){
		if(t2 == null){
			return true;
		}
		if(t1 == null){
			return false;
		}
		boolean res1 = compare(t1,t2);
		boolean res2 = compare(t1.left, t2);
		boolean res3 = compare(t1.right,t2);
		return res1 || res2 || res3;
	}

	private boolean compare(TreeNode t1, TreeNode t2) {
		if(t2 == null){
			return true;
		}
		if(t1 == null){
			return false;
		}

		if(t1.val != t2.val){
			return false;
		}

		return compare(t1.left, t2.left) && compare(t1.right, t2.right);

	}


}
