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
public class search_a_2d_matrix {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new search_a_2d_matrix.Solution().searchMatrix(input, -5));
    }

    //转成一维数组进行二分
    //注意不会产生真正的数组
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int left = 0, right = matrix.length * matrix[0].length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                int temp = matrix[mid / matrix[0].length][mid % matrix[0].length];
                if (temp == target) {
                    return true;
                } else if (temp < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }

//        public boolean searchMatrix(int[][] matrix, int target) {
//            ArrayList list = new ArrayList();
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix[0].length; j++) {
//                    list.add(matrix[i][j]);
//                }
//            }
//            int left = 0, right = list.size() - 1;
//            while (left <= right) {
//                int mid = (left + right) / 2;
//                if ((int) list.get(mid) == target) return true;
//                else if ((int) list.get(mid) < target) {
//                    left = mid + 1;
//                } else {
//                    right = mid - 1;
//                }
//            }
//            return false;
//        }
    }
}
