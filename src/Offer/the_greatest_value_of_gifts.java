package Offer;

//��һ��m*n�����̵�ÿһ���񶼷���һ�����ÿ�����ﶼ��һ����ֵ������0���������Ͻǿ�ʼ�����
//ÿ�����һ������ƶ�һ��ֱ�����½ǽ���������һ�����̣����õ����������ֵ�����磬������������
//1    10   3    8
//12   2    9    6
//5    7    4    11
//3    7    16   5
//���������ֵΪ1+12+5+7+7+16+5=53��
public class the_greatest_value_of_gifts {
    public static void main(String[] args) {
        System.out.println(new the_greatest_value_of_gifts().getMost(
                new int[][]{
                        {1, 10, 3, 8},
                        {12, 2, 9, 6},
                        {5, 7, 4, 11},
                        {3, 7, 16, 5},
                }
        ));
    }

    //Ӧ���ö�̬�滮��⣬���������������������������������ڸ��ӣ��������Ž⡣
    //dp[i,j] = max{ dp[i-1][j], dp[i][j-1] } + g[i,j]
    //dp[i,j]��ʾ��(0,0)��(i,j)�����ֵ��g[i,j]��ʾ(i,j)��ֵ
    //��άdpתһάdp
    //  1   10  3   8   ->  _   10  3   8   ->  _   _   3   8
    //  12  a               12  a+12            12  14  14+b
    //���Կ�������a�������ֵʱ�Ѿ���1�޹��ˣ�ֻ��Ƚ�a�������ֵ10�������ֵ12����
    //��������ά���󱣴�dp
    public int getMost(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) return 0;
        int n = values[0].length;//����
        int[] dp = new int[n];
        for (int[] value : values) {
            dp[0] += value[0];//��1  1+12    1+12+5  1+12+5+3�ֱ���dp[0,0] dp[1,0] dp[2,0] dp[3,0]
            for (int i = 1; i < n; i++)
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];//dp[i]����dp[i,j-1]��dp[i-1]����dp[i-1,j]
        }
        return dp[n - 1];
    }
}
