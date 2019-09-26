package String;

import java.util.HashMap;

//205
//给定两个字符串 s 和 t，判断它们是否是同构的。
//如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
//所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
public class isomorphic_strings03 {
    public static void main(String[] args) {
        String s = "paper", t = "title";
        System.out.println(new Solution().isIsomorphic(s, t));

    }

    //通过hashmap的键值是否相等来判断是否同构
    //s是键 t是值，只保留不重复的键值对
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
