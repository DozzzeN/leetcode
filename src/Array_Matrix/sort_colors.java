package Array_Matrix;

import java.util.Arrays;

//75
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//注意:
//不能使用代码库中的排序函数来解决这道题。
//示例:
//输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2]
//进阶：
//	一个直观的解决方案是使用计数排序的两趟扫描算法。
//	首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
//	你能想出一个仅使用常数空间的一趟扫描算法吗？
public class sort_colors {
    public static void main(String[] args) {
        int[] input = new int[]{2};
        new sort_colors.Solution().sortColors(input);
        System.out.println(Arrays.toString(input));
    }

    //计数排序需要扫描两遍，第一遍生成颜色的数目，第二编生成新数组
    //注意：只有两种颜色，故使用双指针分别记录红色和蓝色的边界，两个指针分别从首尾往中间遍历
    //左边交换完, nums[i]的的值是0。一定要往后挪一位继续扫描
    //而右边交换完，nums[i]是之前的nums[blueIndex]的值，这个值是没有被扫描过的，所以不用挪一位，直接扫描i。
    static class Solution {
        public void sortColors(int[] nums) {
            int redIndex = 0, blueIndex = nums.length - 1;
            int i = 0;
            while (i < blueIndex + 1) {
                if (nums[i] == 0) {//red
                    swap(nums, i++, redIndex++);
                    continue;
                } else if (nums[i] == 2) {//blue
                    swap(nums, i, blueIndex--);
                    continue;
                }
                //white
                i++;
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            //当left=right时为0，出错
            //nums[left] += nums[right];
            //nums[right] = nums[left] - nums[right];
            //nums[left] -= nums[right];
        }
    }
}
