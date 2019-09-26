package Array_Matrix;
//240
//��дһ����Ч���㷨������ m x n ���� matrix �е�һ��Ŀ��ֵ target���þ�������������ԣ�
//	ÿ�е�Ԫ�ش������������С�
//	ÿ�е�Ԫ�ش��ϵ����������С�
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
            //�ȴ����Խ��߿�ʼ���αȽ�
            for (int i = 0, j = 0; i < matrix[0].length && j < matrix.length; i++, j++) {
                //���ֱ�ӷ���
                if (matrix[i][j] == target) return true;
                //����Ŀ��ֵ
                if (matrix[i][j] > target) {
                    //������Խ�Ԫ�صĵ�ǰ���н��в���
                    for (int k = 0; matrix[k][j] <= target || matrix[i][k] <= target; k++) {
                        if (matrix[k][j] == target || matrix[i][k] == target) {
                            return true;
                        }
                    }
                } else {
                    //С��Ŀ��ֵ��һ��û�ҵ����п��ܾ����������Σ�ֻ�����Ŵ��д��н��в���
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
