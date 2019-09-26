package Array_Matrix;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//49
//����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
//ʾ��:
//����: ["eat", "tea", "tan", "ate", "nat", "bat"],
//���:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
public class group_anagrams02 {
    public static void main(String[] args) {
        String[] input = new String[]{"tea", "and", "ace", "ad", "eat", "dans"};
        List<List<String>> result = new Solution().groupAnagrams(input);
        for (List<String> strings : result) {
            System.out.println(strings);
        }
    }

    //�����ڽ�����ϣ��������ϣ�㷨�ǽ�������������ʱ�临�ӶȽ�С
    //ʱ�临�Ӷȣ�O(NKlogK)������ N �� strs �ĳ��ȣ��� K �� strs ���ַ�������󳤶ȡ�
    // �����Ǳ���ÿ���ַ���ʱ���ⲿѭ�����еĸ��Ӷ�Ϊ O(N)��Ȼ�������� O(KlogK) ��ʱ���ڶ�ÿ���ַ�������
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList();
            Map<String, List> ans = new HashMap<>();
            for (String s : strs) {
                char[] ca = s.toCharArray();
                Arrays.sort(ca);
                String key = String.valueOf(ca);
                if (!ans.containsKey(key)) ans.put(key, new ArrayList());
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }

    }
}
