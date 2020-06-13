package DynamicProgramming;

//���������ַ���s1s2...sn��t1t2..tn. ����������ַ�����Ĺ��������еĳ��ȡ��ַ���
//s1s2..sn��������ָ���Ա�ʾΪsi1si2...sim(i1<i2<...im)�����С�

//����
//n=4
//m=4
//s = "abcd"
//t = "becd

//���
//3("bcd")
public class ����������� {
    //dp[i][j]:=s1...si��t1...tj��Ӧ������������еĳ���
    //dp[i+1][j+1] = dp[i][j]+1 si+1=tj+1
    //             = max{dp[i+1][j],dp[i][j+1]} ����

    int n = 4, m = 4;
    char[] s = {'a', 'b', 'c', 'd'};
    char[] t = {'b', 'e', 'c', 'd'};
    int[][] dp = new int[n + 1][m + 1];

    public static void main(String[] args) {
        new �����������().solve();
    }

    public void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i] == t[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
