package basic.BinaryTree;

import org.junit.Test;
import structure.TreeNode;
import utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q4_序列化反序列化 {


	/**
	 *
	 * 	 *      10
	 * 	 *   5			15
	 * 	 * 1   6  3    16
	 * 	 * 						11  1
	 * 比如上面其实就是先返回== 1 null null
	 * 6 null null
	 * 然后和5平起来
	 * 5 1 null null 6 null null
	 * @param root 遍历到root节点
	 * @return	返回这个节点序列化的结果
	 */
	public String serialByPre(TreeNode root){
		if(root == null){
			return "null ";
		}
		String res = root.val + " ";
		// 先序遍历
		res += serialByPre(root.left);
		res += serialByPre(root.right);
		return res;
	}

	public TreeNode reconByPreString(String s){
		String[] strs = s.split(" ");

		// LinkedList 实现了queue这个接口
		Queue<String> queue = new LinkedList<>();
		for(int i=0; i<strs.length; i++){
			queue.add(strs[i]);
		}
		return reconPreOrder(queue);

	}

	public TreeNode reconPreOrder(Queue<String> queue){
		String s = queue.poll();
		if(s.equals("null")){
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(s));
		root.left = reconPreOrder(queue);
		root.right = reconPreOrder(queue);
		return root;
	}

	@Test
	public void test(){
		TreeNode root = TreeUtils.getExsample();
		String s = serialByPre(root);
		TreeUtils.levelOrder(reconByPreString(s));
	}
}
