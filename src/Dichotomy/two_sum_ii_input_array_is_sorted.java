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
public class two_sum_ii_input_array_is_sorted {
    public static void main(String[] args) {
        int[] result = new two_sum_ii_input_array_is_sorted.Solution().twoSum(
                new int[]{1, 3, 5, 7, 9}, 7);
        System.out.println(Arrays.toString(result));
    }

    //�ҵ��м�ֵ��Ȼ����м�ֵ�������
    //1��3��5��7��9����������ѭ��
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] result;
            int left = 0, right = numbers.length;
            int half = target / 2;
            int index = 0;
            boolean flag = false;
            boolean leftBound = false;
            boolean rightBound = false;
            while (left < right) {
                int mid = (left + right) / 2;
                if (numbers[mid] == half) {
                    flag = true;
                    index = mid;
                    break;
                } else if (numbers[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (!flag) {
                index = left;
            }
            if (index == numbers.length) index--;
            if (index == 0) index++;
            left = index - 1;
            right = index;
            while (left >= 0 && right < numbers.length) {
                int temp = numbers[left] + numbers[right];
                if (temp == target) {
                    result = new int[]{left + 1, right + 1};
                    return result;
                } else if (temp < target) {
                    if (right == numbers.length - 1) {
                        rightBound = true;
                        left++;
                    } else {
                        if (!leftBound) {//��ߵ��߽�֮���ұ߾Ͳ��������ƶ���
                            right++;
                        } else {
                            left++;
                        }
                    }
                } else {
                    if (left == 0) {
                        leftBound = true;
                        right--;
                    } else {
                        if (!rightBound) {
                            left--;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return new int[]{-1, -1};
        }
    }
}
