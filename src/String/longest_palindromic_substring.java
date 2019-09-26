package String;

//5
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
public class longest_palindromic_substring {
    public static void main(String[] args) {
        String input = "babad";
        System.out.println(new longest_palindromic_substring.Solution().longestPalindrome2(input));

    }

    //优化暴力搜索，将时间复杂度由O(n^3)转为O(n^2)
    //动态规划 定义函数P(i,j) 如果Si...Sj串是回文串则返回true，否则返回false
    //P(i,j) = P(i+1,j-1) 如果Si==Sj
    //P(i,i) = true
    //P(i,i+1) = true 如果Si==Si+1
    static class Solution {
        //超时
        public String longestPalindrome(String s) {
            int length = 0;
            int left = 0;
            int right = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (P(s, i, j)) {
                        if (length < (j - i + 1)) {
                            //substring包前不包后
                            length = j - i + 1;
                            left = i;
                            right = j;
                        }
                    }
                }
            }

            return s.length() <= 1 || s == null ? s : s.substring(left, right + 1);
        }

        public boolean P(String s, int i, int j) {
            if (i == j) return true;
            if (i + 1 == j && s.charAt(i) == s.charAt(j)) return true;
            if (s.charAt(i) == s.charAt(j)) {
                return P(s, i + 1, j - 1);
            }
            return false;
        }

        //不会超时
        public String longestPalindrome2(String s) {
            if (s.length() <= 1) return s;
            if (s == null) return null;

            int len = s.length();
            //定义二维数组存储dp的结果值
            boolean[][] dp = new boolean[len][len];
            String result = s.substring(0, 1);
            for (int i = 0; i < len; i++) {
                //单个字符（起点终点索引相同）全部为true
                dp[i][i] = true;
            }
            for (int i = 0; i < len - 1; i++) {
                //两个字符如果字符相同为true（注意数组不要越界）
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                if (dp[i][i + 1]) {
                    result = s.substring(i, i + 1 + 1);
                }
            }
            //依次循环三个字符、四个字符......
            for (int k = 3; k <= len; k++) {
                for (int i = 0; (i + k) <= len; i++) {
                    //有起点索引 i，有子串长度 k 则可以得到终点索引 j （同样注意数组越界问题）
                    int j = i + k - 1;
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    if (dp[i][j] && (j - i + 1) > result.length()) {
                        //比较回文子串长度与保存的result长度
                        result = s.substring(i, j + 1);
                    }
                }
            }
            return result;
        }
    }
}
