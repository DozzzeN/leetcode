package String;

//9
//�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
//����: -121
//���: false
//����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
public class palindrome_number {
    public static void main(String[] args) {
        int input = 121;
        System.out.println(new palindrome_number.Solution().isPalindrome(input));
    }

    //��תԴ�ַ������е�
    static class Solution {
        public boolean isPalindrome(int x) {
            String result = String.valueOf(x);
            char[] temp = result.toCharArray();
            char[] reverse = new char[temp.length];
            for (int i = 0; i < temp.length; i++) {
                reverse[temp.length - i - 1] = temp[i];
            }
            String afterReverse = new String(reverse, 0, reverse.length);
            return result.equals(afterReverse);
        }
    }
}
