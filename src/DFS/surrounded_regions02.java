package DFS;

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
public class surrounded_regions02 {
    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };
        new surrounded_regions02.Solution().solve(input);
        for (char[] chars : input) {
            System.out.println(Arrays.toString(chars));
        }

    }

    //��4�����ϵ�OԪ�ؿ�ʼDFS,����������O��������ֵ������'Y'
    //ɨ���������飬������ʣ�µ�OԪ�ض���ΪX��������YԪ����ΪO
    static class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) return;
            int row = board.length, col = board[0].length;
            //��¼��������ΪO�ĵ�
            for (int i = 0; i < row; i++) {
                dfs(board, i, 0);
                dfs(board, i, col - 1);
            }
            for (int i = 0; i < col; i++) {
                dfs(board, 0, i);
                dfs(board, row - 1, i);
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    if (board[i][j] == 'Y') board[i][j] = 'O';
                }
            }
        }

        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') return;
            board[x][y] = 'Y';
            dfs(board, x + 1, y);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x, y - 1);
        }
    }
}
