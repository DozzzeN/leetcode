package Math;

//69
//ʵ�� int sqrt(int x) ������
//
//���㲢���� x ��ƽ���������� x �ǷǸ�������
//���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
//ʾ�� 1:
//����: 4
//���: 2
//ʾ�� 2:
//����: 8
//���: 2
//˵��: 8 ��ƽ������ 2.82842...,
//     ���ڷ���������������С�����ֽ�����ȥ��
public class sqrtx02 {
    public static void main(String[] args) {
        System.out.println(new sqrtx02.Solution().mySqrt(6));
    }

    //ţ�ٵ�����
    //f(x) = x ^ 2 - a
    //f(x) = f(x0) + (x - x0)f'(x0)
    //��f(x) = 0 ����a = x ^ 2
    //�õ�f(x0) + (x - x0)f'(x0) = f(x0) + (x - x0)(2x) = 0
    //��x = 1/2 (x0 + a / x0)

    static class Solution {
        public int mySqrt(int a) {
            long x = a;
            while (x * x > a) {
                x = (x + a / x) >> 1;
            }
            return (int) x;
        }
    }
}
