package Array_Matrix;

import java.util.Arrays;
//1
//����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
//����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
//���� nums = [2, 7, 11, 15], target = 9
//��Ϊ nums[0] + nums[1] = 2 + 7 = 9
//���Է��� [0, 1]
public class two_sum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        two_sum.Solution sol = new two_sum.Solution();
        int[] result = sol.twoSum(nums, target);
        System.out.print(Arrays.toString(result));
    }

    //��������
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] + nums[i] == target && i < j) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
            //return new int[] { i, j }
            return result;
        }
    }
}


