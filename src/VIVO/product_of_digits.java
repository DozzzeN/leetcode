package VIVO;

//�ָ������������� n����Ѱ�Ҳ������С�������� m��m>9����ʹ�� m �ĸ�λ����λ��ʮλ����λ ... ...��֮�˻�����n��������������� -1��
//��������1:
//36
//�������1:
//49
//��������2:
//100
//�������2:
//455
public class product_of_digits {
    public static void main(String[] args) {
        System.out.println(new product_of_digits.Solution().solution(362880));
    }

    public static class Solution {
        /**
         * ����һ��������ֵ������һ������ֵ
         *
         * @param n int���� n>9
         * @return int����
         */
        public int solution(int n) {
            int result = 0, base = 1;
            for (int i = 9; i > 1; i--) {
                while (n % i == 0) {
                    result += i * base;
                    base *= 10;
                    n /= i;
                }
            }
            if (n > 1) return -1;
            return result;
        }
    }
}
