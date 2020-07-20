package basic.test.ListNode.逆序;

import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

import java.util.List;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/8
 * @description
 */
public class partReverse {
	public ListNode partReverse(ListNode head,int start, int end){
		if(head == null || head.next == null){
			return head;
		}
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode temp = pre;

		for(int i=0; i<start; i++){
			pre = pre.next;
		}

		ListNode cur = pre.next;
		for(int i=start; i<end; i++){
			ListNode next = cur.next;
			cur.next = next.next;

			ListNode reversedFirst = pre.next;
			pre.next = next;
			next.next = reversedFirst;
		}

		return temp.next;
	}

	@Test
	public void test(){
		ListNode head = ListNodeUtil.getSimpleExample();
		ListNodeUtil.printListNode(head);
		ListNodeUtil.printListNode(partReverse(head,1,1));

	}
}
