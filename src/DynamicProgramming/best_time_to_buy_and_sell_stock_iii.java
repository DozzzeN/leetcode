package DynamicProgramming;

//123
//����һ�����飬���ĵ� i ��Ԫ����һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
//���һ���㷨�����������ܻ�ȡ�������������������� ���� ���ס�
//ע��: �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
//ʾ�� 1:
//����: [3,3,5,0,0,3,1,4]
//���: 6
//����: �ڵ� 4 �죨��Ʊ�۸� = 0����ʱ�����룬�ڵ� 6 �죨��Ʊ�۸� = 3����ʱ����������ʽ������ܻ������ = 3-0 = 3 ��
//     ����ڵ� 7 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 8 �� ����Ʊ�۸� = 4����ʱ����������ʽ������ܻ������ = 4-1 = 3
public class best_time_to_buy_and_sell_stock_iii {
    public static void main(String[] args) {
        int[] input = new int[]{7, 6, 4, 3, 1};
        System.out.println(new Solution().maxProfit(input));
    }

    //��̬�滮
    //maxProfit = max(maxPartProfit(0,i),maxPartProfit(i+1,n))  0 <= i < n
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0 || prices.length == 1) {
                return 0;
            }
            int maxP = 0;
            for (int i = 1; i < prices.length; i++) {
                maxP = Math.max(maxP, maxPartProfit(prices, i));
            }
            return maxP;
        }

        public int maxPartProfit(int[] prices, int cut) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int minV = prices[0];
            int maxP = 0;
            for (int i = 0; i <= cut; i++) {
                minV = Math.min(minV, prices[i]);
                maxP = Math.max(maxP, prices[i] - minV);
            }
            int minV2 = prices[cut];
            int maxP2 = 0;
            for (int i = cut; i < prices.length; i++) {
                minV2 = Math.min(minV2, prices[i]);
                maxP2 = Math.max(maxP2, prices[i] - minV2);
            }
            return maxP + maxP2;
        }
    }
}
