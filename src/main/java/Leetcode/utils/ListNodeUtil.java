package Leetcode.utils;

import Leetcode.structure.ListNode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/6
 * @description
 */
public class ListNodeUtil {
    public static ListNode getSimpleExample(){
        // 5->2->3->1->4
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;
        //d.next = e;

        return a;
    }

    public static void printListNode(ListNode head){
        ListNode temp = head;
        while (true){
            if (temp.next == null){
                System.out.print(temp.val);
                break;
            }
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
