package basic.ListNode;

import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/30
 * @description
 */
public class Q4_反转部分单向链表 {
	public ListNode reversePartList(ListNode head, int from , int to){
		// 不画图空想题目的都是SB
		if(head == null){
			return null;
		}
		ListNode pre = new ListNode(-1);
		ListNode temp = pre;
		pre.next = head;

		for(int i=0; i<from-1; i++){
			pre = pre.next;
		}
		// pre到达要开始反转的前一个位置
		ListNode cur = pre.next;

		for(int i= from; i<to; i++){
			ListNode next = cur.next;
			cur.next = next.next;

			ListNode reversedNode = pre.next;
			pre.next = next;
			next.next = reversedNode;
		}
		return temp.next;
	}

	@Test
	public void test01(){
		ListNode head = ListNodeUtil.getSimpleExample();
		ListNodeUtil.printListNode(head);

		ListNode head1 = reversePartList(head,2,4);
		ListNodeUtil.printListNode(head1);
	}

}
