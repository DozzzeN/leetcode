package DynamicProgramming;

//714
//给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
//你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
//返回获得利润的最大值。
//示例 1:
//输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出: 8
//解释: 能够达到的最大利润:
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
public class best_time_to_buy_and_sell_stock_with_transaction_fee {
    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 2, 8, 4, 9};
        System.out.println(new Solution().maxProfit(input, 2));
    }

    //第四题，k = +infinity with fee
    //每次交易要支付手续费，只要把手续费从利润中减去即可。改写方程：
    //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    //dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
    //解释：相当于买入股票的价格升高了。
    //在第一个式子里减也是一样的，相当于卖出股票的价格减小了。
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

        //减少空间复杂度
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
