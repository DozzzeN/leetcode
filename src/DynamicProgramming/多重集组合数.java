package DynamicProgramming;

//有n种物品，第i种物品有a;个。不同种类的物品可以互相区分但相同种类的无法区分。从
//这些物品中取出m个的话，有多少种取法?求出方案数模M的余数。

//输入
//n=3
//m=3
//a={1，2，3}
//M=10000

//输出
//6(0+0+3，0+1+2，0+2+1，1+0+2，1+1+1，1+2+0)
public class 多重集组合数 {
    //dp[i+1][j]:=从前i种物品中取出j个组合总数
    //dp[i+1][j] = sigma(k=0,min(j,a[i])) {dp[i][j-k]}
    //           = dp[i+1][j-1]+dp[i][j]-dp[i][j-1-ai]
    int n = 3, m = 3;
    int[] a = new int[]{1, 2, 3};
    int M = 10000;
    int[][] dp = new int[n + 1][m + 1];

    public static void main(String[] args) {
        new 多重集组合数().solve();
    }

    public void solve() {
        //一个都不取的方法总是只有一种
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - 1 - a[i] >= 0) {
                    dp[i + 1][j] = (dp[i + 1][j - 1] + dp[i][j] - dp[i][j - 1 - a[i]] + M) % M;
                } else {
                    dp[i + 1][j] = (dp[i + 1][j - 1] + dp[i][j]) % M;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
