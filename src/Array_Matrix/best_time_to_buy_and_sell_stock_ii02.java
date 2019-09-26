package Array_Matrix;

//122
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//示例 1:
//输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
public class best_time_to_buy_and_sell_stock_ii02 {
    public static void main(String[] args) {
        int[] input = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit_k_inf(input));
    }

    //第二题，k = +infinity
    //如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的。可以这样改写框架：
    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
    //            = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
    //我们发现数组中的 k 已经不会改变了，也就是说不需要记录 k 这个状态了：
    //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    //dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
    static class Solution {
        int maxProfit_k_inf(int[] prices) {
            int n = prices.length;
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                //与上一个阶段的dp_i_0，dp_i_1相比较，省略了分配数组的开支
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
            }
            return dp_i_0;
        }
    }
}
