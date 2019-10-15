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
public class power_of_two02 {
    public static void main(String[] args) {
        System.out.println(new power_of_two02.Solution().isPowerOfTwo(Integer.MIN_VALUE));

    }

    //2的幂始终是以1开头，后面全是0
    //减去1以后各个位就全是1了
    //将 n 和 n-1 做与运算会将最低位的 1 变成 0
    //注意MIN_VALUE - 1会越界
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
