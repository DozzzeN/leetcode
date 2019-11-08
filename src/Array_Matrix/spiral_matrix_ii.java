package Array_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//59
//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
//示例:
//输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
public class spiral_matrix_ii {
    public static void main(String[] args) {
        int[][] result = new spiral_matrix_ii.Solution().generateMatrix(4);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            //设置当前允许访问的数组范围，当横纵坐标有一个超过范围时就需要改变方向
            int topBound = 0, bottomBound = n - 1, leftBound = 0, rightBound = n - 1;
            int step = 0;
            for (int i = 0, j = 0, index = 1; index <= n * n; index++) {
                if (i == topBound && j != rightBound) {
                    result[i][j] = index;
                    j++;
                } else if (j == rightBound && i != bottomBound) {
                    result[i][j] = index;
                    i++;
                } else if (i == bottomBound && j != leftBound) {
                    result[i][j] = index;
                    j--;
                } else if (i != topBound && j == leftBound) {
                    result[i][j] = index;
                    i--;
                }
                if (topBound == bottomBound && leftBound == rightBound) {
                    result[i][j] = index;
                }
                //已经遍历了一圈，需要更新访问范围
                if (i == step && j == step) {
                    step++;
                    topBound++;
                    bottomBound--;
                    leftBound++;
                    rightBound--;
                    i++;
                    j++;
                }
            }
            return result;
        }
    }
}
