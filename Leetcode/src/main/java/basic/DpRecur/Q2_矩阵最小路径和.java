package basic.DpRecur;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/27
 * @description
 */
public class Q2_矩阵最小路径和 {
	public int getMinPathSum(int[][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		// dp代表的是从(0,0)位置走到(i,j)位置最小的路径和
		int[][] dp = new int[rows][cols];
		// dp init
		dp[0][0] = matrix[0][0];

		for(int i =1; i< matrix.length; i++){
			dp[i][0] = matrix[i][0];
		}

		for(int j = 1; j< matrix[0].length; j++){
			dp[0][j] = matrix[0][j];
		}

		for(int i=1; i<matrix.length; i++){
			for(int j=1; j<matrix[0].length; j++){
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
			}
		}
		return dp[rows-1][cols-1];
	}

	/**
	 * TODO：空间优化
	 * @param matrix
	 * @return
	 */
	public int solve2(int[][] matrix){
		return 0;
	}
}
