package String;

import java.util.ArrayList;
import java.util.List;

//76
//����һ���ַ��� S��һ���ַ��� T�������ַ��� S �����ҳ������� T ������ĸ����С�Ӵ���
//ʾ����
//����: S = "ADOBECODEBANC", T = "ABC"
//���: "BANC"
//˵����
//	��� S �в����������Ӵ����򷵻ؿ��ַ��� ""��
//	��� S �д����������Ӵ������Ǳ�֤����Ψһ�Ĵ𰸡�
public class minimum_window_substring {
    public static void main(String[] args) {
        System.out.println(new minimum_window_substring.Solution().minWindow("aa", "aa"));
    }

    //ֱ���ҵ�����s�а���t�����ַ�����ѡ�����
    //��ʱ
    static class Solution {
        public String minWindow(String s, String t) {
            if (s == null || s.length() == 0) return "";
            if (t == null || s.length() < t.length()) return "";
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    String temp = s.substring(i, j + 1);
                    if (isContain(temp, t)) {
                        list.add(temp);
                    }
                }
            }
            String result = list.size() == 0 ? "" : list.get(0);
            for (String s1 : list) {
                if (result.length() > s1.length()) {
                    result = s1;
                }
            }
            return result;
        }

        public boolean isContain(String s, String t) {
            StringBuilder sb = new StringBuilder(s);
            boolean result = true;
            for (int i = 0; i < t.length(); i++) {
                int index = sb.indexOf(String.valueOf(t.charAt(i)));
                if (index >= 0) {
                    sb.deleteCharAt(index);
                } else {
                    result = false;
                    break;
                }
            }
            return result;
        }
    }
}

