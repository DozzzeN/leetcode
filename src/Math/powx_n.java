package Math;

//50
//实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//示例 1:
//输入: 2.00000, 10
//输出: 1024.00000
//示例 2:
//输入: 2.10000, 3
//输出: 9.26100
//示例 3:
//输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25
//说明:
//	-100.0 < x < 100.0
//	n 是 32 位有符号整数，其数值范围是 [-31, 2 ^ 31 - 1] 。
public class powx_n {
    public static void main(String[] args) {
        System.out.println(new powx_n.Solution().myPow(-1,
                -2147483648));
    }

    //二分法
    static class Solution {
        public double myPow(double x, int n) {
            return myPow(x, (long) n);
        }

        public double myPow(double x, long n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            if (n < 0) {
                n = -n;
                x = 1 / x;
            }
            double temp = myPow(x, n / 2);
            if (n % 2 == 0) return temp * temp;
            else return x * temp * temp;
        }
    }
}
