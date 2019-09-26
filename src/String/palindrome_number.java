package String;

//9
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
public class palindrome_number {
    public static void main(String[] args) {
        int input = 121;
        System.out.println(new palindrome_number.Solution().isPalindrome(input));
    }

    //反转源字符串，判等
    static class Solution {
        public boolean isPalindrome(int x) {
            String result = String.valueOf(x);
            char[] temp = result.toCharArray();
            char[] reverse = new char[temp.length];
            for (int i = 0; i < temp.length; i++) {
                reverse[temp.length - i - 1] = temp[i];
            }
            String afterReverse = new String(reverse, 0, reverse.length);
            return result.equals(afterReverse);
        }
    }
}
