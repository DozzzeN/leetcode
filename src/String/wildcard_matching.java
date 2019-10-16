package String;

//44
//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//'?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
//两个字符串完全匹配才算匹配成功。
//说明:
//	s 可能为空，且只包含从 a-z 的小写字母。
//	p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
//示例 1:
//输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
//示例 2:
//输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
//示例 3:
//输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
//示例 4:
//输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
//示例 5:
//输入:
//s = "acdcb"
//p = "a*c?b"
//输入: false
public class wildcard_matching {
    public static void main(String[] args) {
        System.out.println(new wildcard_matching.Solution().isMatch("aabbaa", "a*b*a"));
    }

    //每遇到一个*，就记录当前*的坐标和s的坐标，然后s从前往后扫描，如果能成功匹配则返回true
    //如果不成功，则返回上一次记录的s坐标，右移一位重新扫描
    static class Solution {
        public boolean isMatch(String s, String p) {
            int i = 0;
            int j = 0;
            int start = -1;
            int match = 0;
            while (i < s.length()) {
                if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                    i++;
                    j++;
                } else if (j < p.length() && p.charAt(j) == '*') {
                    start = j;
                    match = i;
                    j++;
                } else if (start != -1) {
                    j = start + 1;
                    match++;
                    i = match;
                } else {
                    return false;
                }
            }
            while (j < p.length()) {
                if (p.charAt(j) != '*') return false;
                j++;
            }
            return true;
        }
    }
}
