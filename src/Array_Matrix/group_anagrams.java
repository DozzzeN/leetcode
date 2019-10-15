package Array_Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//49
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//示例:
//输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
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

    //超时
    //每个字符串建立哈希表存储，字母映射到数组的对于位
    //时间复杂度：O(NK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。计算每个字符串的字符串大小是线性的，我们统计每个字符串。
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
            //不使用ConcurrentHashMap会报错，因为HashMap不支持同步修改后遍历
            //即在map遍历过程中，原map不能被修改
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
                        //一个add方法即可搞定向map中同一个键追加值的问题
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

        //将整数数组转为字符串
        public String intArrayToString(int[] input) {
            StringBuilder output = new StringBuilder();
            for (int i : input) {
                output.append(i);
            }
            return output.toString();
        }

    }
}
