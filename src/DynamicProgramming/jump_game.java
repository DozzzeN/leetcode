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
public class jump_game {
    public static void main(String[] args) {
        System.out.println(new jump_game.Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    //��̬�滮
    //dp[i]��ʾ�Ƿ����ߵ�i��
    //dp[i] = falseֱ���˳�
    //����nums[i]��ֵ����i�������ܵ����λ�ø�ֵtrue
    static class Solution {
        public boolean canJump(int[] nums) {
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;
            for (int i = 0; i < nums.length - 1; i++) {
                if (!dp[i]) return false;
                int canArrive = i + nums[i];
                while (canArrive > 0) {
                    if (canArrive >= nums.length) {
                        canArrive--;
                        continue;
                    }
                    dp[canArrive] = true;
                    canArrive--;
                }
            }
            return dp[nums.length - 1];
        }
    }
}
