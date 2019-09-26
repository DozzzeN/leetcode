package String;

//5
//����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
//����: "babad"
//���: "bab"
//ע��: "aba" Ҳ��һ����Ч�𰸡�
public class longest_palindromic_substring02 {
    public static void main(String[] args) {
        String input = "abbc";
        System.out.println(new longest_palindromic_substring02.Solution().longestPalindrome(input));

    }

    //������������չ ������palindromic_substrings03
    static class Solution {
        private int start = 0, maxLen = 0;

        public String longestPalindrome(String s) {
            if (s.length() < 1) return s;
            for (int i = 0; i < s.length(); i++) {
                // �����Ӵ�Ϊ����ʱ������������Ӵ�
                extendPalindrome(s, i, i);
                // �����Ӵ�Ϊż��ʱ������������Ӵ�
                extendPalindrome(s, i, i + 1);
            }
            return s.substring(start, start + maxLen);
        }

        private void extendPalindrome(String s, int left, int right) {
            // �ж��Ƿ�Ϊ�����Ӵ������ǣ�����ָ�������ƶ�����ָ�������ƶ�
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            // �����Ӵ�������ɺ��жϸող��ҵĻ����Ӵ��Ƿ�Ϊ������Ӵ������ǣ��������ʼλ�ú������
            if (maxLen < right - left - 1) {
                start = left + 1;
                maxLen = right - left - 1;
            }
        }
    }

}
