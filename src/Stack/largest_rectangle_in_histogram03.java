package Stack;

import java.util.Arrays;
import java.util.Stack;

//84
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//示例:
//输入: [2,1,5,6,2,3]
//输出: 10
public class largest_rectangle_in_histogram03 {
    public static void main(String[] args) {
        System.out.println(new largest_rectangle_in_histogram03.Solution().largestRectangleArea(
                new int[]{2, 1, 5, 6, 2, 3}
        ));
    }

    //栈 O(n)
    //维护一个递增的栈，当前元素小于栈顶元素则入栈当前元素的序号
    //否则合并栈中元素，直到栈顶元素小于当前元素
    //对于2，1，5，6，2，3
    //栈内元素为0 此时heights[1] < heights[0] 计算第0个板子的到当前元素的最大面积：2 即第1个板子的面积
    //然后合并栈：栈内元素为1
    //继续入栈：栈内元素为1，2，3 此时heights[4] < heights[3] 计算第3个板子到当前元素的最大面积：6 即第3个板子的面积
    //3出栈：栈内元素为1，2 此时heights[4] < heights[3] 计算第2个板子到当前元素的最大面积：10 即从第2个板子到当前板子的面积
    //2出栈，4入栈，5入栈
    //此时heights[5] < 0 计算第5个板子到当前元素的最大面积：3 即第5个板子的面积
    //然后计算面积8
    //然后计算面积6
    //最大面积为10
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            //使得原heights末尾为0，最后一个板子也被处理
            int[] newHeights = new int[heights.length + 1];
            for (int i = 0; i < heights.length; i++) {
                newHeights[i] = heights[i];
            }
            newHeights[heights.length] = 0;
            int sum = 0;
            for (int i = 0; i < newHeights.length; i++) {
                if (stack.empty() || newHeights[i] > newHeights[stack.peek()]) stack.push(i);
                else {
                    int temp = stack.peek();
                    stack.pop();
                    sum = Math.max(sum, newHeights[temp] * (stack.empty() ? i : i - stack.peek() - 1));
                    i--;
                }
            }
            return sum;
        }
    }
}
