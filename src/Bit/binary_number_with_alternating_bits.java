package Bit;

//693
//����һ����������������Ƿ�Ϊ����λ�������������仰˵���������Ķ����������ڵ�����λ��������ȡ�
//ʾ�� 1:
//����: 5
//���: True
//����:
//5�Ķ���������: 101
//ʾ�� 2:
//����: 7
//���: False
//����:
//7�Ķ���������: 111
//ʾ�� 3:
//����: 11
//���: False
//����:
//11�Ķ���������: 1011
// ʾ�� 4:
//����: 10
//���: True
//����:
//10�Ķ���������: 1010
public class binary_number_with_alternating_bits {
    public static void main(String[] args) {
        System.out.println(new binary_number_with_alternating_bits.Solution().hasAlternatingBits(11));
    }

    static class Solution {
        public boolean hasAlternatingBits(int n) {
            int lastDigit, thisDigit = n & 1;
            while (n > 0) {
                lastDigit = thisDigit;
                n >>= 1;
                thisDigit = n & 1;
                if (lastDigit == thisDigit) {
                    return false;
                }
            }
            return true;
        }
    }
}
