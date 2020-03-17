package Offer;

//https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11218&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//�����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
//·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
//���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� ����
//  a   b   c   e
//  s   f   c   s
//  a   d   e   e
//�����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
public class paths_in_a_matrix {
    public static void main(String[] args) {
        System.out.println(new paths_in_a_matrix.Solution().hasPath(
                new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'},
                3, 4, new char[]{'b', 'c', 'c', 'e', 'd'}
        ));
    }

    //���ݷ�
    public static class Solution {
        public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
            boolean[] visited = new boolean[matrix.length];
            //���Դ��κ�һ����ڿ�ʼ
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (helper(matrix, rows, cols, str, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean helper(char[] matrix, int rows, int cols, char[] str, int row, int col, int i, boolean[] visited) {
            //��Ӧ��һά���������
            int index = row * cols + col;
            if (row < 0 || col < 0 || row >= rows || col >= cols ||
                    visited[index] || matrix[index] != str[i]) {
                return false;
            }
            if (i == str.length - 1) return true;
            visited[index] = true;
            if (helper(matrix, rows, cols, str, row - 1, col, i + 1, visited)
                    || helper(matrix, rows, cols, str, row + 1, col, i + 1, visited)
                    || helper(matrix, rows, cols, str, row, col + 1, i + 1, visited)
                    || helper(matrix, rows, cols, str, row, col - 1, i + 1, visited)) {
                return true;
            }
            visited[index] = false;
            return false;
        }
    }
}
