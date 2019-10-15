package BackTracking;

import java.util.ArrayList;
import java.util.List;

//17
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//示例:
//输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
public class letter_combinations_of_a_phone_number {
    public static void main(String[] args) {
        List<String> result = new letter_combinations_of_a_phone_number.Solution().letterCombinations(
                "23"
        );
        System.out.println(result);
    }

    static class Solution {
        List<String> set = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) return set;
            String[] trans = new String[]{"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            generater(trans, digits, "", 0);
            return set;
        }

        public void generater(String[] trans, String digits, String result, int deep) {
            if (deep == digits.length()) {
                set.add(result);
                return;
            }
            int index = digits.charAt(deep) - 48;
            //每一次循环都可以当作同一层树的所有分支
            for (int i = 0; i < trans[index].length(); i++) {
                //添加一个字母
                result = result + trans[index].charAt(i);
                //递归，添加下一个字母
                generater(trans, digits, result, deep + 1);
                //回溯，删除已添加的字母
                result = result.substring(0, result.length() - 1);
            }
        }
    }
}
