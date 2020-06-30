package basic.DpRecur;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/6/24
 * @description 有时间复杂度为O(lgN)的解法
 * 本质上是通过递推公式 f(n) = f(n-1) + f(n-2),找出矩阵乘法的表示形式。
 * [f(n), f(n-1)] = [f(n-1), f(n-2)] * [1, 1
 * 																			1, 0]
 * 这样子，就变成了递归的过程，最后分解到
 * [f(n), f(n-1)] = [f(2), f(1)] * m^(n-2)
 * <p>
 * 就变成了求一个矩阵的N次方的问题，而这个问题的求解，是
 */
public class Q1_fibonaci的最快方法 {
	public int fibonaci(int n) {
		if(n<1){
			return 0;
		}
		if(n == 1 || n== 2){
			return 1;
		}
		int[][] base = {{1,1},{1,0}};
		int[][] res = matrixPower(base,n-2);
		return res[0][0] + res[1][0];
	}

	/**
	 * 矩阵的乘法，加速的秘诀在哪里 2^32 ==> (2^16)^2
	 */

	public int[][] matrixPower(int[][] matrix, int n){
		// res是单位矩阵
		int[][] res = new int[matrix.length][matrix[0].length];
		for(int i=0; i< matrix.length; i++){
			res[i][i] = 1;
		}
		// temp是自己
		int[][] temp = matrix;
		for(; n!=0; n = n>>1){
			// 这里的细节要扣一下
			// res是记录最后累计成起来的结果，比如 2^11 = 2^8 * 2^2 * 2^1
			// 所以说起来就是n的二进制对应是1的才应该乘，之前一直不明白这个地方，要训练下
			//
			if((n&1) != 0){
				// 如果次方是奇数，就是先乘一个自己，再转化成偶数来算
				res = matrixMulti(res,temp);
			}
			// temp一直在变
			temp = matrixMulti(temp,temp);
		}
		return res;
	}


	public int[][] matrixMulti(int[][] m1, int[][] m2) {
		int[][] res = new int[m1.length][m2[0].length];

		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k <m2.length; k++){
					res[i][j] +=  m1[i][k]* m2[k][j];
				}
			}
		}
		return res;
	}

	@Test
	public void test(){
		int fibonaci = fibonaci(13);
		System.out.println(fibonaci);
	}

	/**
	 * 母牛生崽的问题，小牛三年之后才能成熟，成熟的牛每年可以生一个
	 * 其实基本的公式就是： f(n) = f(n-1) + f(n-3) 这个的理解就是每年新生的牛，都是三年前成熟的牛的总数，
	 * 三年前到现在的肯定都是成熟的了
	 *
	 * 这是一个三阶递推数列，f(n)依赖f(n-1) f(n-3)
	 *
	 * @param n
	 * @return
	 */
	public int solve2(int n){
		if(n<1){
			return 0;
		}
		if(n == 1 || n==2 || n==3){
			return n;
		}
		int[][] base = {{1,1,0},{0,0,1},{1,0,0}};
		int[][] res = matrixPower(base, n-3);
		return 3*res[0][0] + 2*res[1][0] + res[2][0];
	}

}
