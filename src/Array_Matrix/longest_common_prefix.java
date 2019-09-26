package Array_Matrix;

//14
//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。
public class longest_common_prefix {
    public static void main(String[] args) {
        String[] input = new String[]{"flower", "flow", "flight"};
        System.out.println(new longest_common_prefix.Solution().longestCommonPrefix(input));
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder(strs[0]);
            for (int i = 0; i < strs.length; i++) {
                for (int j = 0; j < Math.max(strs[i].length(), stringBuilder.length()); j++) {

                    if (strs[i].length() == j) {
                        stringBuilder.delete(j, stringBuilder.length());
                        break;
                    }

                    if (j == stringBuilder.length() || j == strs[i].length()) {
                        break;
                    }

                    if (stringBuilder.charAt(j) != strs[i].charAt(j)) {
                        stringBuilder.delete(j, stringBuilder.length());
                        break;
                    }

                }
            }
            return stringBuilder.toString();
        }
    }
}
