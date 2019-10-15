package Array_Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class group_anagrams {
    public static void main(String[] args) {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = new Solution().groupAnagrams(input);
        for (List<String> strings : result) {
            System.out.println(strings);
        }
    }

    //��ʱ
    //ÿ���ַ���������ϣ��洢����ĸӳ�䵽����Ķ���λ
    //ʱ�临�Ӷȣ�O(NK)������ N �� strs �ĳ��ȣ��� K �� strs ���ַ�������󳤶ȡ�����ÿ���ַ������ַ�����С�����Եģ�����ͳ��ÿ���ַ�����
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<Integer, String> hashTable = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                int[] hash = new int[26];
                for (int j = 0; j < strs[i].length(); j++) {
                    hash[strs[i].charAt(j) - 'a']++;
                }
                hashTable.put(i, intArrayToString(hash));
            }
            List<List<String>> result = new ArrayList<>();
            //��ʹ��ConcurrentHashMap�ᱨ����ΪHashMap��֧��ͬ���޸ĺ����
            //����map���������У�ԭmap���ܱ��޸�
            Map<String, List<String>> revHash = new ConcurrentHashMap<>();
            List<Integer> used = new ArrayList<>();
            for (int i = 0; i < hashTable.keySet().size(); i++) {
                if (revHash.keySet().size() == 0) {
                    List<String> strs0 = new ArrayList<>();
                    strs0.add(strs[0]);
                    used.add(0);
                    revHash.put(hashTable.get(0), strs0);
                }
                for (String s : revHash.keySet()) {
                    if (used.contains(i)) {
                        continue;
                    }
                    if (i == 0) {
                        break;
                    }
                    if (s.equals(hashTable.get(i))) {
                        //һ��add�������ɸ㶨��map��ͬһ����׷��ֵ������
                        revHash.get(s).add(strs[i]);
                    } else if (!revHash.containsKey(hashTable.get(i))) {
                        List<String> newStr = new ArrayList<>();
                        newStr.add(strs[i]);
                        used.add(i);
                        revHash.put(hashTable.get(i), newStr);
                    }
                }
            }
            for (String strHash : revHash.keySet()) {
                List<String> strings = new ArrayList<>(revHash.get(strHash));
                result.add(strings);
            }
            return result;
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
