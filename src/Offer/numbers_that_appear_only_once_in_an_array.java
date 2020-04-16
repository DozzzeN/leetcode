package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��Ŀ����
//һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
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

    //num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
    //��num1[0],num2[0]����Ϊ���ؽ��
    public static class Solution {
        public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
            List<String> list = new ArrayList<>();
            //���list���Ǵ���������ְ�Ԫ��ɾ���Ͱ��±�ɾ�����������������ǰ��±�ɾ��
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

        //��������ȵ�Ԫ����λ����ʾ�ϱض�����һλ���ڲ�ͬ�������������Ԫ�����õ��Ľ��Ϊ�������ظ�������Ԫ�����Ľ����
        //diff&=-diff�õ���diff���Ҳ಻Ϊ0��λ��Ҳ���ǲ������ظ�������Ԫ����λ����ʾ�����Ҳ಻ͬ����һλ��������һλ�Ϳ��Խ�����Ԫ�����ֿ�����
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
