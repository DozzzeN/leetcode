package DynamicProgramming;

import java.util.Arrays;

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
public class minimum_path_sum02 {
    public static void main(String[] args) {
        System.out.println(new minimum_path_sum02.Solution().minPathSum(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }));
    }

    //Min[i][j]是从左上方到grid[i][j]的最短路径
    //滚动数组
    static class Solution {
        public int minPathSum(int[][] grid) {
            if (grid.length == 0) return 0;
            int[] Min = new int[grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                Min[0] += grid[i][0];
                for (int j = 1; j < grid[0].length; j++) {
                    Min[j] = (Min[j] == 0 ? Min[j - 1] : Math.min(Min[j - 1], Min[j])) + grid[i][j];
                }
            }
            return Min[grid[0].length - 1];
        }
    }
}
