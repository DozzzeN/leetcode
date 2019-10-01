package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//140
//����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict�����ַ��������ӿո�������һ�����ӣ�ʹ�þ��������еĵ��ʶ��ڴʵ��С�����������Щ���ܵľ��ӡ�
//˵����
//	�ָ�ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
//	����Լ����ֵ���û���ظ��ĵ��ʡ�
//ʾ�� 1��
//����:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//���:
//[
//  "cats and dog",
//  "cat sand dog"
//]
//ʾ�� 2��
//����:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//���:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//����: ע��������ظ�ʹ���ֵ��еĵ��ʡ�
//ʾ�� 3��
//����:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//���:
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
        //����¼���м�֦
        boolean[] memo;

        public List<String> wordBreak(String s, List<String> wordDict) {
            this.wordDict = wordDict;
            //���鳤�ȱ�s�����Է�Խ��
            this.memo = new boolean[s.length() + 1];
            //ȫ����ʼ��Ϊtrue
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
                    //��memo���м�֦����ʼ���Խ���
                    if (wordDict.contains(piece) && memo[i + 1]) {
                        int beforeSize = result.size();
                        wordBreak(s, i + 1, sb.append(piece).append(" "));
                        //���ݹ��Ժ������鳤�Ȳ������仯���˴���i+1��β���ַ��������ֵ��У��ʽ�memo��Ӧλ����Ϊfalse
                        if (beforeSize == result.size()) memo[i + 1] = false;
                        //���л���
                        sb.delete(sb.length() - piece.length() - 1, sb.length());
                    }
                }
            }
        }
    }
}
