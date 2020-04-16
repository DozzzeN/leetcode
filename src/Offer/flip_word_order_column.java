package Offer;

//https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//题目描述
//牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
//同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
//例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
//正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
public class flip_word_order_column {
    public static void main(String[] args) {
        System.out.println(new flip_word_order_column.Solution().ReverseSentence(
                " "
        ));
        System.out.println(new flip_word_order_column.Solution().ReverseSentence02(
                "student. a am I"
        ));
    }

    public static class Solution {
        //先按空格将字符串切割成字符串数组，将字符串数组反转拼接输出
        public String ReverseSentence(String str) {
            if (str == null || str.length() == 0) return "";
            String[] array = str.split(" ");
            //“ ”的情况
            if (array.length == 0) return str;
            StringBuilder result = new StringBuilder();
            for (int i = array.length - 1; i >= 0; i--) {
                result.append(array[i]).append(" ");
            }
            result.deleteCharAt(result.length() - 1);
            return result.toString();
        }

        //不能用额外的空间，反转每个单词后反转整个字符串
        public String ReverseSentence02(String str) {
            char[] chars = str.toCharArray();
            int i = 0, j = 0;
            while (j <= str.length()) {
                if (j == str.length() || chars[j] == ' ') {
                    reverse(chars, i, j - 1);
                    i = j + 1;
                }
                j++;
            }
            reverse(chars, 0, str.length() - 1);
            return new String(chars);
        }

        private void reverse(char[] c, int i, int j) {
            while (i < j)
                swap(c, i++, j--);
        }

        private void swap(char[] c, int i, int j) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
        }
    }
}
