package Array_Matrix;

import java.util.Arrays;

//645
//集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，
// 导致集合丢失了一个整数并且有一个元素重复。
//给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
//输入: nums = [1,2,2,4]
//输出: [2,3]
public class set_mismatch {
    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 2};
        System.out.println(Arrays.toString(new set_mismatch.Solution().findErrorNums(input)));
    }

    //最直接的方法是先对数组进行排序，这种方法时间复杂度为 O(NlogN)。
    // 本题可以以 O(N) 的时间复杂度、O(1) 空间复杂度来求解。
    //主要思想是通过交换数组元素，使得数组上的元素在正确的位置上。
    // 遍历数组，如果第 i 位上的元素不是 i + 1，那么一直交换第 i 位和 nums[i] - 1 位置上的元素。
    static class Solution {
        public int[] findErrorNums(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return new int[]{nums[i], i + 1};
                }
            }
            return null;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
