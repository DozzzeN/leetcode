package Offer;

import java.util.HashMap;
import java.util.Map;

//https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
public class the_first_character_that_appears_only_once {
    public static void main(String[] args) {
        System.out.println(new the_first_character_that_appears_only_once.Solution().FirstNotRepeatingChar(
                "google"
        ));
        System.out.println(new the_first_character_that_appears_only_once.Solution().FirstNotRepeatingChar2(
                "google"
        ));
    }

    public static class Solution {
        public int FirstNotRepeatingChar(String str) {
            if (str == null || str.length() == 0) return -1;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                map.put(str.charAt(i), 0);
            }
            for (int i = 0; i < str.length(); i++) {
                if (map.get(str.charAt(i)) == 0) {
                    map.put(str.charAt(i), 1);
                } else {
                    map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                }
            }
            for (int i = 0; i < str.length(); i++) {
                if (map.get(str.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }

        //��ϣ���ķ���
        public int FirstNotRepeatingChar2(String str) {
            if (str == null || str.length() == 0) return -1;
            int[] hashtable = new int[256];
            for (int i = 0; i < str.length(); i++) {
                hashtable[str.charAt(i)]++;
            }
            for (int i = 0; i < str.length(); i++) {
                if (hashtable[str.charAt(i)] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}