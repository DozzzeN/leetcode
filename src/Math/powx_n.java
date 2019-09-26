package Math;

//50
//ʵ�� pow(x, n) �������� x �� n ���ݺ�����
//ʾ�� 1:
//����: 2.00000, 10
//���: 1024.00000
//ʾ�� 2:
//����: 2.10000, 3
//���: 9.26100
//ʾ�� 3:
//����: 2.00000, -2
//���: 0.25000
//����: 2-2 = 1/22 = 1/4 = 0.25
//˵��:
//	-100.0 < x < 100.0
//	n �� 32 λ�з�������������ֵ��Χ�� [-31, 2 ^ 31 - 1] ��
public class powx_n {
    public static void main(String[] args) {
        System.out.println(new powx_n.Solution().myPow(-1,
                -2147483648));
    }

    //���ַ�
    static class Solution {
        public double myPow(double x, int n) {
            return myPow(x, (long) n);
        }

        public double myPow(double x, long n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            if (n < 0) {
                n = -n;
                x = 1 / x;
            }
            double temp = myPow(x, n / 2);
            if (n % 2 == 0) return temp * temp;
            else return x * temp * temp;
        }
    }
}
