package Stack;

import java.util.Stack;

//32
//����һ��ֻ���� '(' �� ')' ���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�
//ʾ�� 1:
//����: "(()"
//���: 2
//����: ���Ч�����Ӵ�Ϊ "()"
//ʾ�� 2:
//����: ")()())"
//���: 4
//����: ���Ч�����Ӵ�Ϊ "()()"
public class longest_valid_parentheses {
    public static void main(String[] args) {
        System.out.println(new longest_valid_parentheses.Solution().longestValidParentheses("(()"));
    }

    //������ջ�ڱ��������ַ����Ĺ�����ȥ�жϵ�ĿǰΪֹɨ������ַ�������Ч�ԣ�ͬʱ�ܵĶ����Ч�ַ����ĳ����������Ƚ�-1����ջ��
    //����������ÿ����(�������ǽ������±����ջ��
    //����������ÿ����)�������ǵ���ջ����Ԫ�ز�����ǰԪ�ص��±��뵯��Ԫ���±�����ó���ǰ��Ч�����ַ����ĳ���
    //ͨ�����ַ��������Ǽ���������Ч���ַ����ĳ��ȣ������շ������Ч���ַ����ĳ���
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
