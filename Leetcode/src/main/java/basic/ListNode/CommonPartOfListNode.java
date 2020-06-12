package basic.ListNode;

import structure.ListNode;

import java.util.Stack;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/12
 * @description 两个链表是否相交的一系列问题
 */
public class CommonPartOfListNode {
	/**
	 * 是否有公共部分，有的话返回第一个相交的节点
	 * @param head1
	 * @param head2
	 * @return
	 */
	public ListNode hasCommonPart(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return head1 != null ? head1 : head2;
		}
		if (head1 == head2) {
			return head1;
		}
		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();

		while (head1!=null){
			stack1.push(head1);
			head1 = head2.next;
		}

		while (head2!=null){
			stack2.push(head2);
			head2 = head2.next;
		}

		if (stack1.peek() != stack2.peek()){
			return null;
		}else {
			// 两个栈一起pop()，第一个不想等的地方，下一个节点就是
			while (true){
				ListNode val1 = stack1.pop();
				ListNode val2 = stack2.pop();
				if (val1 != val2){
					return val1.next;
				}
			}
		}

	}

}
