package Offer;

import java.util.Arrays;

//https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//统计一个数字在排序数组中出现的次数。
public class the_number_of_times_the_number_appears_in_the_sorted_array {
    public static void main(String[] args) {
        System.out.println(new the_number_of_times_the_number_appears_in_the_sorted_array.Solution().GetNumberOfK(
                new int[]{1, 2, 3, 6, 8, 8, 8, 9}, 8
        ));
    }

    public static class Solution {
        public int GetNumberOfK(int[] array, int k) {
            //注意调用原生的二分不会找到第一次出现的位置，如k=8时返回5
            //0-7 mid=3 a[mid]=6
            //4-7 mid=5 a[mid]=8 => return 5
            int index = Arrays.binarySearch(array, k);
            if (index < 0) return 0;
            int result = 1;
            for (int i = index + 1; i < array.length && array[i] == k; i++) result++;
            for (int i = index - 1; i >= 0 && array[i] == k; i--) result++;
            return result;
        }
    }
}
