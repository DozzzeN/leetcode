package DynamicProgramming;

//55
//给定一个非负整数数组，你最初位于数组的第一个位置。
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//判断你是否能够到达最后一个位置。
//示例 1:
//输入: [2,3,1,1,4]
//输出: true
//解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
//示例 2:
//输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
public class jump_game {
    public static void main(String[] args) {
        System.out.println(new jump_game.Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    //动态规划
    //dp[i]表示是否能走到i处
    //dp[i] = false直接退出
    //根据nums[i]的值将从i处所有能到达的位置赋值true
    static class Solution {
        public boolean canJump(int[] nums) {
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;
            for (int i = 0; i < nums.length - 1; i++) {
                if (!dp[i]) return false;
                int canArrive = i + nums[i];
                while (canArrive > 0) {
                    if (canArrive >= nums.length) {
                        canArrive--;
                        continue;
                    }
                    dp[canArrive] = true;
                    canArrive--;
                }
            }
            return dp[nums.length - 1];
        }
    }
}
