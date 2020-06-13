package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
//被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。
//任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。
//如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
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

    //从4个边上的O元素开始BFS,所有相连的O都赋个新值，比如"Y"
    //扫描整个数组，将所有剩下的O元素都置为X，将所有Y元素置为O
    static class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) return;
            int row = board.length, col = board[0].length;
            List<Integer> xIndex = new ArrayList<>();
            List<Integer> yIndex = new ArrayList<>();
            //记录四条边上为O的点
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
            //BFS 对每一个点搜索其周围4个相邻点
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
