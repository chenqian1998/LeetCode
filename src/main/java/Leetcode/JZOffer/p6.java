package Leetcode.JZOffer;

import Leetcode.structure.ListNode;
import Leetcode.utils.ListNodeUtil;

import java.util.Stack;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/6
 * @description 从尾到头打印二叉树
 */
public class p6 {

    public static void printLast2First(ListNode head){
        Stack<ListNode> stack = new Stack<>();

        while (head != null){
            stack.add(head);
            head = head.next;
        }

        while (stack.size() > 0){
            System.out.println(stack.pop().val);
        }

    }

    public static void main(String[] args) {
        ListNode simpleExample = ListNodeUtil.getSimpleExample();
        ListNodeUtil.printListNode(simpleExample);

        printLast2First(simpleExample);

    }

}
