package Greedy;

//45
//给定一个非负整数数组，你最初位于数组的第一个位置。
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//示例:
//输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//说明:
//假设你总是可以到达数组的最后一个位置。
public class jump_game_ii {
    public static void main(String[] args) {
        System.out.println(new jump_game_ii.Solution().jump(new int[]{2, 3, 1, 1, 4}));
    }

    //贪心算法
    //维护一个覆盖区间，每次扫描区间元素时重新计算新的区间边界
    //如2,3,1,1,4 区间为[0,0]，获得从第一个元素能到达的区间范围：[1,2]
    //在[1,2]中已经可以直接到达末尾，直接返回
    //每次新增一个区间，步数就自增1
    static class Solution {
        public int jump(int[] nums) {
            int start = 0, end = 0, count = 0;
            if (nums.length == 1) return 0;
            while (end < nums.length) {
                int max = 0;
                count++;
                //找出该从区间中选一个元素，能走到的最大位置max
                for (int i = start; i <= end; i++) {
                    if (nums[i] + i >= nums.length - 1) return count;
                    if (nums[i] + i > max) max = nums[i] + i;
                }
                start = end + 1;
                end = max;
            }
            return count;
        }
    }
}
