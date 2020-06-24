package zuo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/11
 * @description 经典典中典：最大子矩阵的大小
 * [ 1,0,1,1,
 * 1,1,1,1,
 * 1,1,1,0]
 * 这个矩阵中全是1的矩阵的面积就是6
 */
public class p6_单调栈2 {

	/**
	 * arr [4，3，2，5，6] 代表的是高度，最后要得到这个构成的矩形的最大面积。这个又是做过的经典问题，
	 * 其实一般的想法很简单的，以每个柱的高度为基准，左右滑动，遇到比他小的就停止，这样就得到了这个高度能得到的最大面积，
	 * 所有的柱子都这样走过一边就能从中得到最大面积。
	 * <p>
	 * 4只能向右， 4>3, 就不能继续向右了，长度就是1，高度为4，面积就是4
	 * 3向左到4， 向右2小于3, 就不能继续向右了，长度就是2，高度为3，面积就是6
	 * <p>
	 * 其实这样子没必要用啥栈
	 *
	 * @param arr
	 * @return
	 */
	public int getMaxRectangleArea(int[] arr) {
		int maxArea = 0;

		for (int i = 0; i < arr.length; i++) {
			int height = arr[i];
			int length = 1;
			int index1 = i - 1;
			int index2 = i + 1;
			// 向左边走
			while (index1 > 0 && height < arr[index1]) {
				index1 -= 1;
				length += 1;
			}
			while (index2 < arr.length && height < arr[index2]) {
				index2 += 1;
				length += 1;
			}
			maxArea = Math.max((index2 - index1) * height, maxArea);

		}
		return maxArea;
	}

	public int getMaxRectangleArea2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int maxArea = 0;

		// 约定这个单调栈是从大到小？？？
		Stack<Integer> stack = new Stack<>();


		// 遍历整个数组
		for (int i = 0; i < arr.length; i++) {
			// 入栈元素小于栈顶，栈顶元素就不能往右移动了,计算一下栈顶元素的最大矩形
			// 因为栈是从大到小，下面的元素肯定是不能向左扩，那么这个元素最后确定的边界就是，底下那个元素的下标——当前元素下标的长度
			// 最核心的就是入栈元素和出战元素比较，比如我们这里约定从栈底到栈顶是要从小到大，因为大于就不能向右边扩展了，如果不是这样了
			// 就要计算了，

			while (!stack.isEmpty() && arr[i] <= arr[stack.peek()] ){
				int j = stack.pop();
				int k = stack.isEmpty()?-1:stack.peek();
				// 左边界是底下这个数字，如果没有就是-1
				// 右边界是i
				// 注意，比如3进入，违反单调性，计算4的值，index_left = -1, index_right = 1
				int curArea = (i-k-1)*arr[j];
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		// 最后，数组都已经遍历一边了，如果栈中不为null,我们约定的单调栈是从栈底到栈顶是要从小到大，所以最后变成这样
		//   4   都是下标
		//   3
		//   2
		while (!stack.isEmpty()){

			int j = stack.pop();
			int k = stack.isEmpty()?-1:stack.peek();
			// 到了这里，都是可以到达最右边的
			// 到达边界的左边是底下这个元素，这个元素是到不了的，
			// index = 4,
			int curArea = (arr.length-k-1)*arr[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return  maxArea;
	}

	@Test
	public void test01(){
		int[] arr= {4,3,2,5,6};
		System.out.println(getMaxRectangleArea2(arr));
	}

	/**
	 * 这个求最大矩形面积的问题，其实就是用第一个的做法
	 * 首先是一层层的算，其实就回到了上面算高度的问题
	 * 最后时间复杂度：O(n*m)
	 * @param matrix
	 * @return
	 */
	public int solve(int[][] matrix) {

		if(matrix == null || matrix.length == 0){
			return 0;
		}
		int length = matrix.length;

		if(matrix[0].length == 0){
			return 0;
		}
		int width = matrix[0].length;

		// 算出每一层的高度数组
		// 这一层是0，直接归0，因为求的是从这层出发，连续的1是

		int[] preArr = new int[width];
		int[] arr = new int[width];
		int maxArea = 0;

		for(int i = 0; i< length; i++){
			for(int j=0; j< width; j++){
				if (matrix[i][j] == 0){
					arr[j] = 0;
				}else {
					arr[j] = preArr[j] + 1;
				}
			}
			int area = getMaxRectangleArea2(arr);
			maxArea = Math.max(maxArea,area);
			System.out.println(Arrays.toString(arr));
			preArr = arr;
		}
		return maxArea;
	}

	@Test
	public void test02(){
		int[][] matrix = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};

		int solve = solve(matrix);
		System.out.println(solve);

	}


}
