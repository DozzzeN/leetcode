package String;

//696
//给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
//重复出现的子串要计算它们出现的次数。
//输入: "00110011"
//输出: 6
//解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
//请注意，一些重复出现的子串要计算它们出现的次数。
//另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
public class count_binary_substrings {
    public static void main(String[] args) {
        String input = "00110011";
        System.out.println(new count_binary_substrings.Solution().countBinarySubstrings(input));
    }

    //超时
    //穷举所有子字符串，正则判断是否是多个1+多个0或者多个0+多个1的形式
    static class Solution {
        public int countBinarySubstrings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            StringBuilder sb = new StringBuilder();
            int countOfZero = 0;
            int countOfOne = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    String temp = s.substring(j, i + 1);
                    for (int k = 0; k < temp.length(); k++) {
                        if (temp.charAt(k) == '0') {
                            sb.append(0);
                            countOfZero++;
                        }
                        if (temp.charAt(k) == '1') {
                            sb.append(1);
                            countOfOne++;
                        }
                        if (sb.length() == temp.length() && (countOfOne == countOfZero) &&
                                ((temp.matches("0+1+")) || (temp.matches("1+0+")))) {
                            count++;
                        }
                    }
                    countOfOne = 0;
                    countOfZero = 0;
                    sb.delete(0, sb.length());
                }
            }
            return count;
        }
    }
}
