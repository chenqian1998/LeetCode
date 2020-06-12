package basic.ListNode;

import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/12
 * @description
 */
public class SortListNode {
	// 一个非常适合链表排序的算法就是 merge_sort
	// 先确定中点
	public ListNode mergeSortCore(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode mid = slow.next;
		slow.next = null;

		// 其实现在就是两个链表 head --->slow ;  mid ---->last
		ListNode node1 = mergeSortCore(head);
		ListNode node2 = mergeSortCore(mid);

		// node1, node2两个链表都已经排好序了
		ListNode pre = new ListNode(-1);
		ListNode temp = pre;

		while (node1 != null && node2 != null) {
			if (node1.val <= node2.val) {
				pre.next = node1;
				pre = node1;
				node1 = node1.next;
			} else {
				pre.next = node2;
				pre = node2;
				node2 = node2.next;
			}
		}
		// 最后还有一部分
		pre.next = node1 != null ? node1 : node2;

		// 返回的是组成整个有序链表的头节点
		return temp.next;

	}

	@Test
	public void test() {
		ListNode head = ListNodeUtil.getSimpleExample();
		ListNodeUtil.printListNode(head);

		ListNode listNode = mergeSortCore(head);
		ListNodeUtil.printListNode(listNode);
	}

}
