package 场景题.structure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BasicPriorityQueue {
    private String[] table;

    private int capacity;

    private int size;

    private Comparator<String> comparator;

    public BasicPriorityQueue(int capacity, Comparator<String> comparator) {
        this.capacity = capacity;
        table = new String[capacity];
        size = 0;
        this.comparator = comparator;
    }

    public void add(String val) {
        int i = size;
        if (i >= capacity) {
            // 扩容处理
        }
        size += 1;
        // 在 下标i 放下val
        if (i == 0) {
            table[i] = val;
        } else {
            siftUp(i, val);
        }
    }

    public void siftUp(int i, String val) {
        while (i>0){
            int p_index = (i-1) >> 1;
            String p_data = table[p_index];
            if (comparator.compare(p_data,val) >= 0){
                break;
            }else {
                table[i] = p_data;
                i = p_index;
            }
        }
        table[i] = val;
    }

    public void print() {
        for (String s : table) {
            if ("".equals(s) || s == null) {
                break;
            }
            System.out.print(s);

        }
        System.out.println();
    }


    public static void main(String[] args) {
        BasicPriorityQueue maxHeap = new BasicPriorityQueue(10, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        maxHeap.add("a");
        maxHeap.add("b");
        maxHeap.print();

        maxHeap.add("c");
        maxHeap.print();

        maxHeap.add("f");
        maxHeap.add("g");
        maxHeap.add("z");
        maxHeap.print();

        PriorityQueue queue = new PriorityQueue();
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
    }
}
