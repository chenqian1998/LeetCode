package basic.ListNode;

import structure.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q13_单链表删除制定值的节点 {
	// 应该是所有相同的值
	public ListNode del(ListNode head, int value){
		Stack<ListNode> stack = new Stack<>();
		ListNode cur = head;
		while (cur!=null){
			if(cur.val!=value){
				stack.add(cur);
			}
			cur = cur.next;
		}
		ListNode node = null;
		while(!stack.isEmpty()){
			  node= stack.pop();
			  node.next = cur;
			  cur = node;
		}
		return cur;
	}
}
