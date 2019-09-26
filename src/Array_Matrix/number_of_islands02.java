package Array_Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class number_of_islands02 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution().numIslands(grid));
        for (char[] chars : grid) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    //广度优先搜索（类似于二叉树中序遍历的队列实现）
    //线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动广度优先搜索。
    //将其放入队列中，并将值设为 0 以标记访问过该结点。迭代地搜索队列中的每个结点，直到队列为空。
    static class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        ++num_islands;
                        grid[r][c] = '0';
                        Queue<Integer> queue = new LinkedList<>();
                        //加入当前遍历的元素的位置 以整数表示
                        queue.add(r * nc + c);
                        while (!queue.isEmpty()) {
                            //队头出队
                            int index = queue.remove();
                            int row = index / nc;
                            int col = index % nc;
                            if (row + 1 < nr && grid[row + 1][col] == '1') {
                                queue.add((row + 1) * nc + col);
                                grid[row + 1][col] = '0';
                            }
                            if (col + 1 < nc && grid[row][col + 1] == '1') {
                                queue.add((row) * nc + col + 1);
                                grid[row][col + 1] = '0';
                            }
                            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                                queue.add((row - 1) * nc + col);
                                grid[row - 1][col] = '0';
                            }
                            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                                queue.add(row * nc + col - 1);
                                grid[row][col - 1] = '0';
                            }
                        }
                    }
                }
            }
            return num_islands;
        }
    }
}