package Offer;

//https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
//保证base和exponent不同时为0
public class integer_power {
    public static void main(String[] args) {
        System.out.println(new integer_power.Solution().Power(-2.5, -5));
    }

    public static class Solution {
        public double Power(double base, int exponent) {
            if (base == 0) return 0;
            else if (exponent == 0) return 1;
            double result = 1;
            if (exponent < 0) {
                for (int i = 0; i < -exponent; i++) {
                    result *= base;
                }
            } else {
                for (int i = 0; i < exponent; i++) {
                    result *= base;
                }
            }
            return exponent > 0 ? result : 1 / result;
        }
    }
}
