package Array_Matrix;

//36
//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//	数字 1-9 在每一行只能出现一次。
//	数字 1-9 在每一列只能出现一次。
//	数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
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
                //清空hashtable的数据
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
                    //清空hashtable的数据
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
