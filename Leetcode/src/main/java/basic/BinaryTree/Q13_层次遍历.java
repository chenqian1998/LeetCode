package basic.BinaryTree;

import org.junit.Test;
import structure.TreeNode;
import utils.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/6
 * @description
 */
public class Q13_层次遍历 {
	public static void levelOrder(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode cur = root;
		int thisLevel = 1;
		int nextLevel = 0;
		queue.add(cur);

		while(!queue.isEmpty() && cur!=null){
			TreeNode node = queue.poll();
			System.out.print(node.val+" ");
			thisLevel--;

			if(node.left!=null){
				queue.add(node.left);
				nextLevel += 1;
			}
			if(node.right!=null){
				queue.add(node.right);
				nextLevel += 1;
			}

			if(thisLevel == 0){
				thisLevel = nextLevel;
				nextLevel = 0;
				System.out.println();
			}
		}
	}


	@Test
	public void test(){
		TreeNode root = TreeUtils.getExsample();
		levelOrder(root);
	}
}
