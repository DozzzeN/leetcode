package Array_Matrix;
//121
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
//注意你不能在买入股票前卖出股票。
//示例 1:
//输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
public class best_time_to_buy_and_sell_stock {
    public static void main(String[] args) {
        int[] input = new int[]{7, 6, 4, 3, 1};
        System.out.println(new Solution().maxProfit(input));
    }

    //记录当前最低价minV和当前最大利润maxP
    //对于数组中每一个元素，计算其与最低价的差，若差小于maxP则舍弃
    //若差大于maxP则用新的差替换旧的差
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
