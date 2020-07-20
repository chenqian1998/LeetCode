package basic.BinaryTree;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/6
 * @description 根据后序遍历
 */
public class Q14_根据后序数组重建搜索二叉树 {
	public boolean solve(int[] arr){
		return check(arr, 0, arr.length-1);
	}

	// TODO：不对
	private boolean check(int[] arr, int start, int end) {
		if(start >= end){
			return true;
		}
		int pivot = arr[end];
		int splitIndex = -1;
		for(int i = start; i<=end; i++){
			if(arr[i] > pivot){
				splitIndex = i;
				break;
			}
		}
		if(splitIndex == -1){
			return check(arr,start,end-1);
		}
		for(int i = splitIndex; i<end; i++){
			if(arr[i] <= pivot){
				return false;
			}
		}
		return check(arr,start,splitIndex-1) && check(arr,splitIndex,end-1);

	}



	@Test
	public void test(){
		//int[] arr = {2,1,3,6,5,7,4};
		int[] arr = {1,2,8,5,12,18,11,10};
		System.out.println(solve(arr));
	}
}
