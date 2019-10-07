package String;

//9
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
public class palindrome_number0 {
    public static void main(String[] args) {
        int input = 121;
        System.out.println(new palindrome_number0.Solution().isPalindrome(input));
    }

    //要求不能使用额外空间，也就不能将整数转换为字符串进行判断。
    //双指针从首尾两端往中间扫，分别比较首位
    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            int div = 1;
            while (x / div >= 10) {
                div *= 10;
            }
            while (x > 0) {
                int l = x / div;
                int r = x % 10;
                if (l != r) return false;
                x = x % div / 10;
                div /= 100;
            }
            return true;
        }
    }
}
