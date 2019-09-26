package Greedy;

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
public class jump_game04 {
    public static void main(String[] args) {
        System.out.println(new jump_game04.Solution().canJump(new int[]{3,2,1,0,4}));
    }

    //贪心（倒推）
    //这个题我们可以从后往前分析，首先判断倒数第二个元素能否到达最后一个元素，如果可以，我们将不再考虑最后一个元素，
    //因为根据刚才的分析如果可以到达倒数第二个，那么也可以到达最后一个元素。
    //然后依次往前递推，如果都能跳到的话，我们最后应该分析的就是第一个元素能否跳到第二个元素上。

    //从右往左迭代，对于每一个节点检查是否存在一步到达最右节点的位置
    //若有一个节点可以到达，则继续检查是否可以到达该新节点的位置
    //最终最后一个节点若是开始节点的位置，则说明可以成功跳跃
    static public class Solution {
        public boolean canJump(int[] nums) {
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i + nums[i] > lastPos) lastPos = i;
            }
            return lastPos == 0;
        }

    }
}
