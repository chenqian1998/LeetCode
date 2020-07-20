package basic.test.ListNode.删除;

import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/8
 * @description
 */
public class delDuplicate {

	/**
	 * 整个
	 *
	 * @param head
	 * @return
	 */
	public ListNode delDuplicate(ListNode head) {
		HashSet<Integer> set = new HashSet<>();
		Stack<ListNode> stack = new Stack<>();

		ListNode cur = head;
		while (cur != null) {
			if (set.contains(cur.val)) {
				cur = cur.next;
			} else {
				stack.push(cur);
				set.add(cur.val);
				cur = cur.next;
			}
		}
		cur = stack.pop();
		while(!stack.isEmpty()){
			ListNode next = stack.peek();
			next.next = cur;
			cur = stack.pop();
		}
		return cur;
	}

	@Test
	public void test(){
		Stack<Integer> stack = new Stack<>();
		// exception
		System.out.println(stack.peek() == null);
	}

	@Test
	public void test01(){
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(5);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(4);
		ListNode f = new ListNode(3);
		ListNode g = new ListNode(1);
		ListNode h = new ListNode(1);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;

		ListNode head = delDuplicate(a);
		ListNodeUtil.printListNode(head);
	}
}
