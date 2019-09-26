package Math;

//29
//�������������������� dividend �ͳ��� divisor�������������Ҫ��ʹ�ó˷��������� mod �������
//���ر����� dividend ���Գ��� divisor �õ����̡�
//ʾ�� 1:
//����: dividend = 10, divisor = 3
//���: 3
//ʾ�� 2:
//����: dividend = 7, divisor = -3
//���: -2
public class divide_two_integers {
    public static void main(String[] args) {
        System.out.println(new divide_two_integers.Solution().divide(10, 3));
    }

    static class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) return 0;
            int sign = 1;
            if (dividend < 0) sign *= -1;
            if (divisor < 0) sign *= -1;
            long longDivisor = divisor < 0 ? -(long) divisor : divisor;
            long longDividend = dividend < 0 ? -(long) dividend : dividend;
            long value = 1, temp = longDivisor, result = 0;
            while (longDividend > 0) {
                while (temp <= longDividend) {
                    value <<= 1;
                    temp <<= 1;
                }
                result += value >> 1;
                value = 1;
                temp >>= 1;
                longDividend -= temp;
                temp = longDivisor;
            }
            result = sign * result;
            if (result >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) result;
        }
    }
}
