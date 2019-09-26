package Array_Matrix;

public class maximum_subarray03 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            //·ÖÖÎ
            int maxSum = 0;
            int thisSum = 0;
            for (int i = 0; i < nums.length; i++) {
                thisSum += nums[i];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                } else if (thisSum < 0) {
                    thisSum = 0;
                }
            }
            return maxSum;
        }
    }
}
