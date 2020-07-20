package basic.test.ListNode.删除;

import structure.ListNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/8
 * @description
 */
public class O1del {
	public ListNode del(ListNode head, ListNode target) {
		if (head == null || target == null) {
			return head;
		}
		if (head == target) {
			return head.next;
		}
		// 要删除的是最后一个节点
		if (target.next == null) {
			ListNode cur = head;
			while (cur.next != target) {
				cur = cur.next;
			}
			cur.next = null;
			return head;
		}

		// O(1)删除 。。。。 不是再遍历
		target.val = target.next.val;
		target.next = target.next.next;

		return head;
	}
}
