package String;

//409
//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
//输入:
//"abccccdd"
//输出:
//7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
public class longest_palindrome {
    public static void main(String[] args) {
        String input = "abccccdd";
        System.out.println(new Solution().longestPalindrome(input));

    }

    static class Solution {
        public int longestPalindrome(String s) {
            int[] frequency = new int[100];
            for (char temp : s.toCharArray()) {
                frequency[temp - 'A']++;
            }
            int length = 0;
            for (int temp : frequency) {
                //偶数频率的字符一定能形成回文串、奇数频率的字符则要向下保留最接近的偶数次数
                if (temp > 1) {
                    length += (temp / 2) * 2;
                }
            }
            //当length长度小于字符串时，表示还有一个单独的字符可以加入回文串
            return length < s.length() ? length + 1 : length;
        }
    }
}
