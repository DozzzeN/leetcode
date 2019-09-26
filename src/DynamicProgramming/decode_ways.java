package DynamicProgramming;

//91
//һ��������ĸ A-Z ����Ϣͨ�����·�ʽ�����˱��룺
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//����һ��ֻ�������ֵķǿ��ַ������������뷽����������
//ʾ�� 1:
//����: "12"
//���: 2
//����: �����Խ���Ϊ "AB"��1 2������ "L"��12����
//ʾ�� 2:
//����: "226"
//���: 3
//����: �����Խ���Ϊ "BZ" (2 26), "VF" (22 6), ���� "BBF" (2 2 6) ��
public class decode_ways {
    public static void main(String[] args) {
        System.out.println(new decode_ways.Solution().numDecodings("123"));
    }

    //f(n)��s����Ϊnʱ�Ľⷨ���͸���
    //���s[n] = 0��s[n - 1] = 1��2 ��f(n) = f(n - 2) ���򷵻�0 ��30�����
    //���s[n] �� 0��s[n - 1] = 1 ��f(n) = f(n - 1�� + f(n - 2)
    //���1 <= s[n] <= 6��s[n - 1] = 2 ��f(n) = f(n - 1�� + f(n - 2)
    static class Solution {
        public int numDecodings(String s) {
            if (s.charAt(0) == '0') return 0;//s[0] == 0ֱ�ӷ���
            int fn_2 = 1, fn = 0, fn_1 = 1;//f(0) = 1,f(-1) = 1
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                        fn = fn_2;
                    } else {
                        return 0;
                    }
                } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                    fn = fn_1 + fn_2;
                }
                fn_2 = fn_1;
                fn_1 = fn;
            }
            return fn;
        }
    }
}
