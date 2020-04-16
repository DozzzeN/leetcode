package Offer;

//可以有一次买入和一次卖出，买入必须在前。求最大收益。
//如7 1 5 3 6 4，在1处买6出卖获得最大收益6-1=5
public class stock_maximum_profit {
    public static void main(String[] args) {
        System.out.println(new stock_maximum_profit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //使用贪心策略，假设第i轮进行卖出操作，买入操作价格应该在i之前并且价格最低。
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int soFarMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            soFarMin = Math.min(soFarMin, prices[i]);//买入的价格：最低价
            maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
        }
        return maxProfit;
    }
}
