package Dichotomy;

//367
//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
//说明：不要使用任何内置的库函数，如  sqrt。
//示例 1：
//输入：16
//输出：True
//示例 2：
//输入：14
//输出：False
public class valid_perfect_square {
    public static void main(String[] args) {
        System.out.println(new valid_perfect_square.Solution().isPerfectSquare(808201));
    }

    //注意防止temp溢出
    static class Solution {
        public boolean isPerfectSquare(int num) {
            long left = 0, right = num;
            while (left < right) {
                long mid = (left + right) >>> 1;
                long temp = mid * mid;
                if (temp == num) return true;
                else if (temp > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left * left == num;
        }
    }
}
