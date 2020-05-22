package Leetcode.leetcode;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/8
 * @description
 */
public class p221_最大的正方形 {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        if (cols == 0) {
            return 0;
        }

        // dp[i][j]代表以(i,j)作为右下角，最大正方形的面积
        // dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j])
        // 但是怎么确定dp数组的大小，一般考虑肯定和matrix的大小一样就可以了，那么这样其实就要初始化了
        // 因为公式里面 i-1,j-1的，只能(i,j)从（1，1）开始遍历，设置dp[i][0] = matrix[i][0],dp[0][j] = matrix[0][j]
        // 但是如果向下面这样把DP设置大一点
        int[][] dp = new int[rows + 1][cols + 1];
        int maxLen = 0;

        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    maxLen = Math.max(maxLen,dp[i][j]);
                }
            }
        }
        return maxLen;


    }
}
