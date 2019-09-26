package Array_Matrix;

import java.util.Arrays;
import java.util.HashSet;

//349
//给定两个数组，编写一个函数来计算它们的交集。
public class intersection_of_two_arrays02 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{1, 2};
        int[] result = new intersection_of_two_arrays02.Solution().intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    static class Solution {

        //java内置函数
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<Integer>();
            for (Integer n : nums1) set1.add(n);
            HashSet<Integer> set2 = new HashSet<Integer>();
            for (Integer n : nums2) set2.add(n);

            set1.retainAll(set2);

            int[] output = new int[set1.size()];
            int idx = 0;
            for (int s : set1) output[idx++] = s;
            return output;
        }
    }
}
