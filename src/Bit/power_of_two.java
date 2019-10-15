package Bit;

//231
//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//示例 1:
//输入: 1
//输出: true
//解释: 2^0 = 1
//示例 2:
//输入: 16
//输出: true
//解释: 2^4 = 16
//示例 3:
//输入: 218
//输出: false
public class power_of_two {
    public static void main(String[] args) {
        System.out.println(new power_of_two.Solution().isPowerOfTwo(2));

    }

    //每次除以2看是否能除尽
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n == 0) return false;
            while (n != 1) {
                if (n == (2 * (n >> 1))) {
                    n >>= 1;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
