package Offer;

import java.util.Arrays;

//https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
//所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
public class adjust_array_order_so_that_odd_numbers_precede_even_numbers {
    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 2, 5, 6, 7, 1};
        new adjust_array_order_so_that_odd_numbers_precede_even_numbers.Solution().reOrderArray(a);
        System.out.println(Arrays.toString(a));
    }

    public static class Solution {
        public void reOrderArray(int[] array) {
            if (array == null || array.length == 0) return;
            int pre = 0;
            for (int i = 0; i < array.length; i++) {
                if (Math.abs(array[i]) % 2 == 1) {
                    int temp = array[i];
                    int last = i;
                    while (last > pre) {
                        array[last] = array[last - 1];
                        last--;
                    }
                    array[pre] = temp;
                    pre++;
                }
            }
        }
    }
}
