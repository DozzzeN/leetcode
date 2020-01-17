package String;

//557
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//示例 1:
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc"
//注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
public class reverse_words_in_a_string_iii {
    public static void main(String[] args) {
        System.out.println(new reverse_words_in_a_string_iii.Solution().reverseWords("Let's take LeetCode contest"));
    }

    static class Solution {
        public String reverseWords(String s) {
            String[] words = s.split(" ");
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                result.append(new StringBuilder(words[i]).reverse()).append(" ");
            }
            return result.toString().trim();
        }
    }
}
