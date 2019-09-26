package String;

import java.util.Arrays;

//205
//给定两个字符串 s 和 t，判断它们是否是同构的。
//如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
//所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
public class isomorphic_strings {
    public static void main(String[] args) {
        String s = "paper", t = "title";
        System.out.println(new Solution().isIsomorphic(s, t));

    }

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() == 0 && t.length() == 0) {
                return true;
            }
            int sNum[] = new int[s.length()];
            int tNum[] = new int[t.length()];
            sNum[0] = 1;
            tNum[0] = 1;
            int max = 1;
            //将paper转化为12134
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        sNum[i] = sNum[j];
                        break;
                    }
                    if (j == i - 1) {
                        sNum[i] = ++max;
                    }
                }
            }
            max = 1;
            for (int i = 0; i < t.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (t.charAt(i) == t.charAt(j)) {
                        tNum[i] = tNum[j];
                        break;
                    }
                    if (j == i - 1) {
                        tNum[i] = ++max;
                    }
                }
            }

            return Arrays.equals(sNum, tNum);

        }
    }
}
