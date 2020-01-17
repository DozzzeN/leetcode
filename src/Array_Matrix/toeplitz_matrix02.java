package Array_Matrix;

public class toeplitz_matrix02 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}};
        System.out.println(new toeplitz_matrix02.Solution().isToeplitzMatrix(matrix));
    }

    static class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            for (int i = 0; i < matrix[0].length; i++) {
                //检查列
                if (!check(matrix, matrix[0][i], 0, i)) {
                    return false;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                //检查行
                if (!check(matrix, matrix[i][0], i, 0)) {
                    return false;
                }
            }
            return true;
        }

        private boolean check(int[][] matrix, int expectValue, int row, int col) {
            if (row >= matrix.length || col >= matrix[0].length) {
                return true;
            }
            //若元素与其右下元素不相等则返回false
            if (matrix[row][col] != expectValue) {
                return false;
            }
            return check(matrix, expectValue, row + 1, col + 1);
        }
    }
}
