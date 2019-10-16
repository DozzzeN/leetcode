package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

//120
//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//例如，给定三角形：
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//说明：
//如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
public class triangle {
    public static void main(String[] args) {
        int[][] inputArray = new int[][]{
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        List<List<Integer>> input = new ArrayList<>();
        for (int[] ints : inputArray) {
            List<Integer> list = new ArrayList<>();
            for (int anInt : ints) {
                list.add(anInt);
            }
            input.add(list);
        }
        System.out.println(new triangle.Solution().minimumTotal(input));
    }


    //使用滚动数组
    //MinV[i][j] = array[i][j] if i == row - 1
    //        or = min(MinV[i+1][j], MinV[i+1][j+1]) + array[i][j] if i != row - 1
    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.size() == 0) return 0;
            int[] minV = new int[triangle.size()];
            for (int i = triangle.size() - 1; i >= 0; i--) {
                int col = triangle.get(i).size();
                for (int j = 0; j < col; j++) {
                    if (i == triangle.size() - 1) {
                        minV[j] = triangle.get(i).get(j);
                    } else {
                        minV[j] = Math.min(minV[j], minV[j + 1]) + triangle.get(i).get(j);
                    }
                }
            }
            return minV[0];
        }
    }
}
