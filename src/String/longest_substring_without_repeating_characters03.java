package String;

//3
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
public class longest_substring_without_repeating_characters03 {
    public static void main(String[] args) {
        longest_substring_without_repeating_characters03.Solution sol = new longest_substring_without_repeating_characters03.Solution();
        String test = "pwwkew";
        System.out.print(sol.lengthOfLongestSubstring(test));
    }

    static class Solution {
        //当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换字符串。
        //常用的表如下所示：
        //int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
        //int [128] 用于ASCII码
        //int [256] 用于扩展ASCII码
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128]; // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                //找出重复的字符的索引
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                //将遍历过的字符的位置存入数组对应索引处（更新重复字符的最新位置）
                index[s.charAt(j)] = j + 1;
            }
            return ans;

        }
    }
}
