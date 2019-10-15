package Bit;

//371
//��ʹ������� + �� - ������������ a ��b ֮�͡�
//ʾ�� 1:
//����: a = 1, b = 2
//���: 3
//ʾ�� 2:
//����: a = -2, b = 3
//���: 1
public class sum_of_two_integers {
    public static void main(String[] args) {
        System.out.println(new sum_of_two_integers.Solution().getSum(1, 9));
    }

    //��������ӣ���λ��a&b����λ�ĺ�Ϊa^b
    static class Solution {
        public int getSum(int a, int b) {
            int sum = 0, carry = 0, result = 0;
            for (int i = 0; i < 32; i++) {
                sum = (a & (1 << i)) ^ (b & (1 << i));
                carry = ((a & (1 << i)) & (b & (1 << i))) << 1;
                result += (sum + carry);
            }
            return result;
        }

        public int getSum2(int a, int b) {
            while (b != 0) {
                int res = (a & b) << 1;
                a = a ^ b;
                b = res;
            }
            return a;
        }
    }

}
