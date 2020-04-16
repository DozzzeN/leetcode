package Offer;

//https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
public class the_number_of_1s_in_binary {
    public static void main(String[] args) {
        System.out.println(new the_number_of_1s_in_binary.Solution().NumberOf1(-3));
        System.out.println(new the_number_of_1s_in_binary.Solution().NumberOf102(-3));
        System.out.println(new the_number_of_1s_in_binary.Solution().NumberOf103(-3));
    }

    public static class Solution {
        public int NumberOf1(int n) {
            int result = 0;
            //最终越界退出
            for (int i = 1; i != 0; i <<= 1) {
                if ((n & i) != 0) {
                    result++;
                }
            }
            return result;
        }

        //n&(n-1):该位运算去除n的位级表示中最低的那一位。
        //n:10110100  n-1:10110011 n&n-1:10110000 把n最后的1去掉了
        public int NumberOf102(int n) {
            int result = 0;
            while (n != 0) {
                result++;
                n &= (n - 1);
            }
            return result;
        }

        public int NumberOf103(int n) {
            return Integer.bitCount(n);
        }
    }
}
