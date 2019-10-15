package Array_Matrix;

import java.util.Arrays;

//48
//����һ�� n �� n �Ķ�ά�����ʾһ��ͼ��
//��ͼ��˳ʱ����ת 90 �ȡ�
//˵����
//�������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��
//ʾ�� 1:
//���� matrix =
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//ԭ����ת�������ʹ���Ϊ:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
//ʾ�� 2:
//���� matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],
//ԭ����ת�������ʹ���Ϊ:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
public class rotate_image {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        new rotate_image.Solution().rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            int len = matrix.length;
            //���Ÿ��Խ�����ת
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len - i - 1; j++) {
                    swap(matrix, i, j, len - j - 1, len - i - 1);
                }
            }
            //����X��������ת
            for (int i = 0; i < len / 2; i++) {
                for (int j = 0; j < len; j++) {
                    swap(matrix, i, j, len - i - 1, j);
                }
            }
        }

        public void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
            matrix[x1][y1] += matrix[x2][y2];
            matrix[x2][y2] = matrix[x1][y1] - matrix[x2][y2];
            matrix[x1][y1] -= matrix[x2][y2];
        }
    }
}

