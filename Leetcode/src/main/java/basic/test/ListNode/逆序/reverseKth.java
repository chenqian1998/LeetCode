package basic.test.ListNode.逆序;

import org.junit.Test;
import org.junit.jupiter.api.io.TempDir;
import structure.ListNode;
import utils.ListNodeUtil;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/8
 * @description
 */
public class reverseKth {

	public ListNode partReverse(ListNode head, int start, int end){
		ListNode pre = new ListNode(-1);
		pre.next = head;

		ListNode temp = pre;
		for(int i=0; i<start; i++){
			pre = pre.next;
		}

		ListNode cur = pre.next;

		for(int i = start; i<end; i++){
			ListNode next = cur.next;
			cur.next = next.next;

			ListNode reveredFirst = pre.next;
			next.next = reveredFirst;
			pre.next = next;
		}
		return temp.next;

	}

	public ListNode reverseKth(ListNode head){
		int k = 2;
		int length = 0;
		ListNode cur = head;
		while(cur!=null){
			cur = cur.next;
			length++;
		}
		int times = length/k;

		for(int i=0; i<times; i++){
			head = partReverse(head, i*k, (i+1)*k-1);
		}
		return head;

	}

	@Test
	public void test(){
		ListNode head = ListNodeUtil.getSimpleExample();
		ListNodeUtil.printListNode(head);
		ListNodeUtil.printListNode(reverseKth(head));
	}

}
