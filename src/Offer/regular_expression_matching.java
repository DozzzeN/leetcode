package Offer;

//https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tqId=11205&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��
//ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
//�ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
public class regular_expression_matching {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.match02(
                new char[]{'a', 'a', 'a'},
                new char[]{'a', '*'}));
    }

    //�������� "a" ".*"
    //"" "."
    static public class Solution {
        public boolean match(char[] str, char[] pattern) {
            return matchHelper(str, 0, pattern, 0);
        }

        //dp[i][j]��ʾstr��ǰi����pattern��ǰj���Ƿ�ƥ��
        //��str="aaa" pattern="a*"
        //��ʼ����              �ڶ���ƥ��              ������ƥ��               ������ƥ��
        //    _    a    *          _    a    *           _    a    *           _    a    *
        //_   1         1(0)   _   1         1       _   1         1       _   1         1
        //a                    a        1(1) 1(2)    a        1(1) 1(2)    a        1(1) 1(2)
        //a                    a                     a             1(2)    a             1(2)
        //a                    a                     a                     a             1(2)
        public boolean match02(char[] str, char[] pattern) {
            boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];

            dp[0][0] = true;
            for (int i = 1; i <= pattern.length; i++)
                if (pattern[i - 1] == '*')
                    dp[0][i] = dp[0][i - 2];//��(0)

            for (int i = 1; i <= str.length; i++)
                for (int j = 1; j <= pattern.length; j++)
                    if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                        dp[i][j] = dp[i - 1][j - 1];//��(1)
                    else if (pattern[j - 1] == '*')
                        if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {//��(2)
                            dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                            dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                            dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                        } else
                            dp[i][j] = dp[i][j - 2];   // a* only counts as empty

            return dp[str.length][pattern.length];
        }

        public boolean matchHelper(char[] str, int i, char[] pattern, int j) {
            if (i == str.length && j == pattern.length) return true;
            if (j >= pattern.length) return false;
            if (j + 1 == pattern.length || (j + 1 < pattern.length && pattern[j + 1] != '*')) {
                if ((i < str.length) && (str[i] == pattern[j] || pattern[j] == '.')) {
                    return matchHelper(str, i + 1, pattern, j + 1);
                } else return false;
            } else {
                if ((i < str.length) && (str[i] == pattern[j] || pattern[j] == '.')) {//�Ǻ�ƥ��0�λ�һ��
                    return matchHelper(str, i, pattern, j + 2) || matchHelper(str, i + 1, pattern, j);
                } else return matchHelper(str, i, pattern, j + 2);
            }
        }
    }
}
