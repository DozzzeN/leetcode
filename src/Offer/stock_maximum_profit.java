package Offer;

//������һ�������һ�����������������ǰ����������档
//��7 1 5 3 6 4����1����6��������������6-1=5
public class stock_maximum_profit {
    public static void main(String[] args) {
        System.out.println(new stock_maximum_profit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //ʹ��̰�Ĳ��ԣ������i�ֽ���������������������۸�Ӧ����i֮ǰ���Ҽ۸���͡�
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int soFarMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            soFarMin = Math.min(soFarMin, prices[i]);//����ļ۸���ͼ�
            maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
        }
        return maxProfit;
    }
}
