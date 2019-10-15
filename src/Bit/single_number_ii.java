package Bit;

//137
//����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ����������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
//˵����
//����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
//ʾ�� 1:
//����: [2,2,3,2]
//���: 3
//ʾ�� 2:
//����: [0,1,0,1,0,1,99]
//���: 99
public class single_number_ii {
    public static void main(String[] args) {
        System.out.println(new single_number_ii.Solution().singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }

    //��ÿһλ���ְ�λ�ۼӣ��������ÿһ��λ�ϵ�1���ֵĴ�����3ȡģ��ʣ�µľ��ǽ��

    //1.λ����������;
    //2.��������г������ε����ֵĶ����Ʊ�ʾ��ÿһλ������,��ôÿһλ���ܱ�3����;
    //3.���ĳһλ�ĺ��ܱ�3����,��ôֻ����һ�����ֵĶ�����λ�ж�Ӧ����һλ����0,�������1;
    static class Solution {
        public int singleNumber(int[] nums) {
            int[] bit = new int[32];//��Ϊint��-2^31����2^31-1
            for (int i = 0; i < nums.length; i++) {
                int k = 1;
                for (int j = 0; j < 32; j++) {
                    int rotated;
                    if ((rotated = nums[i] >> j) == 0) break;//����2
                    bit[j] += rotated & k;//ȡ����
                }
            }
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result += (bit[i] % 3 << i);
            }
            return result;
        }
    }
}
