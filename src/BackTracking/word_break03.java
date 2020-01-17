package BackTracking;

import java.util.ArrayList;
import java.util.List;

//139
//����: s = "applepenapple", wordDict = ["apple", "pen"]
//���: true
//����: ���� true ��Ϊ "applepenapple" ���Ա���ֳ� "apple pen apple"��
//     ע��������ظ�ʹ���ֵ��еĵ��ʡ�
//ʾ�� 3��
//����: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//���: false
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

    //����֦�Ļ��ݣ�ʹ�ñ���¼��
    static class Solution {
        private List<String> wordDict;
        //�����Boolean���������boolean�����Ŀ�ģ�Boolean[]��ʼ����Ԫ��Ϊnull��δ��ֵ״̬������boolean[]��ʼ��
        //��Ԫ�ؾ�Ϊfalse���븳ֵΪfalse�޷�����
        private Boolean[] memo;

        public boolean wordBreak(String s, List<String> wordDict) {
            this.wordDict = wordDict;
            this.memo = new Boolean[s.length()];
            return wordBreak(s, 0);
        }

        public boolean wordBreak(String s, int start) {
            if (start == s.length()) return true;
            //ֻҪ��ֵ�ˣ��Ϳ���ֱ�ӷ���
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
