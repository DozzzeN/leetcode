package Bit;

//693
//给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
//示例 1:
//输入: 5
//输出: True
//解释:
//5的二进制数是: 101
//示例 2:
//输入: 7
//输出: False
//解释:
//7的二进制数是: 111
//示例 3:
//输入: 11
//输出: False
//解释:
//11的二进制数是: 1011
// 示例 4:
//输入: 10
//输出: True
//解释:
//10的二进制数是: 1010
public class binary_number_with_alternating_bits {
    public static void main(String[] args) {
        System.out.println(new binary_number_with_alternating_bits.Solution().hasAlternatingBits(11));
    }

    static class Solution {
        public boolean hasAlternatingBits(int n) {
            int lastDigit, thisDigit = n & 1;
            while (n > 0) {
                lastDigit = thisDigit;
                n >>= 1;
                thisDigit = n & 1;
                if (lastDigit == thisDigit) {
                    return false;
                }
            }
            return true;
        }
    }
}
