package Offer;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class the_minimum_number_of_K {
    public static void main(String[] args) {
        System.out.println(new the_minimum_number_of_K.Solution().GetLeastNumbers_Solution(
                new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 10
        ));
    }

    public static class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            ArrayList<Integer> result = new ArrayList<>();
            if (input == null || input.length == 0 || k <= 0 || k > input.length) return result;
            quicksort(input, 0, input.length - 1);
            for (int i = 0; i < k; i++) {
                result.add(input[i]);
            }
            return result;
        }

        public void quicksort(int[] input, int low, int high) {
            if (low >= high) return;
            int axis = input[low];
            int i = low, j = high;
            while (i < j) {
                while (input[j] >= axis && i < j) {
                    j--;
                }
                while (input[i] <= axis && i < j) {
                    i++;
                }
                if (i < j) {
                    input[i] = input[i] + input[j];
                    input[j] = input[i] - input[j];
                    input[i] = input[i] - input[j];
                }
            }
            input[low] = input[i];
            input[i] = axis;
            quicksort(input, low, i - 1);
            quicksort(input, i + 1, high);
        }
    }
}
