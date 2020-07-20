package basic.ListNode;

import structure.ListNode;

import java.util.List;

import static com.sun.tools.javac.jvm.ByteCodes.*;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/1
 * @description
 */
public class Q8_单链表pivot左边小右边大 {
	public ListNode list_partition(ListNode head, int pivot) {
		if (head == null || pivot < 0) {
			return head;
		}
		ListNode cur = head;
		int length = 0;
		while (cur != null) {
			length++;
			cur = cur.next;
		}
		ListNode[] arr = new ListNode[length];

		cur = head;
		for (int i = 0; i < length; i++) {
			arr[i] = cur;
			cur = cur.next;
		}

		return null;

	}

	public void arrPartition(ListNode[] arr, int pivot) {
		int small = -1;
		int big = arr.length;
		int index = 0;

		while (index != big) {
			if (arr[index].val < pivot) {
				swap(arr, ++small, index++);
			} else if (arr[index].val == pivot) {
				index++;
			} else {
				swap(arr, --big, index);
			}
		}
	}


	private void swap(ListNode[] arr, int i, int j) {
		ListNode temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
