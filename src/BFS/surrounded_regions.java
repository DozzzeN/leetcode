package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
//��Χ�Ƶ����䲻������ڱ߽��ϣ����仰˵���κα߽��ϵ�'O'�����ᱻ���Ϊ'X'��
//�κβ��ڱ߽��ϣ�����߽��ϵ�'O'������'O'���ն��ᱻ���Ϊ'X'��
//�������Ԫ����ˮƽ��ֱ�������ڣ���������ǡ��������ġ�
public class surrounded_regions {
    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new surrounded_regions.Solution().solve(input);
        for (char[] chars : input) {
            System.out.println(Arrays.toString(chars));
        }

    }

    //��4�����ϵ�OԪ�ؿ�ʼBFS,����������O��������ֵ������"Y"
    //ɨ���������飬������ʣ�µ�OԪ�ض���ΪX��������YԪ����ΪO
    static class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) return;
            int row = board.length, col = board[0].length;
            List<Integer> xIndex = new ArrayList<>();
            List<Integer> yIndex = new ArrayList<>();
            //��¼��������ΪO�ĵ�
            for (int i = 0; i < row; i++) {
                if (board[i][0] == 'O') {
                    xIndex.add(i);
                    yIndex.add(0);
                }
                if (board[i][col - 1] == 'O') {
                    xIndex.add(i);
                    yIndex.add(col - 1);
                }
            }
            for (int i = 0; i < col; i++) {
                if (board[0][i] == 'O') {
                    xIndex.add(0);
                    yIndex.add(i);
                }
                if (board[row - 1][i] == 'O') {
                    xIndex.add(row - 1);
                    yIndex.add(i);
                }
            }
            //BFS ��ÿһ������������Χ4�����ڵ�
            int k = 0;
            while (k < xIndex.size()) {
                int x = xIndex.get(k);
                int y = yIndex.get(k);
                board[x][y] = 'Y';
                if (x > 0 && board[x - 1][y] == 'O') {
                    xIndex.add(x - 1);
                    yIndex.add(y);
                }
                if (x + 1 < row && board[x + 1][y] == 'O') {
                    xIndex.add(x + 1);
                    yIndex.add(y);
                }
                if (y > 0 && board[x][y - 1] == 'O') {
                    xIndex.add(x);
                    yIndex.add(y - 1);
                }
                if (y + 1 < col && board[x][y + 1] == 'O') {
                    xIndex.add(x);
                    yIndex.add(y + 1);
                }
                k++;
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    if (board[i][j] == 'Y') board[i][j] = 'O';
                }
            }
        }
    }
}
