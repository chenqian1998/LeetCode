package Leetcode.左的课堂练习;

import Leetcode.structure.ListNode;
import Leetcode.utils.ListNodeUtil;
import org.junit.Test;

import java.util.Stack;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/15
 * @description 笔试：只要过了就行
 * 面试的时候要好好沟通下，保证时间和空间的最小值
 */
public class 链表 {
    // 找出两个有序链表的公共部分
    public void getCommonPart(ListNode head1, ListNode head2) {

    }

    // 链表是否是回文结构
    public boolean isHuiWen(ListNode head) {
        // 这个如果把节点值都存在数组里面，然后判断是不是回文
        // 这个方法，特点是时间复杂度是O(N)，空间复杂度也是O(N)

        // 还有一种做法是先找到中间位置，然后把后面元素压入栈中
        // 最后，从头遍历链表，与栈中的元素比较
        ListNode slow = head;
        ListNode fast = head;

        /**
         * 其实最重要的是这个，寻找中间节点的办法
         */
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow节点就是中间的位置
        // 如果是奇数，slow正好
        // 偶数的话，slow是中间的前面一个
        //System.out.println(slow.val);

        ListNode head2 = slow.next;
        slow.next = null;

        Stack<ListNode> stack = new Stack<>();
        while (head2 != null) {
            stack.push(head2);
            head2 = head2.next;
        }
        System.out.println(stack.size());


        ListNode curNode = head;
        while (curNode != null && stack.size() > 0) {
            ListNode node = stack.pop();
            if (curNode.val != node.val) {
                return false;
            }
        }
        return true;

        // 上面这个算法就是只需要利用栈，
    }

    @Test
    public void test() {
        ListNode node = ListNodeUtil.getSimpleExample();
        ListNodeUtil.printListNode(node);
        isHuiWen(node);
    }

    // 两个链表相加
    // 3->4->5 其实代表的数字是543
    // 4->6->7->8 代表的数字是8764
    // 两个链表相加最后的结果，返回一个链表
    // https://leetcode-cn.com/problems/sum-lists-lcci/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }

        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        boolean overTen = false;

        // 1、第一个关键的是这个 ||  我之前的做法是
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int val = num1 + num2;
            if (overTen) {
                val++;
            }
            if (val > 9) {
                val = val % 10;
                overTen = true;
            } else {
                overTen = false;
            }
            pre.next = new ListNode(val);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            pre = pre.next;

        }
        if (overTen){
            pre.next = new ListNode(1);
        }
        return temp.next;
    }

    public String addStrings(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        boolean overTen = false;
        int i = num1.length()-1, j = num2.length()-1;
        // || 保证走到最后
        while(i>=0 || j>=0){
            int a = i>=0 ? (int)num1.indexOf(i) : 0;
            int b = j>=0 ? (int)num2.indexOf(i) : 0;
            int num = a+ b;
            if (overTen){
                num += 1;
                        
            }

        }
        return null;
    }

}
