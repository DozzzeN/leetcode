package Dichotomy;

import java.util.Arrays;

//34
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//你的算法时间复杂度必须是 O(log n) 级别。
//如果数组中不存在目标值，返回 [-1, -1]。
//示例 1:
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//示例 2:
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]
public class find_first_and_last_position_of_element_in_sorted_array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new find_first_and_last_position_of_element_in_sorted_array.Solution().searchRange(
                new int[]{1, 2, 3}, 2
        )));
    }

    //两次二分找到左右边界，参考二分查找算法框架
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[]{-1, -1};
            if (nums == null || nums.length == 0) return result;
            int left = 0, right = nums.length - 1;
            //此时不能取等，防止边界溢出 如{2,2}这种
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (nums[left] == target) {
                result[0] = left;
            } else {
                return result;
            }
            right = nums.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            result[1] = right - 1;
            return result;
        }
    }
}
