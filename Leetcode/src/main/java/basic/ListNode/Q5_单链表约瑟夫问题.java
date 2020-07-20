package basic.ListNode;

import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/1
 * @description
 */
public class Q5_单链表约瑟夫问题 {
	//
	public ListNode solve(ListNode head, int m){
		if(head == null || m<1){
			return head;
		}
		if(m==1){
			return head;
		}
		ListNode cur = head;
		int count=1;
		while(cur.next!=cur){
			if(count == m-1){
				count = 1;
				cur.next = cur.next.next;
				cur = cur.next;
			}else {
				cur = cur.next;
				count +=1;
			}
		}
		return cur;
	}

	// TODO : 进阶解法

	@Test
	public void test(){
		ListNode head = ListNodeUtil.getCircle();
		System.out.println(solve(head,3).val);
	}
}
