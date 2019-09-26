package Stack;

import java.util.Stack;

//20
//����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
//��Ч�ַ��������㣺
//	�����ű�������ͬ���͵������űպϡ�
//	�����ű�������ȷ��˳��պϡ�
//ע����ַ����ɱ���Ϊ����Ч�ַ�����
//ʾ�� 1:
//����: "()"
//���: true
//ʾ�� 2:
//����: "()[]{}"
//���: true
//ʾ�� 3:
//����: "(]"
//���: false
//ʾ�� 4:
//����: "([)]"
//���: false
//ʾ�� 5:
//����: "{[]}"
//���: true
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
