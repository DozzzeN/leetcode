package BackTracking;

import java.util.Arrays;

//37
//��дһ������ͨ�������Ŀո�������������⡣
//һ�������Ľⷨ����ѭ���¹���
//	���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
//	���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
//	���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
//�հ׸��� '.' ��ʾ��
//Note:
//	��������������ֻ�������� 1-9 ���ַ� '.' ��
//	����Լ������������ֻ��Ψһ�⡣
//	����������Զ�� 9x9 ��ʽ�ġ�
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

    //ʹ�õĸ���:Լ�����
    //��������˼���ڷ���ÿ������ʱ������Լ�����������Ϸ���һ�����ֺ������ų���ǰ��,�к��ӷ���Ը����ֵ�ʹ�á�
    //��ᴫ��Լ������,�������ڼ�����Ҫ������ϵĸ�����
    static class Solution {
        //ʹ�ù�ϣ�����洢�С��С�3*3����
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
                        //Ԥ����
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
                            //����һ��
                            backtrack(row + 1, 0);
                        } else {
                            //����һ��
                            backtrack(row, col + 1);
                        }
                        //û�н�ɾ������
                        if (!isSuccess) {
                            removeNumber(n, row, col);
                        }
                    }
                }
            } else {
                if (row == 8 && col == 8) isSuccess = true;
                else if (col == 8) {
                    //����һ��
                    backtrack(row + 1, 0);
                } else {
                    //����һ��
                    backtrack(row, col + 1);
                }
            }
        }

        public void putNumber(int n, int row, int col) {
            //��¼Լ��
            int index = (row / 3) * 3 + col / 3;
            rows[row][n]++;
            cols[col][n]++;
            boxes[index][n]++;
            //��������
            board[row][col] = (char) (n + '0');
        }

        public void removeNumber(int n, int row, int col) {
            //ɾ��Լ��
            int index = (row / 3) * 3 + col / 3;
            rows[row][n]--;
            cols[col][n]--;
            boxes[index][n]--;
            //ɾ������������
            board[row][col] = '.';
        }

        public boolean canPut(int n, int row, int col) {
            int index = (row / 3) * 3 + col / 3;
            return rows[row][n] == 0 && cols[col][n] == 0 && boxes[index][n] == 0;
        }
    }
}
