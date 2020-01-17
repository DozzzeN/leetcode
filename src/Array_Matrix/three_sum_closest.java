package Array_Matrix;

import java.util.Arrays;

public class three_sum_closest {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        System.out.println(new Solution().threeSumClosest(nums, 0));
    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            //×¢ÒâJavaÖĞMath.abs(-2147483648) = -2147483648
            int result = Integer.MIN_VALUE / 2;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int start = i + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[start] + nums[i] + nums[end];
                    if (sum == target) {
                        return sum;
                    } else if (sum > target) {
                        result = Math.abs(sum - target) < Math.abs(result - target) ? sum : result;
                        end--;
                    } else {
                        result = Math.abs(sum - target) < Math.abs(result - target) ? sum : result;
                        start++;
                    }
                }
            }
            return result;
        }
    }
}
