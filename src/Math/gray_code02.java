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
public class gray_code02 {
    public static void main(String[] args) {
        System.out.println(Solution.grayCode(3));
    }

    //i右移一位与i异或
    static class Solution {
        public static List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<>();
            int size = 1 << n;
            for (int i = 0; i < size; i++) {
                result.add((i >> 1) ^ i);
            }
            return result;
        }
    }
}
