package Dichotomy;

//74
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//	每行中的整数从左到右按升序排列。
//	每行的第一个整数大于前一行的最后一个整数。
//示例 1:
//输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
//示例 2:
//输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false
public class search_a_2d_matrix02 {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new search_a_2d_matrix02.Solution().searchMatrix(input, -6));
    }

    //做两次二分
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            if (target < matrix[0][0]) return false;//此时targetRow=-1，如果不判断会产生数组越界
            int up = 0, down = matrix.length - 1;
            while (up <= down) {
                int mid = (up + down) / 2;
                if (matrix[mid][0] == target) return true;
                else if (matrix[mid][0] < target) {
                    up = mid + 1;
                } else {
                    down = mid - 1;
                }
            }
            int targetRow = down;
            int left = 0, right = matrix[0].length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[targetRow][mid] == target) return true;
                else if (matrix[targetRow][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}
