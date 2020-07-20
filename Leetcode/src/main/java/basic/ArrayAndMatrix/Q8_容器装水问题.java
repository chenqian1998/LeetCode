package basic.ArrayAndMatrix;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/19
 * @description
 */
public class Q8_容器装水问题 {
	public int solve(int[] arr) {
		int res = 0;
		int length = arr.length - 1;
		for (int i = 1; i < length - 1; i++) {
			// 某个位置能装水的容量，取决于左边的最大值和右边的最大值，然后取两者中的最小值
			int leftMax = 0;
			int rightMax = 0;
			for (int j = 0; j < i; j++) {
				leftMax = Math.max(leftMax, arr[j]);
			}
			for (int j = i + 1; j < length; j++) {
				rightMax = Math.max(rightMax, arr[j]);
			}

			int height = Math.max(leftMax, rightMax) - arr[i];
			if (height < 0) {
				continue;
			} else {
				res += height;
			}
		}
		return res;
	}

	public int solve2(int[] arr) {
		// 对上面的优化，上面主要的问题在与每个位置上求解左边最大值和右边最大值的过程中，考虑把结果记下来
		int length = arr.length;
		// leftMaxArr[i] 代表的含义就是 arr[0..i] 上最大值
		int[] leftMaxArr = new int[length];
		leftMaxArr[0] = arr[0];
		for (int i = 1; i < length; i++) {
			leftMaxArr[i] = Math.max(leftMaxArr[i-1], arr[i]);
		}

		//arr[i..N-1] 上最大值
		int[] rightMaxArr = new int[length];
		rightMaxArr[length-1] = arr[length-1];
		for(int i=length-2; i>=0; i--){
			rightMaxArr[i] = Math.max(rightMaxArr[i+1], arr[i]);
		}

		int res = 0;
		for(int i=1; i<length-1; i++){
			int height = Math.max(leftMaxArr[i-1], rightMaxArr[i+1]) - arr[i];
			if(height<0){
				continue;
			}else {
				res += height;
			}
		}
		return res;
	}


}
