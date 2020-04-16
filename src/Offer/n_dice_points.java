package Offer;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//��n���������ڵ��ϣ��������Ϊs�ĸ��ʡ�
public class n_dice_points {
    public static void main(String[] args) {
        System.out.println(new n_dice_points().dicesSum(4));
        System.out.println(new n_dice_points().dicesSum02(4));
    }

    //��̬�滮
    //ʹ��һ����ά����dp�洢�������ֵĴ���������dp[i][j]��ʾǰi�����Ӳ�������j�Ĵ�����
    //�ռ临�Ӷȣ�O(N^2)
    //dp[i][j]=dp[i-1][j-1]+dp[i-1][j-2]+dp[i-1][j-3]+dp[i-1][j-4]+dp[i-1][j-5]+dp[i-1][j-6]
    //��i����������j��Ĵ���=i-1����������j-1��Ĵ�������i����������1�㣩+...
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int pointNum = 6 * n;
        long[][] dp = new long[n + 1][pointNum + 1];

        for (int i = 1; i <= 6; i++)//��ʼ��
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = i; j <= pointNum; j++)     /* ʹ�� i ��������С����Ϊ i */
                for (int k = 1; k <= 6 && k <= j; k++)
                    dp[i][j] += dp[i - 1][j - k];

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> result = new ArrayList<>();
        for (int i = n; i <= pointNum; i++)
            result.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
        return result;
    }

    //��̬�滮+��ת����
    //�ռ临�Ӷȣ�O(N)
    public List<Map.Entry<Integer, Double>> dicesSum02(int n) {
        final int pointNum = 6 * n;
        long[][] dp = new long[2][pointNum + 1];//ֻʹ������Ϊ2�����齻���ȡ

        for (int i = 1; i <= 6; i++)
            dp[0][i] = 1;

        int flag = 1;                                     /* ��ת��� */
        for (int i = 2; i <= n; i++, flag = 1 - flag) {
            for (int j = 0; j <= pointNum; j++)
                dp[flag][j] = 0;                          /* ��ת�������� */

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
