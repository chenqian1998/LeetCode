package basic.test.ListNode.删除;

import structure.ListNode;

import java.util.Stack;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/8
 * @description
 */
public class 删除num相等的所有节点 {
	public ListNode del(ListNode head, int num){
		if(head == null){
			return head;
		}
		Stack<ListNode> stack = new Stack<>();
		ListNode cur = head;

		while (cur!=null){
			stack.push(cur);
			cur = cur.next;
		}

		// cur已经到了最后的null了
		while(!stack.isEmpty()){
			ListNode node = stack.peek();
			node.next = cur;
			cur = stack.pop();
		}
		return cur;
	}
}
