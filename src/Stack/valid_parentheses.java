package Stack;

import java.util.Stack;

//20
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//有效字符串需满足：
//	左括号必须用相同类型的右括号闭合。
//	左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。
//示例 1:
//输入: "()"
//输出: true
//示例 2:
//输入: "()[]{}"
//输出: true
//示例 3:
//输入: "(]"
//输出: false
//示例 4:
//输入: "([)]"
//输出: false
//示例 5:
//输入: "{[]}"
//输出: true
public class valid_parentheses {
    public static void main(String[] args) {
        System.out.println(new valid_parentheses.Solution().isValid("[])"));
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            if (s == null || s.length() == 0) {
                return true;
            }
            for (int i = 0; i < s.length(); i++) {
                if (stack.size() == 0) {
                    stack.push(s.charAt(i));
                    continue;
                }
                if ((s.charAt(i) == ')' && stack.peek() == '(') ||
                        (s.charAt(i) == '}' && stack.peek() == '{') ||
                        (s.charAt(i) == ']' && stack.peek() == '[')) {
                    stack.pop();
                    continue;
                }
                stack.push(s.charAt(i));
            }
            return stack.size() == 0;
        }
    }
}
