package DynamicProgramming;

//64
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//说明：每次只能向下或者向右移动一步。
//示例:
//输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
public class minimum_path_sum {
    public static void main(String[] args) {
        System.out.println(new minimum_path_sum.Solution().minPathSum(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }));
    }

    //Min[i][j]是从左上方到grid[i][j]的最短路径
    static class Solution {
        public int minPathSum(int[][] grid) {
            if (grid.length == 0) return 0;
            int[][] Min = new int[grid.length][grid[0].length];
            Min[0][0] = grid[0][0];
            for (int i = 1; i < grid.length; i++) {
                Min[i][0] = Min[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < grid[0].length; i++) {
                Min[0][i] = Min[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    Min[i][j] = Math.min(Min[i - 1][j], Min[i][j - 1]) + grid[i][j];
                }
            }
            return Min[grid.length - 1][grid[0].length - 1];
        }
    }
}
