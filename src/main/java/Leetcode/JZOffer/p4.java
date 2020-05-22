package Leetcode.JZOffer;

import Leetcode.utils.PrintUtil;

import java.util.Scanner;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/6
 * @description 二维数组是否存在一个整数, 这个二维数组有比较神奇的特征就是：（1）从左向右递增 （2）从上到下递增
 */
public class p4 {
    public static boolean findNumInMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }

        int i = 0, j = cols - 1;

        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (target < matrix[i][j]) {
                j -= 1;
            } else {
                i += 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        // 考验一下数组怎么输入
        Scanner scanner =  new Scanner(System.in);


        int[][] matrix = {{1, 2, 3}, {1, 1, 1}, {3, 3, 3}};

        PrintUtil.print(matrix);

        System.out.println(findNumInMatrix(matrix, 10));
    }
}
