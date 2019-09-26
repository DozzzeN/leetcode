package String;

//28
//实现strStr()函数。
//给定一个haystack字符串和一个needle字符串，在haystack字符串中找出needle字符串出现的第一个位置(从0开始)。如果不存在，则返回-1。
//示例1:
//输入:haystack="hello",needle="ll"
//输出:2
//示例2:
//输入:haystack="aaaaa",needle="bba"
//输出:-1
public class implement_strstr {
    public static void main(String[] args) {
        System.out.println(new implement_strstr.Solution().strStr("a"
                ,""));
    }

    //暴力法，双循环
    static class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) return -1;
            if (haystack.length() < needle.length()) return -1;
            //无须全部搜索haystack串
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                int j = 0;
                int point = i;
                for (; j < needle.length(); j++) {
                    if (haystack.charAt(point) != needle.charAt(j)) break;
                    point++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }
            return -1;
        }
    }
}
