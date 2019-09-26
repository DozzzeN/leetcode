package String;

//3
//����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
//����: "pwwkew"
//���: 3
//����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
//     ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ�
public class longest_substring_without_repeating_characters03 {
    public static void main(String[] args) {
        longest_substring_without_repeating_characters03.Solution sol = new longest_substring_without_repeating_characters03.Solution();
        String test = "pwwkew";
        System.out.print(sol.lengthOfLongestSubstring(test));
    }

    static class Solution {
        //������֪�����ַ����Ƚ�С��ʱ����ǿ�����һ������������Ϊֱ�ӷ��ʱ����滻�ַ�����
        //���õı�������ʾ��
        //int [26] ������ĸ ��a�� - ��z�� �� ��A�� - ��Z��
        //int [128] ����ASCII��
        //int [256] ������չASCII��
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128]; // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                //�ҳ��ظ����ַ�������
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                //�����������ַ���λ�ô��������Ӧ�������������ظ��ַ�������λ�ã�
                index[s.charAt(j)] = j + 1;
            }
            return ans;

        }
    }
}
