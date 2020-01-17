package DynamicProgramming;
//70
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//注意：给定 n 是一个正整数。
//示例 1：
//输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶

//示例 2：
//输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
public class climbing_stairs {
    //f(n)是n阶台阶的爬法
    //f(n)=f(n-1)+f(n-2)
    //f(1)=1
    //f(2)=2
    public static void main(String[] args) {
        System.out.println(new climbing_stairs.Solution().climbStairs(44));
    }

    //纯递归会超时
    static class Solution {
        public int climbStairs(int n) {
            return f(n);
        }

        public int f(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            return f(n - 1) + f(n - 2);
        }
    }
}
