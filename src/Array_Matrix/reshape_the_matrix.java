package Array_Matrix;
//566
//��MATLAB�У���һ���ǳ����õĺ��� reshape�������Խ�һ����������Ϊ��һ����С��ͬ���¾��󣬵�������ԭʼ���ݡ�
//����һ���ɶ�ά�����ʾ�ľ����Լ�����������r��c���ֱ��ʾ��Ҫ���ع��ľ����������������
//�ع���ľ�����Ҫ��ԭʼ���������Ԫ������ͬ���б���˳����䡣
//������и���������reshape�����ǿ����Һ���ģ�������µ����ܾ��󣻷������ԭʼ����

import java.util.Arrays;

//����:
//nums =
//[[1,2],
// [3,4]]
//r = 1, c = 4
//���:
//[[1,2,3,4]]
public class reshape_the_matrix {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 2}, {3, 4}};
        int[][] output = new reshape_the_matrix.Solution().matrixReshape(input, 1, 4);
        for (int[] ints : output) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            if (r * c != nums[0].length * nums.length) {
                return nums;
            }
            int[] temp = new int[r * c];
            int[][] result = new int[r][c];
            int tempIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[0].length; j++) {
                    temp[tempIndex++] = nums[i][j];
                }
            }
            tempIndex = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    result[i][j] = temp[tempIndex++];
                }
            }

            return result;
        }
    }
}
