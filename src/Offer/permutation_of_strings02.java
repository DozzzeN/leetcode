package Offer;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//题目描述
//输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
//输入描述:
//输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
public class permutation_of_strings02 {
    public static void main(String[] args) {
        System.out.println(new permutation_of_strings02.Solution().Permutation("aabc"));
    }

    public static class Solution {
        private ArrayList<String> result = new ArrayList<>();

        public ArrayList<String> Permutation(String str) {
            if (str.length() == 0) return result;
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            backtracking(chars, new boolean[chars.length], new StringBuilder());
            return result;
        }

        private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
            if (s.length() == chars.length) {
                result.add(s.toString());
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (hasUsed[i]) continue;
                //不能重复
                if (i != 0 && chars[i] == chars[i - 1] && hasUsed[i - 1]) continue;
                hasUsed[i] = true;
                s.append(chars[i]);
                backtracking(chars, hasUsed, s);
                s.deleteCharAt(s.length() - 1);
                hasUsed[i] = false;
            }
        }
    }
}
