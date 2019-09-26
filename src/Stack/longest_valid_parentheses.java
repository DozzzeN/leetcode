package Stack;

import java.util.Stack;

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
public class longest_valid_parentheses {
    public static void main(String[] args) {
        System.out.println(new longest_valid_parentheses.Solution().longestValidParentheses("(()"));
    }

    //可以用栈在遍历给定字符串的过程中去判断到目前为止扫描的子字符串的有效性，同时能的都最长有效字符串的长度我们首先将-1放入栈顶
    //对于遇到的每个‘(’，我们将它的下标放入栈中
    //对于遇到的每个‘)’，我们弹出栈顶的元素并将当前元素的下标与弹出元素下标作差，得出当前有效括号字符串的长度
    //通过这种方法，我们继续计算有效子字符串的长度，并最终返回最长有效子字符串的长度
    static class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int length = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (s.charAt(i) == ')') {
                    stack.pop();
                    if (stack.empty()) {
                        stack.push(i);
                    } else {
                        length = Math.max(length, i - stack.peek());
                    }
                }
            }
            return length;
        }
    }
}
