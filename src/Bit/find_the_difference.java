package Bit;

//389
//���������ַ��� s �� t������ֻ����Сд��ĸ��
//�ַ��� t ���ַ��� s ������ţ�Ȼ�������λ�����һ����ĸ��
//���ҳ��� t �б���ӵ���ĸ��
//ʾ��:
//���룺
//s = "abcd"
//t = "abcde"
//�����
//e
//���ͣ�
//'e' ���Ǹ�����ӵ���ĸ��
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
