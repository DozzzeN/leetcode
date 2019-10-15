package Bit;

import java.util.Arrays;

//260
//����һ���������� nums������ǡ��������Ԫ��ֻ����һ�Σ���������Ԫ�ؾ��������Ρ� �ҳ�ֻ����һ�ε�������Ԫ�ء�
//ʾ�� :
//����: [1,2,1,3,2,5]
//���: [3,5]
//ע�⣺
//	��������˳�򲢲���Ҫ��������������ӣ� [5, 3] Ҳ����ȷ�𰸡�
//	����㷨Ӧ�þ�������ʱ�临�Ӷȡ����ܷ��ʹ�ó����ռ临�Ӷ���ʵ�֣�
public class single_number_iii {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new single_number_iii.Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 99})));
    }

    //1.�������������,һ�������ֵ���,����һ�ε�����������������ض���Ϊ0;
    //2.������ֺ��෴����������õ�һ��������λ���ұ�һλΪ1������;
    //3.mask�������ÿ��������������,����0�ķ�Ϊһ��,����mask�ķ�Ϊһ��,ͬʱҲ��������һ�������ַֿ�;
    static class Solution {
        public int[] singleNumber(int[] nums) {
            int[] result = new int[2];
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            int mask = xor & (-xor);
            for (int num : nums) {
                if ((mask & num) == 0) {
                    //����д��result[0] = num ��Ϊ����ȡ���ظ���Ԫ��
                    result[0] ^= num;
                } else {
                    result[1] ^= num;
                }
            }
            //����
            //result[1] = result[0] ^ xor;
            return result;
        }
    }
}
