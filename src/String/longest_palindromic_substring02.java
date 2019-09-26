package String;

//5
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
public class longest_palindromic_substring02 {
    public static void main(String[] args) {
        String input = "abbc";
        System.out.println(new longest_palindromic_substring02.Solution().longestPalindrome(input));

    }

    //从中心向外扩展 类似于palindromic_substrings03
    static class Solution {
        private int start = 0, maxLen = 0;

        public String longestPalindrome(String s) {
            if (s.length() < 1) return s;
            for (int i = 0; i < s.length(); i++) {
                // 回文子串为奇数时，查找最长回文子串
                extendPalindrome(s, i, i);
                // 回文子串为偶数时，查找最长回文子串
                extendPalindrome(s, i, i + 1);
            }
            return s.substring(start, start + maxLen);
        }

        private void extendPalindrome(String s, int left, int right) {
            // 判断是否为回文子串，若是，则左指针向左移动，右指针向右移动
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            // 回文子串查找完成后，判断刚刚查找的回文子串是否为最长回文子串，若是，则更新起始位置和最长长度
            if (maxLen < right - left - 1) {
                start = left + 1;
                maxLen = right - left - 1;
            }
        }
    }

}
