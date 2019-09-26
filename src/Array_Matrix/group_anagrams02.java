package Array_Matrix;

import java.util.*;
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
public class group_anagrams02 {
    public static void main(String[] args) {
        String[] input = new String[]{"tea", "and", "ace", "ad", "eat", "dans"};
        List<List<String>> result = new Solution().groupAnagrams(input);
        for (List<String> strings : result) {
            System.out.println(strings);
        }
    }

    //类似于建立哈希表，不过哈希算法是进行排序，这样的时间复杂度较小
    //时间复杂度：O(NKlogK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。
    // 当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。然后，我们在 O(KlogK) 的时间内对每个字符串排序。
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
