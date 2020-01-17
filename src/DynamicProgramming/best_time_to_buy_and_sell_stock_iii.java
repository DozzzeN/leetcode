package DynamicProgramming;

//123
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
//注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//示例 1:
//输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3
public class best_time_to_buy_and_sell_stock_iii {
    public static void main(String[] args) {
        int[] input = new int[]{7, 6, 4, 3, 1};
        System.out.println(new Solution().maxProfit(input));
    }

    //动态规划
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
