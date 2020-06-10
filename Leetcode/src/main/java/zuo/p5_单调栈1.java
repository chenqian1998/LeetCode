package zuo;

import org.junit.Test;
import utils.PrintUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/10
 * @description 又是很经典的一道题目，太经典了，这种题目要一下子清楚过程，核心的逻辑
 * <p>
 * [3,5,2,4,6,0,1,5] 找到每个元素 左边最近的大于这个元素的数
 * num   左边最近  右边最近
 * 3			null			5
 * 5 			null  		6
 * 2			5					4
 * <p>
 * 关键是能否O(N)时间复杂度做到？？？， 显然暴力的方法是O(N^2)
 * <p>
 * solution:
 * 所谓的单调栈，其实很简单，就是一个栈，添加元素的时候保证栈从小到大，或者，从大到小。
 * 比如这里栈底到栈顶，设置成一个从大到小的结构。
 * 核心就在：
 * （1）添加一个元素，比栈顶元素大，破坏了从小到大的结构，
 * 那么其实可以得出结论：使得这个结构破坏的元素，一定是比栈顶元素大，栈顶元素左边比他大的，就是他底部的
 */
public class p5_单调栈1 {

	public void solve(int[] arr) {
		// 其实可以分成两步，先算出每个数字右边比这个大的最近的是哪个
		Stack<List<Integer>> stack = new Stack<>();
		int length = arr.length;

		int[][] res = new int[length][2];
		// res[i][0] 这个数字左边最近的大数
		// res[i][1] 				右边
		Arrays.fill(res[0],-1);
		Arrays.fill(res[1],-1);

		for (int i = 0; i < length; i++) {
			if (stack.empty()) {
				stack.push(Arrays.asList(new Integer(i)));
			} else {
				System.out.println(stack);

				if (arr[i] < arr[stack.peek().get(0)]) {
					stack.push(Arrays.asList(new Integer(i)));
				} else if (arr[i] == arr[stack.peek().get(0)]) {
					List<Integer> list = stack.peek();
					list.add(i);
				} else {

					// 这应该是while循环的
					while (!stack.empty() && stack.peek().get(0) < arr[i]) {
						// 入栈元素比栈顶元素大
						List<Integer> integers = stack.pop();
						for (Integer integer : integers) {
							// integer的右边较大的最近是i
							res[integer][1] = i;
							// integer左边较大的是下面这个
							if (!stack.isEmpty()) {
								res[integer][0] = stack.peek().get(0);
							}
						}
					}
					stack.push(Arrays.asList(new Integer(i)));
				}
			}
		}
		PrintUtil.print(res);
	}

	@Test
	public void test() {
		Integer[] arr = {5, 2, 1, 4};

		List<Integer> integers = Arrays.asList(arr);
		System.out.println(integers);
		System.out.println(integers.size());

		int[] arr2 = {1, 2, 3, 4};
		List<int[]> list = Arrays.asList(arr2);
		System.out.println(list);
		System.out.println(list.size());

		List<Integer> integers1 = Arrays.asList(new Integer(3));
		System.out.println(integers1);

	}

	@Test
	public void test02(){
		int[] arr = {5,4,2,1,4};
		solve(arr);
	}


	public static void main(String[] args){
		//3 1 3 4 3 5 3 2 2
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		String[] arr = sc.nextLine().split(" ");
		Stack<ArrayList<Integer>> s = new Stack<>();
		ArrayList<Integer> al;
		String[] res = new String[n];
		//遍历
		for(int i=0; i<n; i++){
			if(s.isEmpty()){
				s.push(new ArrayList<Integer>());
				s.peek().add(i);
			}
			else{
				//压入当前位置i后还要保证栈底到栈顶对应元素非递减
				int stackTop = Integer.valueOf(arr[s.peek().get(0)]);
				int curr = Integer.valueOf(arr[i]);
				if(stackTop < curr){
					s.push(new ArrayList<Integer>());
					s.peek().add(i);
				}
				else if(stackTop == curr){
					s.peek().add(i);
				}
				//不能保证的话,就要先弹出, 直到栈空或者能保证严格递增后再压入i
				else{//stackTop > curr
					while(!s.isEmpty() && stackTop > curr){
						al = s.pop();
						for(int j=0; j<al.size(); j++){
							res[al.get(j)] = s.isEmpty() ? "-1 " + i : s.peek().get(s.peek().size()-1) + " " + i;
						}
						if(s.isEmpty())
							break;
						else
							stackTop = Integer.valueOf(arr[s.peek().get(s.peek().size()-1)]);
					}
					//栈不为空 同时 curr和栈顶代表的元素相等, 将curr的索引加入的栈顶元素中
					if(!s.isEmpty() && Integer.valueOf(arr[s.peek().get(0)]) == curr)
						s.peek().add(i);
						//否则的话就得新创建个ArrayList
					else{
						s.push(new ArrayList<Integer>());
						s.peek().add(i);
					}
				}
			}
		}
		//遍历结束, 开始清算
		while(!s.isEmpty()){
			al = s.pop();
			for(int i=0; i<al.size(); i++){
				//注意是处理res的那个索引!
				res[al.get(i)] = s.isEmpty()? "-1 -1" : s.peek().get(s.peek().size()-1) + " -1";
			}
		}
		//打印结果
		for(int i=0; i<res.length; i++)
			System.out.println(res[i]);
	}


}
