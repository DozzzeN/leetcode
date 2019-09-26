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
public class best_time_to_buy_and_sell_stock_ii {
    public static void main(String[] args) {
        int[] input = new int[]{7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(input));
    }

    //�����ڵ�ǰ�ɼ�������������ʿ��Խ����ظ�����
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0 || prices.length == 1) {
                return 0;
            }
            int maxP = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                maxP += prices[i + 1] - prices[i] > 0 ? prices[i + 1] - prices[i] : 0;
            }
            return maxP;
        }
    }
}
