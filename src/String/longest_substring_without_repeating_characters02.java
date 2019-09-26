package String;

import java.util.HashSet;
import java.util.Set;

//3
//����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
//����: "pwwkew"
//���: 3
//����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
//     ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ�
public class longest_substring_without_repeating_characters02 {
    public static void main(String[] args) {
        longest_substring_without_repeating_characters02.Solution sol = new longest_substring_without_repeating_characters02.Solution();
        String test = "pwwkew";
        System.out.print(sol.lengthOfLongestSubstring02(test));
    }

    static class Solution {
        //�Ż��Ļ�������
        //���ǿ��Զ����ַ���������ӳ�䣬������ʹ�ü������ж�һ���ַ��Ƿ���ڡ� �������ҵ��ظ����ַ�ʱ�����ǿ������������ô��ڡ�
        //Ҳ����˵����� s[j] �� [i,j) ��Χ������ j�� �ظ����ַ������ǲ���Ҫ������ i ��
        //���ǿ���ֱ������ [i��j��] ��Χ�ڵ�����Ԫ�أ����� i ��Ϊ j��+1 ��
        public int lengthOfLongestSubstring(String s) {
            if (s.equals(" ")) {
                return 1;
            }
            if (s.length() == 0) {
                return 0;
            }
            StringBuilder sb = new StringBuilder();
            //�������ַ�
            sb.append(s.charAt(0));
            int result = 1;
            for (int i = 0; i < s.length() - 1; i++) {
                //���ظ�Ԫ�ؽ���sb
                if (sb.indexOf(String.valueOf(s.charAt(i + 1))) != -1) {
                    //��sb�Ŀ�ͷɾ�����ظ�Ԫ�ص�λ��
                    sb.delete(0, 1 + sb.indexOf(String.valueOf(s.charAt(i + 1))));
                }
                sb.append(s.charAt(i + 1));
                result = Math.max(result, sb.length());
            }
            return result;
        }

        //setʵ�ֻ�������
        //ʹ�� HashSet ���ַ��洢�ڵ�ǰ���� [i,j)����� j=i���С�
        //Ȼ���������Ҳ໬������ j����������� HashSet �У����ǻ�������� j��
        //ֱ�� s[j] �Ѿ������� HashSet �С���ʱ�������ҵ���û���ظ��ַ�������ַ������������� i ��ͷ��������Ƕ����е� i ���������Ϳ��Եõ��𰸡�
        public int lengthOfLongestSubstring02(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                } else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }
    }
}
