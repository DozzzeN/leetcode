package Bit;

import java.util.Arrays;

//338
//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//示例 1:
//输入: 2
//输出: [0,1,1]
//示例 2:
//输入: 5
//输出: [0,1,1,2,1,2]
//进阶:
//	给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
//	要求算法的空间复杂度为O(n)。
//	你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
public class counting_bits02 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new counting_bits02.Solution().countBits(40)));
    }

    //假设有一个整数：
    //x=(1001011101)2=(605)10
    //我们已经计算了从 000 到 x - 1 的全部结果。
    //我们知道，xxx 与 我们计算过的一个数只有一位之差:
    //x′=(1011101)2=(93)10
    //它们只在最高有效位上不同。

    //P(x+b)=P(x)+1,b=(2^m)>x
    //动态规划
    static class Solution {
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            int i = 0, b = 1;
            // [0, b) is calculated
            while (b <= num) {
                // generate [b, 2b) or [b, num) from [0, b)
                while (i < b && i + b <= num) {
                    ans[i + b] = ans[i] + 1;
                    ++i;
                }
                i = 0;   // reset i
                b <<= 1; // b = 2b
            }
            return ans;
        }
    }
}
