package Dichotomy;

//74
//��дһ����Ч���㷨���ж� m x n �����У��Ƿ����һ��Ŀ��ֵ���þ�������������ԣ�
//	ÿ���е����������Ұ��������С�
//	ÿ�еĵ�һ����������ǰһ�е����һ��������
//ʾ�� 1:
//����:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//���: true
//ʾ�� 2:
//����:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//���: false
public class search_a_2d_matrix02 {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(new search_a_2d_matrix02.Solution().searchMatrix(input, -6));
    }

    //�����ζ���
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            if (target < matrix[0][0]) return false;//��ʱtargetRow=-1��������жϻ��������Խ��
            int up = 0, down = matrix.length - 1;
            while (up <= down) {
                int mid = (up + down) / 2;
                if (matrix[mid][0] == target) return true;
                else if (matrix[mid][0] < target) {
                    up = mid + 1;
                } else {
                    down = mid - 1;
                }
            }
            int targetRow = down;
            int left = 0, right = matrix[0].length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[targetRow][mid] == target) return true;
                else if (matrix[targetRow][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}
