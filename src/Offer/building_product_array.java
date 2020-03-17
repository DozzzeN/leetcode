package Offer;

import java.util.Arrays;

//https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��
//B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
//��ע�⣺�涨B[0] = A[1] * A[2] * ... * A[n-1]��B[n-1] = A[0] * A[1] * ... * A[n-2];��
public class building_product_array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new building_product_array.Solution().multiply(
                new int[]{1, 2, 3, 4, 5}
        )));
        System.out.println(Arrays.toString(new building_product_array.Solution().multiply2(
                new int[]{1, 2, 3, 4, 5}
        )));
    }

    public static class Solution {
        public int[] multiply(int[] A) {
            if (A == null || A.length == 0) return null;
            int[] B = new int[A.length];
            Arrays.fill(B, 1);
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (i != j) {
                        B[i] *= A[j];
                    }
                }
            }
            return B;
        }

        //B0    1   A1  A2  ---  An-2   An-1
        //B1    A0  1   A2  ---  An-2   An-1
        //B2    A0  A1  1   ---  An-2   An-1

        //Bn-2  A0  A1  --- An-3 1      An-1
        //Bn-1  A0  A1  --- An-3 An-2   1
        //�ֱ�����������������εĳ˻�Ȼ����ƴ��
        public int[] multiply2(int[] A) {
            if (A == null || A.length == 0) return null;
            int[] B = new int[A.length];
            B[0] = 1;
            //��������
            for (int i = 1; i < A.length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            //��������
            int temp = 1;
            for (int i = A.length - 1; i >= 0; i--) {
                B[i] *= temp;
                temp *= A[i];
            }
            return B;
        }
    }
}
