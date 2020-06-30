package basic.DpRecur;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/27
 * @description
 */
public class Q4_机器人到达指定位置的方法数 {
	/**
	 * 从目标位置CUR出发，到达target，要经过rest步，一共有几种走法
	 *
	 * 返回结果：以上的走法有几种
	 *
	 * @param N
	 * @param cur
	 * @param rest 剩下几步要走，题目中一开始说的是要走几步，转换成剩下几步
	 * @param target
	 * @return
	 */
	public int walk(int N, int cur, int rest, int target){
		if(rest == 0){
			return cur == target? 1:0;
		}
		if(cur == 1){
			// 只能向右走
			return walk(N,cur+1, rest-1,target);
		}
		if(cur == N){
			// 只能向左走
			return walk(N,cur-1,rest-1, target);
		}
		return walk(N,cur+1,rest-1,target) + walk(N,cur-1,rest-1,target);
	}

	public int solve(int N, int cur, int rest, int target){
		// 变量是cur,rest,根据两者的范围新建DP
		// 这里暂且rest作为维度1
		// 大小的确定：画图，rest是可以从0取值到9
		// cur默认是1到N
		int[][] dp = new int[rest+1][N+1];

		// init
		// 如果rest == 0, dp?
		dp[0][target]=1;

		// 特殊情况 边界的时候只能向一边走
		//  0<=i<=rest,可以
		for(int i=1; i<=rest; i++){
			for(int j= 0; j<=N;j++){
				if(j==1){
					dp[i][j] = dp[i-1][j+1];
				}else if(j==N){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				}
			}
		}
		return dp[rest][cur];
	}
}
