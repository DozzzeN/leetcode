package Array_Matrix;
//240
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
//	每行的元素从左到右升序排列。
//	每列的元素从上到下升序排列。
public class search_a_2d_matrix_ii {
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
        System.out.println(new search_a_2d_matrix_ii.Solution().searchMatrix(matrix, 7));
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            //先从主对角线开始依次比较
            for (int i = 0, j = 0; i < matrix[0].length && j < matrix.length; i++, j++) {
                //相等直接返回
                if (matrix[i][j] == target) return true;
                //大于目标值
                if (matrix[i][j] > target) {
                    //从这个对角元素的当前行列进行查找
                    for (int k = 0; matrix[k][j] <= target || matrix[i][k] <= target; k++) {
                        if (matrix[k][j] == target || matrix[i][k] == target) {
                            return true;
                        }
                    }
                } else {
                    //小于目标值不一定没找到，有可能矩阵不是正方形，只需沿着此行此列进行查找
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[k][j] == target) {
                            return true;
                        }
                    }
                    for (int k = 0; k < matrix[0].length; k++) {
                        if (matrix[i][k] == target) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
