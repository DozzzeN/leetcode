package DynamicProgramming;

//714
//����һ���������� prices�����е� i ��Ԫ�ش����˵� i ��Ĺ�Ʊ�۸� ���Ǹ����� fee �����˽��׹�Ʊ���������á�
//��������޴ε���ɽ��ף�������ÿ�ν��׶���Ҫ�������ѡ�������Ѿ�������һ����Ʊ����������֮ǰ��Ͳ����ټ��������Ʊ�ˡ�
//���ػ����������ֵ��
//ʾ�� 1:
//����: prices = [1, 3, 2, 8, 4, 9], fee = 2
//���: 8
//����: �ܹ��ﵽ���������:
//�ڴ˴����� prices[0] = 1
//�ڴ˴����� prices[3] = 8
//�ڴ˴����� prices[4] = 4
//�ڴ˴����� prices[5] = 9
//������: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
public class best_time_to_buy_and_sell_stock_with_transaction_fee {
    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 2, 8, 4, 9};
        System.out.println(new Solution().maxProfit(input, 2));
    }

    //�����⣬k = +infinity with fee
    //ÿ�ν���Ҫ֧�������ѣ�ֻҪ�������Ѵ������м�ȥ���ɡ���д���̣�
    //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    //dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
    //���ͣ��൱�������Ʊ�ļ۸������ˡ�
    //�ڵ�һ��ʽ�����Ҳ��һ���ģ��൱��������Ʊ�ļ۸��С�ˡ�
    static class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0 || prices.length == 1) {
                return 0;
            }
            int n = prices.length;
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0] - fee;
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
            }
            return dp[prices.length - 1][0];
        }

        //���ٿռ临�Ӷ�
        int maxProfit_with_cool(int[] prices, int fee) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
            }
            return dp_i_0;
        }
    }
}
