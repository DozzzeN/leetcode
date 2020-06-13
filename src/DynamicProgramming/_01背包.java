package DynamicProgramming;

//有n个重量和价值分别为wi，vi的物品。从这些物品中挑选出总重量不超过W的物品，求所
//有挑选方案中价值总和的最大值。

//输入
//n=4
//(w，v)={(2，3)，(1，2)，(3，4)，(2，2)}
//W=5

import java.util.Arrays;

//输出
//7(选择第0、1、3号物品)
public class _01背包 {
    int n = 4, W = 5;
    int[] w = new int[]{2, 1, 3, 2};
    int[] v = new int[]{3, 2, 4, 2};
    //dp[i+1][j]=从前i个物品中选总重不小于j的总价值的最大值
    //dp[0][j]=0
    //dp[i+1][j] = dp[i][j] 当w[i]>j
    //           = max{dp[i][j],dp[i][j-w[i]]+v[i]} 其他
    int[][] dp = new int[n + 1][W + 1];

    public static void main(String[] args) {
        new _01背包().solve();
        new _01背包().solve02();
        new _01背包().solve03();
    }

    public void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }

    //减少空间
    public void solve02() {
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = W; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[W]);
    }

    //dp改为针对不同的价值计算最小的重量
    //dp[i+1][j]=从前i个物品中选价值总和为j时总重量的最小值，初始为无穷大
    //dp[i+1][j]=min{dp[i][j],dp[i][j-v[i]]+w[i]}
    public void solve03() {
        int maxV = v[0];
        for (int value : v) {
            maxV = Math.max(maxV, value);
        }
        int[][] dp = new int[n + 1][n * maxV + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 1000000);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n * maxV; j++) {
                if (j < v[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.min(dp[i][j], dp[i][j - v[i]] + w[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n * maxV; i++) {
            if (dp[n][i] <= W) res = i;
        }

        System.out.println(res);
    }
}
