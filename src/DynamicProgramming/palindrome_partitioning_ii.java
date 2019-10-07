package DynamicProgramming;

import java.util.Arrays;

//132
//����һ���ַ��� s���� s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���
//���ط���Ҫ������ٷָ������
//ʾ��:
//����: "aab"
//���: 1
//����: ����һ�ηָ�Ϳɽ� s �ָ�� ["aa","b"] �������������Ӵ���
public class palindrome_partitioning_ii {
    public static void main(String[] args) {
        System.out.println(new palindrome_partitioning_ii.Solution().minCut("aabcabaa"));
    }

    //D[i,n]��ʾ[i,n]��������С����
    //D[i,n] = min(D[i,j] + D[j+1,n]) i <= j < n
    //��ΪD[i] = min(D[i], D[j+1]+1) ��[i,j]�ǻ��Ĵ�ʱ
    static class Solution {
        public int minCut(String s) {
            int[] D = new int[s.length() + 1];
            Arrays.fill(D, s.length() + 1);
            D[s.length()] = 0;
            //memo
            boolean[][] P = new boolean[s.length()][s.length()];
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    //��memo���ж��Ƿ��ǻ��ģ����м�
                    if (s.charAt(i) == s.charAt(j) && (j - i < 2 || P[i + 1][j - 1])) {
                        P[i][j] = true;
                        D[i] = Math.min(D[i], D[j + 1] + 1);
                    }
                }
            }
            return D[0] - 1;
        }
    }
}
