package Dichotomy;

import java.util.Arrays;

//34
//����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
//����㷨ʱ�临�Ӷȱ����� O(log n) ����
//��������в�����Ŀ��ֵ������ [-1, -1]��
//ʾ�� 1:
//����: nums = [5,7,7,8,8,10], target = 8
//���: [3,4]
//ʾ�� 2:
//����: nums = [5,7,7,8,8,10], target = 6
//���: [-1,-1]
public class find_first_and_last_position_of_element_in_sorted_array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new find_first_and_last_position_of_element_in_sorted_array.Solution().searchRange(
                new int[]{1, 2, 3}, 2
        )));
    }

    //���ζ����ҵ����ұ߽磬�ο����ֲ����㷨���
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[]{-1, -1};
            if (nums == null || nums.length == 0) return result;
            int left = 0, right = nums.length - 1;
            //��ʱ����ȡ�ȣ���ֹ�߽���� ��{2,2}����
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (nums[left] == target) {
                result[0] = left;
            } else {
                return result;
            }
            right = nums.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            result[1] = right - 1;
            return result;
        }
    }
}
