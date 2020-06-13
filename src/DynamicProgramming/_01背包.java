package DynamicProgramming;

//��n�������ͼ�ֵ�ֱ�Ϊwi��vi����Ʒ������Щ��Ʒ����ѡ��������������W����Ʒ������
//����ѡ�����м�ֵ�ܺ͵����ֵ��

//����
//n=4
//(w��v)={(2��3)��(1��2)��(3��4)��(2��2)}
//W=5

import java.util.Arrays;

//���
//7(ѡ���0��1��3����Ʒ)
public class _01���� {
    int n = 4, W = 5;
    int[] w = new int[]{2, 1, 3, 2};
    int[] v = new int[]{3, 2, 4, 2};
    //dp[i+1][j]=��ǰi����Ʒ��ѡ���ز�С��j���ܼ�ֵ�����ֵ
    //dp[0][j]=0
    //dp[i+1][j] = dp[i][j] ��w[i]>j
    //           = max{dp[i][j],dp[i][j-w[i]]+v[i]} ����
    int[][] dp = new int[n + 1][W + 1];

    public static void main(String[] args) {
        new _01����().solve();
        new _01����().solve02();
        new _01����().solve03();
    }

    public void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }

    //���ٿռ�
    public void solve02() {
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = W; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[W]);
    }

    //dp��Ϊ��Բ�ͬ�ļ�ֵ������С������
    //dp[i+1][j]=��ǰi����Ʒ��ѡ��ֵ�ܺ�Ϊjʱ����������Сֵ����ʼΪ�����
    //dp[i+1][j]=min{dp[i][j],dp[i][j-v[i]]+w[i]}
    public void solve03() {
        int maxV = v[0];
        for (int value : v) {
            maxV = Math.max(maxV, value);
        }
        int[][] dp = new int[n + 1][n * maxV + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 1000000);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n * maxV; j++) {
                if (j < v[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.min(dp[i][j], dp[i][j - v[i]] + w[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n * maxV; i++) {
            if (dp[n][i] <= W) res = i;
        }

        System.out.println(res);
    }
}
