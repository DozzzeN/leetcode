package String;

import java.util.ArrayList;
import java.util.List;

//5
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
public class longest_palindromic_substring03 {
    public static void main(String[] args) {
        String input = "abbc";
        System.out.println(new longest_palindromic_substring03.Solution().longestPalindrome(input));

    }

    //Manacher算法
    static class Solution {
        public String longestPalindrome(String s) {
            //将原字符串转为manacher字符串 #b#a#b#a#d#
            List<Character> s_new = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                s_new.add('#');
                s_new.add(s.charAt(i));
            }
            s_new.add('#');
            List<Integer> Len = new ArrayList<>();//Len数组性质：以S_new[i]为中心的最长回文子串长度为2Len[i] - 1
            //Len[i]即以i为中心的最长回文串的最右端字符距离该字符的距离
            //                                               ↓          ↓
            //如  S_new:        #  a  #  a  #  b  #  a  #  b  #  b  #  a  #
            //对应  Len         1  2  3  2  1  4  1  4  1  2  5  2  1  2  1
            //                                               ↑
            String sub = "";//最长回文子串
            int sub_midd = 0;//表示在i之前所得到的Len数组中的最大值所在位置（最长回文串中心）sub_midd = Len.indexOf(Math.max(Len)
            int sub_side = 0;//表示以sub_midd为中心的最长回文子串的最右端在S_new中的位置（最长回文串的右边界）sub_side = sub_midd + Len[sub_midd] - 1
            Len.add(1);
            for (int i = 1; i < s_new.size(); i++) {
                //sub_midd - (sub_side - sub_midd) = 2 * sub_midd - sub_side
                //S_new  2*sub_midd-sub_side | { j } | sub_midd | { i } | sub_side
                if (i < sub_side) { //i<sub_side时，在Len[j]和sub_side - i中取最小值，省去了j的判断
                    int j = 2 * sub_midd - i;//j是i关于sub_midd的对称点
                    if (j >= 2 * sub_midd - sub_side && Len.get(j) <= sub_side - i) {
                        //以S_new[j]为中心的最长回文子串是在以S_new[sub_midd]为中心的最长回文子串的内部，再由于i、j关于sub_midd对称，可知Len[i] = Len[j]
                        Len.add(Len.get(j));
                    } else
                        //S_new[i]为中心的回文串可能延伸到sub_side之外，而大于sub_side的部分还没有进行匹配，所以要从sub_side+1位置开始进行匹配
                        //S_new  2*sub_midd-sub_side { | j | } sub_midd { | i | } sub_side
                        Len.add(sub_side - i + 1);
                } else
                    //当i > sub_side时，则说明以S_new[i]为中心的最长回文子串还没开始匹配寻找，因此需要一个一个进行匹配寻找
                    //结束后更新sub_side和对应的sub_midd以及Len[i]
                    //此处的回文串右边界为1，即本个字符
                    Len.add(1);
                while ((i - Len.get(i) >= 0 && i + Len.get(i) < s_new.size()) && (s_new.get(i - Len.get(i)) == s_new.get(i + Len.get(i))))
                    //(i - Len.get(i) >= 0 && i + Len.get(i) < s_new.size()表示以i为中心，一直遍历整个字符串
                    //s_new.get(i - Len.get(i)) == s_new.get(i + Len.get(i)表示原本以i为中心的回文串两端字符相同，Len[i]值需要更新
                    Len.set(i, Len.get(i) + 1);//s_new[i]两端开始扩展匹配，直到匹配失败时停止
                if (Len.get(i) >= Len.get(sub_midd)) {
                    //匹配的新回文子串长度大于原有的长度
                    sub_side = Len.get(i) + i - 1;
                    sub_midd = i;
                }
            }
            //对应S_new是[2 * sub_midd - sub_side , sub_side]
            sub = s.substring((2 * sub_midd - sub_side) / 2, sub_side / 2);//在s中找到最长回文子串的位置
            return sub;
        }
    }

}
