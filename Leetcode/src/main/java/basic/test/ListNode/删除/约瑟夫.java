package basic.test.ListNode.删除;

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
public class 约瑟夫 {
	public ListNode solve(ListNode head, int m) {
		ListNode cur = head;
		if(m == 1){
			ListNode last = head;
			while(last != head){
				last = last.next;
			}
			return last;
		}
		int k = m-2;
		while (cur.next!=cur) {
			if(k == 0){
				cur.next = cur.next.next;
				cur = cur.next;
				k = m-2;
			}else {
				cur = cur.next;
				k--;
			}
		}
		return cur;
	}



	@Test
	public void test(){
		ListNode head = ListNodeUtil.getCircle();
		System.out.println(solve(head,2).val);
	}
}
