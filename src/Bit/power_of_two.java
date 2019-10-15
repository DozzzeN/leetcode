package Bit;

//231
//����һ����������дһ���������ж����Ƿ��� 2 ���ݴη���
//ʾ�� 1:
//����: 1
//���: true
//����: 2^0 = 1
//ʾ�� 2:
//����: 16
//���: true
//����: 2^4 = 16
//ʾ�� 3:
//����: 218
//���: false
public class power_of_two {
    public static void main(String[] args) {
        System.out.println(new power_of_two.Solution().isPowerOfTwo(2));

    }

    //ÿ�γ���2���Ƿ��ܳ���
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n == 0) return false;
            while (n != 1) {
                if (n == (2 * (n >> 1))) {
                    n >>= 1;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
