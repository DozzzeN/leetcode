package Offer;

import java.util.ArrayList;
import java.util.Collections;

//https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��Ŀ����
//����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
//��������:
//����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��
public class permutation_of_strings {
    public static void main(String[] args) {
        System.out.println(new permutation_of_strings.Solution().Permutation("aabc"));
    }

    public static class Solution {
        private ArrayList<String> result = new ArrayList<>();

        public ArrayList<String> Permutation(String str) {
            StringBuilder sb = new StringBuilder(str);
            permutation(sb, 0);
            Collections.sort(result);
            return result;
        }

        private void permutation(StringBuilder sb, int start) {
            if (start == sb.length() - 1 && !result.contains(sb.toString())) {
                result.add(sb.toString());
            } else {
                for (int i = start; i < sb.length(); i++) {
                    if (i + 1 < sb.length() && sb.charAt(i) == sb.charAt(i + 1)) continue;
                    swap(sb, start, i);
                    permutation(sb, start + 1);
                    swap(sb, start, i);
                }
            }
        }

        private void swap(StringBuilder sb, int i, int j) {
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j,c);
        }
    }
}
