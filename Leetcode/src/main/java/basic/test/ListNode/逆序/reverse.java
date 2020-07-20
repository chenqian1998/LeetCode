package basic.test.ListNode.逆序;

import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/8
 * @description
 */
public class reverse {
	public ListNode reverse(ListNode head){
		ListNode cur = head;
		ListNode pre = null;

		while(cur!=null){
			ListNode next = cur.next;
			cur.next = pre;

			pre = cur;
			cur = next;
		}
		return pre;
	}

	@Test
	public void test(){
		ListNodeUtil.printListNode(ListNodeUtil.getSimpleExample());
		ListNodeUtil.printListNode(reverse(ListNodeUtil.getSimpleExample()));
	}


}
