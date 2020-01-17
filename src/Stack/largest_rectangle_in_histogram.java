package Stack;

//84
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//示例:
//输入: [2,1,5,6,2,3]
//输出: 10
public class largest_rectangle_in_histogram {
    public static void main(String[] args) {
        System.out.println(new largest_rectangle_in_histogram.Solution().largestRectangleArea(
                new int[]{2, 1, 5, 6, 2, 3}
        ));
    }

    //暴力法 O(n*n)
    //每一个height，遍历前面所有height，求取面积最大值
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            int maxV = 0;
            for (int i = 0; i < heights.length; i++) {
                int minV = heights[i];
                for (int j = i; j >= 0; j--) {
                    minV = Math.min(minV, heights[j]);
                    maxV = Math.max(maxV, (i - j + 1) * minV);
                }
            }
            return maxV;
        }
    }
}
