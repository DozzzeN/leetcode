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
public class jump_game03 {
    public static void main(String[] args) {
        System.out.println(new jump_game03.Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    //动态规划
    //只记录可达最右边界
    static class Solution {
        public boolean canJump(int[] nums) {
            int maxCover = 0;
            for (int start = 0; start < nums.length && start <= maxCover; start++) {
                if (nums[start] + start > maxCover) maxCover = nums[start] + start;
                if (maxCover >= nums.length - 1) return true;
            }
            return false;
        }
    }
}
