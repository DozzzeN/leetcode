package Offer;

import java.util.ArrayList;
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

        public void FindNumsAppearOnce2(int[] array, int[] num1, int[] num2) {
            int result = 0;
            for (int value : array) {
                result ^= value;
            }
            //resultĳһλΪ1�����ʾnum1��num2�в�ͬ��λ
            //��result���ҵ���һ����ͬ��λ�����ݽ��з��࣬����Ϊ�������ж����ݽ���������
            int index = 1;
            while ((index & result) == 0)
                index = index << 1;//��Ϊ�����ж��λΪ1������Ҫ��һ��λ��
            int result1 = 0;
            int result2 = 0;
            for (int value : array) {
                if ((index & value) == 0)
                    result1 = result1 ^ value;
                else
                    result2 = result2 ^ value;
            }
            num1[0] = result1;
            num2[0] = result2;
        }
    }
}
