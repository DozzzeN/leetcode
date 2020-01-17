package Array_Matrix;

//287
//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
//假设只有一个重复的整数，找出这个重复的数。
//不能更改原数组（假设数组是只读的）。
//只能使用额外的 O(1) 的空间。
//时间复杂度小于 O(n2) 。
//e数组中只有一个重复的数字，但它可能不止重复出现一次。
public class find_the_duplicate_number {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2, 3};
        System.out.println(new Solution().findDuplicate(nums));
    }

    static class Solution {
        public int findDuplicate(int[] nums) {
            //二分查找法
            int l = 1, h = nums.length - 1;
            while (l <= h) {
                int mid = l + (h - l) / 2;
                int cnt = 0;
                for (int i = 0; i < nums.length; i++) {
                    //数组中小于mid的个数为cnt
                    if (nums[i] <= mid) cnt++;
                }
                //cnt大于mid时，重复的数字在左子数组中
                if (cnt > mid) h = mid - 1;
                    //否则在右子数组中
                else l = mid + 1;
            }
            return l;
        }
    }
}
