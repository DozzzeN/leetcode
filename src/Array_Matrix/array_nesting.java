package Array_Matrix;

import java.util.HashSet;
import java.util.Set;

//565
//������0��ʼ����ΪN������A������0��N - 1������������
//�ҵ����������ļ���S��S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }���������µĹ���
//����ѡ������Ϊi��Ԫ��A[i]ΪS�ĵ�һ��Ԫ�أ�S����һ��Ԫ��Ӧ����A[A[i]]��֮����A[A[A[i]]]...
//�Դ����ƣ��������ֱ��S�����ظ���Ԫ�ء�
public class array_nesting {
    public static void main(String[] args) {
        int[] input = new int[]{5, 4, 0, 3, 1, 6, 2};
        System.out.println(new array_nesting.Solution().arrayNesting(input));
    }

    static class Solution {
        public int arrayNesting(int[] nums) {
            int temp = 1;
            int result = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                int j = nums[i];
                if (set.contains(nums[i])) {
                    break;
                }
                while (i != j) {
                    set.add(j);
                    temp++;
                    j = nums[j];
                }
                result = Math.max(temp, result);
                temp = 1;
            }

            return result;
        }
    }
}
