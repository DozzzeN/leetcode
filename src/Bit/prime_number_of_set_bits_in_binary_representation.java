package Bit;

import java.util.Arrays;

//762
//������������ L �� R ���ҵ������� [L, R] ��Χ�ڣ�������λλ��Ϊ����������������
//��ע�⣬������λ��������Ʊ�ʾ��1�ĸ��������� 21 �Ķ����Ʊ�ʾ 10101 �� 3 ��������λ�����У�1 ������������
//ʾ�� 1:
//����: L = 6, R = 10
//���: 4
//����:
//6 -> 110 (2 ��������λ��2 ������)
//7 -> 111 (3 ��������λ��3 ������)
//9 -> 1001 (2 ��������λ��2 ������)
//10-> 1010 (2 ��������λ��2 ������)
//ʾ�� 2:
//����: L = 10, R = 15
//���: 5
//����:
//10 -> 1010 (2 ��������λ, 2 ������)
//11 -> 1011 (3 ��������λ, 3 ������)
//12 -> 1100 (2 ��������λ, 2 ������)
//13 -> 1101 (3 ��������λ, 3 ������)
//14 -> 1110 (3 ��������λ, 3 ������)
//15 -> 1111 (4 ��������λ, 4 ��������)
//ע��:
//	L, R �� L <= R ���� [1, 10^6] �е�������
//	R - L �����ֵΪ 10000��
public class prime_number_of_set_bits_in_binary_representation {
    public static void main(String[] args) {
        System.out.println(new prime_number_of_set_bits_in_binary_representation.Solution().countPrimeSetBits(842, 888));
    }

    static class Solution {
        public int countPrimeSetBits(int L, int R) {
            int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
            int count = 0, result = 0, _R = R;
            while (_R != 0) {
                count++;
                _R >>= 1;
            }
            for (int i = L; i <= R; i++) {
                int digit = 0;
                for (int j = 0; j <= count; j++) {
                    digit += ((i & (1 << j)) >> j);
                }
                //[1] ����ֵ��������Ԫ�أ��������鷶Χ�ڣ���1��ʼ�������á� - ���������ֵ����
                //[2] ����ֵ������Ԫ�أ���0��ʼ������������ֵ������ֵ��
                //[3] ����ֵ��������Ԫ�أ��Ҵ���������Ԫ�أ�����ֵΪ �C (length + 1);
                //[4] ����ֵ��������Ԫ�أ���С��������Ԫ�أ�����ֵΪ �C 1��
                int index = Arrays.binarySearch(prime, digit);
                if (index >= 0 && index <= 8) {
                    result++;
                }
            }
            return result;
        }
    }
}
