package Bit;

//136
//����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
//˵����
//����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
//ʾ�� 1:
//����: [2,2,1]
//���: 1
//ʾ�� 2:
//����: [4,1,2,1,2]
//���: 4
public class single_number {
    public static void main(String[] args) {
        System.out.println(new single_number.Solution().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    //��������������г������ε�Ԫ��
    static class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }
            return result;
        }
    }
}
