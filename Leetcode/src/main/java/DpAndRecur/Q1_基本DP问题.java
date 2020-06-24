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


    public int solve2(){
        int n = 10;
        // 母羊生崽的问题
    }
}
