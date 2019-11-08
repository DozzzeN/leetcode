package Bit;

import java.util.Arrays;

//762
//给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
//（注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
//示例 1:
//输入: L = 6, R = 10
//输出: 4
//解释:
//6 -> 110 (2 个计算置位，2 是质数)
//7 -> 111 (3 个计算置位，3 是质数)
//9 -> 1001 (2 个计算置位，2 是质数)
//10-> 1010 (2 个计算置位，2 是质数)
//示例 2:
//输入: L = 10, R = 15
//输出: 5
//解释:
//10 -> 1010 (2 个计算置位, 2 是质数)
//11 -> 1011 (3 个计算置位, 3 是质数)
//12 -> 1100 (2 个计算置位, 2 是质数)
//13 -> 1101 (3 个计算置位, 3 是质数)
//14 -> 1110 (3 个计算置位, 3 是质数)
//15 -> 1111 (4 个计算置位, 4 不是质数)
//注意:
//	L, R 是 L <= R 且在 [1, 10^6] 中的整数。
//	R - L 的最大值为 10000。
public class prime_number_of_set_bits_in_binary_representation {
    public static void main(String[] args) {
        System.out.println(new prime_number_of_set_bits_in_binary_representation.Solution().countPrimeSetBits(842, 888));
    }

    static class Solution {
        public int countPrimeSetBits(int L, int R) {
            int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
            int count = 0, result = 0, _R = R;
            while (_R != 0) {
                count++;
                _R >>= 1;
            }
            for (int i = L; i <= R; i++) {
                int digit = 0;
                for (int j = 0; j <= count; j++) {
                    digit += ((i & (1 << j)) >> j);
                }
                //[1] 搜索值不是数组元素，且在数组范围内，从1开始计数，得“ - 插入点索引值”；
                //[2] 搜索值是数组元素，从0开始计数，得搜索值的索引值；
                //[3] 搜索值不是数组元素，且大于数组内元素，索引值为 – (length + 1);
                //[4] 搜索值不是数组元素，且小于数组内元素，索引值为 – 1。
                int index = Arrays.binarySearch(prime, digit);
                if (index >= 0 && index <= 8) {
                    result++;
                }
            }
            return result;
        }
    }
}
