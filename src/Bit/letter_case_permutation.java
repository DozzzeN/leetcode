package Bit;

import java.util.ArrayList;
import java.util.List;

//784
//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
//示例:
//输入: S = "a1b2"
//输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
//输入: S = "3z4"
//输出: ["3z4", "3Z4"]
//输入: S = "12345"
//输出: ["12345"]
//注意：
//	S 的长度不超过12。
//	S 仅由数字和字母组成。
public class letter_case_permutation {
    public static void main(String[] args) {
        System.out.println(new letter_case_permutation.Solution().letterCasePermutation("a1b2"));
    }

    static class Solution {
        private List<String> result = new ArrayList<>();

        public List<String> letterCasePermutation(String S) {
            letterCasePermutation(S, 0, new StringBuilder());
            return this.result;
        }

        public void letterCasePermutation(String S, int depth, StringBuilder temp) {
            if (S.length() == depth) {
                result.add(temp.toString());
            } else {
                char s = S.charAt(depth);
                //数字不用判断，否则进行大小写变换后产生冗余数据
                //优化2：判断是否是数字可以：Character.isDigit()
                if (S.charAt(depth) <= '9' && S.charAt(depth) >= '0') {
                    temp.append(s);
                    letterCasePermutation(S, depth + 1, temp);
                    temp.deleteCharAt(depth);
                } else {
                    //temp也可以用stack，不过把stack转为string也需要遍历
                    //优化1：转大小写可以写成与1<<5 (32) 进行异或
                    //异或运算+1可以自动根据某个数位上的值，使得0变成1，1变成0，即达到了大小写转换的目的
                    temp.append((char) (s ^ (1 << 5)));
                    letterCasePermutation(S, depth + 1, temp);
                    temp.deleteCharAt(depth);
                    temp.append(s);
                    letterCasePermutation(S, depth + 1, temp);
                    temp.deleteCharAt(depth);
                }
            }
        }
    }
}
