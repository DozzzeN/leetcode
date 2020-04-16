package Offer;

//给定一个数字，按照如下规则翻译成字符串：1翻译成“a”，2翻译成“b”...26翻译成“z”。
//一个数字有多种翻译可能，例如12258一共有5种，分别是abbeh，lbeh，aveh，abyh，lyh。
//实现一个函数，用来计算一个数字有多少种不同的翻译方法。
public class translate_numbers_into_strings {
    public static void main(String[] args) {
        System.out.println(new translate_numbers_into_strings().numDecodings("1011"));
    }

    //动态规划
    //dp[i] = dp[i-1] + dp[i-2]+g[i-1,i]
    //dp[i]是字符串从1到i位的翻译方法，g[i-1,i]当字符串[i-1,i]可以翻译时是1，否则是0
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;//初始化
        dp[1] = s.charAt(0) == '0' ? 0 : 1;//初始化
        for (int i = 2; i <= s.length(); i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            if (one != 0)//注意数字不能出现0
                dp[i] += dp[i - 1];
            if (s.charAt(i - 2) == '0')//注意数字不能出现0
                continue;
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (two <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
