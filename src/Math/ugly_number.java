package Math;

//263
//��дһ�������жϸ��������Ƿ�Ϊ������
//��������ֻ���������� 2, 3, 5 ����������
//ʾ�� 1:
//����: 6
//���: true
//����: 6 = 2 �� 3
//ʾ�� 2:
//����: 8
//���: true
//����: 8 = 2 �� 2 �� 2
//ʾ�� 3:
//����: 14
//���: false
//����: 14 ���ǳ�������Ϊ������������һ�������� 7��
//˵����
//	1 �ǳ�����
//	���벻�ᳬ�� 32 λ�з��������ķ�Χ: [-2^31,  2^31 - 1]��
public class ugly_number {
    public static void main(String[] args) {
        System.out.println(new ugly_number.Solution().isUgly(14));
    }

    static class Solution {
        public boolean isUgly(int num) {
            if (num < 1) return false;
            while (num % 2 == 0) {
                num >>= 1;
            }
            while (num % 3 == 0) {
                num /= 3;
            }
            while (num % 5 == 0) {
                num /= 5;
            }
            return num == 1;
        }
    }
}
