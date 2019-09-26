package DivideConquer;

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

    //分治法 O(n*logn) ~ O(n*n)
    //通过观察，可以发现，最大面积矩形存在于以下几种情况：
    //确定了最矮柱子以后，矩形的宽尽可能往两边延伸
    //在最矮柱子左边的最大面积矩形（子问题）
    //在最矮柱子右边的最大面积矩形（子问题）
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            return largestRectangleArea(heights, 0, heights.length - 1);
        }

        public int largestRectangleArea(int[] heights, int start, int end) {
            if (start > end) return 0;
            int minIndex = start;
            for (int i = start; i <= end; i++) {
                if (heights[i] < heights[minIndex]) minIndex = i;
            }
            return Math.max(heights[minIndex] * (end - start + 1),
                    Math.max(largestRectangleArea(heights, start, minIndex - 1),
                            largestRectangleArea(heights, minIndex + 1, end)));
        }
    }
}
