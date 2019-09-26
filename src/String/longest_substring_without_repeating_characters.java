package String;

import java.util.HashSet;
import java.util.Set;

//3
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
public class longest_substring_without_repeating_characters {
    public static void main(String[] args) {
        longest_substring_without_repeating_characters.Solution sol = new longest_substring_without_repeating_characters.Solution();
        String test = "pwwkeww";
        System.out.print(sol.lengthOfLongestSubstring(test));
    }

    //穷举所有子串，超时
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int ans = 0;
            //得到所有子串
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j <= n; j++)
                    if (allUnique(s, i, j)) {
                        ans = Math.max(ans, j - i);
                    }
            return ans;
        }

        //如果子字符串中的字符都是唯一的，它会返回 true，否则会返回 false
        public boolean allUnique(String s, int start, int end) {
            Set<Character> set = new HashSet<>();
            for (int i = start; i < end; i++) {
                Character ch = s.charAt(i);
                if (set.contains(ch)) return false;
                set.add(ch);
            }
            //不重复时为ture，此时长度为end-start（j-i）
            return true;
        }
    }
}
