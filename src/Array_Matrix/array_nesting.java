package Array_Matrix;

import java.util.HashSet;
import java.util.Set;

//565
//索引从0开始长度为N的数组A，包含0到N - 1的所有整数。
//找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
//假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]...
//以此类推，不断添加直到S出现重复的元素。
public class array_nesting {
    public static void main(String[] args) {
        int[] input = new int[]{5, 4, 0, 3, 1, 6, 2};
        System.out.println(new array_nesting.Solution().arrayNesting(input));
    }

    static class Solution {
        public int arrayNesting(int[] nums) {
            int temp = 1;
            int result = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                int j = nums[i];
                if (set.contains(nums[i])) {
                    break;
                }
                while (i != j) {
                    set.add(j);
                    temp++;
                    j = nums[j];
                }
                result = Math.max(temp, result);
                temp = 1;
            }

            return result;
        }
    }
}
