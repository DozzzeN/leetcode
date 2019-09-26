package Array_Matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

//349
//�����������飬��дһ���������������ǵĽ�����
public class intersection_of_two_arrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{1, 2};
        int[] result = new intersection_of_two_arrays.Solution().intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    //���ݵ�һ������ nums1 ���������ÿ��ֵ�Ƿ������ nums2 �ڡ�������ڽ�ֵ��ӵ������
    //ʱ�临�Ӷ�ΪO(n*m)
    //����set�洢��ȥ��
    static class Solution {
        static int binarySearch(int[] array, int value) {
            Arrays.sort(array);
            int low = 0;
            int high = array.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (value == array[mid]) {
                    return mid;
                }
                if (value > array[mid]) {
                    low = mid + 1;
                }
                if (value < array[mid]) {
                    high = mid - 1;
                }

            }
            return -1;
        }

        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> result = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                int index = binarySearch(nums2, nums1[i]);
                if (index >= 0) {
                    result.add(nums1[i]);
                }
            }
            int[] temp = new int[result.size()];
            int j = 0;
            for (Iterator i = result.iterator(); i.hasNext(); j++) {
                temp[j] = (int) i.next();
            }

            return temp;
        }

    }
}
