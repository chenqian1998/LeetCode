package basic.test.ListNode.删除;

import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

import java.awt.*;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/8
 * @description
 */
public class 删除倒数第K个 {
	public ListNode delFromLastkth(ListNode head, int k) {
		if (head == null || k <= 0) {
			return head;
		}
		ListNode fast = head;
		for (int i = 0; i < k; i++) {
			if(fast == null){
				if(i == k-1){
					return head.next;
				}else {
					return head;
				}
			}
			fast = fast.next;
		}

		ListNode slow = head;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		// slow 已经到了倒数第K个了
		slow.next = slow.next.next;

		return head;
	}

	@Test
	public void test(){
		ListNode head = ListNodeUtil.getSimpleExample();
		ListNodeUtil.printListNode(head);
		ListNodeUtil.printListNode(delFromLastkth(head,5));
	}

}
