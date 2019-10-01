package String;

//76
//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
//示例：
//输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC"
//说明：
//	如果 S 中不存这样的子串，则返回空字符串 ""。
//	如果 S 中存在这样的子串，我们保证它是唯一的答案。
public class minimum_window_substring02 {
    public static void main(String[] args) {
        System.out.println(new minimum_window_substring02.Solution().minWindow("ADOBECODEBANC",
                "ABC"));
    }

    //哈希表
    //采用双指针，动态维护一个区间。尾指针不断往后扫，当扫到一个窗口包含了所有T的字符后，再收缩头指针，直到不能收缩为止
    //这就是当前的最小窗口。最后记录所有最小窗口的值，从中选择最小的一个
    static class Solution {
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0) return "";
            if (t == null || s.length() < t.length()) return "";
            int[] appearCount = new int[256];
            int[] expectCount = new int[256];
            for (int i = 0; i < t.length(); i++) {
                expectCount[t.charAt(i)]++;
            }
            int minV = Integer.MAX_VALUE;
            int minStart = 0;
            int widStart = 0;
            int appeared = 0;
            for (int widEnd = 0; widEnd < s.length(); widEnd++) {
                if (expectCount[s.charAt(widEnd)] > 0) {
                    appearCount[s.charAt(widEnd)]++;
                    //统计S中出现T的字符的个数appeared
                    if (appearCount[s.charAt(widEnd)] <= expectCount[s.charAt(widEnd)]) appeared++;
                }
                if (appeared == t.length()) {
                    //收缩头指针，直到不能再收缩
                    //条件一：S中出现T的字符个数比T中字符多；条件二：T中未出现S的字符
                    while (appearCount[s.charAt(widStart)] > expectCount[s.charAt(widStart)]
                            || expectCount[s.charAt(widStart)] == 0) {
                        appearCount[s.charAt(widStart)]--;
                        widStart++;
                    }
                    //记录窗口长度，标记头指针处为窗口的起点位置
                    if (minV > (widEnd - widStart + 1)) {
                        minV = widEnd - widStart + 1;
                        minStart = widStart;
                    }
                }
            }
            if (minV == Integer.MAX_VALUE) return "";
            return s.substring(minStart, minV + minStart);
        }
    }
}

