package Array_Matrix;

import java.util.ArrayList;
import java.util.List;

//350
//给定两个数组，编写一个函数来计算它们的交集。
public class intersection_of_two_arrays_ii {

    public static void main(String[] args) {
        intersection_of_two_arrays_ii.Solution solution = new intersection_of_two_arrays_ii.Solution();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        int[] result = solution.intersect(nums1, nums2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> num1 = new ArrayList<>();
            for (int temp : nums1) {
                num1.add(temp);
            }

            List<Integer> num2 = new ArrayList<>();
            for (int temp : nums2) {
                num2.add(temp);
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < num1.size(); i++) {
                Integer temp = num1.get(i);
                if (num2.contains(temp)) {
                    result.add(temp);
                    num2.remove(temp);
                }
            }

            int[] resultArray = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                resultArray[i] = result.get(i);
            }

            return resultArray;
        }
    }
}
