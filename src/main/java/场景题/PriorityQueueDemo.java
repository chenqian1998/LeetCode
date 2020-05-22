package 场景题;


import 语法.domain.Person;

import java.util.Comparator;
import java.util.PriorityQueue;

// 防止面试让我写下这个PriorityQueue
public class PriorityQueueDemo {
    private String[] table;
    private int size;
    private Comparator comparator;

    public PriorityQueueDemo(Comparator comparator) {
        this.comparator = comparator;
        size = 0;
        table = new String[10];
    }

    public void inreTableCapacity(int i) {

    }

    public void add(String s) {
        int i = size;
        if (i > table.length) {
            // 扩容
            inreTableCapacity(i);
        }
        size += 1;
        if (i == 0) {
            table[i] = s;
        } else {
            siftUp(i, s);
        }
    }

    /*
        在第i个位置加上元素s
     */
    private void siftUp(int i, String s) {
        String temp = s;
        while (i > 0) {
            int parent = (i - 1) >> 1;
            String e = table[parent];
            if (e.compareTo(s) >= 0) {
                break;
            } else {
                table[i] = e;
                i = parent;
            }
        }
        table[i] = temp;
    }

    public static void main(String[] args) {
        PriorityQueue<Person> heap = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });


    }
}
