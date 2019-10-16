package UnionFindSet;

import java.util.Arrays;

//130
//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//示例:
//X X X X
//X O O X
//X X O X
//X O X X
//运行你的函数后，矩阵变为：
//X X X X
//X X X X
//X X X X
//X O X X
//解释:
//被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
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

    //所有边界上的 O 看做一个连通区域。遇到 O 就执行并查集合并操作，这样所有的 O 就会被分成两类
    //和边界上的 O 在一个连通区域内的。这些 O 我们保留。
    //不和边界上的 O 在一个连通区域内的。这些 O 就是被包围的，替换。
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
                            // 和上下左右合并成一个连通区域.
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
                        // 和dummyNode 在一个连通区域的,那么就是O；
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
