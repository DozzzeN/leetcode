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
public class counting_bits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new counting_bits.Solution().countBits(0)));
    }

    //找规律
    //0                         //0
    //1                         //1
    //2 3                       //1 2
    //4 5 6 7                   //1 2 2 3 (1+1 2+1)
    //8 9 10 11 12 13 14 15     //1 2 2 3 2 3 3 4 (1+1 2+1 2+1 3+1)
    //P(x+b)=P(x)+1,b=(2^m)>x
    static class Solution {
        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            for (int i = 1; i < num + 1; i++) {
                int stage = (int) (Math.log(i) / Math.log(2));//位于第几行
                if ((i & (i - 1)) == 0) {//是二的幂，位于每一行的第一行
                    result[i] = 1;
                    continue;
                }
                if (i < (Math.pow(2, stage) + Math.pow(2, stage - 1))) {//行中左边，不变的
                    result[i] = result[i - (int) Math.pow(2, stage - 1)];
                } else {//行中右边，需要加1
                    result[i] = result[i - (int) Math.pow(2, stage - 1)] + 1;
                }
            }
            return result;
        }
    }
}
