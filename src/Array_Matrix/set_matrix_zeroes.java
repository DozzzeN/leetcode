package Array_Matrix;

import java.util.Arrays;

//73
//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
//示例 1:
//输入:
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出:
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//示例 2:
//输入:
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出:
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
//进阶:
//	一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
//	一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
//	你能想出一个常数空间的解决方案吗？
public class set_matrix_zeroes {
    public static void main(String[] args) {
        int[][] result = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        new set_matrix_zeroes.Solution().setZeroes(result);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //使用原数组的第一行和第一列进行记录标志位
    static class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            int row = matrix.length, col = matrix[0].length;
            boolean rowZero = false, colZero = false;
            //搜索第一行和第一列是否有0，来判断第一行和第一列是否要清零
            for (int i = 0; i < row; i++) {
                if (matrix[i][0] == 0) {
                    colZero = true;
                    break;
                }
            }
            for (int i = 0; i < col; i++) {
                if (matrix[0][i] == 0) {
                    rowZero = true;
                    break;
                }
            }
            //扫描剩下元素，如果遇到0，将该行该列所对应的第一行和第一列元素赋值为0（可以赋值为0，因为早晚都是0）
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            //根据第一行和第一列对矩阵元素进行清零
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            //清零第一行和第一列
            if (rowZero) {
                for (int i = 0; i < col; i++) {
                    matrix[0][i] = 0;
                }
            }
            if (colZero) {
                for (int i = 0; i < row; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
