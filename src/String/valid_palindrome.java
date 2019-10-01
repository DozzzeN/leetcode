package String;

//125
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//说明：本题中，我们将空字符串定义为有效的回文串。
//示例 1:
//输入: "A man, a plan, a canal: Panama"
//输出: true
//示例 2:
//输入: "race a car"
//输出: false
public class valid_palindrome {
    public static void main(String[] args) {
        System.out.println(new valid_palindrome.Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }

    //双指针
    //注意有字母和数字
    static class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                //加上start < end的原因是防止在空字符串中，指针越界
                while (start < end && (!Character.isAlphabetic(s.charAt(start)) &&
                        !Character.isDigit(s.charAt(start)))) start++;
                while (start < end && (!Character.isAlphabetic(s.charAt(end)) &&
                        !Character.isDigit(s.charAt(end)))) end--;
                if (s.charAt(start) != s.charAt(end)) return false;
                start++;
                end--;
            }
            return true;
        }
    }
}
