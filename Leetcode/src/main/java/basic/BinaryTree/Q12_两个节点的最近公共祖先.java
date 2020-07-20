package basic.BinaryTree;

import structure.TreeNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q12_两个节点的最近公共祖先 {
	/**
	 *      10
	 *   5			15
	 * 1   6  3    16
	 * 						11  1
	 *
	 * 	3 、11
	 * @param root  遍历到这个节点
	 * @param node1
	 * @param node2
	 * @return 如果是null或者到达了root1 root2，返回root1...
	 * 				如果又一次返回的结果左右都存在其实就说明，这个节点是最近的所求
	 */
	public TreeNode lowestAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || root == node1 || root == node2) {
			return root;
		}
		// 后序遍历
		TreeNode left = lowestAncestor(root.left, node1, node2);
		TreeNode right = lowestAncestor(root.right, node1, node2);
		// 遍历到16这个节点，左边11返回的是null，1返回的是自身，所以16应该返回1
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}
}
