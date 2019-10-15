package String;

import java.util.ArrayList;
import java.util.List;

//438
//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//说明：
//	字母异位词指字母相同，但排列不同的字符串。
//	不考虑答案输出的顺序。
//示例 1:
//输入:
//s: "cbaebabacd" p: "abc"
//输出:
//[0, 6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 示例 2:
//输入:
//s: "abab" p: "ab"
//输出:
//[0, 1, 2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
public class find_all_anagrams_in_a_string {
    public static void main(String[] args) {
        List<Integer> result = new find_all_anagrams_in_a_string.Solution().findAnagrams(
                "abaacbabc",
                "abc"
        );
        System.out.println(result);
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            if (s == null || s.length() == 0) return result;
            if (p == null || p.length() == 0 || s.length() < p.length()) return result;
            int[] appearCount = new int[256];
            int[] expectedCount = new int[256];
            for (int i = 0; i < p.length(); i++) {
                expectedCount[p.charAt(i)]++;
            }
            int left = 0;//左指针
            int appeared = 0;//出现长度
            for (int right = 0; right < s.length(); right++) {
                if (expectedCount[s.charAt(right)] > 0) {
                    appearCount[s.charAt(right)]++;
                    if (appearCount[s.charAt(right)] <= expectedCount[s.charAt(right)]) appeared++;
                }
                if (appeared == p.length()) {
                    //收缩左指针
                    while (appearCount[s.charAt(left)] > expectedCount[s.charAt(left)]
                            || expectedCount[s.charAt(left)] == 0) {
                        appearCount[s.charAt(left)]--;
                        left++;
                    }
                    //长度相等再加入
                    if ((right - left + 1) == p.length() && !result.contains(left)) {
                        result.add(left);
                    }
                }
            }
            return result;
        }
    }
}
