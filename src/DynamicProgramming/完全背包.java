package DynamicProgramming;

//��n�������ͼ�ֵ�ֱ�Ϊwi,vi����Ʒ������Щ��Ʒ����ѡ������������W����Ʒ�������
//ѡ��Ʒ��ֵ�ܺ͵����ֵ�������ÿ����Ʒ������ѡ��������

//����
//n=3
//(w��v)={(3��4)��(4��5)��(2��3)}
//W=7

//���
//10(0����Ʒѡ1����2����Ʒѡ2��)
public class ��ȫ���� {
    //dp[i+1][j]=��ǰi����Ʒ��ѡ���ز�С��j���ܼ�ֵ�����ֵ
    //dp[0][j]=0
    //dp[i+1][j] = max{dp[i][j-k*w[i]]+k*v[i]} k>=0��k*w[i]<=j
    int n = 3, W = 7;
    int[] w = new int[]{3, 4, 2};
    int[] v = new int[]{4, 5, 3};
    int[][] dp = new int[n + 1][W + 1];

    public static void main(String[] args) {
        new ��ȫ����().solve();
        new ��ȫ����().solve02();
        new ��ȫ����().solve03();
    }

    //O(nW^2)
    public void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                for (int k = 0; k * w[i] <= j; k++) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j - k * w[i]] + k * v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }

    //O(nW)
    public void solve02() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i + 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }

    //���ٿռ�
    public void solve03() {
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = w[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[W]);
    }
}
