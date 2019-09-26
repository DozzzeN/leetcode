package Math;

//69
//实现 int sqrt(int x) 函数。
//
//计算并返回 x 的平方根，其中 x 是非负整数。
//由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//示例 1:
//输入: 4
//输出: 2
//示例 2:
//输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
public class sqrtx02 {
    public static void main(String[] args) {
        System.out.println(new sqrtx02.Solution().mySqrt(6));
    }

    //牛顿迭代法
    //f(x) = x ^ 2 - a
    //f(x) = f(x0) + (x - x0)f'(x0)
    //令f(x) = 0 即求a = x ^ 2
    //得到f(x0) + (x - x0)f'(x0) = f(x0) + (x - x0)(2x) = 0
    //即x = 1/2 (x0 + a / x0)

    static class Solution {
        public int mySqrt(int a) {
            long x = a;
            while (x * x > a) {
                x = (x + a / x) >> 1;
            }
            return (int) x;
        }
    }
}
