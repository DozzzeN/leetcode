package DynamicProgramming;

import java.util.Arrays;

//132
//����һ���ַ��� s���� s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���
//���ط���Ҫ������ٷָ������
//ʾ��:
//����: "aab"
//���: 1
//����: ����һ�ηָ�Ϳɽ� s �ָ�� ["aa","b"] �������������Ӵ���
public class palindrome_partitioning_ii02 {
    public static void main(String[] args) {
        System.out.println(new palindrome_partitioning_ii02.Solution().minCut("aabbc"));
    }

    //D[i]��ʾ[0,i]��������С����
    //D[i] = min(D[0,j] + D[j+1,i]) 0 <= j < i
    //��ΪD[i] = min(D[i], D[j]+1) ��[j,i]�ǻ��Ĵ�ʱ
    static class Solution {
        public int minCut(String s) {
            int[] D = new int[s.length() + 1];
            Arrays.fill(D, s.length() + 1);
            D[0] = -1;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j >= 0; j--) {
                    if (isPalindrome(s, j, i)) {
                        D[i + 1] = Math.min(D[i + 1], D[j] + 1);
                    }
                }
            }
            return D[s.length()];
        }

        public boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) return false;
                start++;
                end--;
            }
            return true;
        }
    }
}
