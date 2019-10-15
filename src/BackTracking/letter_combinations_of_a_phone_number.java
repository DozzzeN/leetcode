package BackTracking;

import java.util.ArrayList;
import java.util.List;

//17
//����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
//�������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
//ʾ��:
//���룺"23"
//�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
public class letter_combinations_of_a_phone_number {
    public static void main(String[] args) {
        List<String> result = new letter_combinations_of_a_phone_number.Solution().letterCombinations(
                "23"
        );
        System.out.println(result);
    }

    static class Solution {
        List<String> set = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) return set;
            String[] trans = new String[]{"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            generater(trans, digits, "", 0);
            return set;
        }

        public void generater(String[] trans, String digits, String result, int deep) {
            if (deep == digits.length()) {
                set.add(result);
                return;
            }
            int index = digits.charAt(deep) - 48;
            //ÿһ��ѭ�������Ե���ͬһ���������з�֧
            for (int i = 0; i < trans[index].length(); i++) {
                //���һ����ĸ
                result = result + trans[index].charAt(i);
                //�ݹ飬�����һ����ĸ
                generater(trans, digits, result, deep + 1);
                //���ݣ�ɾ������ӵ���ĸ
                result = result.substring(0, result.length() - 1);
            }
        }
    }
}
