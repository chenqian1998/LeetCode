package basic.ListNode;
import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/12
 * @description
 *
 * 在常数时间内删除一个节点
 *
 */
public class DelNode {


	public ListNode delNode(ListNode head, ListNode target){
		if (head == null || target == null){
			return head;
		}
		if (head == target){
			return head.next;
		}
		if(target.next == null){
			// 最后一个节点只能遍历
			ListNode cur = head;
			while (cur.next != target){
				cur = cur.next;
			}
			cur.next = null;
			return head;
		}
		target.val = target.next.val;
		target.next = target.next.next;
		return head;
	}


	@Test
	public void test(){
		ListNodeUtil.printListNode(ListNodeUtil.getSimpleExample());


		// 5->2->3->1->4
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(4);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;

		// 考虑删除的是
		// 头 5
		ListNode head = delNode(a,a);
		ListNodeUtil.printListNode(head);

		// 尾 4
		ListNode head1 = delNode(head,e);
		ListNodeUtil.printListNode(head1);

		// 中间的 3
		ListNode head2 = delNode(head1,c);
		ListNodeUtil.printListNode(head2);


	}
}
