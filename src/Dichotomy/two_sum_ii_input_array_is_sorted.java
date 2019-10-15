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
public class two_sum_ii_input_array_is_sorted {
    public static void main(String[] args) {
        int[] result = new two_sum_ii_input_array_is_sorted.Solution().twoSum(
                new int[]{1, 3, 5, 7, 9}, 7);
        System.out.println(Arrays.toString(result));
    }

    //找到中间值，然后从中间值两遍遍历
    //1，3，5，7，9的用例是死循环
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] result;
            int left = 0, right = numbers.length;
            int half = target / 2;
            int index = 0;
            boolean flag = false;
            boolean leftBound = false;
            boolean rightBound = false;
            while (left < right) {
                int mid = (left + right) / 2;
                if (numbers[mid] == half) {
                    flag = true;
                    index = mid;
                    break;
                } else if (numbers[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (!flag) {
                index = left;
            }
            if (index == numbers.length) index--;
            if (index == 0) index++;
            left = index - 1;
            right = index;
            while (left >= 0 && right < numbers.length) {
                int temp = numbers[left] + numbers[right];
                if (temp == target) {
                    result = new int[]{left + 1, right + 1};
                    return result;
                } else if (temp < target) {
                    if (right == numbers.length - 1) {
                        rightBound = true;
                        left++;
                    } else {
                        if (!leftBound) {//左边到边界之后，右边就不能向右移动了
                            right++;
                        } else {
                            left++;
                        }
                    }
                } else {
                    if (left == 0) {
                        leftBound = true;
                        right--;
                    } else {
                        if (!rightBound) {
                            left--;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return new int[]{-1, -1};
        }
    }
}
