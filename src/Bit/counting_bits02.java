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
public class counting_bits02 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new counting_bits02.Solution().countBits(40)));
    }

    //������һ��������
    //x=(1001011101)2=(605)10
    //�����Ѿ������˴� 000 �� x - 1 ��ȫ�������
    //����֪����xxx �� ���Ǽ������һ����ֻ��һλ֮��:
    //x��=(1011101)2=(93)10
    //����ֻ�������Чλ�ϲ�ͬ��

    //P(x+b)=P(x)+1,b=(2^m)>x
    //��̬�滮
    static class Solution {
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            int i = 0, b = 1;
            // [0, b) is calculated
            while (b <= num) {
                // generate [b, 2b) or [b, num) from [0, b)
                while (i < b && i + b <= num) {
                    ans[i + b] = ans[i] + 1;
                    ++i;
                }
                i = 0;   // reset i
                b <<= 1; // b = 2b
            }
            return ans;
        }
    }
}
