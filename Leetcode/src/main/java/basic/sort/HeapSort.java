package basic.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/28
 * @description
 */
public class HeapSort {
	public final char[] arr = {'5', '1', '4', '3', '2'};

	@Test
	public void heapSort() {
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}

		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, 0, i);
			adjustHeap(arr, 0, i);
		}
		System.out.println(Arrays.toString(arr));
	}


	private void adjustHeap(char[] chas, int i, int size) {
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int largest = i;
		while (left < size) {
			if (chas[left] > chas[i]) {
				largest = left;
			}
			if (right < size && chas[right] > chas[largest]) {
				largest = right;
			}
			if (largest != i) {
				swap(chas, largest, i);
			}else {
				break;
			}
			i = largest;
			left = i * 2 + 1;
			right = i * 2 + 2;
		}

	}


	public void heapInsert(char[] arr, int i) {
		int parent = 0;
		while (i != 0) {
			parent = (i - 1) / 2;
			if (arr[parent] < arr[i]) {
				swap(arr, parent, i);
				i = parent;
			} else {
				break;
			}
		}
	}

	public void swap(char[] chas, int index1, int index2) {
		char temp = chas[index1];
		chas[index1] = chas[index2];
		chas[index2] = temp;
	}

}
