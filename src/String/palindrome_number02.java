package String;

//9
//�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
//����: -121
//���: false
//����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
public class palindrome_number02 {
    public static void main(String[] args) {
        int input = 121;
        System.out.println(new palindrome_number02.Solution().isPalindrome(input));
    }

    //Ҫ����ʹ�ö���ռ䣬Ҳ�Ͳ��ܽ�����ת��Ϊ�ַ��������жϡ�
    //�������ֳ����������֣��ұ��ǲ�����Ҫת�ã�Ȼ���ж����������Ƿ���ȡ�
    static class Solution {
        public boolean isPalindrome(int x) {
            //�����������β�ķ�����������
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }

            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }

            // �����ֳ���Ϊ����ʱ�����ǿ���ͨ�� revertedNumber/10 ȥ��������λ�����֡�
            // ���磬������Ϊ 12321 ʱ���� while ѭ����ĩβ���ǿ��Եõ� x = 12��revertedNumber = 123��
            // ���ڴ�����λ�����ֲ�Ӱ����ģ����������Լ���ȣ����������ǿ��Լ򵥵ؽ���ȥ����
            return x == revertedNumber || x == revertedNumber / 10;
        }
    }
}
