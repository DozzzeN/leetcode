package DynamicProgramming;

//97
//给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
//示例 1:
//输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出: true
//示例 2:
//输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出: false
public class interleaving_string02 {
    public static void main(String[] args) {
        System.out.println(new interleaving_string02.Solution().isInterleave(
                "aabcc", "dbbca", "aadbbcbcac"
        ));
    }

    //动态规划
    //dp[i][j]表示s1的i+1位前缀和s2的j+1位前缀是否能够匹配s3的i+j+2位前缀
    static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s3.length() != s1.length() + s2.length()) return false;
            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

            for (int i = 0; i <= s1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = true;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    } else {
                        dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                                || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                    }
                }
            }
            return dp[s1.length()][s2.length()];
        }
    }
}
