package Offer;

import java.util.Arrays;

//输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。
//例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4。
public class the_longest_substring_without_repeated_characters {
    public static void main(String[] args) {
        System.out.println(new the_longest_substring_without_repeated_characters().longestSubStringWithoutDuplication(
                "arabcacfr"
        ));
    }

    //动态规划，用f(i)表示以i个字符[结尾]不包含重复子字符串的最长长度，从左向右扫描
    //1、若第i个字符在之前没出现过，则f(i)=f(i-1)+1;
    //2、若第i个字符在之前出现过，
    //计算第i个字符距离上次出现之间的距离为d
    //(a)若d<=f(i-1)，则说明第i个字符上次出现在f(i-1)对应的不重复字符串之内，那么这时候更新f(i)=d
    //(b)若d>f(i-1)，则无影响，f(i)=f(i-1)+1
    //例如arabcacfr
    //f(0)=1，a
    //f(1)=2，ar
    //f(2)=2，ra，因为d=2，f(1)=2，所以上一个a在f(1)之中
    //f(3)=3，rab
    //f(4)=4，rabc
    //f(5)=3，bca，因为d=3，f(4)=4，所以上一个a一定在f(4)中
    //f(6)=2，ac
    //f(7)=3，acf
    //f(8)=4，acfr，因为d=7，f(7)=3，因此上一个r不在f(7)中，f(8)=f(7)+1
    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndex = new int[26];//保存字符出现的上一次的索引位置
        Arrays.fill(preIndex, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndex[c];
            if (preI == -1 || curI - preI > curLen) {//没出现过，或者d>f(i-1)
                curLen++;
            } else {//出现过
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;//f(i)=d
            }
            preIndex[c] = curI;
        }
        return Math.max(maxLen, curLen);
    }
}
