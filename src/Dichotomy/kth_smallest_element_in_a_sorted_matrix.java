package Dichotomy;

//378
//����һ�� n x n ��������ÿ�к�ÿ��Ԫ�ؾ������������ҵ������е�kС��Ԫ�ء�
//��ע�⣬���������ĵ�kСԪ�أ������ǵ�k��Ԫ�ء�
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
        //���ַ�����������а���������
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int low = matrix[0][0], high = matrix[m - 1][n - 1];
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int cnt = 0;
                //�����������С�ڵ���mid��Ԫ�ظ���cnt��ֻ�����������������
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
