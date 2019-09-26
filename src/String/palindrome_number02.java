package String;

//9
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
public class palindrome_number02 {
    public static void main(String[] args) {
        int input = 121;
        System.out.println(new palindrome_number02.Solution().isPalindrome(input));
    }

    //要求不能使用额外空间，也就不能将整数转换为字符串进行判断。
    //将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等。
    static class Solution {
        public boolean isPalindrome(int x) {
            //负数，以零结尾的非零数不符合
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }

            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }

            // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
            // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
            // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
            return x == revertedNumber || x == revertedNumber / 10;
        }
    }
}
