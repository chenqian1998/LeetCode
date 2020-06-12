package basic.ListNode;

import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/12
 * @description 原地反转链表
 */
public class ReverseListNode {
	public ListNode reverseListNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;

			pre = cur;
			cur = next;
		}

		return pre;
	}


	// TODO:间隔反转

	//TODO:部分反转
	/**
	 * // 把下标索引从start到end的链表反转
	 * 如果还是按照上面的方式做的话，很容易遇见下标边界的复杂情况
	 * 有一个比较简单的技巧：把这个节点通过插入前面节点的方式
	 *
	 * 5->3->1->4->2  start = 1  end = 3 , 先找到start的前一个位置
	 *
	 * @param head
	 * @param start
	 * @param end
	 * @return
	 */
	public ListNode partReverseListNode(ListNode head, int start, int end){

		// 如果start = 0这种，按照我这个方法就没有前面一个节点，那一般可以设置一个pre节点
		ListNode pre = new ListNode(-1);
		ListNode temp = pre;
		pre.next = head;

		for (int i = 0; i < start; i++){
			pre = pre.next;
		}

		// pre已经到达 start的前一个位置
		// fisrt是第一个节点，start
		// cur节点是要插入在pre节点后面的开始位置
		ListNode cur = pre.next;

		for(int i = start; i < end; i++){
			ListNode next = cur.next;
			cur.next = next.next;

			//  通过这种方式获得要插入节点的下一个节点
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

		ListNode head1 = reverseListNode(head);
		ListNodeUtil.printListNode(head1);
	}

	@Test
	public void test1(){
		ListNode head = ListNodeUtil.getSimpleExample();
		ListNodeUtil.printListNode(head);

		ListNode head1 = partReverseListNode(head,1,3);
		ListNodeUtil.printListNode(head1);
	}
}
