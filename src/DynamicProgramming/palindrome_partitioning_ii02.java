package DynamicProgramming;

import java.util.Arrays;

//132
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//返回符合要求的最少分割次数。
//示例:
//输入: "aab"
//输出: 1
//解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
public class palindrome_partitioning_ii02 {
    public static void main(String[] args) {
        System.out.println(new palindrome_partitioning_ii02.Solution().minCut("aabbc"));
    }

    //D[i]表示[0,i]区间内最小划分
    //D[i] = min(D[0,j] + D[j+1,i]) 0 <= j < i
    //简化为D[i] = min(D[i], D[j]+1) 当[j,i]是回文串时
    static class Solution {
        public int minCut(String s) {
            int[] D = new int[s.length() + 1];
            Arrays.fill(D, s.length() + 1);
            D[0] = -1;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j >= 0; j--) {
                    if (isPalindrome(s, j, i)) {
                        D[i + 1] = Math.min(D[i + 1], D[j] + 1);
                    }
                }
            }
            return D[s.length()];
        }

        public boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) return false;
                start++;
                end--;
            }
            return true;
        }
    }
}
