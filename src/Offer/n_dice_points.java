package Offer;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//把n个骰子扔在地上，求点数和为s的概率。
public class n_dice_points {
    public static void main(String[] args) {
        System.out.println(new n_dice_points().dicesSum(4));
        System.out.println(new n_dice_points().dicesSum02(4));
    }

    //动态规划
    //使用一个二维数组dp存储点数出现的次数，其中dp[i][j]表示前i个骰子产生点数j的次数。
    //空间复杂度：O(N^2)
    //dp[i][j]=dp[i-1][j-1]+dp[i-1][j-2]+dp[i-1][j-3]+dp[i-1][j-4]+dp[i-1][j-5]+dp[i-1][j-6]
    //即i个骰子掷出j点的次数=i-1个骰子掷出j-1点的次数（第i个骰子掷出1点）+...
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int pointNum = 6 * n;
        long[][] dp = new long[n + 1][pointNum + 1];

        for (int i = 1; i <= 6; i++)//初始化
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = i; j <= pointNum; j++)     /* 使用 i 个骰子最小点数为 i */
                for (int k = 1; k <= 6 && k <= j; k++)
                    dp[i][j] += dp[i - 1][j - k];

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> result = new ArrayList<>();
        for (int i = n; i <= pointNum; i++)
            result.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
        return result;
    }

    //动态规划+旋转数组
    //空间复杂度：O(N)
    public List<Map.Entry<Integer, Double>> dicesSum02(int n) {
        final int pointNum = 6 * n;
        long[][] dp = new long[2][pointNum + 1];//只使用行数为2的数组交替存取

        for (int i = 1; i <= 6; i++)
            dp[0][i] = 1;

        int flag = 1;                                     /* 旋转标记 */
        for (int i = 2; i <= n; i++, flag = 1 - flag) {
            for (int j = 0; j <= pointNum; j++)
                dp[flag][j] = 0;                          /* 旋转数组清零 */

            for (int j = i; j <= pointNum; j++)
                for (int k = 1; k <= 6 && k <= j; k++)
                    dp[flag][j] += dp[1 - flag][j - k];
        }

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> result = new ArrayList<>();
        for (int i = n; i <= pointNum; i++)
            result.add(new AbstractMap.SimpleEntry<>(i, dp[1 - flag][i] / totalNum));
        return result;
    }
}
