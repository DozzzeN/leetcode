package DynamicProgramming;

//给定两个字符串s1s2...sn和t1t2..tn. 求出这两个字符串最长的公共子序列的长度。字符串
//s1s2..sn的子序列指可以表示为si1si2...sim(i1<i2<...im)的序列。

//输入
//n=4
//m=4
//s = "abcd"
//t = "becd

//输出
//3("bcd")
public class 最长公共子序列 {
    //dp[i][j]:=s1...si和t1...tj对应的最长公共子序列的长度
    //dp[i+1][j+1] = dp[i][j]+1 si+1=tj+1
    //             = max{dp[i+1][j],dp[i][j+1]} 其他

    int n = 4, m = 4;
    char[] s = {'a', 'b', 'c', 'd'};
    char[] t = {'b', 'e', 'c', 'd'};
    int[][] dp = new int[n + 1][m + 1];

    public static void main(String[] args) {
        new 最长公共子序列().solve();
    }

    public void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i] == t[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
