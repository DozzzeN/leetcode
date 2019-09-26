package DynamicProgramming;

//55
//����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
//�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
//�ж����Ƿ��ܹ��������һ��λ�á�
//ʾ�� 1:
//����: [2,3,1,1,4]
//���: true
//����: ��λ�� 0 �� 1 �� 1 ��, Ȼ���� 3 ���������һ��λ�á�
//ʾ�� 2:
//����: [3,2,1,0,4]
//���: false
//����: �������������ܻᵽ������Ϊ 3 ��λ�á�����λ�õ������Ծ������ 0 �� ��������Զ�����ܵ������һ��λ�á�
public class jump_game02 {
    public static void main(String[] args) {
        System.out.println(new jump_game02.Solution().canJump(new int[]{0, 2, 3}));
    }

    //��̬�滮
    //dp[i]��ʾ��0��Ծ��i����ʣ��������
    //dp[i] = max(dp[i-1],nums[i-1]) - 1
    static class Solution {
        public boolean canJump(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
                if (dp[i] < 0) return false;
            }
            return dp[nums.length - 1] >= 0;
        }
    }
}
