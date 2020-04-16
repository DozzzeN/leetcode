package String;

import java.util.Arrays;

//28
//实现strStr()函数。
//给定一个haystack字符串和一个needle字符串，在haystack字符串中找出needle字符串出现的第一个位置(从0开始)。如果不存在，则返回-1。
//示例1:
//输入:haystack="hello",needle="ll"
//输出:2
//示例2:
//输入:haystack="aaaaa",needle="bba"
//输出:-1
public class implement_strstr02 {
    public static void main(String[] args) {

        System.out.println(new implement_strstr02.Solution().strStr("ababababacabababa", "ababaca"));
    }


    //KMP
    static class Solution {
        int[] next;

        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) return -1;
            if (needle.length() == 0) return 0;
            if (haystack.length() < needle.length()) return -1;
            next = new int[needle.length()];
            GetNext(needle, next);
            int i = 0;
            int j = 0;
            while (i < haystack.length() && j < needle.length()) {
                //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
                if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else {
                    //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                    //next[j]即为j所对应的next值
                    j = next[j];
                }
            }
            if (j == needle.length())
                return i - j;
            else
                return -1;
        }

        public void GetNext(String ch, int[] next) {
            next[0] = -1;
            int k = -1;
            int j = 0;
            while (j < ch.length() - 1) {
                if (k == -1 || ch.charAt(k) == ch.charAt(j)) {
                    k++;
                    j++;
                    next[j] = k;
                } else {
                    k = next[k];
                }
            }
            System.out.println(Arrays.toString(next));
        }
    }
}
