package DynamicProgramming;

//有n个无区别的物品，将它们划分成不超过m组，求出划分方法数模M的余数。
//输入
//n=4
//m=3
//M=10000
//输出
//4(1+1+2=1+3=2+2=4)
//注意1+1+2和1+2+1是一个划分，这样的划分叫做n的m划分
public class 划分数 {
    //dp[i][j]:=j的i划分总数
    //dp[i][j]=dp[i][j-i]+dp[i-1][j]
    int n = 4, m = 3;
    int M = 10000;
    int[][] dp = new int[m + 1][n + 1];

    public static void main(String[] args) {
        new 划分数().solve();
    }

    public void solve() {
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= i) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - i]) % M;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
