package basic.ListNode;

import org.junit.Test;
import structure.ListNode;
import utils.ListNodeUtil;

import java.util.Stack;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/3
 * @description
 */
public class Q10_两个链表相交的一系列问题 {
	// 1、单链表是否存在环，如果存在，环的长度，以及环的入口是那个节点,如果不存在返回null
	public ListNode isCircle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		// 这样初始化的原因是和下面走法一直
		// 而且在下面找到如环的第一个节点位置有帮助
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while (slow != fast) {
			if (fast.next == null || fast.next.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		System.out.println(fast.val);
		// slow 和fast相遇的位置应该是在环以内
		ListNode cur = head;

		// 怎么得到环的入口呢？？
		// 这个和上面的相交的信息有关
		while (slow != cur) {
			slow = slow.next;
			cur = cur.next;
		}
		return cur;
	}

	@Test
	public void test() {
		ListNode head = ListNodeUtil.getCircle();
		System.out.println(isCircle(head).val);
	}


	/**
	 * 两个无环链表，返回相交的第一个节点;
	 * 显然这种做法的时间复杂度是 O(N)
	 * 但是空间复杂度是 O(N)
	 * 有没有空间复杂度是 O(1)的做法呢，其实也是有，看书上的做法吧
	 */
	public ListNode firstCommon(ListNode head1, ListNode head2){
		if(head1 == null || head2 == null){
			return null;
		}

		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();

		while(head1!=null){
			stack1.push(head1);
			head1 = head1.next;
		}

		while(head2!=null){
			stack2.push(head2);
			head2 = head2.next;
		}

		// 依次弹出吧，然后如果有两个弹出的元素是一样的
		while(!stack1.isEmpty() && !stack2.isEmpty()){
			ListNode val1 = stack1.pop();
			ListNode val2 = stack2.pop();

			if(val1 == val2){
				return val1;
			}
		}

		return null;

	}

	public  ListNode firstCommon2(ListNode head1, ListNode head2){
		// 先判断是不是存在相交的位置？？


		// 若存在，就让长的那个向前走 长度差距
		// 这样两个相交的位置应该都是在这个位置，向前走相同步数就可以到达
		return null;
	}

}
