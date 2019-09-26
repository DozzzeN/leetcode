package Math;

//29
//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//返回被除数 dividend 除以除数 divisor 得到的商。
//示例 1:
//输入: dividend = 10, divisor = 3
//输出: 3
//示例 2:
//输入: dividend = 7, divisor = -3
//输出: -2
public class divide_two_integers {
    public static void main(String[] args) {
        System.out.println(new divide_two_integers.Solution().divide(10, 3));
    }

    static class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) return 0;
            int sign = 1;
            if (dividend < 0) sign *= -1;
            if (divisor < 0) sign *= -1;
            long longDivisor = divisor < 0 ? -(long) divisor : divisor;
            long longDividend = dividend < 0 ? -(long) dividend : dividend;
            long value = 1, temp = longDivisor, result = 0;
            while (longDividend > 0) {
                while (temp <= longDividend) {
                    value <<= 1;
                    temp <<= 1;
                }
                result += value >> 1;
                value = 1;
                temp >>= 1;
                longDividend -= temp;
                temp = longDivisor;
            }
            result = sign * result;
            if (result >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) result;
        }
    }
}
