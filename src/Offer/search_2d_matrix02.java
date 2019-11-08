package Offer;
//https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
public class search_2d_matrix02 {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(new search_2d_matrix02.Solution().Find(14, input));
    }

    public static class Solution {
        public boolean Find(int target, int[][] array) {
            if (array == null || array.length == 0 || array[0].length == 0) return false;
            if (target < array[0][0]) return false;
            int row = array.length, col = array[0].length;
            //�����¿�ʼ����
            for (int i = row - 1, j = 0; i >= 0 && j < col;) {
                if (array[i][j] > target) {
                    i--;
                } else if (array[i][j] < target) {
                    j++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
