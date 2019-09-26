package DivideConquer;

public class search_a_2d_matrix_ii02 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};
                {2, 5},
                {2, 8},
                {7, 9},
                {7, 11},
                {9, 11}};
        System.out.println(new search_a_2d_matrix_ii02.Solution().searchMatrix(matrix, 7));
    }

    //分治法。
    //左下角的元素是这一行中最小的元素，同时又是这一列中最大的元素。比较左下角元素和目标：
    //若左下角元素等于目标，则找到
    //若左下角元素大于目标，则目标不可能存在于当前矩阵的最后一行，问题规模可以减小为在去掉最后一行的子矩阵中寻找目标
    //若左下角元素小于目标，则目标不可能存在于当前矩阵的第一列，问题规模可以减小为在去掉第一列的子矩阵中寻找目标
    //若最后矩阵减小为空，则说明不存在
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int m = matrix.length, n = matrix[0].length;
            int row = 0, col = n - 1;//左下角元素
            while (row < m && col >= 0) {
                if (target == matrix[row][col]) return true;
                else if (target < matrix[row][col]) col--;
                else row++;
            }
            return false;
        }
    }
}
