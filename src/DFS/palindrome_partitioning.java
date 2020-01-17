package DFS;

import java.util.ArrayList;
import java.util.List;

//131
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//返回 s 所有可能的分割方案。
//示例:
//输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//]
public class palindrome_partitioning {
    public static void main(String[] args) {
        List<List<String>> result = new palindrome_partitioning.Solution().partition("aab");
        for (List<String> strings : result) {
            System.out.println(strings);
        }
    }

    //也可以看作是回溯
    static class Solution {
        List<List<String>> result = new ArrayList<>();
        List<String> output = new ArrayList<>();

        public List<List<String>> partition(String s) {
            DFS(s, 0);
            return result;
        }


        public void DFS(String s, int start) {
            if (start == s.length()) {
                result.add(new ArrayList<>(output));
                return;
            }
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    output.add(s.substring(start, i + 1));
                    DFS(s, i + 1);
                    output.remove(output.size() - 1);
                }
            }
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
