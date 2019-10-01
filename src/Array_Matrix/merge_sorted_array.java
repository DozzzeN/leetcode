package Array_Matrix;

import java.util.Arrays;

//88
//�������������������� nums1 �� nums2���� nums2 �ϲ��� nums1 �У�ʹ�� num1 ��Ϊһ���������顣
//˵��:
//	��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n��
//	����Լ��� nums1 ���㹻�Ŀռ䣨�ռ��С���ڻ���� m + n�������� nums2 �е�Ԫ�ء�
//ʾ��:
//����:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//���: [1,2,2,3,5,6]
public class merge_sorted_array {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new merge_sorted_array.Solution().merge(nums1, 1, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    //�Ӻ���ǰɨ�裬��ʡ�ռ䣬��Ϊ����Ҫ����Ŀռ�洢nums1�������Ϣ
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int k = m + n - 1;
            for (; m > 0 && n > 0; k--) {
                if (nums1[m - 1] > nums2[n - 1]) {
                    nums1[k] = nums1[m - 1];
                    m--;
                } else {
                    nums1[k] = nums2[n - 1];
                    n--;
                }
            }

            while (n > 0) {
                nums1[k] = nums2[n - 1];
                k--;
                n--;
            }
        }
    }
}
