package String;

//647
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
public class palindromic_substrings03 {
    public static void main(String[] args) {
        String input = "aaa";
        System.out.println(new palindromic_substrings03.Solution().countSubstrings(input));

    }

    //从中心向外扩散
    //从字符串的某一位开始，尝试着去扩展子字符串。
    static class Solution {
        private int cnt = 0;

        public int countSubstrings(String s) {
            for (int i = 0; i < s.length(); i++) {
                extendSubstrings(s, i, i);     // 奇数长度 每次扩展两个1+2+...是奇数
                extendSubstrings(s, i, i + 1); // 偶数长度 每次扩展两个2+2+...是偶数
            }
            return cnt;
        }

        //i=0 cnt=1 a start=0 end=0
        //i=0 cnt=1 aa start=0 end=1
        //i=1 cnt=2 a start=1 end=1 aaa start=0 end=2
        //i=1 cnt=1 aa start=1 end=2
        //i=2 cnt=1 a start=2 end=2
        private void extendSubstrings(String s, int start, int end) {
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
                cnt++;
            }
        }
    }
}
