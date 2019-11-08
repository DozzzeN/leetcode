package Array_Matrix;

//217
//给定一个整数数组，判断是否存在重复元素。
//如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
//示例 1:
//输入: [1,2,3,1]
//输出: true
//示例 2:
//输入: [1,2,3,4]
//输出: false
//示例 3:
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true
public class contains_duplicate {
    public static void main(String[] args) {
        System.out.println(new contains_duplicate.Solution().containsDuplicate(new int[]{3, 3}));
    }

    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            int min = nums[0], max = nums[0];
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
            int[] hashtable = new int[max - min + 1];
            for (int i = 0; i < n; i++) {
                if (hashtable[nums[i] - min] == 0) {
                    hashtable[nums[i] - min] = 1;
                } else {
                    hashtable[nums[i] - min]++;
                }
            }
            for (int i = 0; i < max - min + 1; i++) {
                if (hashtable[i] > 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
