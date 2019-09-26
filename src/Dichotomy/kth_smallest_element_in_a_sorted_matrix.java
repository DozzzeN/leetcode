package Dichotomy;

//378
//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
//请注意，它是排序后的第k小元素，而不是第k个元素。
public class kth_smallest_element_in_a_sorted_matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(new kth_smallest_element_in_a_sorted_matrix.Solution().kthSmallest(matrix, 20));
    }

    static class Solution {
        //二分法无须矩阵行列按升序排序
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int low = matrix[0][0], high = matrix[m - 1][n - 1];
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int cnt = 0;
                //计算出矩阵中小于等于mid的元素个数cnt（只计算个数，无须排序）
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                        cnt++;
                    }
                }
                if (cnt < k) low = mid + 1;
                else high = mid - 1;
            }
            return low;
        }
    }
}
