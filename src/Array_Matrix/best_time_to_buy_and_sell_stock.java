package Array_Matrix;
//121
//����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
//��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������
//ע���㲻���������Ʊǰ������Ʊ��
//ʾ�� 1:
//����: [7,1,5,3,6,4]
//���: 5
//����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
//     ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�
public class best_time_to_buy_and_sell_stock {
    public static void main(String[] args) {
        int[] input = new int[]{7, 6, 4, 3, 1};
        System.out.println(new Solution().maxProfit(input));
    }

    //��¼��ǰ��ͼ�minV�͵�ǰ�������maxP
    //����������ÿһ��Ԫ�أ�����������ͼ۵Ĳ����С��maxP������
    //�������maxP�����µĲ��滻�ɵĲ�
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0 || prices.length == 1) {
                return 0;
            }
            int minV = prices[0];
            int maxP = 0;
            for (int i = 0; i < prices.length; i++) {
                minV = Math.min(minV, prices[i]);
                maxP = Math.max(maxP, prices[i] - minV);
            }
            return maxP;
        }
    }
}
