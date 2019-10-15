package Bit;

import java.util.ArrayList;
import java.util.List;

//784
//����һ���ַ���S��ͨ�����ַ���S�е�ÿ����ĸת���Сд�����ǿ��Ի��һ���µ��ַ������������п��ܵõ����ַ������ϡ�
//ʾ��:
//����: S = "a1b2"
//���: ["a1b2", "a1B2", "A1b2", "A1B2"]
//����: S = "3z4"
//���: ["3z4", "3Z4"]
//����: S = "12345"
//���: ["12345"]
//ע�⣺
//	S �ĳ��Ȳ�����12��
//	S �������ֺ���ĸ��ɡ�
public class letter_case_permutation {
    public static void main(String[] args) {
        System.out.println(new letter_case_permutation.Solution().letterCasePermutation("a1b2"));
    }

    static class Solution {
        private List<String> result = new ArrayList<>();

        public List<String> letterCasePermutation(String S) {
            letterCasePermutation(S, 0, new StringBuilder());
            return this.result;
        }

        public void letterCasePermutation(String S, int depth, StringBuilder temp) {
            if (S.length() == depth) {
                result.add(temp.toString());
            } else {
                char s = S.charAt(depth);
                //���ֲ����жϣ�������д�Сд�任�������������
                //�Ż�2���ж��Ƿ������ֿ��ԣ�Character.isDigit()
                if (S.charAt(depth) <= '9' && S.charAt(depth) >= '0') {
                    temp.append(s);
                    letterCasePermutation(S, depth + 1, temp);
                    temp.deleteCharAt(depth);
                } else {
                    //tempҲ������stack��������stackתΪstringҲ��Ҫ����
                    //�Ż�1��ת��Сд����д����1<<5 (32) �������
                    //�������+1�����Զ�����ĳ����λ�ϵ�ֵ��ʹ��0���1��1���0�����ﵽ�˴�Сдת����Ŀ��
                    temp.append((char) (s ^ (1 << 5)));
                    letterCasePermutation(S, depth + 1, temp);
                    temp.deleteCharAt(depth);
                    temp.append(s);
                    letterCasePermutation(S, depth + 1, temp);
                    temp.deleteCharAt(depth);
                }
            }
        }
    }
}
