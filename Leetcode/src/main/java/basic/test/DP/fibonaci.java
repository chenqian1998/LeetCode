package basic.test.DP;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/7/1
 * @description
 */
public class fibonaci {
	public int solve(int n) {
		if (n < 1) {
			return -1;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int[][] matrix = {{1, 1}, {1, 0}};
		int[][] res = matrixPower(matrix, n - 2);
		return res[0][0] + res[1][0];
	}

	private int[][] matrixPower(int[][] matrix, int n) {
		int[][] res = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			res[i][i] = 1;
		}

		// 基本的原则和 number_power的加速规则一样，2^11 ==> 一般乘以11次
		// 11是 1+2+8
		// 2^11 = 2^1 * 2^2 * 2^8
		int[][] temp = matrix;
		for(int i=n; i!=0; i = i>>1){
			if((i&1) == 1){
				res = matrixMulti(res,temp);
			}
			temp = matrixMulti(temp,temp);
		}
		return res;
	}

	private int[][] matrixMulti(int[][] m1, int[][] m2) {
		int m = m1.length;
		int n = m2.length;
		int[][] res = new int[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}

	public int numberPower(int base, int n){
		int res = 1;
		int temp = base;
		for(int i = n; i !=0; i = i>>1){
			if( (i&1) == 1){
				res = res * temp;
			}
			// 所以说求2^11只需要找到2^1, 2^2 , 2^8
			temp = temp*temp;
		}
		return res;
	}

	@Test
	public void test03(){
		System.out.println(numberPower(2,9));
	}


	@Test
	public void test(){
		System.out.println(solve(7));
	}

}
