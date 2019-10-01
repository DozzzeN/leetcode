package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//139
//����: s = "applepenapple", wordDict = ["apple", "pen"]
//���: true
//����: ���� true ��Ϊ "applepenapple" ���Ա���ֳ� "apple pen apple"��
//     ע��������ظ�ʹ���ֵ��еĵ��ʡ�
//ʾ�� 3��
//����: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//���: false
public class word_break {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new word_break.Solution().wordBreak("leetcode", wordDict));
    }

    //possible[i]����Ϊs�ַ���[0,i]�Ӵ��Ƿ���Ը����ֵ���зֶ�
    //possible[i] = true if there exist a k (0<k<i), which makes possible[k] == true and s[k+1,j] is in the Dict
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            s = "#" + s; //��һ��dummy�ڵ��ʾ���ַ���Ҳ����
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
