package String;

//28
//ʵ��strStr()������
//����һ��haystack�ַ�����һ��needle�ַ�������haystack�ַ������ҳ�needle�ַ������ֵĵ�һ��λ��(��0��ʼ)����������ڣ��򷵻�-1��
//ʾ��1:
//����:haystack="hello",needle="ll"
//���:2
//ʾ��2:
//����:haystack="aaaaa",needle="bba"
//���:-1
public class implement_strstr {
    public static void main(String[] args) {
        System.out.println(new implement_strstr.Solution().strStr("a"
                ,""));
    }

    //��������˫ѭ��
    static class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) return -1;
            if (haystack.length() < needle.length()) return -1;
            //����ȫ������haystack��
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                int j = 0;
                int point = i;
                for (; j < needle.length(); j++) {
                    if (haystack.charAt(point) != needle.charAt(j)) break;
                    point++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }
            return -1;
        }
    }
}
