package basic.ListNode;

import org.junit.Test;
import structure.ListNode;
import structure.TreeNode;
import utils.ListNodeUtil;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q9_两个单链表生成相加链表 {
	// ali 把我搞死的这题
	// 好好扣，有些细节要经常做

	public ListNode addList(ListNode head1, ListNode head2) {
		ListNode cur1 = reverseList(head1);
		ListNode cur2 = reverseList(head2);
		ListNode cur = null;
		int sum = 0;
		boolean over9 = false;
		ListNode pre = null;

		while (cur1 != null || cur2 != null) {
			int val1 = cur1 != null ? cur1.val : 0;
			int val2 = cur2 != null ? cur2.val : 0;
			sum = val1 + val2;
			if (over9) {
				sum += 1;
				over9 = false;
			}

			if (sum > 9) {
				over9 = true;
				sum = sum % 10;
			}

			cur = new ListNode(sum);
			cur.next = pre;
			pre = cur;

			cur1 = cur1 != null ? cur1.next : null;
			cur2 = cur2 != null ? cur2.next : null;
		}
		if (over9) {
			cur = new ListNode(1);
			cur.next = pre;
		}
		return cur;
	}

	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;

			// 下面2个的顺序也不能变
			pre = cur;
			cur = next;
		}
		return pre;
	}


	@Test
	public void test() {
		ListNode simpleExample = ListNodeUtil.getSimpleExample();
		ListNode simpleExample1 = ListNodeUtil.getSimpleExample();
		ListNode head = addList(simpleExample1, simpleExample);
		ListNodeUtil.printListNode(head);
	}

}
