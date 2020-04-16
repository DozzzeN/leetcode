package Offer;

//����һ�����֣��������¹�������ַ�����1����ɡ�a����2����ɡ�b��...26����ɡ�z����
//һ�������ж��ַ�����ܣ�����12258һ����5�֣��ֱ���abbeh��lbeh��aveh��abyh��lyh��
//ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
public class translate_numbers_into_strings {
    public static void main(String[] args) {
        System.out.println(new translate_numbers_into_strings().numDecodings("1011"));
    }

    //��̬�滮
    //dp[i] = dp[i-1] + dp[i-2]+g[i-1,i]
    //dp[i]���ַ�����1��iλ�ķ��뷽����g[i-1,i]���ַ���[i-1,i]���Է���ʱ��1��������0
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;//��ʼ��
        dp[1] = s.charAt(0) == '0' ? 0 : 1;//��ʼ��
        for (int i = 2; i <= s.length(); i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            if (one != 0)//ע�����ֲ��ܳ���0
                dp[i] += dp[i - 1];
            if (s.charAt(i - 2) == '0')//ע�����ֲ��ܳ���0
                continue;
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (two <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
