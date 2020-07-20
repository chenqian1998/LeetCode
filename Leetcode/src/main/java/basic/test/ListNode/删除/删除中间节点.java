package basic.test.ListNode.删除;

import org.junit.Test;
import structure.ListNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/8
 * @description
 */
public class 删除中间节点 {
	public ListNode delMid(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// 这样可以定义到中点的左边的
		ListNode pre = head;
		ListNode cur = head.next.next;
		while (cur.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		return head;
	}

	public ListNode delab(ListNode head, int a, int b) {
		int r = a / b;
		if (head == null || r == 0 || r > 1) {
			return head;
		}
		int length = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			length++;
		}
		// 看区间的问题 (0,1/5] , 如果直接a / b * length 这样边界就会出问题，向上取整的话就很不错
		int k = (int) Math.ceil(a / b * length);

		if (k == 1) {
			return head.next;
		}

		cur = head;
		// 这就很尴尬，在边界的处理上，k=2 , k=5 不太好处理
		for (int i = 0; i < k - 2; i++) {
			cur = cur.next;
		}
		cur.next = cur.next.next;

		return head;
	}

	@Test
	public void test(){
		for(int i=0; i<0;i++){
			System.out.println("aa");
		}
	}

}
