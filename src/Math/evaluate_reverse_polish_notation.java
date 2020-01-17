package Math;

import java.util.Stack;

//150
//根据逆波兰表示法，求表达式的值。
//有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
//说明：
//	整数除法只保留整数部分。
//	给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
//示例 1：
//输入: ["2", "1", "+", "3", "*"]
//输出: 9
//解释: ((2 + 1) * 3) = 9
public class evaluate_reverse_polish_notation {
    public static void main(String[] args) {
        System.out.println(new evaluate_reverse_polish_notation.Solution().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> operand = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                switch (tokens[i]) {
                    case "+": {
                        int op1 = operand.pop();
                        int op2 = operand.pop();
                        operand.push(op2 + op1);
                        break;
                    }
                    case "-": {
                        int op1 = operand.pop();
                        int op2 = operand.pop();
                        operand.push(op2 - op1);
                        break;
                    }
                    case "*": {
                        int op1 = operand.pop();
                        int op2 = operand.pop();
                        operand.push(op2 * op1);
                        break;
                    }
                    case "/": {
                        int op1 = operand.pop();
                        int op2 = operand.pop();
                        operand.push(op2 / op1);
                        break;
                    }
                    default: {
                        operand.push(Integer.valueOf(tokens[i]));
                    }
                }
            }
            return operand.pop();
        }
    }
}
