package DynamicProgramming;

//63
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//网格中的障碍物和空位置分别用 1 和 0 来表示。
//说明：m 和 n 的值均不超过 100。
//示例 1:
//输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
public class unique_paths_ii {
    public static void main(String[] args) {
        System.out.println(new unique_paths_ii.Solution().uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        }));
    }

    //step[0][0] = 1
    //step[i][j] = step[i-1][j] + step[i][j-1] i!=0 || j!=0
    //step[i][j] = 0 if array[i][j] = 1
    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
            if (obstacleGrid[0][0] == 1) return 0;
            int row = obstacleGrid[0].length;
            int col = obstacleGrid.length;
            int[] step = new int[row];
            step[0] = 1;
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        step[j] = 0;
                    } else if (j > 0) {
                        step[j] += step[j - 1];
                    }
                }
            }
            return step[row - 1];
        }
    }
}
