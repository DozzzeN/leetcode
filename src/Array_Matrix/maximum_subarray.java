package Array_Matrix;
//53
//����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
public class maximum_subarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            //��ʱ
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
