package zuo;

import org.junit.Test;
import structure.TreeNode;

import java.util.ArrayList;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/17
 * @description
 *
 * 经典永流传，本质上就是左子树上的最大值要小
 * 					右子树上的最小值要大
 */
public class p8_是否是二叉搜索树 {

	public TreeNode maxNodeInLeftTree(TreeNode node){
		while(node.right != null){
			node = node.right;
		}
		return node;
	}

	public TreeNode minNodeInRightTree(TreeNode node){
		while (node.left!=null){
			node = node.left;
		}
		return node;
	}


	/**
	 * 这个方法还有问题
	 * TODO : 递归怎么实现
	 * @param root
	 * @return
	 */
	public boolean solve(TreeNode root){
		if (root == null){
			return true;
		}
		if(root.left == null || root.right == null){
				return true;
		}
		// 左子树的最大值
		TreeNode leftMax = maxNodeInLeftTree(root.left);
		TreeNode rightMin = minNodeInRightTree(root.right);

		if (root.val <= leftMax.val || root.val >= rightMin.val){
			return false;
		}
		return solve(root.left) && solve(root.right);

	}


	private ArrayList<Integer> res = new ArrayList<>();

	public boolean solve2(TreeNode root){
		// 比较取巧的一个方式是中序遍历，应该是严格递增的
		// 左 ==》 根 ==》 右

		midOrder(root,res);

		System.out.println(res);

		// 判断res是严格递增？？
		for(int i=1; i<res.size(); i++){
			if((res.get(i) - res.get(i-1)) <= 0){
				return false;
			}
		}
		return  true;
	}

	private void midOrder(TreeNode root, ArrayList<Integer> res) {
		if (root == null){
			return ;
		}
		midOrder(root.left,res);
		res.add(root.val);
		midOrder(root.left, res);
	}

	@Test
	public void test(){
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(4);

	}



}
