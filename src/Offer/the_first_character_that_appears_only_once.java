package Offer;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

//https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
public class the_first_character_that_appears_only_once {
    public static void main(String[] args) {
        System.out.println(new the_first_character_that_appears_only_once.Solution().FirstNotRepeatingChar(
                "google"
        ));
        System.out.println(new the_first_character_that_appears_only_once.Solution().FirstNotRepeatingChar02(
                "google"
        ));
        System.out.println(new the_first_character_that_appears_only_once.Solution().FirstNotRepeatingChar03(
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

        //哈希表的方法
        public int FirstNotRepeatingChar02(String str) {
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

        //以上实现的空间复杂度还不是最优的。考虑到只需要找到只出现一次的字符，
        //那么需要统计的次数信息只有0，1，更大，使用两个比特位就能存储这些信息。
        public int FirstNotRepeatingChar03(String str) {
            BitSet bs1 = new BitSet(256);
            BitSet bs2 = new BitSet(256);
            for (char c : str.toCharArray()) {
                if (!bs1.get(c) && !bs2.get(c))//出现过
                    bs1.set(c);
                else if (bs1.get(c) && !bs2.get(c))//出现了了两次
                    bs2.set(c);
            }
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (bs1.get(c) && !bs2.get(c))//出现了了两次
                    return i;
            }
            return -1;
        }
    }
}
