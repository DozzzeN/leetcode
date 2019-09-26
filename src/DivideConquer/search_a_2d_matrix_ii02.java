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

    //���η���
    //���½ǵ�Ԫ������һ������С��Ԫ�أ�ͬʱ������һ��������Ԫ�ء��Ƚ����½�Ԫ�غ�Ŀ�꣺
    //�����½�Ԫ�ص���Ŀ�꣬���ҵ�
    //�����½�Ԫ�ش���Ŀ�꣬��Ŀ�겻���ܴ����ڵ�ǰ��������һ�У������ģ���Լ�СΪ��ȥ�����һ�е��Ӿ�����Ѱ��Ŀ��
    //�����½�Ԫ��С��Ŀ�꣬��Ŀ�겻���ܴ����ڵ�ǰ����ĵ�һ�У������ģ���Լ�СΪ��ȥ����һ�е��Ӿ�����Ѱ��Ŀ��
    //���������СΪ�գ���˵��������
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int m = matrix.length, n = matrix[0].length;
            int row = 0, col = n - 1;//���½�Ԫ��
            while (row < m && col >= 0) {
                if (target == matrix[row][col]) return true;
                else if (target < matrix[row][col]) col--;
                else row++;
            }
            return false;
        }
    }
}
