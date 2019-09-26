package String;

//647
//����һ���ַ�������������Ǽ�������ַ������ж��ٸ������Ӵ���
//���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ��Ϊ�ǲ�ͬ���Ӵ���
//����: "aaa"
//���: 6
//˵��: 6�������Ӵ�: "a", "a", "a", "aa", "aa", "aaa".
public class palindromic_substrings03 {
    public static void main(String[] args) {
        String input = "aaa";
        System.out.println(new palindromic_substrings03.Solution().countSubstrings(input));

    }

    //������������ɢ
    //���ַ�����ĳһλ��ʼ��������ȥ��չ���ַ�����
    static class Solution {
        private int cnt = 0;

        public int countSubstrings(String s) {
            for (int i = 0; i < s.length(); i++) {
                extendSubstrings(s, i, i);     // �������� ÿ����չ����1+2+...������
                extendSubstrings(s, i, i + 1); // ż������ ÿ����չ����2+2+...��ż��
            }
            return cnt;
        }

        //i=0 cnt=1 a start=0 end=0
        //i=0 cnt=1 aa start=0 end=1
        //i=1 cnt=2 a start=1 end=1 aaa start=0 end=2
        //i=1 cnt=1 aa start=1 end=2
        //i=2 cnt=1 a start=2 end=2
        private void extendSubstrings(String s, int start, int end) {
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
                cnt++;
            }
        }
    }
}
