package basic.ListNode;

import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

import java.util.HashSet;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q12_删除单链表中重复出现的节点 {
	/**
	 * 保留一个重复的值，有一个比较大的问题，题目的要求是所有的重复值，不仅仅是相连的。。。。。
	 */
	public void removeDuplication(ListNode head) {
		if (head == null) {
			return;
		}

		HashSet<Integer> set = new HashSet<>();
		ListNode pre = head;
		ListNode cur = head.next;
		set.add(head.val);

		while (cur != null) {
			if(set.contains(cur.val)){
				pre.next = cur.next;
			}else {
				set.add(cur.val);
				pre = cur;
			}
			cur = cur.next;
		}

	}

	/**
	 * 还是想之前删除连续的重复的值
	 *
	 * @param head
	 * @return
	 */
	public ListNode delDuplicateNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.next.val == cur.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}


	@Test
	public void test() {
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

		ListNode head = delDuplicateNode(a);
		ListNodeUtil.printListNode(head);

	}
}
