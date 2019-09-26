package DivideConquer;

//115
//给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
//一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
//示例 1:
//输入: S = "rabbbit", T = "rabbit"
//输出: 3
//解释:
//如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
public class distinct_subsequences {
    public static void main(String[] args) {
        System.out.println(new distinct_subsequences.Solution().numDistinct(
                "babgbag", "bag"
        ));
    }

    //递归之分治（回溯）
    static class Solution {
        public int numDistinct(String s, String t) {
            return numDistinct(s, 0, t, 0);
        }

        //从sStart开始的s串中选择从tStart开始的t串
        public int numDistinct(String s, int sStart, String t, int tStart) {
            int count = 0;
            //t串已经到达末尾，选法是1种
            if (tStart == t.length()) {
                return 1;
            }
            //s串已经到达末尾，选法是0种
            if (sStart == s.length()) {
                return 0;
            }
            if (s.charAt(sStart) == t.charAt(tStart)) {
                //从当前sStart位置的s串中选此字母与不选此字母
                count = numDistinct(s, sStart + 1, t, tStart + 1)
                        + numDistinct(s, sStart + 1, t, tStart);
            } else {
                count = numDistinct(s, sStart + 1, t, tStart);
            }
            return count;
        }
    }
}
