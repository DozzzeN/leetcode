package Array_Matrix;

//766
//���һ�������ÿһ���������ϵ����µĶԽ����Ͼ�����ͬԪ�أ���ô����������������ľ���
//����һ�� M x N �ľ��󣬵��ҽ��������������ľ���ʱ���� True��
public class toeplitz_matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}};
//        int[][] matrix = {
//                {1,2},
//                {2,2}
//        };
        System.out.println(new toeplitz_matrix.Solution().isToeplitzMatrix(matrix));
    }

    static class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length - 1; i++) {//�б���
                for (int j = 0; j < matrix[0].length - 1; j++) {//�б���
                    if (matrix[i][j] != matrix[i + 1][j + 1]) {
                        return false;
                    }
                }
            }
            return true;
        }


    }
}
