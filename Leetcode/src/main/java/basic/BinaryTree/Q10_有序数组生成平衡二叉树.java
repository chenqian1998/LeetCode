package basic.BinaryTree;

import structure.TreeNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q10_有序数组生成平衡二叉树 {
	/**
	 * 主要是既是平衡的，又是搜索二叉树，只能从中间切分，这样才能保证二叉树是平衡的
	 *
	 * @param sortedArr
	 * @return
	 */
	public TreeNode generateTree(int[] sortedArr) {
		return generate(sortedArr, 0, sortedArr.length - 1);
	}

	private TreeNode generate(int[] sortedArr, int start, int end) {
		// 注意等于的情况
		if(start > end){
			return null;
		}

		int mid = start + ((end - start) >> 1);
		TreeNode root = new TreeNode(mid);
		root.left = generate(sortedArr, start, mid - 1);
		root.right = generate(sortedArr, mid + 1, end);
		return root;

	}
}
