package BackTracking;

import java.util.ArrayList;
import java.util.List;

//51
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//示例:
//输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
public class n_queens {
    public static void main(String[] args) {
        List<List<String>> result = new n_queens.Solution().solveNQueens(11);
        result.forEach((l) -> {
            l.forEach(System.out::println);
            System.out.println();
        });
    }

    static class Solution {
        List<Position> solution = new ArrayList<>();
        List<List<Position>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            backtrack(n, 0);
            //输出结果
            List<List<String>> lists = new ArrayList<>();
            for (List<Position> positions : result) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    StringBuilder s = new StringBuilder();
                    for (int j = 0; j < n; j++) {
                        if (j != positions.get(i).y) {
                            s.append('.');
                        } else {
                            s.append("Q");
                        }
                    }
                    list.add(s.toString());
                }
                lists.add(list);
            }
            return lists;
        }

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
                        result.add(new ArrayList<>(solution));
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

