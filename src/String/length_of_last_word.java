package String;

//58
//����һ����������Сд��ĸ�Ϳո� ' ' ���ַ��������������һ�����ʵĳ��ȡ�
//������������һ�����ʣ��뷵�� 0 ��
//˵����һ��������ָ����ĸ��ɣ����������κοո���ַ�����
//ʾ��:
//����: "Hello World"
//���: 5
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
