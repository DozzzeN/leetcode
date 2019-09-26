package DynamicProgramming;

//377
//给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
//示例:
//nums = [1, 2, 3]
//target = 4
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
//因此输出为 7。
public class combination_sum_iv {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new combination_sum_iv.Solution().combinationSum4(nums, 4));
    }

    //很容易发现“重叠子问题”，因此，我们可以使用“动态规划”来做，如果题目问具体的解，那么用“回溯搜索”做。
    static class Solution {
        //dp[i]表示目标总和为i时的选择方法
        //dp[i] = sum { dp[i - num] for num in nums and i >= num}
        //dp[4] = dp[3] + dp[2] + dp[1]   7
        //dp[3] = dp[2] + dp[1] + dp[0]   4
        //dp[2] = dp[1] + dp[0]           2
        //dp[1] = dp[0]                   1
        //dp[0] = 1
        int[] nums;

        //超时
        public int combinationSum4(int[] nums, int target) {
            this.nums = nums;
            return dp(target);
        }

        public int dp(int i) {
            int result = 0;
            if (i < 0) return 0;
            if (i == 0) return 1;
            for (int num : nums) {
                result += dp(i - num);
            }
            return result;
        }
    }
}
