package Array_Matrix;

public class maximum_subarray02 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }

    //动态规划
    static class Solution {
        public int maxSubArray(int[] nums) {
            int result = nums[0];
            int temp = nums[0];
            for (int i = 1; i < nums.length; i++) {
                //如果temp是负数，则选择nums[i]舍弃之前的temp
                //比较原来的结果加上新的数与新的数的大小
                temp = Math.max(nums[i] + temp, nums[i]);//加上一位的当前最优解
                //比较原来的结果与原来的结果加上新的数的大小
                result = Math.max(result, temp);
            }
            return result;

            //第二种方法原理一样，只不过若是负数则可以省略求和的判断
//            int maxSum = 0;
//            int thisSum = 0;
//            for (int i = 0; i < nums.length; i++) {
//                thisSum += nums[i];
//                if (thisSum > maxSum) {
//                    maxSum = thisSum;
//                } else if (thisSum < 0) {
//                    thisSum = 0;
//                }
//            }
//            return maxSum;
        }
    }
}
