package BFS;

import java.util.LinkedList;
import java.util.Queue;

//695
//给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
// 你可以假设二维矩阵的四个边缘都被水包围着。
//找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
public class max_area_of_island02 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        int[][] grid2 = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        System.out.println(new Solution().maxAreaOfIsland(grid2));
    }

    //广度优先搜索
    static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int maxArea = 0;
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == 1) {
                        int temp = 0;
                        grid[r][c] = 0;
                        Queue<Integer> queue = new LinkedList<>();
                        //加入当前遍历的元素的位置 以整数表示
                        queue.add(r * nc + c);
                        while (!queue.isEmpty()) {
                            //队头出队
                            temp++;
                            int index = queue.remove();
                            int row = index / nc;
                            int col = index % nc;
                            if (row + 1 < nr && grid[row + 1][col] == 1) {
                                queue.add((row + 1) * nc + col);
                                grid[row + 1][col] = 0;
                            }
                            if (col + 1 < nc && grid[row][col + 1] == 1) {
                                queue.add((row) * nc + col + 1);
                                grid[row][col + 1] = 0;
                            }
                            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                                queue.add((row - 1) * nc + col);
                                grid[row - 1][col] = 0;
                            }
                            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                                queue.add(row * nc + col - 1);
                                grid[row][col - 1] = 0;
                            }
                        }
                        maxArea = Math.max(maxArea, temp);
                    }
                }
            }
            return maxArea;
        }
    }
}


