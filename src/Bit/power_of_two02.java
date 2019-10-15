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
public class power_of_two02 {
    public static void main(String[] args) {
        System.out.println(new power_of_two02.Solution().isPowerOfTwo(Integer.MIN_VALUE));

    }

    //2����ʼ������1��ͷ������ȫ��0
    //��ȥ1�Ժ����λ��ȫ��1��
    //�� n �� n-1 ��������Ὣ���λ�� 1 ��� 0
    //ע��MIN_VALUE - 1��Խ��
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
