package utils;

import structure.TreeNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/19
 * @description
 */
public class TreeUtils {
	public static TreeNode getExsample(){
		//      	10
		//  	 5      15
		// 	2  8   	12  18
		// 1

		TreeNode a1 = new TreeNode(10);
		TreeNode a2 = new TreeNode(5);
		TreeNode a3 = new TreeNode(15);
		TreeNode a4 = new TreeNode(2);
		TreeNode a5 = new TreeNode(8);
		TreeNode a6 = new TreeNode(12);
		TreeNode a7 = new TreeNode(18);
		TreeNode a8 = new TreeNode(1);
		a1.left = a2;
		a1.right = a3;
		a2.left = a4;
		a2.right = a5;
		a3.left = a6;
		a3.right = a7;
		a4.left = a8;
		return a1;
	}
}
