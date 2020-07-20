package basic.test.TreeNode.遍历.先序遍历;

import org.junit.Test;
import structure.ListNode;
import structure.TreeNode;
import utils.PrintUtil;
import utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/8
 * @description
 */
public class 序列化 {
	public String serial(TreeNode root) {
		if (root == null) {
			return "null ";
		}
		String s = root.val + " ";
		s = s + serial(root.left);
		s = s + serial(root.right);
		return s;
	}

	public TreeNode deserial(String s) {
		String[] strs = s.split(" ");
		Queue<String> queue = new LinkedList<>();
		for (int i = 0; i < strs.length; i++) {
			queue.add(strs[i]);
		}
		TreeNode root = process(queue);
		return root;
	}

	public TreeNode process(Queue<String> queue) {
		if ("null".equals(queue.peek())) {
			queue.poll();
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(queue.poll()));
		root.left = process(queue);
		root.right = process(queue);
		return root;
	}


	@Test
	public void test() {
		TreeNode root = TreeUtils.getExsample();
		String s = serial(root);
		System.out.println(s);

		TreeNode a = deserial(s);
		TreeUtils.levelOrder(a);

	}


}
