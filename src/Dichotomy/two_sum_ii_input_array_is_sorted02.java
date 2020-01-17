package Dichotomy;

import java.util.Arrays;

//167
//����һ���Ѱ����������� ���������飬�ҵ�������ʹ���������֮�͵���Ŀ������
//����Ӧ�÷����������±�ֵ index1 �� index2������ index1 ����С�� index2��
//˵��:
//	���ص��±�ֵ��index1 �� index2�����Ǵ��㿪ʼ�ġ�
//	����Լ���ÿ������ֻ��ӦΨһ�Ĵ𰸣������㲻�����ظ�ʹ����ͬ��Ԫ�ء�
//ʾ��:
//����: numbers = [2, 7, 11, 15], target = 9
//���: [1,2]
//����: 2 �� 7 ֮�͵���Ŀ���� 9 ����� index1 = 1, index2 = 2 ��
public class two_sum_ii_input_array_is_sorted02 {
    public static void main(String[] args) {
        int[] result = new two_sum_ii_input_array_is_sorted02.Solution().twoSum(
                new int[]{5, 25, 75}, 6);
        System.out.println(Arrays.toString(result));
    }

    //�ҵ��м�ֵ��Ȼ����м�ֵ�������
    //1��3��5��7��9����������ѭ��
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length - 1; i++) {
                int temp = search(numbers, target - numbers[i], i + 1, numbers.length - 1);
                if (temp != -1) {
                    return new int[]{i + 1, temp + 1};
                }
            }
            return new int[]{-1, -1};
        }

        public int search(int[] numbers, int target, int left, int right) {
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (numbers[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return numbers[left] == target ? left : -1;
        }
    }
}
