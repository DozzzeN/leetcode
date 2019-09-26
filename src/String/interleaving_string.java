package String;

//97
//给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
//示例 1:
//输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出: true
//示例 2:
//输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出: false
public class interleaving_string {
    public static void main(String[] args) {
        System.out.println(new interleaving_string.Solution().isInterleave(
                "aabcc", "dbbca", "aadbbcbcac"
        ));
    }

    //二路归并是错的解法，会遍历到aabcc dbb aadbbcbc 发现ca和ac不匹配
    //正向匹配或者逆向匹配都是错误结果（如aabc abad aabadabc)
    static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder(), sb3 = new StringBuilder();
            for (int i = s1.length() - 1; i >= 0; i--) {
                sb1.append(s1.charAt(i));
            }
            for (int i = s2.length() - 1; i >= 0; i--) {
                sb2.append(s2.charAt(i));
            }
            for (int i = s3.length() - 1; i >= 0; i--) {
                sb3.append(s3.charAt(i));
            }
            s1 = sb1.toString();
            s2 = sb2.toString();
            s3 = sb3.toString();
            if (s3.length() != s1.length() + s2.length()) return false;
            int i = 0, j = 0, k = 0;
            while (i < s1.length() && j < s2.length()) {
                if (s1.charAt(i) == s3.charAt(k)) i++;
                else if (s2.charAt(j) == s3.charAt(k)) j++;
                else return false;
                k++;
            }
            while (i < s1.length()) {
                if (s1.charAt(i) == s3.charAt(k)) {
                    i++;
                    k++;
                } else return false;
            }
            while (j < s2.length()) {
                if (s2.charAt(j) == s3.charAt(k)) {
                    j++;
                    k++;
                } else return false;
            }
            return true;
        }
    }
}
