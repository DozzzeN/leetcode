package DivideConquer;

//4
//����������СΪ m �� n ���������� nums1 �� nums2��
//�����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(log(m + n))��
//����Լ��� nums1 �� nums2 ����ͬʱΪ�ա�
//ʾ�� 1:
//nums1 = [1, 3]
//nums2 = [2]
//����λ���� 2.0
//ʾ�� 2:
//nums1 = [1, 2]
//nums2 = [3, 4]
//����λ���� (2 + 3)/2 = 2.5
public class median_of_two_sorted_arrays {
    public static void main(String[] args) {
        System.out.println(new median_of_two_sorted_arrays.Solution().findMedianSortedArrays(
                new int[]{1, 3}, new int[]{2}
        ));
    }

    //�д���
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            if ((m + n) % 2 == 0) {
                return (findMedianSortedArrays(nums1, 0, m, nums2, 0, n, (m + n) / 2)
                        + findMedianSortedArrays(nums1, 0, m, nums2, 0, n, (m + n) / 2 + 1)) / 2.0;
            } else {
                return findMedianSortedArrays(nums1, 0, m, nums2, 0, n, (m + n) / 2 + 1);
            }
        }


        public double findMedianSortedArrays(int[] nums1, int nums1_left, int nums1_right,
                                             int[] nums2, int nums2_left, int nums2_right, int k) {
            System.out.println(nums1_left + " " + nums1_right + " " + nums2_left + " " + nums2_right + " " + k);
            if (nums1_right <= nums1_left || nums1_right <= 0 || nums1_left >= nums1.length) {
//                if (nums2.length <= k) k--;
                return nums2[k - 1];
            }
            if (nums2_right <= nums2_left || nums2_right <= 0 || nums2_left >= nums2.length) {
//                if (nums1.length <= k) k--;
                return nums1[k - 1];
            }

            if (k <= 1) return Math.min(nums1[0], nums2[0]);
            if (nums1[(nums1_right - nums1_left) / 2] >= nums2[(nums2_right - nums2_left) / 2]) {
                if (((nums1_right - nums1_left + nums2_right - nums2_left) / 2 + 1) >= k) {
                    //section2
                    if (nums1_right - nums1_left == 1) {
                        return findMedianSortedArrays(nums1, nums1_left, nums1_right,
                                nums2, nums2_left, nums2_right, k);
                    }
                    System.out.println("2");
                    return findMedianSortedArrays(nums1, nums1_left, (nums1_right - nums1_left) / 2,
                            nums2, nums2_left, nums2_right, k);
                } else
                    //section3
                    System.out.println("3");
                return findMedianSortedArrays(nums1, nums1_left, nums1_right,
                        nums2, (nums1_right - nums1_left) / 2 + 1, nums2_right - (nums1_right - nums1_left) / 2 - 1,
                        k - (nums2_right - nums2_left) / 2 - 1);
            } else {
                if (((nums1_right - nums1_left + nums2_right - nums2_left) / 2 + 1) >= k) {
                    //section4
                    System.out.println("4");
//                    if (nums2_right - nums2_left == 1) {
//                        return findMedianSortedArrays(nums1, nums1_left, nums1_right,
//                                nums2, nums2_left, nums2_right, k);
//                    }
                    return findMedianSortedArrays(nums1, nums1_left, nums1_right,
                            nums2, nums2_left, (nums2_right - nums2_left) / 2, k);
                } else {
                    //section1
                    System.out.println("1");
                    return findMedianSortedArrays(nums1, (nums1_right - nums1_left) / 2 + 1, nums1_right - (nums1_right - nums1_left) / 2 - 1,
                            nums2, nums2_left, nums2_right, k - (nums2_right - nums2_left) / 2 - 1);
                }
            }
        }
    }
}
