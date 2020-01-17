package Offer;

//https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
public class number_that_occurs_more_than_half_of_the_times_in_an_array {
    public static void main(String[] args) {
        System.out.println(new number_that_occurs_more_than_half_of_the_times_in_an_array.Solution().MoreThanHalfNum_Solution(
                new int[]{1, 1, 2, 2}
        ));
        System.out.println(new number_that_occurs_more_than_half_of_the_times_in_an_array.Solution().MoreThanHalfNum_Solution2(
                new int[]{1, 1, 2, 2}
        ));
    }

    public static class Solution {
        public int MoreThanHalfNum_Solution(int[] array) {
            if (array == null || array.length == 0) return 0;
            int[] hashtable = new int[10000];
            for (int value : array) {
                hashtable[value]++;
            }
            int result = 0;
            for (int i = 0; i < hashtable.length; i++) {
                if (hashtable[i] > array.length / 2) {
                    result = i;
                }
            }
            return result;
        }

        public int MoreThanHalfNum_Solution2(int[] array) {
            if (array == null || array.length == 0) return 0;
            int preValue = array[0];
            int count = 1;
            for (int i = 1; i < array.length; i++) {
                if (array[i] == preValue) {
                    count++;
                } else {
                    if (count-- == 0) {
                        preValue = array[i];
                        count = 1;
                    }
                }
            }
            int num = 0;
            //需要判断是否真的是大于1半数
            for (int value : array)
                if (value == preValue)
                    num++;
            return (num > array.length / 2) ? preValue : 0;
        }
    }
}
