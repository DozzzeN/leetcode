package Stack;

import java.util.Stack;

//42
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
//示例:
//输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
public class trapping_rain_water03 {
    public static void main(String[] args) {
        System.out.println(new trapping_rain_water03.Solution().trap(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
    }

    //我们在遍历数组时维护一个栈。如果当前的条形块小于或等于栈顶的条形块，我们将条形块的索引入栈，意思是当前的条形块被栈中的前一个条形块界定。
    //如果我们发现一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块和栈的前一个条形块界定，因此我们可以弹出栈顶元素并且累加答案到 ans 。
    static class Solution {
        public int trap(int[] height) {
            if (height.length < 2) return 0;
            int result = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) {
                while (!stack.empty() && height[i] > height[stack.peek()]) {
                    int top = stack.peek();
                    stack.pop();
                    if (stack.empty()) break;
                    result += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[top]);
                }
                stack.push(i);
            }
            return result;
        }
    }
}
