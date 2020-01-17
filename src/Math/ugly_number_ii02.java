package Math;

//264
//编写一个程序，找出第 n 个丑数。
//丑数就是只包含质因数 2, 3, 5 的正整数。
//示例:
//输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//说明:
//	1 是丑数。
//	n 不超过1690。
public class ugly_number_ii02 {
    public static void main(String[] args) {
        System.out.println(new ugly_number_ii02.Solution().nthUglyNumber(10));
    }

    //ugly[i] = min(ugly[_2] * 2, ugly[_3] * 3, ugly[_5] * 5) 0 < j < i
    static class Solution {
        public int nthUglyNumber(int n) {
            int[] ugly = new int[n];
            ugly[0] = 1;
            int _2 = 0, _3 = 0, _5 = 0;
            for (int i = 1; i < n; i++) {
                ugly[i] = Math.min((ugly[_2] * 2), Math.min(ugly[_3] * 3, ugly[_5] * 5));
                if (ugly[i] == ugly[_2] * 2) _2++;
                if (ugly[i] == ugly[_3] * 3) _3++;
                if (ugly[i] == ugly[_5] * 5) _5++;
            }
            return ugly[n - 1];
        }
    }
}
