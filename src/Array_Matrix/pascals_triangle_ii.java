package Array_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//119
//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//在杨辉三角中，每个数是它左上方和右上方的数的和。
//示例:
//输入: 3
//输出: [1,3,3,1]
//进阶：
//你可以优化你的算法到 O(k) 空间复杂度吗？
public class pascals_triangle_ii {
    public static void main(String[] args) {
        System.out.println(new pascals_triangle_ii.Solution().getRow(3));
    }

    //从后先前扫描，不需要存储临时变量，也不需要二维数组（使用滚动数组）
    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            int[] resultArray = new int[rowIndex + 2];
            Arrays.fill(resultArray, 0);
            resultArray[1] = 1;
            for (int i = 0; i < rowIndex; i++) {//行
                for (int j = rowIndex + 1; j > 0; j--) {//列
                    resultArray[j] += resultArray[j - 1];
                }
            }
            for (int i = 1; i < resultArray.length; i++) {
                result.add(resultArray[i]);
            }
            return result;
        }
    }
}
