package BackTracking;

//79
//����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�
//���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
//ʾ��:
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//���� word = "ABCCED", ���� true.
//���� word = "SEE", ���� true.
//���� word = "ABCB", ���� false.
public class word_search {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(new word_search.Solution().exist(board, "SEEDAD"));
    }

    static class Solution {
        char[][] board;
        String word;
        boolean[][] record;

        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.word = word;
            this.record = new boolean[board.length][board[0].length];
            //��֪�������￪ʼ�ң�����Ҫ������������
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (backtrack(0, i, j)) return true;
                }
            }
            return false;
        }

        public boolean backtrack(int i, int row, int col) {
            if (canReach(i, row, col)) {
                //���ﵥ��ĩβʱ����Ҫ�ж����һλ�ַ����Ƿ��ҵ�
                if (i == word.length() - 1) return board[row][col] == word.charAt(i);
                if (backtrack(i + 1, row + 1, col)) return true;
                if (backtrack(i + 1, row - 1, col)) return true;
                if (backtrack(i + 1, row, col + 1)) return true;
                if (backtrack(i + 1, row, col - 1)) return true;
                //�ĸ�����û�ҵ���һ���������
                record[row][col] = false;
            }
            return false;
        }

        public boolean canReach(int i, int row, int col) {
            if (row > board.length - 1 || col > board[0].length - 1 || row < 0 || col < 0) return false;
            else if (!record[row][col] && word.charAt(i) == board[row][col]) {
                record[row][col] = true;
                return true;
            }
            return false;
        }
    }
}
