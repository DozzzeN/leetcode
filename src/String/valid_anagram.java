package String;

//242
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//输入: s = "rat", t = "car"
//输出: false
//输入: s = "anagram", t = "nagaram"
//输出: true
public class valid_anagram {
    public static void main(String[] args) {
        valid_anagram.Solution solution = new valid_anagram.Solution();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution.isAnagram(s, t));
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            int[] cnts = new int[26];//小写字母26个
            for (char c : s.toCharArray()) {
                cnts[c - 'a']++;//小写字母转成数字，对应cnts数组之中的某一位
            }
            for (char c : t.toCharArray()) {
                cnts[c - 'a']--;//若是重复字母，cnts数组中的值为0
            }
            for (int cnt : cnts) {
                if (cnt != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
