package basic.BinaryTree;

import structure.TreeNode;

import java.util.Stack;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q1_遍历 {
	public void preOrder(TreeNode root){
		if(root == null){
			return;
		}
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	public void preOrderNoRecur(TreeNode root){
		if(root == null){
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			System.out.println(cur.val);

			if(cur.right!=null){
				stack.push(cur.right);
			}
			if(cur.left!=null){
				stack.push(cur.left);
			}
		}
	}


	public void midOrder(TreeNode root){
		if(root == null){
			return ;
		}
		midOrder(root.left);
		System.out.println(root.val);
		midOrder(root.right);
	}


	public void midOrderNoRecur(TreeNode root){
		if(root == null){
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;

		while(!stack.isEmpty() || cur!=null){
			if(cur!=null){
				stack.push(cur);
				cur = cur.left;
			}else {
				cur = stack.pop();
				System.out.println(cur.val);
				cur = cur.right;
			}
		}
	}

}
