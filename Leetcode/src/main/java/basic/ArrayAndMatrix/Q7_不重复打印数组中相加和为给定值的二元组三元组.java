package basic.ArrayAndMatrix;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/17
 * @description 注意到原数组已经有序
 */
public class Q7_不重复打印数组中相加和为给定值的二元组三元组 {
	public void solve(int[] arr, int aim) {
		int length = arr.length;
		int start = 0;
		int end = length - 1;
		int sum = 0;

		while (start < end) {
			sum = arr[start] + arr[end];
			if (sum < aim) {
				start++;
			} else if (sum > aim) {
				end--;
			} else {
				System.out.println(arr[start] + " + " + arr[end] + " = " + aim);
				start++;
				end--;
			}
		}
	}


	public void solve2(int[] arr, int aim) {
		int length = arr.length;
		int start = 0;
		int end = length - 1;
		int sum = 0;

		for (int i = 0; i < length; i++) {
			int target = aim - arr[i];
			start = i + 1;
			end = length - 1;

			while (start < end) {
				sum = arr[start] + arr[end];
				if (sum < target) {
					start++;
				} else if (sum > target) {
					end--;
				} else {
					System.out.println(arr[i] + " + " + arr[start] + " + " + arr[end] + " = " + aim);
					start++;
					end--;
				}
			}
		}
	}


	@Test
	public void test() {

	}
}
