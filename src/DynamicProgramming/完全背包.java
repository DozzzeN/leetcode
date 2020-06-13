package DynamicProgramming;

//有n种重量和价值分别为wi,vi的物品。从这些物品中挑选总重量不超过W的物品，求出挑
//选物品价值总和的最大值。在这里，每种物品可以挑选任意多件。

//输入
//n=3
//(w，v)={(3，4)，(4，5)，(2，3)}
//W=7

//输出
//10(0号物品选1个，2号物品选2个)
public class 完全背包 {
    //dp[i+1][j]=从前i个物品中选总重不小于j的总价值的最大值
    //dp[0][j]=0
    //dp[i+1][j] = max{dp[i][j-k*w[i]]+k*v[i]} k>=0且k*w[i]<=j
    int n = 3, W = 7;
    int[] w = new int[]{3, 4, 2};
    int[] v = new int[]{4, 5, 3};
    int[][] dp = new int[n + 1][W + 1];

    public static void main(String[] args) {
        new 完全背包().solve();
        new 完全背包().solve02();
        new 完全背包().solve03();
    }

    //O(nW^2)
    public void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                for (int k = 0; k * w[i] <= j; k++) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j - k * w[i]] + k * v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }

    //O(nW)
    public void solve02() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i + 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }

    //减少空间
    public void solve03() {
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = w[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[W]);
    }
}
