package BackTracking;

import java.util.Stack;

//377
//����һ��������������Ҳ������ظ����ֵ����飬�ҳ���Ϊ����Ŀ������������ϵĸ�����
//ʾ��:
//nums = [1, 2, 3]
//target = 4
//���п��ܵ����Ϊ��
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//��ע�⣬˳��ͬ�����б�������ͬ����ϡ�
//������Ϊ 7��
public class combination_sum_iv {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4};
        System.out.println(new combination_sum_iv.Solution().combinationSum4(nums, 32));
    }

    static class Solution {
        int result;
        int[] nums;

        //��ʱ��ʹ�ö�̬�滮
        public int combinationSum4(int[] nums, int target) {
            this.nums = nums;
            findCombinationSum(target, 0, new Stack<>());
            return result;
        }

        public void findCombinationSum(int residue, int start, Stack<Integer> solution) {
            if (residue < 0) {
                return;
            }
            if (residue == 0) {
                result++;
                return;
            }
            for (int i = start; i < nums.length; i++) {
                solution.push(nums[i]);
                findCombinationSum(residue - nums[i], start, solution);
                //ѡ����һ����֧
                solution.pop();
            }
        }
    }
}
