package Offer;

//https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

import java.util.ArrayList;

//输出描述:
//对应每个测试案例，输出两个数，小的先输出。
public class and_two_numbers_for_s {
    public static void main(String[] args) {
        System.out.println(new and_two_numbers_for_s.Solution().FindNumbersWithSum(
                new int[]{1, 2, 4, 5, 6, 9}, 10
        ));

        System.out.println(new and_two_numbers_for_s.Solution().FindNumbersWithSum2(
                new int[]{1, 2, 4, 5, 6, 9}, 10
        ));
    }

    public static class Solution {
        //穷举法
        public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
            ArrayList<Integer> result = new ArrayList<>();
            int nums = 0;
            for (int i = 0; i < array.length; i++) {
                int a = array[i];
                for (int j = i + 1; j < array.length; j++) {
                    if (a + array[j] == sum) {
                        nums++;
                        if (nums > 1) {
                            if (result.get(0) * result.get(1) > a * array[j]) {
                                result.add(0, a);
                                result.add(1, array[j]);
                            }
                        } else {
                            result.add(a);
                            result.add(array[j]);
                        }
                    }
                }
            }
            return result;
        }

        //双指针
        public ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
            int left = 0, right = array.length - 1;
            ArrayList<Integer> result = new ArrayList<Integer>();
            while (left < right) {
                //乘积一定最小
                if (array[left] + array[right] == sum) {
                    result.add(array[left]);
                    result.add(array[right]);
                    break;
                } else if (array[left] + array[right] < sum) {
                    left++;
                } else {
                    right--;
                }
            }
            return result;
        }
    }
}
