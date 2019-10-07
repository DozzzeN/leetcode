package String;

//9
//�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
//����: -121
//���: false
//����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
public class palindrome_number0 {
    public static void main(String[] args) {
        int input = 121;
        System.out.println(new palindrome_number0.Solution().isPalindrome(input));
    }

    //Ҫ����ʹ�ö���ռ䣬Ҳ�Ͳ��ܽ�����ת��Ϊ�ַ��������жϡ�
    //˫ָ�����β�������м�ɨ���ֱ�Ƚ���λ
    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            int div = 1;
            while (x / div >= 10) {
                div *= 10;
            }
            while (x > 0) {
                int l = x / div;
                int r = x % 10;
                if (l != r) return false;
                x = x % div / 10;
                div /= 100;
            }
            return true;
        }
    }
}
