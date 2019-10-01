package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//139
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//示例 3：
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
public class word_break {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new word_break.Solution().wordBreak("leetcode", wordDict));
    }

    //possible[i]定义为s字符串[0,i]子串是否可以根据字典进行分段
    //possible[i] = true if there exist a k (0<k<i), which makes possible[k] == true and s[k+1,j] is in the Dict
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            s = "#" + s; //第一个dummy节点表示空字符串也成立
            boolean[] possible = new boolean[s.length()];
            possible[0] = true;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    possible[i] = possible[j] && wordDict.contains(s.substring(j + 1, i + 1));
                    if (possible[i]) break;
                }
            }
            System.out.println(Arrays.toString(possible));
            return possible[possible.length - 1];
        }
    }
}
