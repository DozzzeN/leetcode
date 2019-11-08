package Minimax;

//375
//����������һ��������Ϸ����Ϸ�������£�
//�Ҵ� 1 �� n ֮��ѡ��һ�����֣���������ѡ���ĸ����֡�
//ÿ����´��ˣ��Ҷ�������㣬��ѡ�����ֱ���Ĵ��˻���С�ˡ�
//Ȼ��������������� x ���Ҳ´��˵�ʱ������Ҫ֧�����Ϊ x ���ֽ�ֱ����µ���ѡ�����֣������Ӯ���������Ϸ��
//ʾ��:
//n = 10, ��ѡ����8.
//��һ��: �����ѡ���������5���һ�����㣬�ҵ����ָ���һЩ��Ȼ������Ҫ֧��5�顣
//�ڶ���: �����7���Ҹ����㣬�ҵ����ָ���һЩ����֧��7�顣
//������: �����9���Ҹ����㣬�ҵ����ָ�СһЩ����֧��9�顣
//��Ϸ������8 ������ѡ�����֡�
//������Ҫ֧�� 5 + 7 + 9 = 21 ��Ǯ��
//���� n �� 1��������������Ҫӵ�ж����ֽ����ȷ������Ӯ�������Ϸ��
public class guess_number_higher_or_lower_ii02 {
    public static void main(String[] args) {
        System.out.println(new guess_number_higher_or_lower_ii02.Solution().getMoneyAmount(7));
    }

    //��̬�滮������� dp(i,j) ������ (i,j) ����������С�����Ĵ���
    //ʱ�临�Ӷȣ� O(n^3)
    //�ռ临�Ӷȣ� O(n^2)
    static class Solution {
        public int getMoneyAmount(int n) {
            int[][] dp = new int[n + 1][n + 1];
            //len = 1ʱΪ0 len = end - start + 1 start = end - len + 1 end = len + start - 1
            for (int len = 2; len <= n ; len++) {
                for (int start = 1; start <= n - len + 1; start++) {
                    int minRes = Integer.MAX_VALUE;
                    for (int piv = start; piv < len + start - 1; piv++) {
                        int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                        minRes = Math.min(res, minRes);
                    }
                    dp[start][start + len - 1] = minRes;
                }
            }
            return dp[1][n];
        }
    }
}
