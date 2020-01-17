package Array_Matrix;

//使用数组中的值作为索引下标进行遍历，遍历的结果肯定是一个环（有一个重复元素）
//检测重复元素问题转换成检测环的入口
public class find_the_duplicate_number02 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 1};
        System.out.println(new Solution().findDuplicate(nums));
    }

    static class Solution {
        public int findDuplicate(int[] nums) {
            int slow = nums[0], fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
