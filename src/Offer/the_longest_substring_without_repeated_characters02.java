package Offer;

import java.util.Arrays;

//输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。
//例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4。
public class the_longest_substring_without_repeated_characters02 {
    public static void main(String[] args) {
        System.out.println(new the_longest_substring_without_repeated_characters02().longestSubStringWithoutDuplication(
                "arabcacfr"
        ));
    }

    //用双指针i,j分别指向第一第二个元素，当j发现了重复元素，则从i的下一位开始搜索
    public int longestSubStringWithoutDuplication(String str) {
        int[] preIndex = new int[26];//保存字符出现的上一次的索引位置
        Arrays.fill(preIndex, -1);
        int maxlen = 0, start = -1;
        for (int i = 0; i < str.length(); i++) {
            //s[i]字符上次出现的下标是否在start之后，若是，则重复了，则修改start为上一次s[i]的位置，从它后一位开始搜索
            if (preIndex[str.charAt(i)] > start)
                start = preIndex[str.charAt(i)];
            preIndex[str.charAt(i)] = i;
            maxlen = Math.max(maxlen, i - start);
        }
        return maxlen;
    }
}
