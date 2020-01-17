package Dichotomy;

import java.util.Arrays;

//167
//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
//说明:
//	返回的下标值（index1 和 index2）不是从零开始的。
//	你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
//示例:
//输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
public class two_sum_ii_input_array_is_sorted02 {
    public static void main(String[] args) {
        int[] result = new two_sum_ii_input_array_is_sorted02.Solution().twoSum(
                new int[]{5, 25, 75}, 6);
        System.out.println(Arrays.toString(result));
    }

    //找到中间值，然后从中间值两遍遍历
    //1，3，5，7，9的用例是死循环
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length - 1; i++) {
                int temp = search(numbers, target - numbers[i], i + 1, numbers.length - 1);
                if (temp != -1) {
                    return new int[]{i + 1, temp + 1};
                }
            }
            return new int[]{-1, -1};
        }

        public int search(int[] numbers, int target, int left, int right) {
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (numbers[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return numbers[left] == target ? left : -1;
        }
    }
}
