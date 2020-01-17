package String;

//409
//����һ��������д��ĸ��Сд��ĸ���ַ������ҵ�ͨ����Щ��ĸ����ɵ���Ļ��Ĵ���
//�ڹ�������У���ע�����ִ�Сд������ "Aa" ���ܵ���һ�������ַ�����
//����:
//"abccccdd"
//���:
//7
//����:
//���ǿ��Թ������Ļ��Ĵ���"dccaccd", ���ĳ����� 7��
public class longest_palindrome {
    public static void main(String[] args) {
        String input = "abccccdd";
        System.out.println(new Solution().longestPalindrome(input));

    }

    static class Solution {
        public int longestPalindrome(String s) {
            int[] frequency = new int[100];
            for (char temp : s.toCharArray()) {
                frequency[temp - 'A']++;
            }
            int length = 0;
            for (int temp : frequency) {
                //ż��Ƶ�ʵ��ַ�һ�����γɻ��Ĵ�������Ƶ�ʵ��ַ���Ҫ���±�����ӽ���ż������
                if (temp > 1) {
                    length += (temp / 2) * 2;
                }
            }
            //��length����С���ַ���ʱ����ʾ����һ���������ַ����Լ�����Ĵ�
            return length < s.length() ? length + 1 : length;
        }
    }
}
