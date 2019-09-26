package DynamicProgramming;

//91
//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//给定一个只包含数字的非空字符串，请计算解码方法的总数。
//示例 1:
//输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//示例 2:
//输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
public class decode_ways {
    public static void main(String[] args) {
        System.out.println(new decode_ways.Solution().numDecodings("123"));
    }

    //f(n)是s长度为n时的解法类型个数
    //如果s[n] = 0且s[n - 1] = 1或2 则f(n) = f(n - 2) 否则返回0 即30的情况
    //如果s[n] ≠ 0且s[n - 1] = 1 则f(n) = f(n - 1） + f(n - 2)
    //如果1 <= s[n] <= 6且s[n - 1] = 2 则f(n) = f(n - 1） + f(n - 2)
    static class Solution {
        public int numDecodings(String s) {
            if (s.charAt(0) == '0') return 0;//s[0] == 0直接返回
            int fn_2 = 1, fn = 0, fn_1 = 1;//f(0) = 1,f(-1) = 1
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                        fn = fn_2;
                    } else {
                        return 0;
                    }
                } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                    fn = fn_1 + fn_2;
                }
                fn_2 = fn_1;
                fn_1 = fn;
            }
            return fn;
        }
    }
}
