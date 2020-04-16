package Offer;

//在一个m*n的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于0）。从左上角开始拿礼物，
//每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
//1    10   3    8
//12   2    9    6
//5    7    4    11
//3    7    16   5
//礼物的最大价值为1+12+5+7+7+16+5=53。
public class the_greatest_value_of_gifts {
    public static void main(String[] args) {
        System.out.println(new the_greatest_value_of_gifts().getMost(
                new int[][]{
                        {1, 10, 3, 8},
                        {12, 2, 9, 6},
                        {5, 7, 4, 11},
                        {3, 7, 16, 5},
                }
        ));
    }

    //应该用动态规划求解，而不是深度优先搜索，深度优先搜索过于复杂，不是最优解。
    //dp[i,j] = max{ dp[i-1][j], dp[i][j-1] } + g[i,j]
    //dp[i,j]表示从(0,0)到(i,j)的最大值，g[i,j]表示(i,j)的值
    //二维dp转一维dp
    //  1   10  3   8   ->  _   10  3   8   ->  _   _   3   8
    //  12  a               12  a+12            12  14  14+b
    //可以看到，求a处的最大值时已经和1无关了，只需比较a的上面的值10和左面的值12即可
    //因此无需二维矩阵保存dp
    public int getMost(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) return 0;
        int n = values[0].length;//列数
        int[] dp = new int[n];
        for (int[] value : values) {
            dp[0] += value[0];//即1  1+12    1+12+5  1+12+5+3分别是dp[0,0] dp[1,0] dp[2,0] dp[3,0]
            for (int i = 1; i < n; i++)
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];//dp[i]就是dp[i,j-1]，dp[i-1]就是dp[i-1,j]
        }
        return dp[n - 1];
    }
}
