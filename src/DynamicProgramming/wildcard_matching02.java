package DynamicProgramming;

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
public class wildcard_matching02 {
    public static void main(String[] args) {
        System.out.println(new wildcard_matching02.Solution().isMatch("aaaa", "*s**a"));
    }

    //dp[i][j]��ʾ s �� 0-i �� p �� 0-j λ���Ƿ�ƥ��
    //��ʼ����dp[0][0]:ʲô��û��,����Ϊtrue
    //      ��һ��dp[0][j],���仰˵,sΪ��,��pƥ��,����ֻҪp��ʼΪ*��Ϊtrue
    //      ��һ��dp[i][0],��Ȼȫ��Ϊfalse

    //���(s[i] == p[j]  || p[j] == "?")  && dp[i-1][j-1] ��dp[i][j] = true
    //���p[j] == "*" && (dp[i-1][j] = true || dp[i][j-1] = true) ��dp[i][j] = true
    //note:
    //	 dp[i][j-1],��ʾ*�����ǿ��ַ�,����ab,ab*
    //   dp[i-1][j],��ʾ*����ǿ��κ��ַ�,����abcd,ab*
    static class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            for (int i = 1; i < p.length() + 1; i++) {
                //ע��sΪ�� pΪ*a
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = dp[0][i - 1];
                }
            }

            for (int i = 1; i < s.length() + 1; i++) {
                for (int j = 1; j < p.length() + 1; j++) {
                    if ((s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                    } else if (p.charAt(j - 1) == '*' && (dp[i - 1][j] || dp[i][j - 1])) {
                        dp[i][j] = true;
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
