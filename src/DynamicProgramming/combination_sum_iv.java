package DynamicProgramming;

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
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new combination_sum_iv.Solution().combinationSum4(nums, 4));
    }

    //�����׷��֡��ص������⡱����ˣ����ǿ���ʹ�á���̬�滮�������������Ŀ�ʾ���Ľ⣬��ô�á���������������
    static class Solution {
        //dp[i]��ʾĿ���ܺ�Ϊiʱ��ѡ�񷽷�
        //dp[i] = sum { dp[i - num] for num in nums and i >= num}
        //dp[4] = dp[3] + dp[2] + dp[1]   7
        //dp[3] = dp[2] + dp[1] + dp[0]   4
        //dp[2] = dp[1] + dp[0]           2
        //dp[1] = dp[0]                   1
        //dp[0] = 1
        int[] nums;

        //��ʱ
        public int combinationSum4(int[] nums, int target) {
            this.nums = nums;
            return dp(target);
        }

        public int dp(int i) {
            int result = 0;
            if (i < 0) return 0;
            if (i == 0) return 1;
            for (int num : nums) {
                result += dp(i - num);
            }
            return result;
        }
    }
}
