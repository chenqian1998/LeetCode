package basic.ArrayAndMatrix;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/16
 * @description
 */
public class Q4_需要排序的最短子数组长度 {
	public int getMinLength(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int length = arr.length;
		int min = arr[length - 1];
		int noMinIndex = -1;

		for (int i = length - 2; i >= 0; i--) {
			if (arr[i] > min) {
				noMinIndex = i;
			} else {
				min = Math.min(min, arr[i]);
			}
		}
		if (noMinIndex == -1) {
			return 0;
		}

		int max = arr[0];
		int noMaxIndex = -1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < max) {
				noMaxIndex = i;
			}else {
				max = Math.max(max,arr[i]);
			}
		}
		return noMaxIndex - noMinIndex + 1;
	}
}
