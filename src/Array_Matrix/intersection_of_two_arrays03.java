package Array_Matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//349
//给定两个数组，编写一个函数来计算它们的交集。
public class intersection_of_two_arrays03 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{1, 2};
        int[] result = new intersection_of_two_arrays03.Solution().intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> result = new HashSet<>();
            Set<Integer> find = new HashSet<>();
            for (int temp : nums1) {
                find.add(temp);
            }
            for (int temp : nums2) {
                if (find.contains(temp)) {
                    result.add(temp);
                }
            }
            int[] temp = new int[result.size()];
            int j = 0;
            for (Iterator i = result.iterator(); i.hasNext(); j++) {
                temp[j] = (int) i.next();
            }

            return temp;
        }
    }
}
