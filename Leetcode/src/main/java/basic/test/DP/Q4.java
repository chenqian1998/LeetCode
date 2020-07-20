package basic.test.DP;

import org.junit.Test;
import utils.PrintUtil;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/2
 * @description
 */
public class Q4 {

	public int solve(int total, int start, int target, int steps) {
		return process(total, start, target, steps);
	}

	/**
	 * @param total  总共的位置数字 [1...N]
	 * @param cur    当前到达的位置
	 * @param target 目标位置
	 * @param steps  还需要走多少步
	 * @return 从当前位置，经过steps走到target位置，一共有x种走法
	 */
	private int process(int total, int cur, int target, int steps) {
		if (steps == 0) {
			return cur == target ? 1 : 0;
		}
		if (cur == 1) {
			return process(total, cur + 1, target, steps - 1);
		}
		if (cur == total) {
			return process(total, cur - 1, target, steps - 1);

		}
		return process(total, cur - 1, target, steps - 1) + process(total, cur + 1, target, steps - 1);
	}


	public int solve2(int TOTAL, int START, int TARGET, int STEPS){
		// ( cur, steps)
		//   1<=cur<=N  这个cur是定义里面说的，从1到N，所以画图的时候0其实走不到，但是暂且范围也拉长吧
		// 0<=steps<=steps  这个还是很好理解的
		// 这个DP的范围一直是我头疼的，其实就是上面的范围


		// dp[cur][steps] 代表走到cur这个位置，走steps步，到达target，有几种走法
		int[][] dp = new int[TOTAL+1][STEPS+1];

		// dp init
		// total ==0

		// steps == 0
		dp[TARGET][0] = 1;

		for(int steps = 1; steps<=STEPS; steps ++ ){
			for(int cur = 1; cur<=TOTAL; cur++){
				if(cur == 1){
					dp[cur][steps] = dp[cur+1][steps-1];
				}else if(cur == TOTAL){
					dp[cur][steps] = dp[cur-1][steps-1];
				}else{
					dp[cur][steps] = dp[cur-1][steps-1] + dp[cur+1][steps-1];
				}
			}
		}
		PrintUtil.print(dp);
		return dp[START][STEPS];
	}


	@Test
	public void test01(){
		System.out.println(solve2(7,4,5,9));
	}
}
