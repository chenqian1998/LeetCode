package basic.ListNode;

import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

import java.util.Stack;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/1
 * @description
 */
public class Q7_判断链表是否为回文结构 {
	public boolean solve(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		// 得到中间或者中间靠右的节点, 这个方法和得到中间或者中间靠左节点的非常蕾丝
		ListNode right = head.next;
		ListNode cur = head;

		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}

		Stack<ListNode> stack = new Stack<>();
		while (right != null) {
			stack.push(right);
			right = right.next;
		}

		cur = head;
		while(!stack.empty()){
			ListNode node = stack.pop();
			if(cur.val != node.val){
				return false;
			}
			cur = cur.next;
		}
		return true;
	}

	@Test
	public void test01() {
		ListNode head = ListNodeUtil.getSimpleExample();
		solve(head);
		System.out.println(Math.ceil(2.2));
	}

}
