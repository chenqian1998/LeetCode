package basic.ListNode;

import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q11_单链表每K个节点之间逆序 {
	/**
	 * 不要理解成
	 *
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKth(ListNode head, int k) {

		int start = 0;
		int end = k - 1;
		ListNode cur = head;
		int length = 0;
		while (cur != null) {
			cur = cur.next;
			length++;
		}
		int times = length / k;
		ListNode temp = null;
		for (int i = 0; i < times; i++) {
			if (i == 0) {
				temp = partReverse(head, i * k, (i + 1) * k - 1);
			} else {
				// 下面这个开头的是temp，这个细节没有捕获到
				partReverse(temp, i * k, (i + 1) * k - 1);
			}
		}

		return temp;
	}


	/**
	 * @param head
	 * @param start 从0开始
	 * @param end
	 * @return
	 */
	public ListNode partReverse(ListNode head, int start, int end) {
		if (start >= end) {
			return head;
		}
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode temp = pre;

		// pre是start的前一个位置
		for (int i = 0; i < start; i++) {
			pre = pre.next;
		}

		// cur 是start的位置
		ListNode cur = pre.next;

		// cur 到达start的前一个位置
		for (int i = start; i < end; i++) {
			ListNode next = cur.next;
			cur.next = next.next;

			ListNode reverseFirst = pre.next;
			next.next = reverseFirst;
			pre.next = next;
		}
		return temp.next;
	}

	@Test
	public void test() {
		ListNode head = ListNodeUtil.getSimpleExample();
		ListNodeUtil.printListNode(head);
		head = partReverse(head, 0, 1);
		partReverse(head, 2, 3);
		ListNodeUtil.printListNode(head);
	}

	@Test
	public void test1() {
		ListNode head = ListNodeUtil.getSimpleExample();
		ListNodeUtil.printListNode(head);
		//head = reverseKth(head, 2);
		head = reverseKth(head, 3);
		ListNodeUtil.printListNode(head);
	}
}
