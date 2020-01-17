package BackTracking;

import java.util.ArrayList;
import java.util.List;

//52
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//给定一个整数 n，返回 n 皇后不同的解决方案的数量。
//示例:
//输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//
public class n_queens_ii {
    public static void main(String[] args) {
        System.out.println(new n_queens_ii.Solution().totalNQueens(11));
    }

    static class Solution {
        List<Position> solution = new ArrayList<>();
        int count = 0;

        public int totalNQueens(int n) {
            backtrack(n, 0);
            //输出结果
            return count;
        }

        //时间复杂度：O(n!)
        //放一个皇后：n 放两个皇后：n-2
        //n * (n-2) * (n-4) ...
        public boolean canPut(int n, int row, int col) {
            if (row > n - 1 || col > n - 1 || row < 0 || col < 0) return false;
            int left = row - Math.min(row, col);
            int top = col - Math.min(row, col);
            for (Position position : solution) {
                if (row == position.x) return false;
                if (col == position.y) return false;
                //主对角线
                if (left == position.x - Math.min(position.x, position.y) &&
                        top == position.y - Math.min(position.x, position.y))
                    return false;
                //副对角线
                if (row + col == position.x + position.y) return false;
            }
            return true;
        }

        public void backtrack(int n, int row) {
            for (int col = 0; col < n; col++) {
                if (canPut(n, row, col)) {
                    solution.add(new Position(row, col));
                    if (solution.size() == n) {
                        count++;
                    } else backtrack(n, row + 1);
                    solution.remove(solution.size() - 1);
                }
            }
        }

        //存放已有位置
        static class Position {
            int x;
            int y;

            Position(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
