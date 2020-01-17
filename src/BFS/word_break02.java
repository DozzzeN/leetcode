package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//139
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//示例 3：
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
public class word_break02 {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(new word_break02.Solution().wordBreak("catsandog", wordDict));
    }

    //队列中存放着可以形成单词的前缀最后一个位置的索引+1
    //一直遍历保存在队列的索引到s串的末尾处，直到s的末尾索引入队
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[s.length()];//当之前已经处理过以start开始的节点后，以后不用处理
            queue.add(0);
            while (!queue.isEmpty()) {
                int start = queue.remove();
                if (!visited[start]) {
                    for (int end = start + 1; end <= s.length(); end++) {
                        if (wordDict.contains(s.substring(start, end))) {
                            queue.add(end);
                            if (end == s.length()) {
                                return true;
                            }
                        }
                    }
                }
                visited[start] = true;
            }
            return false;
        }
    }
}
