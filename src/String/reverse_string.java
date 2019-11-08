package String;

import java.util.Arrays;

//344
//��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� char[] ����ʽ������
//��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣
//����Լ��������е������ַ����� ASCII ����еĿɴ�ӡ�ַ���
//ʾ�� 1��
//���룺["h","e","l","l","o"]
//�����["o","l","l","e","h"]
//ʾ�� 2��
//���룺["H","a","n","n","a","h"]
//�����["h","a","n","n","a","H"]
public class reverse_string {
    public static void main(String[] args) {
        char[] input = new char[]{};
        new reverse_string.Solution().reverseString(input);
        System.out.println(Arrays.toString(input));
    }

    static class Solution {
        public void reverseString(char[] s) {
            int n = s.length;
            for (int i = 0; i < n / 2; i++) {
                char c = s[i];
                s[i] = s[n - i - 1];
                s[n - i - 1] = c;
            }
        }
    }
}
