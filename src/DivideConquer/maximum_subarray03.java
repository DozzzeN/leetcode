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
            //������ȫ����[left,mid)��
            int lmax = maxSubArray(nums, left, mid - 1);
            //������ȫ����(mid,right]��
            int rmax = maxSubArray(nums, mid + 1, right);
            maxV = Math.max(lmax, maxV);
            maxV = Math.max(rmax, maxV);
            //��������mid
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
