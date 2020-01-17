package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//139
//����: s = "applepenapple", wordDict = ["apple", "pen"]
//���: true
//����: ���� true ��Ϊ "applepenapple" ���Ա���ֳ� "apple pen apple"��
//     ע��������ظ�ʹ���ֵ��еĵ��ʡ�
//ʾ�� 3��
//����: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//���: false
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

    //�����д���ſ����γɵ��ʵ�ǰ׺���һ��λ�õ�����+1
    //һֱ���������ڶ��е�������s����ĩβ����ֱ��s��ĩβ�������
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[s.length()];//��֮ǰ�Ѿ��������start��ʼ�Ľڵ���Ժ��ô���
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
