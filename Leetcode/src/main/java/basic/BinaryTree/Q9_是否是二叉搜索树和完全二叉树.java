package basic.BinaryTree;

import org.junit.Test;
import structure.TreeNode;
import utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q9_是否是二叉搜索树和完全二叉树 {
	// 其实只需要判断中序遍历是不是递增的？？
	public boolean isBinarySearchTree(TreeNode node) {
		List<TreeNode> list = new ArrayList<>();

		midOrder(node, list);

		// 判断list是不是递增的
		for (int i = 1; i < list.size(); i++) {
			if ((list.get(i).val - list.get(i - 1).val) <= 0) {
				return false;
			}
		}
		return true;
	}

	private void midOrder(TreeNode root, List<TreeNode> list) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				list.add(cur);
				cur = cur.right;
			}
		}
	}

	@Test
	public void test() {
		TreeNode root = TreeUtils.getExsample();
		root.left.left.left.val = 2;
		System.out.println(isBinarySearchTree(root));
	}


	/**
	 * 是否是完全二叉树？？？
	 * <p>
	 * 这个问题一直有些纠结我。。判断标准其实就2个，按照层次遍历
	 * （1）如果一个节点有右节点。。但是没有左节点，直接返回false
	 * （2）如果一个节点不是所有节点都有，那么同一层的右边都要是叶节点了，就是不能再有子节点了
	 *
	 * @param root
	 * @return
	 */
	public boolean isCBT(TreeNode root) {
		if (root == null) {
			return true;
		}

		TreeNode cur = root;
		Queue<TreeNode> queue = new LinkedList<>();
		boolean leaf = false;
		TreeNode l = null;
		TreeNode r = null;
		queue.add(root);
		while (!queue.isEmpty()) {
			cur = queue.poll();
			l = cur.left;
			r = cur.right;

			if (l == null && r != null) {
				return false;
			}
			if (leaf && (l != null || r != null)) {
				return false;
			}
			if (l != null) {
				queue.add(l);
			}
			if (r != null) {
				queue.add(r);
			} else {
				// 有某一层不完整
				leaf = true;
			}
		}
		return false;
	}


}
