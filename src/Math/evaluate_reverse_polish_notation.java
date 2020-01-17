package Math;

import java.util.Stack;

//150
//�����沨����ʾ��������ʽ��ֵ��
//��Ч����������� +, -, *, / ��ÿ��������������������Ҳ��������һ���沨�����ʽ��
//˵����
//	��������ֻ�����������֡�
//	�����沨�����ʽ������Ч�ġ����仰˵�����ʽ�ܻ�ó���Ч��ֵ�Ҳ����ڳ���Ϊ 0 �������
//ʾ�� 1��
//����: ["2", "1", "+", "3", "*"]
//���: 9
//����: ((2 + 1) * 3) = 9
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
