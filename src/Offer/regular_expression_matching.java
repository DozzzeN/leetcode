package Offer;

//https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tqId=11205&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//请实现一个函数用来匹配包括'.'和'*'的正则表达式。
//模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
//在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
public class regular_expression_matching {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.match(
                new char[]{'a'},
                new char[]{'.', '*'}));
    }

    //特殊用例 "a" ".*"
    //"" "."
    static public class Solution {
        public boolean match(char[] str, char[] pattern) {
            return matchHelper(str, 0, pattern, 0);
        }

        public boolean matchHelper(char[] str, int i, char[] pattern, int j) {
            if (i == str.length && j == pattern.length) return true;
            if (j >= pattern.length) return false;
            if (j + 1 == pattern.length || (j + 1 < pattern.length && pattern[j + 1] != '*')) {
                if ((i < str.length) && (str[i] == pattern[j] || pattern[j] == '.')) {
                    return matchHelper(str, i + 1, pattern, j + 1);
                } else return false;
            } else {
                if ((i < str.length) && (str[i] == pattern[j] || pattern[j] == '.')) {//星号匹配0次或一次
                    return matchHelper(str, i, pattern, j + 2) || matchHelper(str, i + 1, pattern, j);
                } else return matchHelper(str, i, pattern, j + 2);
            }
        }
    }
}
