package basic.ListNode;

import org.junit.Test;
import structure.ListNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/30
 * @description
 */
public class Q3_删除链表的中间节点 {
	public ListNode solve(ListNode head){
		if(head == null){
			return head;
		}
		// slow 和 fast 的初始化是怎么做的
		ListNode slow = head;
		ListNode fast = head.next.next;

		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		// 现在这个slow 就是位于中间节点前一个位置
		slow.next = slow.next.next;

		return head;
	}


	public ListNode solve2(ListNode head,int a, int b){
		int length = 0;
		while(head!=null){
			length+=1;
			head = head.next;
		}

		int K = (int) Math.ceil(a / b * length);
		// 删除第K个节点

		if(K == 1){
			return head.next;
		}
		if(K>1){
			ListNode cur = head;
			while (K>1){
				cur = cur.next;
				K--;
			}
			cur.next = cur.next.next;
		}
		return null;
	}

	@Test
	public void test01(){
		double val = 0.7;
		System.out.println(Math.ceil(0.7));
		System.out.println((int)val);
	}

}
