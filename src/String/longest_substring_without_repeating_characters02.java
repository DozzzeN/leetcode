package String;

import java.util.HashSet;
import java.util.Set;

//3
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
public class longest_substring_without_repeating_characters02 {
    public static void main(String[] args) {
        longest_substring_without_repeating_characters02.Solution sol = new longest_substring_without_repeating_characters02.Solution();
        String test = "pwwkew";
        System.out.print(sol.lengthOfLongestSubstring02(test));
    }

    static class Solution {
        //优化的滑动窗口
        //我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
        //也就是说，如果 s[j] 在 [i,j) 范围内有与 j′ 重复的字符，我们不需要逐渐增加 i 。
        //我们可以直接跳过 [i，j′] 范围内的所有元素，并将 i 变为 j′+1 。
        public int lengthOfLongestSubstring(String s) {
            if (s.equals(" ")) {
                return 1;
            }
            if (s.length() == 0) {
                return 0;
            }
            StringBuilder sb = new StringBuilder();
            //加入首字符
            sb.append(s.charAt(0));
            int result = 1;
            for (int i = 0; i < s.length() - 1; i++) {
                //有重复元素进入sb
                if (sb.indexOf(String.valueOf(s.charAt(i + 1))) != -1) {
                    //从sb的开头删除到重复元素的位置
                    sb.delete(0, 1 + sb.indexOf(String.valueOf(s.charAt(i + 1))));
                }
                sb.append(s.charAt(i + 1));
                result = Math.max(result, sb.length());
            }
            return result;
        }

        //set实现滑动窗口
        //使用 HashSet 将字符存储在当前窗口 [i,j)（最初 j=i）中。
        //然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。
        //直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。如果我们对所有的 i 这样做，就可以得到答案。
        public int lengthOfLongestSubstring02(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                } else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }
    }
}
