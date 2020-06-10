import 场景题.structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 多个链表排序 {
    public static void main(String[] args) {
        createPriorityQueue();
    }

    private static void createPriorityQueue() {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            // 返回值
            public int compare(ListNode o1, ListNode o2) {
                return o1.value - o2.value;
            }
        });

        minHeap.add(new ListNode(10));
        minHeap.add(new ListNode(1));
        minHeap.add(new ListNode(100));
        ListNode poll = minHeap.poll();
        System.out.println(poll.value);

        String s1 = "aa";
        String s2 = "aa";
        System.out.println(s1.hashCode() == s2.hashCode());
        String s3 = new String("aa");
        System.out.println(s1.hashCode() == s3.hashCode());
    }
}
