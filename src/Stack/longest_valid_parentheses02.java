package Stack;

//32
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//示例 1:
//输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//示例 2:
//输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
public class longest_valid_parentheses02 {
    public static void main(String[] args) {
        System.out.println(new longest_valid_parentheses02.Solution().longestValidParentheses("(()"));
    }

    //在这种方法中，我们利用两个计数器left和right
    //首先，我们从左到右遍历字符串，对于遇到的每个‘(’，我们增加left计算器，对于遇到的每个‘)’，我们增加right计数器
    //每当left计数器与right计数器相等时，我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串
    //如果right计数器比left计数器大时，我们将left和right计数器同时变回0
    //接下来，我们从右到左做一遍类似的工作
    static class Solution {
        public int longestValidParentheses(String s) {
            int left = 0, right = 0, result = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') left++;
                if (s.charAt(i) == ')') right++;
                if (left == right) result = Math.max(result, left * 2);
                else if (right > left) left = right = 0;
            }
            left = right = 0;
            for (int i = s.length() - 1; i > 0; i--) {
                if (s.charAt(i) == '(') left++;
                if (s.charAt(i) == ')') right++;
                if (left == right) result = Math.max(result, left * 2);
                else if (left > right) left = right = 0;
            }
            return result;
        }
    }
}
