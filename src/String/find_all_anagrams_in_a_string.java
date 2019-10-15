package String;

import java.util.ArrayList;
import java.util.List;

//438
//����һ���ַ��� s ��һ���ǿ��ַ��� p���ҵ� s �������� p ����ĸ��λ�ʵ��Ӵ���������Щ�Ӵ�����ʼ������
//�ַ���ֻ����СдӢ����ĸ�������ַ��� s �� p �ĳ��ȶ������� 20100��
//˵����
//	��ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
//	�����Ǵ������˳��
//ʾ�� 1:
//����:
//s: "cbaebabacd" p: "abc"
//���:
//[0, 6]
//����:
//��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����ĸ��λ�ʡ�
//��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����ĸ��λ�ʡ�
// ʾ�� 2:
//����:
//s: "abab" p: "ab"
//���:
//[0, 1, 2]
//����:
//��ʼ�������� 0 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
//��ʼ�������� 1 ���Ӵ��� "ba", ���� "ab" ����ĸ��λ�ʡ�
//��ʼ�������� 2 ���Ӵ��� "ab", ���� "ab" ����ĸ��λ�ʡ�
public class find_all_anagrams_in_a_string {
    public static void main(String[] args) {
        List<Integer> result = new find_all_anagrams_in_a_string.Solution().findAnagrams(
                "abaacbabc",
                "abc"
        );
        System.out.println(result);
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            if (s == null || s.length() == 0) return result;
            if (p == null || p.length() == 0 || s.length() < p.length()) return result;
            int[] appearCount = new int[256];
            int[] expectedCount = new int[256];
            for (int i = 0; i < p.length(); i++) {
                expectedCount[p.charAt(i)]++;
            }
            int left = 0;//��ָ��
            int appeared = 0;//���ֳ���
            for (int right = 0; right < s.length(); right++) {
                if (expectedCount[s.charAt(right)] > 0) {
                    appearCount[s.charAt(right)]++;
                    if (appearCount[s.charAt(right)] <= expectedCount[s.charAt(right)]) appeared++;
                }
                if (appeared == p.length()) {
                    //������ָ��
                    while (appearCount[s.charAt(left)] > expectedCount[s.charAt(left)]
                            || expectedCount[s.charAt(left)] == 0) {
                        appearCount[s.charAt(left)]--;
                        left++;
                    }
                    //��������ټ���
                    if ((right - left + 1) == p.length() && !result.contains(left)) {
                        result.add(left);
                    }
                }
            }
            return result;
        }
    }
}
