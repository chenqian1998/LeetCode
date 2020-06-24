package DpAndRecur;

/**
 * 基本按照书上的顺序完成，就不写题目了，翻书去
 */
public class Q1_基本DP问题 {
    public int solve1(){
        // 走台阶，每次可以选择走1或2，走到N有几种走法
        int n = 10;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 2; i< n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // 走楼梯的 O(logN) 的解法
    // 其实最重要的一步就是根据二维的递推数列，找出状态矩阵，而且一般都和F(n-1) F(n-2)相关
    // 最后转变成求矩阵的 n-2 次方，然后核心就是有 O(lgN)的算法，可以求出这个矩阵的值
    public int solve2(int n){
        int[][] matrix = {{1,1},{1,0}};
        int[][] res = matrixPower(matrix,n-2);
        int sum = res[0][1] + res[1][1];
        System.out.println(sum);
    }

    // 矩阵乘方的加速方法和数字一样，说了有O(lgN),就代表其实只需要算出一半记住，然后自己相乘就行了
    public int[][] matrixPower(int[][] matrix, int n){
        // 相同大小
        int[][] res = new int[matrix.length][matrix[0].length];
        for(int i =0; i<res.length; i++){
            res[i][i] = 1;
        }
        int[][] temp = matrix;
        for(;n!=0;n= n>>1) {
            if ((n & 1) != 0) {
                // 顺序
                res = multimatrix(res, temp);
            }
            temp = multimatrix(temp,temp);
        }
        // 其实就是返回在上标为n的时候，矩阵相乘的结果
        return res;
    }

    private int[][] multimatrix(int[][] m1, int[][] m2) {
        // 两个矩阵相乘之后的结果
        int[][] res = new int[m1.length][m2[0].length];
        for(int i = 0; i<m1.length; i++){
            for(int j = 0; j<m2[0].length; j++){
                for(int k = 0; k<m2.length; k++){
                    res[i][j] = m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }


    public int solve2(){
        int n = 10;
        // 母羊生崽的问题
    }
}
