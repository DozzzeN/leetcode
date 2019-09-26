package Array_Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class group_anagrams03 {
    public static void main(String[] args) {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = new Solution().groupAnagrams(input);
        for (List<String> strings : result) {
            System.out.println(strings);
        }
    }

    //����һ�ľ����
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> revHash = new HashMap<>();
            for (String str : strs) {
                int[] hash = new int[26];
                for (int j = 0; j < str.length(); j++) {
                    hash[str.charAt(j) - 'a']++;
                }
                String key = intArrayToString(hash);
                //��Ҫ���޸��Ǵ˴�����
                //�������±���revHash����revHash����ӹ������ڱ���strs�У����ٲ���
                if (!revHash.containsKey(key)) {
                    revHash.put(key, new ArrayList());
                }
                revHash.get(key).add(str);
            }
            //ֱ���ù��췽�������ñ���mapȡ����ֵ�ٴ���ArrayList
            return new ArrayList<>(revHash.values());
        }

        //����������תΪ�ַ���
        public String intArrayToString(int[] input) {
            StringBuilder output = new StringBuilder();
            for (int i : input) {
                output.append(i);
            }
            return output.toString();
        }
    }
}
