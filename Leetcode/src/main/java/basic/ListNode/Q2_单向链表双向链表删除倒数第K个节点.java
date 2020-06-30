package basic.ListNode;

import structure.DoubleNode;
import structure.ListNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/30
 * @description
 */
public class Q2_单向链表双向链表删除倒数第K个节点 {
	/**
	 * 3 1 5 4 2   k=3
	 *
	 * @param head
	 * @param K
	 * @return
	 */
	public ListNode solve(ListNode head, int K) {
		if (head == null) {
			return null;
		}
		ListNode cur = head;
		for (int i = 0; i < K; i++) {
			cur = cur.next;
			if (cur == null && i < K - 1) {
				return head;
			}
		}
		if (cur == null) {
			return head.next;
		}
		ListNode res = head;
		while (cur.next != null) {
			cur = cur.next;
			res = res.next;
		}
		// 到达了倒数第K个节点
		res.next = res.next.next;
		return head;
	}


	public DoubleNode solve2(DoubleNode head, int K) {
		if (head == null || K < 0) {
			return head;
		}

		DoubleNode cur = head;
		for (int i = 0; i < K; i++) {
			cur = cur.next;
			if (cur == null && i < K - 1) {
				return head;
			}
		}

		if (cur == null) {
			head = head.next;
			head.pre = null;
			return head;
		}

		DoubleNode res = head;
		while (cur.next != null) {
			cur = cur.next;
			res = res.next;
		}

		// 这个其实就是定位到了倒数第K个位置的前一个位置
		DoubleNode nextNode = res.next.next;
		res.next = nextNode;
		if(nextNode!=null){
			nextNode.pre = res;
		}
		return head;
	}

}
