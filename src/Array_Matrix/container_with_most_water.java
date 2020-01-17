package Array_Matrix;

//11
//画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//说明：你不能倾斜容器，且 n 的值至少为 2。
//图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//示例:
//输入: [1,8,6,2,5,4,8,3,7]
//输出: 49
public class container_with_most_water {
    public static void main(String[] args) {
        System.out.println(new container_with_most_water.Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new container_with_most_water.Solution().maxArea(new int[]{1, 1}));
    }

    static class Solution {
        //暴力法
//        public int maxArea(int[] height) {
//            int result = 0;
//            for (int i = 0; i < height.length; i++) {
//                for (int j = height.length - 1; j > 0; j--) {
//                    result = Math.max(result, Math.abs(i - j) * Math.min(height[i], height[j]));
//                }
//            }
//            return result;
//        }
        //双指针法，容量取决于最短的那个板子，只需要移动短板的指针即可
        public int maxArea(int[] height) {
            int result = 0;
            for (int i = 0, j = height.length - 1; i != j; ) {
                result = Math.max(result, Math.abs(i - j) * Math.min(height[i], height[j]));
                if (height[i] > height[j]) {
                    j--;
                } else {
                    i++;
                }
            }
            return result;
        }
    }
}
