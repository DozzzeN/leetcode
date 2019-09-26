package String;

//205
//给定两个字符串 s 和 t，判断它们是否是同构的。
//如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
//所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
public class isomorphic_strings02 {
    public static void main(String[] args) {
        String s = "paper", t = "title";
        System.out.println(new Solution().isIsomorphic(s, t));

    }

    //记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            int[] sNum = new int[256];
            int[] tNum = new int[256];
            for (int i = 0; i < s.length(); i++) {
                char sc = s.charAt(i), tc = t.charAt(i);
                if (sNum[sc] != tNum[tc]) {
                    return false;
                }
                sNum[sc] = i + 1;
                tNum[tc] = i + 1;
            }

            return true;

        }
    }
}
