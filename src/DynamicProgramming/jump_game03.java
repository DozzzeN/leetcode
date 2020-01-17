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
public class jump_game03 {
    public static void main(String[] args) {
        System.out.println(new jump_game03.Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    //��̬�滮
    //ֻ��¼�ɴ����ұ߽�
    static class Solution {
        public boolean canJump(int[] nums) {
            int maxCover = 0;
            for (int start = 0; start < nums.length && start <= maxCover; start++) {
                if (nums[start] + start > maxCover) maxCover = nums[start] + start;
                if (maxCover >= nums.length - 1) return true;
            }
            return false;
        }
    }
}
