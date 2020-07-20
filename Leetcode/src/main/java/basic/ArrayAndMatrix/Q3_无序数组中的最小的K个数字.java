package basic.ArrayAndMatrix;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/16
 * @description
 */
public class Q3_无序数组中的最小的K个数字 {

	class MyCompararator implements Comparator<Integer> {
		@Override
		public int compare(Integer a, Integer b) {
			return b-a;
		}
	}

	// 复杂度是 O( N logK)
	public int[] getMinKthByHeap(int[] arr, int k) {

		MyCompararator myCmp = new MyCompararator();

		// 最大堆
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, myCmp);

		for(int i=0; i<arr.length; i++){
			if(heap.size() < k){
				heap.add(arr[i]);
			}else {
				heap.poll();
				heap.add(arr[i]);
			}
		}


		System.out.println(heap);
		System.out.println(heap.size());
		return null;
	}

	@Test
	public void test() {
		int[] arr = {5,6,7,0,1, 3, 4, 2, 1};
		getMinKthByHeap(arr, 5);
	}
}
