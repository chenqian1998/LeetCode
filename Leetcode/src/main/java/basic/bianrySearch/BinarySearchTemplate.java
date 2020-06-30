package basic.bianrySearch;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/8
 * @description
 */
public class BinarySearchTemplate {
	public int binarySearchOriggin(int[] arr, int target) {
		if (arr == null) {
			return -1;
		}
		int length = arr.length;
		if (length == 0) {
			return -1;
		}

		int start = 0, end = length - 1;


		while (start <= end) {
			int mid = start + (end - start) / 2;

			// 2.先判断是否符合结果
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				// 搜索的区间 [mid+1, end]
				start = mid + 1;
			} else {

				end = mid - 1;
			}
		}
		return -1;
	}


	public int binarySearch(int[] arr, int target) {
		int length = arr.length;

		if (length == 0) {
			return -1;
		}

		int start = 0, end = length - 1;

		// 1.严格小于，保证退出循环时条件为 start == end, 也就是只剩下一个元素没有判断
		while (start < end) {
			int mid = start + (end - start) / 2;
			// 肯定有一半是不符合的
			if (arr[mid] < target) {
				start = mid + 1;
			} else {
				// 和上面最主要的区别，就是把相等和大于归于同一种可能
				// 每次都排除一半，最后退出的条件是start == end
				end = mid;
			}
		}

		return arr[start] == target ? start : -1;
	}

	@Test
	public void test() {
		int[] arr = {1, 2, 3, 4, 5,7,8};

		System.out.println(binarySearch(arr, 3));
		System.out.println(binarySearch(arr, 0));
		System.out.println(binarySearch(arr, 5));
		System.out.println(binarySearch(arr, -1));
		System.out.println(binarySearch(arr, 6));
		System.out.println(binarySearch(arr, 10));

	}

}
