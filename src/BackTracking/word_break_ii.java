package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//140
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
//说明：
//	分隔时可以重复使用字典中的单词。
//	你可以假设字典中没有重复的单词。
//示例 1：
//输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
//示例 2：
//输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
//示例 3：
//输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
public class word_break_ii {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaa");
        wordDict.add("aaa");
        wordDict.add("aa");
        wordDict.add("a");
        System.out.println(new word_break_ii.Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", wordDict));
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
//        System.out.println(new word_break_ii.Solution().wordBreak("catsanddog", wordDict));
    }

    static class Solution {
        List<String> wordDict;
        List<String> result = new ArrayList<>();
        //备忘录进行剪枝
        boolean[] memo;

        public List<String> wordBreak(String s, List<String> wordDict) {
            this.wordDict = wordDict;
            //数组长度比s长，以防越界
            this.memo = new boolean[s.length() + 1];
            //全部初始化为true
            Arrays.fill(this.memo, true);
            wordBreak(s, 0, new StringBuilder());
            System.out.println(Arrays.toString(memo));
            return this.result;
        }

        public void wordBreak(String s, int start, StringBuilder sb) {
            if (start == s.length()) {
                result.add(sb.toString().trim());
            } else {
                for (int i = start; i < s.length(); i++) {
                    String piece = s.substring(start, i + 1);
                    //用memo进行剪枝，初始可以进入
                    if (wordDict.contains(piece) && memo[i + 1]) {
                        int beforeSize = result.size();
                        wordBreak(s, i + 1, sb.append(piece).append(" "));
                        //若递归以后结果数组长度不发生变化：此次以i+1结尾的字符串不在字典中，故将memo对应位置置为false
                        if (beforeSize == result.size()) memo[i + 1] = false;
                        //进行回溯
                        sb.delete(sb.length() - piece.length() - 1, sb.length());
                    }
                }
            }
        }
    }
}
