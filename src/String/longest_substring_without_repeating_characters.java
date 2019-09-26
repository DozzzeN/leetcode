package String;

import java.util.HashSet;
import java.util.Set;

//3
//����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
//����: "pwwkew"
//���: 3
//����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
//     ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ�
public class longest_substring_without_repeating_characters {
    public static void main(String[] args) {
        longest_substring_without_repeating_characters.Solution sol = new longest_substring_without_repeating_characters.Solution();
        String test = "pwwkeww";
        System.out.print(sol.lengthOfLongestSubstring(test));
    }

    //��������Ӵ�����ʱ
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int ans = 0;
            //�õ������Ӵ�
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j <= n; j++)
                    if (allUnique(s, i, j)) {
                        ans = Math.max(ans, j - i);
                    }
            return ans;
        }

        //������ַ����е��ַ�����Ψһ�ģ����᷵�� true������᷵�� false
        public boolean allUnique(String s, int start, int end) {
            Set<Character> set = new HashSet<>();
            for (int i = start; i < end; i++) {
                Character ch = s.charAt(i);
                if (set.contains(ch)) return false;
                set.add(ch);
            }
            //���ظ�ʱΪture����ʱ����Ϊend-start��j-i��
            return true;
        }
    }
}
