package UnionFindSet;

import java.util.Arrays;

//130
//����һ����ά�ľ��󣬰��� 'X' �� 'O'����ĸ O����
//�ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е� 'O' �� 'X' ��䡣
//ʾ��:
//X X X X
//X O O X
//X X O X
//X O X X
//������ĺ����󣬾����Ϊ��
//X X X X
//X X X X
//X X X X
//X O X X
//����:
//��Χ�Ƶ����䲻������ڱ߽��ϣ����仰˵���κα߽��ϵ� 'O' �����ᱻ���Ϊ 'X'�� �κβ��ڱ߽��ϣ�����߽��ϵ� 'O' ������ 'O' ���ն��ᱻ���Ϊ 'X'���������Ԫ����ˮƽ��ֱ�������ڣ���������ǡ��������ġ�
public class surrounded_regions03 {
    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };
        new surrounded_regions03.Solution().solve(input);
        for (char[] chars : input) {
            System.out.println(Arrays.toString(chars));
        }

    }

    //���б߽��ϵ� O ����һ����ͨ�������� O ��ִ�в��鼯�ϲ��������������е� O �ͻᱻ�ֳ�����
    //�ͱ߽��ϵ� O ��һ����ͨ�����ڵġ���Щ O ���Ǳ�����
    //���ͱ߽��ϵ� O ��һ����ͨ�����ڵġ���Щ O ���Ǳ���Χ�ģ��滻��
    static class Solution {
        public int col = 0;

        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) return;
            int row = board.length;
            this.col = board[0].length;
            UnionFindSet unionFindSet = new UnionFindSet(row * col + 1);
            int dummy = col * row;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') {
                        if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                            unionFindSet.Union(node(i, j), dummy);
                        } else {
                            // ���������Һϲ���һ����ͨ����.
                            if (i > 0 && board[i - 1][j] == 'O')
                                unionFindSet.Union(node(i, j), node(i - 1, j));
                            if (i < row - 1 && board[i + 1][j] == 'O')
                                unionFindSet.Union(node(i, j), node(i + 1, j));
                            if (j > 0 && board[i][j - 1] == 'O')
                                unionFindSet.Union(node(i, j), node(i, j - 1));
                            if (j < col - 1 && board[i][j + 1] == 'O')
                                unionFindSet.Union(node(i, j), node(i, j + 1));
                        }

                    }
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (unionFindSet.Find(node(i, j)) == unionFindSet.Find(dummy)) {
                        // ��dummyNode ��һ����ͨ�����,��ô����O��
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public int node(int x, int y) {
            return x * col + y;
        }
    }
}
