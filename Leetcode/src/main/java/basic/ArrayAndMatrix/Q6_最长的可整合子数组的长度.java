package basic.ArrayAndMatrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/16
 * @description
 */
public class Q6_最长的可整合子数组的长度 {

	public int solve(int[] arr) {
		int length = arr.length;
		int maxLen = 0;
		int partMax = 0;
		int partMin = 0;
		HashSet<Integer> set = new HashSet<>();

		// 这里就是判断从 arr[i...j] 这个区间内是否是可整合的
		for (int i = 0; i < length; i++) {
			partMax = Integer.MIN_VALUE;
			partMin = Integer.MAX_VALUE;
			for (int j = i + 1; j < length; j++) {
				if(set.contains(arr[j])){
					break;
				}
				set.add(arr[j]);
				partMax = Math.max(partMax,arr[j]);
				partMin = Math.min(partMin,arr[j]);
				if(partMax - partMin == j - i){
					maxLen = Math.max(maxLen,j-i+1);
				}
			}
			set.clear();
		}
		return maxLen;
	}


	@Test
	public void test() {
		int[] arr = {5, 6, 7, 0, 1, 3, 4, 2, 1};
		int[] newArr = Arrays.copyOfRange(arr, 0, 3);
		System.out.println(Arrays.toString(newArr));
	}
}
