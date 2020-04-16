package VIVO;

//现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），使得 m 的各位（个位、十位、百位 ... ...）之乘积等于n，若不存在则输出 -1。
//输入例子1:
//36
//输出例子1:
//49
//输入例子2:
//100
//输出例子2:
//455
public class product_of_digits {
    public static void main(String[] args) {
        System.out.println(new product_of_digits.Solution().solution(362880));
    }

    public static class Solution {
        /**
         * 输入一个整形数值，返回一个整形值
         *
         * @param n int整型 n>9
         * @return int整型
         */
        public int solution(int n) {
            int result = 0, base = 1;
            for (int i = 9; i > 1; i--) {
                while (n % i == 0) {
                    result += i * base;
                    base *= 10;
                    n /= i;
                }
            }
            if (n > 1) return -1;
            return result;
        }
    }
}
