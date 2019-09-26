package DynamicProgramming;

//309
//����һ���������飬���е� i ��Ԫ�ش����˵� i ��Ĺ�Ʊ�۸� ��
//���һ���㷨����������������������Լ�������£�����Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ��:
//	�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
//	������Ʊ�����޷��ڵڶ��������Ʊ (���䶳��Ϊ 1 ��)��
//ʾ��:
//����: [1,2,3,0,2]
//���: 3
//����: ��Ӧ�Ľ���״̬Ϊ: [����, ����, �䶳��, ����, ����]
public class best_time_to_buy_and_sell_stock_with_cooldown {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2};
        System.out.println(new Solution().maxProfit(input));
    }

    //�����⣬k = +infinity with cooldown
    //ÿ�� sell ֮��Ҫ��һ����ܼ������ס�ֻҪ������ص�������һ���״̬ת�Ʒ��̼��ɣ�
    //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    //dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
    //���ͣ��� i ��ѡ�� buy ��ʱ��Ҫ�� i-2 ��״̬ת�ƣ������� i-1 ��
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0 || prices.length == 1) {
                return 0;
            }
            int n = prices.length;
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = - prices[0];
            int dp_pre_0 = 0; // ���� dp[i-2][0]
            for (int i = 1; i < n; i++) {
                int temp = dp[i - 1][0];
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp_pre_0 - prices[i]);
                dp_pre_0 = temp;
            }
            return dp[prices.length - 1][0];
        }

        //���ٿռ临�Ӷ�
        int maxProfit_with_cool(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            int dp_pre_0 = 0; // ���� dp[i-2][0]
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
                dp_pre_0 = temp;
            }
            return dp_i_0;
        }
    }
}
