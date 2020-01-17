package String;

import java.util.ArrayList;
import java.util.List;

//76
//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
//示例：
//输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC"
//说明：
//	如果 S 中不存这样的子串，则返回空字符串 ""。
//	如果 S 中存在这样的子串，我们保证它是唯一的答案。
public class minimum_window_substring {
    public static void main(String[] args) {
        System.out.println(new minimum_window_substring.Solution().minWindow("aa", "aa"));
    }

    //直接找到所有s中包含t的子字符串，选出最短
    //超时
    static class Solution {
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0) return "";
            if (t == null || s.length() < t.length()) return "";
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    String temp = s.substring(i, j + 1);
                    if (isContain(temp, t)) {
                        list.add(temp);
                    }
                }
            }
            String result = list.size() == 0 ? "" : list.get(0);
            for (String s1 : list) {
                if (result.length() > s1.length()) {
                    result = s1;
                }
            }
            return result;
        }

        public boolean isContain(String s, String t) {
            StringBuilder sb = new StringBuilder(s);
            boolean result = true;
            for (int i = 0; i < t.length(); i++) {
                int index = sb.indexOf(String.valueOf(t.charAt(i)));
                if (index >= 0) {
                    sb.deleteCharAt(index);
                } else {
                    result = false;
                    break;
                }
            }
            return result;
        }
    }
}

