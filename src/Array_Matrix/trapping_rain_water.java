package Array_Matrix;

//42
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
//示例:
//输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
public class trapping_rain_water {
    public static void main(String[] args) {
        System.out.println(new trapping_rain_water.Solution().trap(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
    }

    //H[i] = min (Max(Array[j]), Max(Array[k])) - Array[i] where j<i and k<i
    //任何一个bar的容积：在左边最高峰和右边最高峰中取一个最小值，然后减去当前bar的高度
    static class Solution {
        public int trap(int[] height) {
            if (height.length < 2) return 0;
            int[] maxL = new int[height.length];//第i柱左边最高的
            int[] maxR = new int[height.length];//第i柱右边最高的
            for (int i = 1; i < height.length; i++) {
                maxL[i] = Math.max(maxL[i - 1], height[i - 1]);
            }
            for (int i = height.length - 2; i >= 0; i--) {
                maxR[i] = Math.max(maxR[i + 1], height[i + 1]);
            }
            int result = 0;
            for (int i = 0; i < height.length; i++) {
                result += Math.max((Math.min(maxL[i], maxR[i]) - height[i]), 0);
            }
            return result;
        }
    }
}
