package Offer;

//https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
public class skip_step {
    public static void main(String[] args) {
        System.out.println(new skip_step.Solution().JumpFloor(4));
        System.out.println(new skip_step.Solution().JumpFloor2(4));
    }

    //f(n) = 1 + f(n-2)
    //     = 1 + f(n-1)
    public static class Solution {
        public int JumpFloor(int target) {
            if (target <= 0) return 0;
            if (target == 1) return 1;
            if (target == 2) return 2;
            return JumpFloor(target - 2) + JumpFloor(target - 1);
        }

        public int JumpFloor2(int target) {
            int[] memo = new int[100000];
            memo[0] = 0;
            memo[1] = 1;
            memo[2] = 2;
            for (int i = 3; i <= target; i++) {
                memo[i] = memo[i - 2] + memo[i - 1];
            }
            return memo[target];
        }
    }
}
