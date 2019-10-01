package Array_Matrix;

import java.util.Arrays;

//88
//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//说明:
//	初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
//	你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//示例:
//输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//输出: [1,2,2,3,5,6]
public class merge_sorted_array {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new merge_sorted_array.Solution().merge(nums1, 1, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    //从后先前扫描，节省空间，因为不需要额外的空间存储nums1数组的信息
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
