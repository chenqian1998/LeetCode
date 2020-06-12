package basic.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/15
 * @description
 */
public class QuickSort {

	public int partition(int[] arr, int start, int end) {
		// 以这个下标的值作为区分,int pivot = start; 不能以下标作为区分，因为下标一致会变化。
		int pivot_val = arr[start];
		int i = start;
		int j = end;

		while (i < j) {
			while (i < j && arr[j] >= pivot_val) {
				j--;
			}
			arr[i] = arr[j];

			while (i < j && arr[i] <= pivot_val) {
				i++;
			}
			arr[j] = arr[i];
		}
		arr[i] = pivot_val;
		return i;
	}

	public void quick_sort_core(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			quick_sort_core(arr, start, pivot - 1);
			quick_sort_core(arr, pivot + 1, end);
		}
	}

	public void quick_sort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		quick_sort_core(arr, 0, arr.length - 1);
	}

	@Test
	public void test() {
		int[] arr = {5, 2, 1, 4, 3};

		quick_sort(arr);

		System.out.println(Arrays.toString(arr));

	}


}
