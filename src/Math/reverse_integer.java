package Math;

//7
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//示例 1:
//输入: 123
//输出: 321
// 示例 2:
//输入: -123
//输出: -321
//示例 3:
//输入: 120
public class reverse_integer {
    //注意溢出
    static class Solution {
        public int reverse(int x) {
            double y = 0;
            int z = Math.abs(x);
            int weishu = 0;
            while (z > 0) {
                weishu++;
                z /= 10;
            }
            z = Math.abs(x);
            for (int i = weishu; i > 0; i--) {
                y += (z % 10) * Math.pow(10, i - 1);
                if (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) {
                    return 0;
                }
                z /= 10;
            }
            return x > 0 ? (int) y : -(int) y;
        }
    }

    public static void main(String[] args) {
        reverse_integer.Solution sol = new reverse_integer.Solution();
        System.out.println(sol.reverse(153436469));//1534236469
    }
}
