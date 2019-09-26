package String;

import java.util.HashMap;

//205
//���������ַ��� s �� t���ж������Ƿ���ͬ���ġ�
//��� s �е��ַ����Ա��滻�õ� t ����ô�������ַ�����ͬ���ġ�
//���г��ֵ��ַ�����������һ���ַ��滻��ͬʱ�����ַ���˳�������ַ�����ӳ�䵽ͬһ���ַ��ϣ����ַ�����ӳ���Լ�����
public class isomorphic_strings03 {
    public static void main(String[] args) {
        String s = "paper", t = "title";
        System.out.println(new Solution().isIsomorphic(s, t));

    }

    //ͨ��hashmap�ļ�ֵ�Ƿ�������ж��Ƿ�ͬ��
    //s�Ǽ� t��ֵ��ֻ�������ظ��ļ�ֵ��
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            HashMap<Character, Character> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))) {
                    if (map.containsValue(t.charAt(i))) {
                        return false;
                    }
                    map.put(s.charAt(i), t.charAt(i));
                } else {
                    if (map.get(s.charAt(i)) != t.charAt(i)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
