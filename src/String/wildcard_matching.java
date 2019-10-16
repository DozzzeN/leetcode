package String;

//44
//����һ���ַ��� (s) ��һ���ַ�ģʽ (p) ��ʵ��һ��֧�� '?' �� '*' ��ͨ���ƥ�䡣
//'?' ����ƥ���κε����ַ���
//'*' ����ƥ�������ַ������������ַ�������
//�����ַ�����ȫƥ�����ƥ��ɹ���
//˵��:
//	s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
//	p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� ? �� *��
//ʾ�� 1:
//����:
//s = "aa"
//p = "a"
//���: false
//����: "a" �޷�ƥ�� "aa" �����ַ�����
//ʾ�� 2:
//����:
//s = "aa"
//p = "*"
//���: true
//����: '*' ����ƥ�������ַ�����
//ʾ�� 3:
//����:
//s = "cb"
//p = "?a"
//���: false
//����: '?' ����ƥ�� 'c', ���ڶ��� 'a' �޷�ƥ�� 'b'��
//ʾ�� 4:
//����:
//s = "adceb"
//p = "*a*b"
//���: true
//����: ��һ�� '*' ����ƥ����ַ���, �ڶ��� '*' ����ƥ���ַ��� "dce".
//ʾ�� 5:
//����:
//s = "acdcb"
//p = "a*c?b"
//����: false
public class wildcard_matching {
    public static void main(String[] args) {
        System.out.println(new wildcard_matching.Solution().isMatch("aabbaa", "a*b*a"));
    }

    //ÿ����һ��*���ͼ�¼��ǰ*�������s�����꣬Ȼ��s��ǰ����ɨ�裬����ܳɹ�ƥ���򷵻�true
    //������ɹ����򷵻���һ�μ�¼��s���꣬����һλ����ɨ��
    static class Solution {
        public boolean isMatch(String s, String p) {
            int i = 0;
            int j = 0;
            int start = -1;
            int match = 0;
            while (i < s.length()) {
                if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                    i++;
                    j++;
                } else if (j < p.length() && p.charAt(j) == '*') {
                    start = j;
                    match = i;
                    j++;
                } else if (start != -1) {
                    j = start + 1;
                    match++;
                    i = match;
                } else {
                    return false;
                }
            }
            while (j < p.length()) {
                if (p.charAt(j) != '*') return false;
                j++;
            }
            return true;
        }
    }
}
