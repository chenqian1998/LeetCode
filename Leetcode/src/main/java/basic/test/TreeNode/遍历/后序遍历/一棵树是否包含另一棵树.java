package basic.test.TreeNode.遍历.后序遍历;

import structure.TreeNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/9
 * @description
 */
public class 一棵树是否包含另一棵树 {

	public boolean solve(TreeNode t1, TreeNode t2) {
		return process(t1, t2);

	}


	public boolean process(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return false;
		}

		return check(t1, t2) || process(t1.left, t2) || process(t1.right, t2);
	}

	public boolean check(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true;
		}
		if (t1 == null) {
			return false;
		}

		if (t1.val != t2.val) {
			return false;
		}

		return check(t1.left, t2.left) && check(t1.right, t2.right);
	}


}
