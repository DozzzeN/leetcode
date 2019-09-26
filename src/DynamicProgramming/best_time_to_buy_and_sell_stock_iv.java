package DynamicProgramming;

//188
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//示例 1:
//输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3
public class best_time_to_buy_and_sell_stock_iv {
    public static void main(String[] args) {
        int[] input = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new Solution().maxProfit(2, input));
    }

    //动态规划
    //maxProfit = max(maxPartProfit(0,i),maxPartProfit(i+1,n))  0 <= i < n
    static class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length == 0 || prices.length == 1) {
                return 0;
            }
            if (k > prices.length / 2) {
                return maxProfit_k_inf(prices);
            }
            int[][][] dp = new int[prices.length][k + 1][2];
            for (int i = 0; i < prices.length; i++) {
                for (int j = 1; j <= k; j++) {
                    if (i == 0) {
                        dp[0][j][0] = 0;
                        dp[0][j][1] = -prices[0];
                        continue;
                    }
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
            return dp[prices.length - 1][k][0];
        }

        //第六题，k = any integer
        //有了上一题 k = 2 的铺垫，这题应该和上一题的第一个解法没啥区别。但是出现了一个超内存的错误，原来是传入的 k 值会非常大，dp 数组太大了。
        //现在想想，交易次数 k 最多有多大呢？
        //一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，相当于 k = +infinity。这种情况是之前解决过的。
        //直接把之前的代码重用：
        int maxProfit_k_any(int max_k, int[] prices) {
            int n = prices.length;
            if (max_k > n / 2)
                return maxProfit_k_inf(prices);

            int[][][] dp = new int[n][max_k + 1][2];
            for (int i = 0; i < n; i++)
                for (int k = max_k; k >= 1; k--) {
                    if (i - 1 == -1) {
                        /* 处理 base case */
                        dp[i][k][0] = 0;
                        dp[i][k][1] = -prices[i];
                        continue;
                    }
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            return dp[n - 1][max_k][0];
        }

        int maxProfit_k_inf(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }
            return dp_i_0;
        }
    }
}
