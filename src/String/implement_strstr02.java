package String;

import java.util.Arrays;

//28
//ʵ��strStr()������
//����һ��haystack�ַ�����һ��needle�ַ�������haystack�ַ������ҳ�needle�ַ������ֵĵ�һ��λ��(��0��ʼ)����������ڣ��򷵻�-1��
//ʾ��1:
//����:haystack="hello",needle="ll"
//���:2
//ʾ��2:
//����:haystack="aaaaa",needle="bba"
//���:-1
public class implement_strstr02 {
    public static void main(String[] args) {

        System.out.println(new implement_strstr02.Solution().strStr("ababababacabababa", "ababaca"));
    }


    //KMP
    static class Solution {
        int[] next;

        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) return -1;
            if (needle.length() == 0) return 0;
            if (haystack.length() < needle.length()) return -1;
            next = new int[needle.length()];
            GetNext(needle, next);
            int i = 0;
            int j = 0;
            while (i < haystack.length() && j < needle.length()) {
                //�����j = -1�����ߵ�ǰ�ַ�ƥ��ɹ�����S[i] == P[j]��������i++��j++
                if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else {
                    //�����j != -1���ҵ�ǰ�ַ�ƥ��ʧ�ܣ���S[i] != P[j]�������� i ���䣬j = next[j]
                    //next[j]��Ϊj����Ӧ��nextֵ
                    j = next[j];
                }
            }
            if (j == needle.length())
                return i - j;
            else
                return -1;
        }

        public void GetNext(String ch, int[] next) {
            next[0] = -1;
            int k = -1;
            int j = 0;
            while (j < ch.length() - 1) {
                if (k == -1 || ch.charAt(k) == ch.charAt(j)) {
                    k++;
                    j++;
                    next[j] = k;
                } else {
                    k = next[k];
                }
            }
            System.out.println(Arrays.toString(next));
        }
    }
}
