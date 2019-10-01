package DivideConquer;

public class maximum_subarray03 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }

    static class Solution {
        private int maxV = Integer.MIN_VALUE;

        public int maxSubArray(int[] nums) {
            return maxSubArray(nums, 0, nums.length - 1);
        }

        public int maxSubArray(int[] nums, int left, int right) {
            if (left > right) return Integer.MIN_VALUE;
            int mid = (left + right) / 2;
            //子数组全部在[left,mid)中
            int lmax = maxSubArray(nums, left, mid - 1);
            //子数组全部在(mid,right]中
            int rmax = maxSubArray(nums, mid + 1, right);
            maxV = Math.max(lmax, maxV);
            maxV = Math.max(rmax, maxV);
            //子数组横跨mid
            int sum = 0, mlmax = 0;
            for (int i = mid - 1; i >= left; i--) {
                sum += nums[i];
                mlmax = Math.max(mlmax, sum);
            }
            sum = 0;
            int mrmax = 0;
            for (int i = mid + 1; i <= right; i++) {
                sum += nums[i];
                mrmax = Math.max(mrmax, sum);
            }
            return Math.max(maxV, mlmax + nums[mid] + mrmax);
        }
    }
}
