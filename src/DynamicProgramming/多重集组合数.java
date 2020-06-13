package DynamicProgramming;

//��n����Ʒ����i����Ʒ��a;������ͬ�������Ʒ���Ի������ֵ���ͬ������޷����֡���
//��Щ��Ʒ��ȡ��m���Ļ����ж�����ȡ��?���������ģM��������

//����
//n=3
//m=3
//a={1��2��3}
//M=10000

//���
//6(0+0+3��0+1+2��0+2+1��1+0+2��1+1+1��1+2+0)
public class ���ؼ������ {
    //dp[i+1][j]:=��ǰi����Ʒ��ȡ��j���������
    //dp[i+1][j] = sigma(k=0,min(j,a[i])) {dp[i][j-k]}
    //           = dp[i+1][j-1]+dp[i][j]-dp[i][j-1-ai]
    int n = 3, m = 3;
    int[] a = new int[]{1, 2, 3};
    int M = 10000;
    int[][] dp = new int[n + 1][m + 1];

    public static void main(String[] args) {
        new ���ؼ������().solve();
    }

    public void solve() {
        //һ������ȡ�ķ�������ֻ��һ��
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - 1 - a[i] >= 0) {
                    dp[i + 1][j] = (dp[i + 1][j - 1] + dp[i][j] - dp[i][j - 1 - a[i]] + M) % M;
                } else {
                    dp[i + 1][j] = (dp[i + 1][j - 1] + dp[i][j]) % M;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
