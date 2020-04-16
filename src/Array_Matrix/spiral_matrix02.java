package Array_Matrix;

import java.util.ArrayList;
import java.util.List;

//54
//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//示例 1:
//输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
//示例 2:
//输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
public class spiral_matrix02 {
    public static void main(String[] args) {
        System.out.println(new spiral_matrix02.Solution().spiralOrder(new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
                {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
                {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
        }));

    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
                 r1 <= r2 && c1 <= c2; r1++, r2--, c1++, c2--) {//每次顺时针遍历一层以后，行和列进行缩小
                for (int i = c1; i <= c2; i++)
                    result.add(matrix[r1][i]);
                for (int i = r1 + 1; i <= r2; i++)
                    result.add(matrix[i][c2]);
                if (r1 != r2)
                    for (int i = c2 - 1; i >= c1; i--)
                        result.add(matrix[r2][i]);
                if (c1 != c2)
                    for (int i = r2 - 1; i > r1; i--)
                        result.add(matrix[i][c1]);
            }
            return result;
        }
    }
}
