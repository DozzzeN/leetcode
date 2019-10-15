package Dichotomy;

//33
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//你可以假设数组中不存在重复的元素。
//你的算法时间复杂度必须是 O(log n) 级别。
//示例 1:
//输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
//示例 2:
//输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1
public class search_in_rotated_sorted_array {
    public static void main(String[] args) {
        System.out.println(new search_in_rotated_sorted_array.Solution().search(
                new int[]{4, 5, 6, 7, 0, 1, 2}, 0
        ));
    }

    //将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
    //此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] == target) return mid;
                    //target 5 in {4,5,6,2,3} 此时[left,mid]是递增的
                else if (nums[mid] >= nums[left]) {
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                    //target 2 in {5,0,1,2,3} 此时[mid,right]是递增的
                } else {
                    if (nums[mid] <= target && target < nums[left]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
