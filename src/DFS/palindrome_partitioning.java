package DFS;

import java.util.ArrayList;
import java.util.List;

//131
//����һ���ַ��� s���� s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���
//���� s ���п��ܵķָ����
//ʾ��:
//����: "aab"
//���:
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

    //Ҳ���Կ����ǻ���
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
