package String;

//647
//����һ���ַ�������������Ǽ�������ַ������ж��ٸ������Ӵ���
//���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ��Ϊ�ǲ�ͬ���Ӵ���
//����: "aaa"
//���: 6
//˵��: 6�������Ӵ�: "a", "a", "a", "aa", "aa", "aaa".
public class palindromic_substrings {
    public static void main(String[] args) {
        String input = "aaa";
        System.out.println(new palindromic_substrings.Solution().countSubstrings(input));

    }

    //����������ַ���������Ƿ��ǻ��Ĵ�
    static class Solution {
        public int countSubstrings(String s) {
            int count = 0;
            for (int i = 0; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (isPalidrome_string(s.substring(j, i))) {
                        count++;
                    }
                }
            }
            return count;
        }

        public boolean isPalidrome_string(String s) {
            boolean isPs = true;
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    isPs = false;
                }
            }
            return isPs;
        }
    }
}
