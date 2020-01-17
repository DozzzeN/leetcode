package String;

//557
//����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��
//ʾ�� 1:
//����: "Let's take LeetCode contest"
//���: "s'teL ekat edoCteeL tsetnoc"
//ע�⣺���ַ����У�ÿ�������ɵ����ո�ָ��������ַ����в������κζ���Ŀո�
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
