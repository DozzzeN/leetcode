package Bit;

//389
//给定两个字符串 s 和 t，它们只包含小写字母。
//字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//请找出在 t 中被添加的字母。
//示例:
//输入：
//s = "abcd"
//t = "abcde"
//输出：
//e
//解释：
//'e' 是那个被添加的字母。
public class find_the_difference {
    public static void main(String[] args) {
        System.out.println(new find_the_difference.Solution().findTheDifference("abcd", "abcde"));
    }

    static class Solution {
        public char findTheDifference(String s, String t) {
            int number = t.charAt(t.length() - 1);
            for (int i = 0; i < s.length(); i++) {
                number += t.charAt(i);
                number -= s.charAt(i);
            }
            return (char) number;
        }
    }
}
