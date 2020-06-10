package zuo.矩阵;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/5/15
 * @description
 * 把矩阵顺时针旋转90度
 */
public class 旋转矩阵 {
    public void rotate(int[][] matrix){
        int a = 0, b = 0;
        int c = matrix.length, d = matrix[0].length-1;
        while (a<c){
            rotateEdge(matrix, a++,b++, c--,d--);
        }
    }

    public void rotateEdge(int[][] matrix, int a, int b, int c, int d) {
        int length = c-a;
        int temp = 0;
        for(int i=0; i<length; i++){
            // 第一个下标
            temp = matrix[a][b+i];
            // 第四个点的下标，变换到第一个下标
            matrix[a][b+i] = matrix[c-i][b];
            // 第三个下标赋值到第四个下标
            matrix[c-i][b] = matrix[c][d-i];
            // 第二个点 ==》 第四个点
            matrix[c][d-i] = matrix[a+i][d];

            matrix[a+i][d] = temp;
        }
    }
}
