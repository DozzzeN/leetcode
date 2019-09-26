package Array_Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class group_anagrams03 {
    public static void main(String[] args) {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = new Solution().groupAnagrams(input);
        for (List<String> strings : result) {
            System.out.println(strings);
        }
    }

    //方法一的精简版
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> revHash = new HashMap<>();
            for (String str : strs) {
                int[] hash = new int[26];
                for (int j = 0; j < str.length(); j++) {
                    hash[str.charAt(j) - 'a']++;
                }
                String key = intArrayToString(hash);
                //重要的修改是此处代码
                //无须重新遍历revHash，将revHash的添加工作放在遍历strs中，减少操作
                if (!revHash.containsKey(key)) {
                    revHash.put(key, new ArrayList());
                }
                revHash.get(key).add(str);
            }
            //直接用构造方法，不用遍历map取出其值再传入ArrayList
            return new ArrayList<>(revHash.values());
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
