package zuo.矩阵;

import org.junit.Test;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/15
 * @description
 */
public class 顺序打印矩阵 {
    public void print(int[][] matrix) {
        // 矩阵框的左上角(a,b)
        int a = 0, b = 0;
        int c = matrix.length - 1, d = matrix[0].length - 1;
        while (a <= c && b <= d) {
            printEdge(matrix, a++, b++, c--, d--);
        }
    }

    public void printEdge(int[][] matrix, int a, int b, int c, int d) {
        if (a > c || b > d) {
            return;
        }
        if (a == c) {
            for (int i = b; i <= d; i++) {
                System.out.print(matrix[a][i] + " ");
            }
        } else if (b == d) {
            for (int i = a; i <= c; i++) {
                System.out.print(matrix[i][b] + " ");
            }
        } else {
            // 打印这个框

            for (int j = b; j < d; j++) {
                System.out.print(matrix[a][j] + " ");
            }
            for (int i = a; i < c; i++) {
                System.out.print(matrix[i][d] + " ");
            }
            for (int j = d; j > b; j--) {
                System.out.print(matrix[c][j] + " ");
            }
            for (int i = c; i > a; i--) {
                System.out.print(matrix[i][b] + " ");
            }

        }
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},{13,14,15,16}};
        print(matrix);
    }
}
