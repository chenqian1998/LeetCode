package zuo;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/8
 * @description 最大值 减去 最小值 小于或等于num 的子数组数量，要求复杂度在O(N)范围内。
 * <p>
 * [5,1,3,2,4] num = 3
 * 首先是子数组吧
 */
public class p4_滑动窗口2 {
	/**
	 * 记录下我听完课后的理解。
	 * 复杂度为O(N)，暴力的方法就不行了
	 * 仔细分析下题目含义， arr[i:j] , max - min <= num ( <= !!!),
	 * 有一个加速的逻辑：如果arr[i:j]不符合，那么右边更大的范围之内都不符合了
	 * [5,3,1,4,2] num = 2;
	 * i = 0, j= 1
	 * [5,3] OK   j+=1   sum = sum + 2 以5为起点有两个 [5], [5,3]
	 * [5,3,1] NO  i+= 1
	 * [3,1]  OK  [3], [3,1]
	 * [3,1,4]  NO  i+=1
	 * [1,4]   No  i+=1
	 * [4]   OK
	 * [4,2]  OK [4],[4,2]
	 * <p>
	 * SUM：1. 一个元素添加，如果导致差额超过num, 即范围[i : j] 满足条件，但是[i: j+1]不符合，
	 * 其实[i : j]之内任何子数组都是符合条件的，但是问题来了，之后i,j该怎么运动呢？？？
	 * 添加了j+1导致出现不符合，显而易见的是arr[j+1]是一个最小或最大值
	 * 以及，从arr[i]出发，其实最多的符合条件的子数组就到这里，之后肯定不会有了，因为已经有部分不满足了。
	 * <p>
	 * 那么下标的移动：元素添加仍符合，j+=1, 继续更新数组的最大最小值。
	 * 添加元素之后不符合了， 计算出arr[i:j] 从i出发有可能的符合条件的子数组个数是： j-i+1 个，然后i+=1,j不变
	 *
	 * @param arr
	 * @param num
	 * @return
	 */
	public int solve(int[] arr, int num) {
		int length = arr.length;

		if (length <= 1 || num < 0) {
			return -1;
		}

		int i = 0, j = 0;
		int count = 0;

		// 记录[i:j]中的最小、大值
		LinkedList<Integer> maxList = new LinkedList<>();
		LinkedList<Integer> minList = new LinkedList<>();

		while (i < length) {
			while (j < length) {

				// 下面其实是定式，意思是：双端队列的最小值结构更新
				while (!minList.isEmpty() && arr[minList.peekLast()] >= arr[j]) {
					minList.pollLast();
				}
				minList.addLast(j);

				// 最大值结构更新
				while (!maxList.isEmpty() && arr[maxList.peekLast()] <= arr[j]) {
					maxList.pollLast();
				}
				maxList.addLast(j);

				if ((arr[maxList.getFirst()] - arr[minList.getFirst()]) > num) {
					// 添加了j之后不符合，j其实不动的， i++
					break;
				}
				// 符合
				j++;
			}
			// 如果最大值所在的就是i, 因为后面要排除i,所以这一步就要把i从队列中删除
			if(maxList.peekFirst() == i){
				maxList.pollFirst();
			}
			if (minList.peekFirst() ==  i){
				minList.pollFirst();
			}

			count += j-i;
			i++;
		}
		return count;

	}


	@Test
	public void test(){
		int[] arr = {5,2,1,3,4};
		int num = 2;

		System.out.println(solve(arr, num));

	}


	@Test
	public void LinkedListDemo() {
		LinkedList<Integer> list = new LinkedList<>();

		// 添加
		list.addFirst(10);
		list.addLast(20);
		// 默认add是添加在后面！！！
		list.add(1000);
		list.add(2000);
		list.add(3000);
		list.add(4000);
		list.add(5000);
		list.add(6000);

		// 删除
		// poll()
		Integer integer = list.pollFirst();
		Integer last = list.pollLast();
		System.out.println(integer + ", " + last);
		System.out.println(list);

		// remove()
		list.removeFirst();
		list.removeLast();
		System.out.println(list);
		list.remove(1);
		System.out.println(list);

		//get
		Integer a = list.get(1);
		System.out.println(a);

	}


}
