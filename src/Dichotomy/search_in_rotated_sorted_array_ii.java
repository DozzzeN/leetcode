package Dichotomy;

//81
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
//编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
//示例 1:
//输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
//示例 2:
//输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false
public class search_in_rotated_sorted_array_ii {
    public static void main(String[] args) {
        System.out.println(new search_in_rotated_sorted_array_ii.Solution().search(
                new int[]{2, 5, 6, 0, 0, 1, 2}, 0
        ));
    }

    static class Solution {
        public boolean search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] == target) return true;
                    //target 5 in {4,5,6,2,3} 此时[left,mid]是递增的
                else if (nums[mid] > nums[left]) {
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                    //target 2 in {5,0,1,2,3} 此时[mid,right]是递增的
                } else if (nums[mid] < nums[left]) {
                    if (nums[mid] <= target && target < nums[left]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                    //无法确定 nums[mid] = numd[left]
                } else {
                    left++;
                }
            }
            return false;
        }
    }
}
