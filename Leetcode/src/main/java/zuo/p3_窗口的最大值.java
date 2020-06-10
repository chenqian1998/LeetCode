package zuo;

import java.util.LinkedList;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/8
 * @description 老经典的一道题目了, label : 滑动窗口
 * <p>
 * 【5，4，1，2，6】 window_size = 3
 * 最大值窗口： [5,4,6]
 * 求这个最大窗口
 */
public class p3_窗口的最大值 {

	public int[] solve(int[] arr, int size) {
		int length = arr.length - size + 1;

		int[] maxArr = new int[length];

		// 提高便利数组的速度，使用双端队列的结构,其实就是类似python里面list,模拟窗口
		// 几个限制啊：
		// 向窗口里面添加元素的规则：
		//    添加： 首先要保证窗口大小 <= size，
		// 					然后，这个元素和队列尾的元素比较
		//							如果这个元素小，[5,4,,,] , 到了4，可能5出去之后，4成为最大的那个，所以其实是要保留加在最后
		//              如果这个元素大 【5,4,1,2.] 到了2，首先是这个5要出去啊，由于都在同一个框内，所以1在后面是不可能成为最大值的，去掉1，加入2
		LinkedList<Integer> window = new LinkedList<>();
		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			// 加入元素的逻辑
			while (window.size() > 0 && arr[window.peekLast()] <= arr[i]) {
				window.pollLast();
			}

			window.addLast(arr[i]);
			if (window.peekFirst() == i - size) {
				window.pollFirst();
			}
			if (i >= size - 1) {
				maxArr[index++] = arr[window.peekFirst()];
			}

		}

		return maxArr;


	}

}
