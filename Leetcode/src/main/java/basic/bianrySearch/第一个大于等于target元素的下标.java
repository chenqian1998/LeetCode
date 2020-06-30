package basic.bianrySearch;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/8
 * @description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * [1,2,3,5,7,10]  target = 8
 * 5存在，返回5的下标3
 * <p>
 * 8不存在，返回要插入的下标地址其实就是10的下标5
 * 11不存在，返回6
 */
public class 第一个大于等于target元素的下标 {
	/**
	 * 其实有序查找，就暗示了要二分法，这道题目就是找第一个大于等于target元素的下标，特别的不存在就返回length
	 *
	 * @param arr
	 * @param target
	 * @return
	 *[1,2,3,5,6,8] target 7
	 */
	public int fisrtBiggerNum(int[] arr, int target) {
		int length = arr.length;

		if (arr[length - 1] < target) {
			return length;
		}

		int start = 0;
		int end = length;
		// 退出条件是两者相等
		while (start < end){
			int mid = start + (end - start)/2;
			if (arr[mid] < target){
				start = mid +1;
			}else {
				end = mid;
			}
		}
		// 因为我们每次排除的都是比这个元素小的区间，保留 >= 区间
		// 最后退出循环就是因为正好是在右边区域，满足题目中条件


		return start;
	}
}
