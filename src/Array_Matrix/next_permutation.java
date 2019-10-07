package Array_Matrix;

import java.util.Arrays;

//31
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//必须原地修改，只允许使用额外常数空间。
//以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
public class next_permutation {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 7, 5, 3, 2};
        new next_permutation.Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public void nextPermutation(int[] nums) {
            int PartitionNumber = nums.length - 1;
            int changeNumber = 0;
            for (int i = PartitionNumber; i > 0; i--) {
                if (nums[i - 1] < nums[i]) {
                    PartitionNumber = i - 1;
                    break;
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[PartitionNumber]) {
                    changeNumber = i;
                    break;
                }
            }
            if (PartitionNumber == nums.length - 1) {
                for (int i = 0; i < nums.length / 2; i++) {
                    nums[i] = nums[nums.length - i - 1] + nums[i];
                    nums[nums.length - i - 1] = nums[i] - nums[nums.length - i - 1];
                    nums[i] = nums[i] - nums[nums.length - i - 1];
                }
                return;
            }
            int temp = nums[changeNumber];
            nums[changeNumber] = nums[PartitionNumber];
            nums[PartitionNumber] = temp;
            PartitionNumber++;
            int end = nums.length - 1;
            while (PartitionNumber < end) {
                nums[PartitionNumber] = nums[end] + nums[PartitionNumber];
                nums[end] = nums[PartitionNumber] - nums[end];
                nums[PartitionNumber] = nums[PartitionNumber] - nums[end];
                end--;
                PartitionNumber++;
            }
        }
    }
}
