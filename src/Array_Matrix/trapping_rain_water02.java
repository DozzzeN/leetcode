package Array_Matrix;

//42
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
//示例:
//输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
public class trapping_rain_water02 {
    public static void main(String[] args) {
        System.out.println(new trapping_rain_water02.Solution().trap(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
    }

    //H[i] = min (Max(Array[j]), Max(Array[k])) - Array[i] where j<i and k<i
    //任何一个bar的容积：在左边最高峰和右边最高峰中取一个最小值，然后减去当前bar的高度
    //使用双指针，简化数组的开销
    static class Solution {
        public int trap(int[] height) {
            if (height.length < 2) return 0;
            int result = 0;
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            while (left <= right) {
                if (leftMax <= rightMax) {
                    leftMax = Math.max(leftMax, height[left]);
                    result += Math.max(0, leftMax - height[left]);
                    left++;
                } else {
                    rightMax = Math.max(rightMax, height[right]);
                    result += Math.max(0, rightMax - height[right]);
                    right--;
                }
            }
            return result;
        }
    }
}
