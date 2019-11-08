package Array_Matrix;

import java.util.ArrayList;
import java.util.List;

//54
//����һ������ m x n ��Ԫ�صľ���m ��, n �У����밴��˳ʱ������˳�򣬷��ؾ����е�����Ԫ�ء�
//ʾ�� 1:
//����:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//���: [1,2,3,6,9,8,7,4,5]
//ʾ�� 2:
//����:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//���: [1,2,3,4,8,12,11,10,9,5,6,7]
public class spiral_matrix {
    public static void main(String[] args) {
        System.out.println(new spiral_matrix.Solution().spiralOrder(new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
                {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
                {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
        }));

    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
            int counts = matrix[0].length * matrix.length;
            //���õ�ǰ�������ʵ����鷶Χ��������������һ��������Χʱ����Ҫ�ı䷽��
            int topBound = 0, bottomBound = matrix.length - 1, leftBound = 0, rightBound = matrix[0].length - 1;
            int step = 0;
            for (int i = 0, j = 0, index = 0; index < counts; index++) {
                if (i == topBound && j != rightBound) {
                    result.add(matrix[i][j]);
                    j++;
                } else if (j == rightBound && i != bottomBound) {
                    result.add(matrix[i][j]);
                    i++;
                } else if (i == bottomBound && j != leftBound) {
                    result.add(matrix[i][j]);
                    j--;
                } else if (i != topBound && j == leftBound) {
                    result.add(matrix[i][j]);
                    i--;
                }
                if (topBound == bottomBound && leftBound == rightBound) {
                    result.add(matrix[i][j]);
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