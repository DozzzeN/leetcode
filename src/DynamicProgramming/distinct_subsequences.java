package DynamicProgramming;

//115
//����һ���ַ��� S ��һ���ַ��� T�������� S ���������� T ���ֵĸ�����
//һ���ַ�����һ����������ָ��ͨ��ɾ��һЩ��Ҳ���Բ�ɾ�����ַ��Ҳ�����ʣ���ַ����λ������ɵ����ַ����������磬"ACE" �� "ABCDE" ��һ�������У��� "AEC" ���ǣ�
//ʾ�� 1:
//����: S = "rabbbit", T = "rabbit"
//���: 3
//����:
//����ͼ��ʾ, �� 3 �ֿ��Դ� S �еõ� "rabbit" �ķ�����
//(�ϼ�ͷ���� ^ ��ʾѡȡ����ĸ)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
public class distinct_subsequences {
    public static void main(String[] args) {
        System.out.println(new distinct_subsequences.Solution().numDistinct(
                "babgbag", "bag"
        ));
    }

    //��̬�滮
    //dp[m][n] ��Ӧ�ڴ� S[m��S_len) ����ѡ�����ٸ� T[n��T_len)
    //S[s] == T[t]����ǰ�ַ���ȣ��ǾͶ�Ӧ���������ѡ��S�ĵ�ǰ��ĸ�Ͳ�ѡ��S�ĵ�ǰ��ĸ
    //  dp[s][t] = dp[s+1][t+1] + dp[s+1][t]
    //S[s] != T[t]��ֻ��һ���������ѡ��S�ĵ�ǰ��ĸ
    //  dp[s][t] = dp[s+1][t]
    static class Solution {
        public int numDistinct(String s, String t) {
            int dp[][] = new int[s.length() + 1][t.length() + 1];
            for (int i = 0; i <= s.length(); i++) {
                dp[i][t.length()] = 1;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = t.length() - 1; j >= 0; j--) {
                    if (s.charAt(i) == t.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
            return dp[0][0];
        }
    }
}
