package DynamicProgramming;

//115
//给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
//一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
//示例 1:
//输入: S = "rabbbit", T = "rabbit"
//输出: 3
//解释:
//如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
public class distinct_subsequences {
    public static void main(String[] args) {
        System.out.println(new distinct_subsequences.Solution().numDistinct(
                "babgbag", "bag"
        ));
    }

    //动态规划
    //dp[m][n] 对应于从 S[m，S_len) 中能选出多少个 T[n，T_len)
    //S[s] == T[t]，当前字符相等，那就对应两种情况，选择S的当前字母和不选择S的当前字母
    //  dp[s][t] = dp[s+1][t+1] + dp[s+1][t]
    //S[s] != T[t]，只有一种情况，不选择S的当前字母
    //  dp[s][t] = dp[s+1][t]
    static class Solution {
        public int numDistinct(String s, String t) {
            int dp[][] = new int[s.length() + 1][t.length() + 1];
            for (int i = 0; i <= s.length(); i++) {
                dp[i][t.length()] = 1;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = t.length() - 1; j >= 0; j--) {
                    if (s.charAt(i) == t.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
            return dp[0][0];
        }
    }
}
