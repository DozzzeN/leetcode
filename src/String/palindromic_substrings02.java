package String;

//647
//����һ���ַ�������������Ǽ�������ַ������ж��ٸ������Ӵ���
//���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ��Ϊ�ǲ�ͬ���Ӵ���
//����: "aaa"
//���: 6
//˵��: 6�������Ӵ�: "a", "a", "a", "aa", "aa", "aaa".
public class palindromic_substrings02 {
    public static void main(String[] args) {
        String input = "aaa";
        System.out.println(new palindromic_substrings02.Solution().countSubstrings(input));

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
            if (s == null || s.length() == 0) {
                return false;
            }
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            return sb.toString().equals(s);
        }
    }
}
