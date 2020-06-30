package basic.StringQ;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/28
 * @description
 */
public class Q5_每个字符只出现一次 {
	/**
	 * 要求时间复杂度 O(N), 空间复杂度 O(1)
	 *
	 * 其实问题就是找一个空间复杂度为O(1)的排序方法，这个指向的是堆排序
	 *
	 * @param chars
	 * @return
	 */
	public boolean isUniquel(char[] chars){
		heapSort(chars);

		System.out.println(Arrays.toString(chars));

		for(int i=1; i<chars.length; i++){
			if(chars[i] == chars[i-1]){
				return false;
			}
		}
		return true;
	}

	@Test
	public void test(){
		char[] arr = {'a','c','b','e','d','a'};
		boolean uniquel = isUniquel(arr);
		System.out.println(uniquel);
	}

	public static void heapSort(char[] arr) {
		//1.构建大顶堆
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			//从第一个非叶子结点从下至上，从右至左调整结构
			adjustHeap(arr, i, arr.length);
		}
		//2.调整堆结构+交换堆顶元素与末尾元素
		for (int j = arr.length - 1; j > 0; j--) {
			//将堆顶元素与末尾元素进行交换
			swap(arr, 0, j);
			//重新对堆进行调整
			adjustHeap(arr, 0, j);
		}

	}

	/**
	 * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
	 *
	 * @param arr
	 * @param i
	 * @param length
	 */
	public static void adjustHeap(char[] arr, int i, int length) {
		//先取出当前元素i
		char temp = arr[i];
		//从i结点的左子结点开始，也就是2i+1处开始
		for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
			//如果左子结点小于右子结点，k指向右子结点
			if (k + 1 < length && arr[k] < arr[k + 1]) {
				k++;
			}
			//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
			arr[i] = arr[k];
			if (arr[k] > temp) {
				i = k;
			} else {
				break;
			}
		}
		arr[i] = temp;//将temp值放到最终的位置
	}

	/**
	 * 交换元素
	 *
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swap(char[] arr, int a, int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
