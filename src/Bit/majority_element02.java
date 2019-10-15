package Bit;

import java.util.Arrays;

//169
//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 [ n/2 ] 的元素。
//你可以假设数组是非空的，并且给定的数组总是存在众数。
//示例 1:
//输入: [3,2,3]
//输出: 3
//示例 2:
//输入: [2,2,1,1,1,2,2]
//输出: 2
public class majority_element02 {
    public static void main(String[] args) {
        System.out.println(new majority_element02.Solution().majorityElement(new int[]{1, 2, 3, 3, 4, 4, 4}));
    }

    //如果所有数字被单调递增或者单调递减的顺序排序，那么众数的下标为 n/2 （不是传统意义上的众数）
    static class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
}
