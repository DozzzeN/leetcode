package Array_Matrix;

import java.util.Arrays;

//73
//����һ�� m x n �ľ������һ��Ԫ��Ϊ 0�����������к��е�����Ԫ�ض���Ϊ 0����ʹ��ԭ���㷨��
//ʾ�� 1:
//����:
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//���:
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//ʾ�� 2:
//����:
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//���:
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
//����:
//	һ��ֱ�ӵĽ��������ʹ��  O(mn) �Ķ���ռ䣬���Ⲣ����һ���õĽ��������
//	һ���򵥵ĸĽ�������ʹ�� O(m + n) �Ķ���ռ䣬������Ȼ������õĽ��������
//	�������һ�������ռ�Ľ��������
public class set_matrix_zeroes {
    public static void main(String[] args) {
        int[][] result = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        new set_matrix_zeroes.Solution().setZeroes(result);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //ʹ��ԭ����ĵ�һ�к͵�һ�н��м�¼��־λ
    static class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            int row = matrix.length, col = matrix[0].length;
            boolean rowZero = false, colZero = false;
            //������һ�к͵�һ���Ƿ���0�����жϵ�һ�к͵�һ���Ƿ�Ҫ����
            for (int i = 0; i < row; i++) {
                if (matrix[i][0] == 0) {
                    colZero = true;
                    break;
                }
            }
            for (int i = 0; i < col; i++) {
                if (matrix[0][i] == 0) {
                    rowZero = true;
                    break;
                }
            }
            //ɨ��ʣ��Ԫ�أ��������0�������и�������Ӧ�ĵ�һ�к͵�һ��Ԫ�ظ�ֵΪ0�����Ը�ֵΪ0����Ϊ������0��
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            //���ݵ�һ�к͵�һ�жԾ���Ԫ�ؽ�������
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            //�����һ�к͵�һ��
            if (rowZero) {
                for (int i = 0; i < col; i++) {
                    matrix[0][i] = 0;
                }
            }
            if (colZero) {
                for (int i = 0; i < row; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
