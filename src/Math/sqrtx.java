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
public class sqrtx {
    public static void main(String[] args) {
        System.out.println(new sqrtx.Solution().mySqrt(6));
    }
    //二分法
    static class Solution {
        public int mySqrt(int x) {
            if (x == 1) return 1;
            long start = 0, end = x >>> 1;
            while (start <= end) {
                long mid = (start + end) >>> 1;
                long sqr = mid * mid;
                if (sqr > x) {
                    end = mid - 1;
                } else if (sqr < x) {
                    start = mid + 1;
                } else if (sqr == x) {
                    return (int) mid;
                }
            }
            return (int) end;
        }
    }
}
