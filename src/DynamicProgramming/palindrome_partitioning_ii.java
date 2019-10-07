package DynamicProgramming;

import java.util.Arrays;

//132
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//返回符合要求的最少分割次数。
//示例:
//输入: "aab"
//输出: 1
//解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
public class palindrome_partitioning_ii {
    public static void main(String[] args) {
        System.out.println(new palindrome_partitioning_ii.Solution().minCut("aabcabaa"));
    }

    //D[i,n]表示[i,n]区间内最小划分
    //D[i,n] = min(D[i,j] + D[j+1,n]) i <= j < n
    //简化为D[i] = min(D[i], D[j+1]+1) 当[i,j]是回文串时
    static class Solution {
        public int minCut(String s) {
            int[] D = new int[s.length() + 1];
            Arrays.fill(D, s.length() + 1);
            D[s.length()] = 0;
            //memo
            boolean[][] P = new boolean[s.length()][s.length()];
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    //用memo来判断是否是回文，进行简化
                    if (s.charAt(i) == s.charAt(j) && (j - i < 2 || P[i + 1][j - 1])) {
                        P[i][j] = true;
                        D[i] = Math.min(D[i], D[j + 1] + 1);
                    }
                }
            }
            return D[0] - 1;
        }
    }
}
