package Bit;

import java.util.Arrays;

//338
//����һ���Ǹ����� num������ 0 �� i �� num ��Χ�е�ÿ������ i ����������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
//ʾ�� 1:
//����: 2
//���: [0,1,1]
//ʾ�� 2:
//����: 5
//���: [0,1,1,2,1,2]
//����:
//	����ʱ�临�Ӷ�ΪO(n*sizeof(integer))�Ľ��ǳ����ס��������������ʱ��O(n)����һ��ɨ��������
//	Ҫ���㷨�Ŀռ临�Ӷ�ΪO(n)��
//	���ܽ�һ�����ƽⷨ��Ҫ����C++���κ����������в�ʹ���κ����ú������� C++ �е� __builtin_popcount����ִ�д˲�����
public class counting_bits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new counting_bits.Solution().countBits(0)));
    }

    //�ҹ���
    //0                         //0
    //1                         //1
    //2 3                       //1 2
    //4 5 6 7                   //1 2 2 3 (1+1 2+1)
    //8 9 10 11 12 13 14 15     //1 2 2 3 2 3 3 4 (1+1 2+1 2+1 3+1)
    //P(x+b)=P(x)+1,b=(2^m)>x
    static class Solution {
        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            for (int i = 1; i < num + 1; i++) {
                int stage = (int) (Math.log(i) / Math.log(2));//λ�ڵڼ���
                if ((i & (i - 1)) == 0) {//�Ƕ����ݣ�λ��ÿһ�еĵ�һ��
                    result[i] = 1;
                    continue;
                }
                if (i < (Math.pow(2, stage) + Math.pow(2, stage - 1))) {//������ߣ������
                    result[i] = result[i - (int) Math.pow(2, stage - 1)];
                } else {//�����ұߣ���Ҫ��1
                    result[i] = result[i - (int) Math.pow(2, stage - 1)] + 1;
                }
            }
            return result;
        }
    }
}
