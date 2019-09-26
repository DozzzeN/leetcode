package DynamicProgramming;

//188
//����һ�����飬���ĵ� i ��Ԫ����һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
//���һ���㷨�����������ܻ�ȡ�������������������� k �ʽ��ס�
//ע��: �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
//ʾ�� 1:
//����: [3,3,5,0,0,3,1,4]
//���: 6
//����: �ڵ� 4 �죨��Ʊ�۸� = 0����ʱ�����룬�ڵ� 6 �죨��Ʊ�۸� = 3����ʱ����������ʽ������ܻ������ = 3-0 = 3 ��
//     ����ڵ� 7 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 8 �� ����Ʊ�۸� = 4����ʱ����������ʽ������ܻ������ = 4-1 = 3
public class best_time_to_buy_and_sell_stock_iv {
    public static void main(String[] args) {
        int[] input = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new Solution().maxProfit(2, input));
    }

    //��̬�滮
    //maxProfit = max(maxPartProfit(0,i),maxPartProfit(i+1,n))  0 <= i < n
    static class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length == 0 || prices.length == 1) {
                return 0;
            }
            if (k > prices.length / 2) {
                return maxProfit_k_inf(prices);
            }
            int[][][] dp = new int[prices.length][k + 1][2];
            for (int i = 0; i < prices.length; i++) {
                for (int j = 1; j <= k; j++) {
                    if (i == 0) {
                        dp[0][j][0] = 0;
                        dp[0][j][1] = -prices[0];
                        continue;
                    }
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
            return dp[prices.length - 1][k][0];
        }

        //�����⣬k = any integer
        //������һ�� k = 2 ���̵棬����Ӧ�ú���һ��ĵ�һ���ⷨûɶ���𡣵��ǳ�����һ�����ڴ�Ĵ���ԭ���Ǵ���� k ֵ��ǳ���dp ����̫���ˡ�
        //�������룬���״��� k ����ж���أ�
        //һ�ν�����������������ɣ�������Ҫ���졣����˵��Ч������ k Ӧ�ò����� n/2�������������û��Լ�������ˣ��൱�� k = +infinity�����������֮ǰ������ġ�
        //ֱ�Ӱ�֮ǰ�Ĵ������ã�
        int maxProfit_k_any(int max_k, int[] prices) {
            int n = prices.length;
            if (max_k > n / 2)
                return maxProfit_k_inf(prices);

            int[][][] dp = new int[n][max_k + 1][2];
            for (int i = 0; i < n; i++)
                for (int k = max_k; k >= 1; k--) {
                    if (i - 1 == -1) {
                        /* ���� base case */
                        dp[i][k][0] = 0;
                        dp[i][k][1] = -prices[i];
                        continue;
                    }
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            return dp[n - 1][max_k][0];
        }

        int maxProfit_k_inf(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }
            return dp_i_0;
        }
    }
}
