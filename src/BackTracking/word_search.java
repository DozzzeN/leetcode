package BackTracking;

//79
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//示例:
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//给定 word = "ABCCED", 返回 true.
//给定 word = "SEE", 返回 true.
//给定 word = "ABCB", 返回 false.
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
            //不知道从哪里开始找，故需要遍历整个数组
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (backtrack(0, i, j)) return true;
                }
            }
            return false;
        }

        public boolean backtrack(int i, int row, int col) {
            if (canReach(i, row, col)) {
                //到达单词末尾时，需要判断最后一位字符串是否找到
                if (i == word.length() - 1) return board[row][col] == word.charAt(i);
                if (backtrack(i + 1, row + 1, col)) return true;
                if (backtrack(i + 1, row - 1, col)) return true;
                if (backtrack(i + 1, row, col + 1)) return true;
                if (backtrack(i + 1, row, col - 1)) return true;
                //四个方向都没找到下一个，则回溯
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
