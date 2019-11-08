package Math;

import java.util.ArrayList;
import java.util.List;

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
public class ugly_number_ii {
    public static void main(String[] args) {
        System.out.println(new ugly_number_ii.Solution().nthUglyNumber(10));
    }

    //超时
    //ugly[i] = min(ugly[j] * 2, ugly[j] * 3, ugly[j] * 5) 0 < j < i
    static class Solution {
        public int nthUglyNumber(int n) {
            List<Integer> ugly = new ArrayList<>();
            ugly.add(1);
            for (int i = 1; i < n; i++) {
                int temp = ugly.get(i - 1) * 2;
                for (int j = 0; j < i; j++) {
                    if (!ugly.contains(ugly.get(j) * 2)) {
                        temp = Math.min(temp,ugly.get(j) * 2);
                    }
                    if (!ugly.contains(ugly.get(j) * 3)) {
                        temp = Math.min(temp,ugly.get(j) * 3);
                    }
                    if (!ugly.contains(ugly.get(j) * 5)) {
                        temp = Math.min(temp,ugly.get(j) * 5);
                    }
                }
                ugly.add(i, temp);
            }
            return ugly.get(n - 1);
        }
    }
}
