package String;

//125
//����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
//˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���
//ʾ�� 1:
//����: "A man, a plan, a canal: Panama"
//���: true
//ʾ�� 2:
//����: "race a car"
//���: false
public class valid_palindrome {
    public static void main(String[] args) {
        System.out.println(new valid_palindrome.Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }

    //˫ָ��
    //ע������ĸ������
    static class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                //����start < end��ԭ���Ƿ�ֹ�ڿ��ַ����У�ָ��Խ��
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
