package Array_Matrix;

//36
//�ж�һ�� 9x9 �������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ�
//	���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
//	���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
//	���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
public class valid_sudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(new valid_sudoku.Solution().isValidSudoku(board));
    }

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            if (board == null || board.length == 0) return false;
            boolean[] row;
            boolean[] col;
            for (int i = 0; i < 9; i++) {
                //���hashtable������
                row = new boolean[9];
                col = new boolean[9];
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        if (row[board[i][j] - '1']) return false;
                        row[board[i][j] - '1'] = true;
                    }
                    if (board[j][i] != '.') {
                        if (col[board[j][i] - '1']) return false;
                        col[board[j][i] - '1'] = true;
                    }
                }
            }
            for (int step1 = 0; step1 < 3; step1++) {
                for (int step2 = 0; step2 < 3; step2++) {
                    //���hashtable������
                    row = new boolean[9];
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (board[i + step1 * 3][j + step2 * 3] != '.') {
                                if (row[board[i + step1 * 3][j + step2 * 3] - '1']) return false;
                                row[board[i + step1 * 3][j + step2 * 3] - '1'] = true;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
}
