package String;

import java.util.Arrays;

//205
//���������ַ��� s �� t���ж������Ƿ���ͬ���ġ�
//��� s �е��ַ����Ա��滻�õ� t ����ô�������ַ�����ͬ���ġ�
//���г��ֵ��ַ�����������һ���ַ��滻��ͬʱ�����ַ���˳�������ַ�����ӳ�䵽ͬһ���ַ��ϣ����ַ�����ӳ���Լ�����
public class isomorphic_strings {
    public static void main(String[] args) {
        String s = "paper", t = "title";
        System.out.println(new Solution().isIsomorphic(s, t));

    }

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() == 0 && t.length() == 0) {
                return true;
            }
            int sNum[] = new int[s.length()];
            int tNum[] = new int[t.length()];
            sNum[0] = 1;
            tNum[0] = 1;
            int max = 1;
            //��paperת��Ϊ12134
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        sNum[i] = sNum[j];
                        break;
                    }
                    if (j == i - 1) {
                        sNum[i] = ++max;
                    }
                }
            }
            max = 1;
            for (int i = 0; i < t.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (t.charAt(i) == t.charAt(j)) {
                        tNum[i] = tNum[j];
                        break;
                    }
                    if (j == i - 1) {
                        tNum[i] = ++max;
                    }
                }
            }

            return Arrays.equals(sNum, tNum);

        }
    }
}
