package Greedy;

//45
//����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
//�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
//���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
//ʾ��:
//����: [2,3,1,1,4]
//���: 2
//����: �������һ��λ�õ���С��Ծ���� 2��
//     ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
//˵��:
//���������ǿ��Ե�����������һ��λ�á�
public class jump_game_ii {
    public static void main(String[] args) {
        System.out.println(new jump_game_ii.Solution().jump(new int[]{2, 3, 1, 1, 4}));
    }

    //̰���㷨
    //ά��һ���������䣬ÿ��ɨ������Ԫ��ʱ���¼����µ�����߽�
    //��2,3,1,1,4 ����Ϊ[0,0]����ôӵ�һ��Ԫ���ܵ�������䷶Χ��[1,2]
    //��[1,2]���Ѿ�����ֱ�ӵ���ĩβ��ֱ�ӷ���
    //ÿ������һ�����䣬����������1
    static class Solution {
        public int jump(int[] nums) {
            int start = 0, end = 0, count = 0;
            if (nums.length == 1) return 0;
            while (end < nums.length) {
                int max = 0;
                count++;
                //�ҳ��ô�������ѡһ��Ԫ�أ����ߵ������λ��max
                for (int i = start; i <= end; i++) {
                    if (nums[i] + i >= nums.length - 1) return count;
                    if (nums[i] + i > max) max = nums[i] + i;
                }
                start = end + 1;
                end = max;
            }
            return count;
        }
    }
}
