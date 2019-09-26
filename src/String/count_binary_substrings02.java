package String;

//696
//给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
//重复出现的子串要计算它们出现的次数。
//输入: "00110011"
//输出: 6
//解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
//请注意，一些重复出现的子串要计算它们出现的次数。
//另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
public class count_binary_substrings02 {
    public static void main(String[] args) {
        String input = "00110011";
        System.out.println(new count_binary_substrings02.Solution().countBinarySubstrings(input));
    }

    //用curLen记录当前数字个数，preLen记录之前一种数字个数，只要之前数字个数大于等于现在数字个数，就有相同数量的子串
    //如0011 perLen=2 curLen=1表示001 有相同数量的子串01
    //如0011 perLen=2 curLen=2表示0011 有相同数量的子串0011
    static class Solution {
        public int countBinarySubstrings(String s) {
            int preLen = 0, curLen = 1, count = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    curLen++;
                } else {
                    preLen = curLen;
                    curLen = 1;
                }

                if (preLen >= curLen) {
                    count++;
                }
            }
            return count;
        }
    }
}
