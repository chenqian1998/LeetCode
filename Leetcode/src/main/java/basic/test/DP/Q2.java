package basic.test.DP;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/1
 * @description
 */
public class Q2 {
	public int solve(int[][] matrix){
		if(matrix == null ||matrix.length == 0){
			return -1;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;

		// dp[i][j] : 走到arr[i][j]的时候，最小的路径和是多少
		int[][] dp = new int[rows][cols];

		dp[0][0] = matrix[0][0];
		// i == 0
		for(int i=1; i<rows; i++){
			dp[i][0] = dp[i-1][0] + matrix[i][0];
		}

		// j==0
		for(int j=1; j<cols; j++){
			dp[0][j] = dp[0][j-1] + matrix[0][j];
		}

		for(int i=1; i<rows; i++){
			for(int j=1; j<cols; j++){
				dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j] , dp[i][j-1]);
			}
		}
		return matrix[rows-1][cols-1];
	}
}
