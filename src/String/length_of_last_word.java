package String;

//58
//给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
//如果不存在最后一个单词，请返回 0 。
//说明：一个单词是指由字母组成，但不包含任何空格的字符串。
//示例:
//输入: "Hello World"
//输出: 5
public class length_of_last_word {
    public static void main(String[] args) {
        System.out.println(new length_of_last_word.Solution().lengthOfLastWord("Hello World"));
    }

    static class Solution {
        public int lengthOfLastWord(String s) {
            int count = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    if (count == 0) continue;
                    else return count;
                }
                count++;
            }
            return count;
        }
    }
}
