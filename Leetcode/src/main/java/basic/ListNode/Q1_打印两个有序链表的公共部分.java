package basic.ListNode;

import structure.ListNode;

import java.util.List;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/30
 * @description
 */
public class Q1_打印两个有序链表的公共部分 {

	public void printCommonPart(ListNode head1, ListNode head2){
		if(head1 == null || head2 == null){
			return;
		}
		ListNode cur1 = head1;
		ListNode cur2 = head2;

		while(cur1!=null && cur2!= null){
			if(cur1.val < cur2.val){
				cur1 = cur1.next;
			}else if(cur1.val > cur2.val){
				cur2 = cur2.next;
			}else{
				System.out.println(cur1.val);
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
		}

	}

}
