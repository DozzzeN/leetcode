package Stack;

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
public class longest_valid_parentheses02 {
    public static void main(String[] args) {
        System.out.println(new longest_valid_parentheses02.Solution().longestValidParentheses("(()"));
    }

    //�����ַ����У�������������������left��right
    //���ȣ����Ǵ����ұ����ַ���������������ÿ����(������������left������������������ÿ����)������������right������
    //ÿ��left��������right���������ʱ�����Ǽ��㵱ǰ��Ч�ַ����ĳ��ȣ����Ҽ�¼ĿǰΪֹ�ҵ�������ַ���
    //���right��������left��������ʱ�����ǽ�left��right������ͬʱ���0
    //�����������Ǵ��ҵ�����һ�����ƵĹ���
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
