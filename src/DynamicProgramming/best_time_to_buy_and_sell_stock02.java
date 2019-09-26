package DynamicProgramming;

//121
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
//注意你不能在买入股票前卖出股票。
//示例 1:
//输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
public class best_time_to_buy_and_sell_stock02 {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2};
        System.out.println(new Solution().maxProfit_k_1(input));
    }

    //动态规划
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0 || prices.length == 1) {
                return 0;
            }
            //int[天数][当前是否持有股票]
            int[][] dp = new int[prices.length][2];
            for (int i = 0; i < prices.length; i++) {
                if (i - 1 == -1) {
                    dp[i][0] = 0;
                    // 解释：
                    //   dp[i][0]
                    // = max(dp[-1][0], dp[-1][1] + prices[i])
                    // = max(0, -infinity + prices[i]) = 0
                    dp[i][1] = -prices[i];
                    //解释：
                    //   dp[i][1]
                    // = max(dp[-1][1], dp[-1][0] - prices[i])
                    // = max(-infinity, 0 - prices[i])
                    // = -prices[i]
                    continue;
                }
                dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            return dp[prices.length - 1][0];
        }

        //减少空间复杂度
        public int maxProfit_k_1(int[] prices) {
            int n = prices.length;
            // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                // dp[i][1] = max(dp[i-1][1], -prices[i])
                dp_i_1 = Math.max(dp_i_1, -prices[i]);
            }
            return dp_i_0;
        }
    }
}
