package DynamicProgramming;

//62
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//问总共有多少条不同的路径？
//例如，上图是一个7 x 3 的网格。有多少可能的路径？
//说明：m 和 n 的值均不超过 100。
//示例 1:
//输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
//示例 2:
//输入: m = 7, n = 3
//输出: 28
public class unique_paths {
    public static void main(String[] args) {
        System.out.println(new unique_paths.Solution().uniquePaths(7, 3));
    }

    //step[0][0] = 1
    //step[i][j] = step[i-1][j] + step[i][j-1] i!=0 || j!=0
    //数组为下所示
    //1 1 1 1
    //1 2 3 4
    //1 3 4 5
    //使用滚动数组 按列遍历
    static class Solution {
        public int uniquePaths(int m, int n) {
            int[] step = new int[n];
            step[0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    step[j] += step[j - 1];
                }
            }
            return step[n - 1];
        }
    }
}
