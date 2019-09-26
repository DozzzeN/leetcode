package String;

//5
//����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
//����: "babad"
//���: "bab"
//ע��: "aba" Ҳ��һ����Ч�𰸡�
public class longest_palindromic_substring {
    public static void main(String[] args) {
        String input = "babad";
        System.out.println(new longest_palindromic_substring.Solution().longestPalindrome2(input));

    }

    //�Ż�������������ʱ�临�Ӷ���O(n^3)תΪO(n^2)
    //��̬�滮 ���庯��P(i,j) ���Si...Sj���ǻ��Ĵ��򷵻�true�����򷵻�false
    //P(i,j) = P(i+1,j-1) ���Si==Sj
    //P(i,i) = true
    //P(i,i+1) = true ���Si==Si+1
    static class Solution {
        //��ʱ
        public String longestPalindrome(String s) {
            int length = 0;
            int left = 0;
            int right = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (P(s, i, j)) {
                        if (length < (j - i + 1)) {
                            //substring��ǰ������
                            length = j - i + 1;
                            left = i;
                            right = j;
                        }
                    }
                }
            }

            return s.length() <= 1 || s == null ? s : s.substring(left, right + 1);
        }

        public boolean P(String s, int i, int j) {
            if (i == j) return true;
            if (i + 1 == j && s.charAt(i) == s.charAt(j)) return true;
            if (s.charAt(i) == s.charAt(j)) {
                return P(s, i + 1, j - 1);
            }
            return false;
        }

        //���ᳬʱ
        public String longestPalindrome2(String s) {
            if (s.length() <= 1) return s;
            if (s == null) return null;

            int len = s.length();
            //�����ά����洢dp�Ľ��ֵ
            boolean[][] dp = new boolean[len][len];
            String result = s.substring(0, 1);
            for (int i = 0; i < len; i++) {
                //�����ַ�������յ�������ͬ��ȫ��Ϊtrue
                dp[i][i] = true;
            }
            for (int i = 0; i < len - 1; i++) {
                //�����ַ�����ַ���ͬΪtrue��ע�����鲻ҪԽ�磩
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                if (dp[i][i + 1]) {
                    result = s.substring(i, i + 1 + 1);
                }
            }
            //����ѭ�������ַ����ĸ��ַ�......
            for (int k = 3; k <= len; k++) {
                for (int i = 0; (i + k) <= len; i++) {
                    //��������� i�����Ӵ����� k ����Եõ��յ����� j ��ͬ��ע������Խ�����⣩
                    int j = i + k - 1;
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    if (dp[i][j] && (j - i + 1) > result.length()) {
                        //�Ƚϻ����Ӵ������뱣���result����
                        result = s.substring(i, j + 1);
                    }
                }
            }
            return result;
        }
    }
}
