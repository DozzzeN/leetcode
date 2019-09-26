package BackTracking;

import java.util.Stack;

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
        int[] nums = new int[]{1, 2, 4};
        System.out.println(new combination_sum_iv.Solution().combinationSum4(nums, 32));
    }

    static class Solution {
        int result;
        int[] nums;

        //超时，使用动态规划
        public int combinationSum4(int[] nums, int target) {
            this.nums = nums;
            findCombinationSum(target, 0, new Stack<>());
            return result;
        }

        public void findCombinationSum(int residue, int start, Stack<Integer> solution) {
            if (residue < 0) {
                return;
            }
            if (residue == 0) {
                result++;
                return;
            }
            for (int i = start; i < nums.length; i++) {
                solution.push(nums[i]);
                findCombinationSum(residue - nums[i], start, solution);
                //选择另一个分支
                solution.pop();
            }
        }
    }
}
