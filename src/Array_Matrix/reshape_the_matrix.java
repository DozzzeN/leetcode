package Array_Matrix;
//566
//在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
//给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
//重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
//如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。

import java.util.Arrays;

//输入:
//nums =
//[[1,2],
// [3,4]]
//r = 1, c = 4
//输出:
//[[1,2,3,4]]
public class reshape_the_matrix {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 2}, {3, 4}};
        int[][] output = new reshape_the_matrix.Solution().matrixReshape(input, 1, 4);
        for (int[] ints : output) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            if (r * c != nums[0].length * nums.length) {
                return nums;
            }
            int[] temp = new int[r * c];
            int[][] result = new int[r][c];
            int tempIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[0].length; j++) {
                    temp[tempIndex++] = nums[i][j];
                }
            }
            tempIndex = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    result[i][j] = temp[tempIndex++];
                }
            }

            return result;
        }
    }
}
