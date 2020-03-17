package Offer;

import java.util.Arrays;

//https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
//B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
//（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
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
        //分别计算上下两个三角形的乘积然后再拼接
        public int[] multiply2(int[] A) {
            if (A == null || A.length == 0) return null;
            int[] B = new int[A.length];
            B[0] = 1;
            //下三角形
            for (int i = 1; i < A.length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            //上三角形
            int temp = 1;
            for (int i = A.length - 1; i >= 0; i--) {
                B[i] *= temp;
                temp *= A[i];
            }
            return B;
        }
    }
}
