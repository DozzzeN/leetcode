package BackTracking;

import java.util.Arrays;

//37
//编写一个程序，通过已填充的空格来解决数独问题。
//一个数独的解法需遵循如下规则：
//	数字 1-9 在每一行只能出现一次。
//	数字 1-9 在每一列只能出现一次。
//	数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//空白格用 '.' 表示。
//Note:
//	给定的数独序列只包含数字 1-9 和字符 '.' 。
//	你可以假设给定的数独只有唯一解。
//	给定数独永远是 9x9 形式的。
public class sudoku_solver {
    public static void main(String[] args) {
        char[][] sudoku = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new sudoku_solver.Solution().solveSudoku(sudoku);
        for (char[] chars : sudoku) {
            System.out.println(Arrays.toString(chars));
        }
    }

    //使用的概念:约束编程
    //基本的意思是在放置每个数字时都设置约束。在数独上放置一个数字后立即排除当前行,列和子方块对该数字的使用。
    //这会传播约束条件,并有利于减少需要考虑组合的个数。
    static class Solution {
        //使用哈希表来存储行、列、3*3宫格
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] boxes = new int[9][10];
        char[][] board;

        boolean isSuccess = false;

        public void solveSudoku(char[][] board) {
            this.board = board;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        //预处理
                        putNumber(Character.getNumericValue(board[i][j]), i, j);
                    }
                }
            }
            backtrack(0, 0);
        }

        public void backtrack(int row, int col) {
            if (board[row][col] == '.') {
                for (int n = 1; n < 10; n++) {
                    if (this.canPut(n, row, col)) {
                        putNumber(n, row, col);
                        if (row == 8 && col == 8) isSuccess = true;
                        else if (col == 8) {
                            //到下一行
                            backtrack(row + 1, 0);
                        } else {
                            //到下一列
                            backtrack(row, col + 1);
                        }
                        //没有解删除最后的
                        if (!isSuccess) {
                            removeNumber(n, row, col);
                        }
                    }
                }
            } else {
                if (row == 8 && col == 8) isSuccess = true;
                else if (col == 8) {
                    //到下一行
                    backtrack(row + 1, 0);
                } else {
                    //到下一列
                    backtrack(row, col + 1);
                }
            }
        }

        public void putNumber(int n, int row, int col) {
            //记录约束
            int index = (row / 3) * 3 + col / 3;
            rows[row][n]++;
            cols[col][n]++;
            boxes[index][n]++;
            //填入数独
            board[row][col] = (char) (n + '0');
        }

        public void removeNumber(int n, int row, int col) {
            //删除约束
            int index = (row / 3) * 3 + col / 3;
            rows[row][n]--;
            cols[col][n]--;
            boxes[index][n]--;
            //删除数独中所填
            board[row][col] = '.';
        }

        public boolean canPut(int n, int row, int col) {
            int index = (row / 3) * 3 + col / 3;
            return rows[row][n] == 0 && cols[col][n] == 0 && boxes[index][n] == 0;
        }
    }
}
