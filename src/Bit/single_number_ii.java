package Bit;

//137
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
//说明：
//你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//示例 1:
//输入: [2,2,3,2]
//输出: 3
//示例 2:
//输入: [0,1,0,1,0,1,99]
//输出: 99
public class single_number_ii {
    public static void main(String[] args) {
        System.out.println(new single_number_ii.Solution().singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }

    //将每一位数字按位累加，将最后结果每一个位上的1出现的次数对3取模，剩下的就是结果

    //1.位运算求解此题;
    //2.如果把所有出现三次的数字的二进制表示的每一位加起来,那么每一位都能被3整除;
    //3.如果某一位的和能被3整除,那么只出现一次数字的二进制位中对应的那一位就是0,否则就是1;
    static class Solution {
        public int singleNumber(int[] nums) {
            int[] bit = new int[32];//因为int是-2^31——2^31-1
            for (int i = 0; i < nums.length; i++) {
                int k = 1;
                for (int j = 0; j < 32; j++) {
                    int rotated;
                    if ((rotated = nums[i] >> j) == 0) break;//除以2
                    bit[j] += rotated & k;//取余数
                }
            }
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result += (bit[i] % 3 << i);
            }
            return result;
        }
    }
}
