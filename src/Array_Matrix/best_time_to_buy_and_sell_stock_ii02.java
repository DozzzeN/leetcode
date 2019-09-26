package Array_Matrix;

//122
//����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
//���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����
//ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
//ʾ�� 1:
//����: [7,1,5,3,6,4]
//���: 7
//����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 3 �죨��Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��
//     ����ڵ� 4 �죨��Ʊ�۸� = 3����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ������, ��ʽ������ܻ������ = 6-3 = 3 ��
public class best_time_to_buy_and_sell_stock_ii02 {
    public static void main(String[] args) {
        int[] input = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit_k_inf(input));
    }

    //�ڶ��⣬k = +infinity
    //��� k Ϊ�������ô�Ϳ�����Ϊ k �� k - 1 ��һ���ġ�����������д��ܣ�
    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    //            = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
    //���Ƿ��������е� k �Ѿ�����ı��ˣ�Ҳ����˵����Ҫ��¼ k ���״̬�ˣ�
    //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    //dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
    static class Solution {
        int maxProfit_k_inf(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                //����һ���׶ε�dp_i_0��dp_i_1��Ƚϣ�ʡ���˷�������Ŀ�֧
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }
            return dp_i_0;
        }
    }
}
