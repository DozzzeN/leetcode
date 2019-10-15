package Bit;

import java.util.Arrays;

//260
//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
//示例 :
//输入: [1,2,1,3,2,5]
//输出: [3,5]
//注意：
//	结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
//	你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
public class single_number_iii {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new single_number_iii.Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 99})));
    }

    //1.对所有数字异或,一样的数字抵消,出现一次的两个数字异或运算后必定不为0;
    //2.这个数字和相反数做与运算得到一个二进制位最右边一位为1的数字;
    //3.mask和数组的每个数字做与运算,等于0的分为一组,等于mask的分为一组,同时也将两个不一样的数字分开;
    static class Solution {
        public int[] singleNumber(int[] nums) {
            int[] result = new int[2];
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            int mask = xor & (-xor);
            for (int num : nums) {
                if ((mask & num) == 0) {
                    //不能写作result[0] = num 因为可能取到重复的元素
                    result[0] ^= num;
                } else {
                    result[1] ^= num;
                }
            }
            //或者
            //result[1] = result[0] ^ xor;
            return result;
        }
    }
}
