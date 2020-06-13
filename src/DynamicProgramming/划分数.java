package DynamicProgramming;

//��n�����������Ʒ�������ǻ��ֳɲ�����m�飬������ַ�����ģM��������
//����
//n=4
//m=3
//M=10000
//���
//4(1+1+2=1+3=2+2=4)
//ע��1+1+2��1+2+1��һ�����֣������Ļ��ֽ���n��m����
public class ������ {
    //dp[i][j]:=j��i��������
    //dp[i][j]=dp[i][j-i]+dp[i-1][j]
    int n = 4, m = 3;
    int M = 10000;
    int[][] dp = new int[m + 1][n + 1];

    public static void main(String[] args) {
        new ������().solve();
    }

    public void solve() {
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= i) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - i]) % M;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
