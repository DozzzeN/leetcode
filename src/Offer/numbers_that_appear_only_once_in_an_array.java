package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//题目描述
//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
public class numbers_that_appear_only_once_in_an_array {
    public static void main(String[] args) {
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new numbers_that_appear_only_once_in_an_array.Solution().FindNumsAppearOnce(
                new int[]{4, 3, 2, 1, 2, 4}, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
        Arrays.fill(num1, 0);
        Arrays.fill(num2, 0);
        new numbers_that_appear_only_once_in_an_array.Solution().FindNumsAppearOnce2(
                new int[]{4, 3, 2, 1, 2, 4}, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public static class Solution {
        public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
            List<String> list = new ArrayList<>();
            //如果list中是纯整数会出现按元素删除和按下标删除歧义的情况：优先是按下标删除
            for (int value : array) {
                if (list.contains("_" + value)) {
                    list.remove("_" + value);
                } else {
                    list.add("_" + value);
                }
            }
            num1[0] = Integer.parseInt(list.get(0).substring(1));
            num2[0] = Integer.parseInt(list.get(1).substring(1));
        }

        //两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
        //diff&=-diff得到出diff最右侧不为0的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
        public void FindNumsAppearOnce2(int[] array, int[] num1, int[] num2) {
            int diff = 0;
            for (int num : array)
                diff ^= num;
            diff &= -diff;
            for (int num : array) {
                if ((num & diff) == 0)
                    num1[0] ^= num;
                else
                    num2[0] ^= num;
            }
        }
    }
}
