package Array_Matrix;

import java.util.Arrays;

//283
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
public class move_zeroes {
    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 0, 3, 12};
        new move_zeroes.Solution().moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int index = 0;
            for(int num:nums){
                if(num!=0){
                    nums[index++]=num;
                }
            }
            while(index<nums.length){
                nums[index++]=0;
            }
        }
    }
}
