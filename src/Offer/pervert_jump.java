package Offer;

//https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//题目描述
//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

import java.util.Arrays;

public class pervert_jump {
    public static void main(String[] args) {
        System.out.println(new pervert_jump.Solution().JumpFloorII(3));
    }

    public static class Solution {
        public int JumpFloorII(int target) {
            return 1 << (target - 1);
        }

        public int JumpFloorII2(int target) {
            int[] dp = new int[target];
            Arrays.fill(dp, 1);
            for (int i = 1; i < target; i++)
                for (int j = 0; j < i; j++)
                    dp[i] += dp[j];
            return dp[target - 1];
        }
    }
}
