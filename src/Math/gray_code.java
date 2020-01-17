package Math;

import java.util.ArrayList;
import java.util.List;

//89
//格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
//给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
//示例 1:
//输入: 2
//输出: [0,1,3,2]
//解释:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//对于给定的 n，其格雷编码序列并不唯一。
//例如，[0,2,3,1] 也是一个有效的格雷编码序列。
//00 - 0
//10 - 2
//11 - 3
//01 - 1
public class gray_code {
    public static void main(String[] args) {
        System.out.println(Solution.grayCode(3));
    }

    //镜像法
    static class Solution {
        public static List<Integer> grayCode(int n) {
            List<String> result = new ArrayList<>();
            List<String> lastResult = new ArrayList<>();
            lastResult.add("0");
            lastResult.add("1");
            result.add("0");
            if (n == 0) return strToInt(result);
            if (n == 1) return strToInt(lastResult);
            for (int i = 2; i <= n; i++) {
                result = lastResult;
                lastResult = new ArrayList<>();
                int length = (int) Math.pow(2, i);
                for (int j = 0; j < length / 2; j++) {
                    lastResult.add("0" + result.get(j));
                }
                for (int j = length / 2; j < length; j++) {
                    lastResult.add("1" + result.get(length - j - 1));
                }
            }
            return strToInt(lastResult);
        }

        public static List<Integer> strToInt(List<String> stringList) {
            List<Integer> result = new ArrayList<>();
            for (String s : stringList) {
                result.add(Integer.valueOf(s, 2));
            }
            return result;
        }
    }
}
