package Offer;

//https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
public class search_2d_matrix {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(new search_2d_matrix.Solution().Find(14, input));
    }

    public static class Solution {
        public boolean Find(int target, int[][] array) {
            if (array == null || array.length == 0 || array[0].length == 0) return false;
            if (target < array[0][0]) return false;
            int index;
            for (int i = 0; i < array.length; i++) {
                int left = 0, right = array.length - 1;
                while (left <= right) {
                    index = (left + right) >>> 1;
                    int temp = array[index][i];
                    if (target == temp) {
                        return true;
                    } else if (target < temp) {
                        right = index - 1;
                    } else {
                        left = index + 1;
                    }
                }
            }
            return false;
        }
    }
}
