package BackTracking;

import java.util.ArrayList;
import java.util.List;

//139
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//示例 3：
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
public class word_break03 {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(new word_break03.Solution().wordBreak("catsanddog", wordDict));
    }

    //带剪枝的回溯（使用备忘录）
    static class Solution {
        private List<String> wordDict;
        //定义成Boolean数组而不是boolean数组的目的：Boolean[]初始化后元素为null（未赋值状态），而boolean[]初始化
        //后元素均为false，与赋值为false无法区分
        private Boolean[] memo;

        public boolean wordBreak(String s, List<String> wordDict) {
            this.wordDict = wordDict;
            this.memo = new Boolean[s.length()];
            return wordBreak(s, 0);
        }

        public boolean wordBreak(String s, int start) {
            if (start == s.length()) return true;
            //只要赋值了，就可以直接返回
            if (memo[start] != null) return memo[start];
            for (int i = start; i < s.length(); i++) {
                if (wordDict.contains(s.substring(start, i + 1)) &&
                        wordBreak(s, i + 1)) {
                    return memo[start] = true;
                }
            }
            return memo[start] = false;
        }
    }
}
