package Array_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//59
//����һ�������� n������һ������ 1 �� n2 ����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е������ξ���
//ʾ��:
//����: 3
//���:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
public class spiral_matrix_ii {
    public static void main(String[] args) {
        int[][] result = new spiral_matrix_ii.Solution().generateMatrix(4);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            //���õ�ǰ������ʵ����鷶Χ��������������һ��������Χʱ����Ҫ�ı䷽��
            int topBound = 0, bottomBound = n - 1, leftBound = 0, rightBound = n - 1;
            int step = 0;
            for (int i = 0, j = 0, index = 1; index <= n * n; index++) {
                if (i == topBound && j != rightBound) {
                    result[i][j] = index;
                    j++;
                } else if (j == rightBound && i != bottomBound) {
                    result[i][j] = index;
                    i++;
                } else if (i == bottomBound && j != leftBound) {
                    result[i][j] = index;
                    j--;
                } else if (i != topBound && j == leftBound) {
                    result[i][j] = index;
                    i--;
                }
                if (topBound == bottomBound && leftBound == rightBound) {
                    result[i][j] = index;
                }
                //�Ѿ�������һȦ����Ҫ���·��ʷ�Χ
                if (i == step && j == step) {
                    step++;
                    topBound++;
                    bottomBound--;
                    leftBound++;
                    rightBound--;
                    i++;
                    j++;
                }
            }
            return result;
        }
    }
}
