package String;

//647
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
public class palindromic_substrings {
    public static void main(String[] args) {
        String input = "aaa";
        System.out.println(new palindromic_substrings.Solution().countSubstrings(input));

    }

    //穷举所有子字符串，检查是否是回文串
    static class Solution {
        public int countSubstrings(String s) {
            int count = 0;
            for (int i = 0; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (isPalidrome_string(s.substring(j, i))) {
                        count++;
                    }
                }
            }
            return count;
        }

        public boolean isPalidrome_string(String s) {
            boolean isPs = true;
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    isPs = false;
                }
            }
            return isPs;
        }
    }
}
