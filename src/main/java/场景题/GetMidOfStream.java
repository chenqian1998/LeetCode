package 场景题;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 数据流中的中位数，往往需要提供接口
 * add(E e) getMid()
 *
 * @author liulixiashu
 */

interface StreamMid {
    // 添加数据
    public void add(Integer integer);

    // 得到数据流的中位数
    public Double gteMid();
}


public class GetMidOfStream implements StreamMid {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(10);
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private int count = 0;

    @Test
    public void test() {
        maxHeap.add(100);
        maxHeap.add(1);
        maxHeap.add(1000);
        System.out.print(maxHeap);
    }

    @Override
    public void add(Integer integer) {
        if ((count & 1) == 0) {
            // 向左边的最大堆添加
            // 有个问题要注意，如果这个数很大，其实应该放在右边的最小堆
            if (minHeap.size() > 0 && integer > minHeap.peek()) {
                Integer val = minHeap.poll();
                minHeap.add(integer);
                maxHeap.add(val);
            } else {
                maxHeap.add(integer);
            }
        } else {
            // 向右边最小堆添加元素
            if (integer < maxHeap.peek()) {
                Integer min = minHeap.poll();
                minHeap.add(integer);
                maxHeap.add(min);
            } else {
                minHeap.add(integer);
            }
        }
        count += 1;
    }

    @Override
    public Double gteMid() {
        Double val = null;
        if ((count & 1) == 1) {
            val = (double) maxHeap.peek();
        } else {
            val = (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return val;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GetMidOfStream stream = new GetMidOfStream();

        while (true) {
            int i = scanner.nextInt();
            stream.add(i);
            System.out.println("数据流中的中位数是：" + stream.gteMid());
        }
    }
}
