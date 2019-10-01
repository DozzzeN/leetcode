package Math;

import java.util.Arrays;

//43
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//示例 1:
//输入: num1 = "2", num2 = "3"
//输出: "6"
//示例 2:
//输入: num1 = "123", num2 = "456"
//输出: "56088"
//说明：
//	num1 和 num2 的长度小于110。
//	num1 和 num2 只包含数字 0-9。
//	num1 和 num2 均不以零开头，除非是数字 0 本身。
//	不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
public class multiply_strings {
    public static void main(String[] args) {
        System.out.println(new multiply_strings.Solution().multiply("9220", "0"));
    }

    static class Solution {
        public String multiply(String num1, String num2) {
            if (num1.length() == 0 || num2.length() == 0) return "0";
            StringBuilder s1 = new StringBuilder().append(num1).reverse();
            StringBuilder s2 = new StringBuilder().append(num2).reverse();
            int[] result = new int[num1.length() + num2.length() + 1];
            for (int i = 0; i < s1.length(); i++) {
                int dig1 = s1.charAt(i) - '0';
                int carry = 0;
                for (int j = 0; j < s2.length(); j++) {
                    int dig2 = s2.charAt(j) - '0';
                    int exist = result[i + j];
                    result[i + j] = ((exist + dig1 * dig2 + carry) % 10);
                    carry = (exist + dig1 * dig2 + carry) / 10;
                }
                if (carry > 0) {
                    result[i + num2.length()] += carry;
                }
            }
            int count = 0;
            for (int i = result.length - 1; i >=0; i--) {
                if (result[i] == 0) {
                    count++;
                } else break;
            }
            if (count == result.length) return "0";
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < result.length - count; i++) {
                res.append(result[i]);
            }
            return res.reverse().toString();
        }
    }
}
