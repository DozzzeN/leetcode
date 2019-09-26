package Array_Matrix;
//53
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
public class maximum_subarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            //超时
            int sum = 0;
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j <= i; j++) {
                    for (int k = j; k <= i; k++) {
                        sum += nums[k];
                    }
                    result = Math.max(sum, result);
                    sum = 0;
                }
            }
            return result;
        }
    }
}
