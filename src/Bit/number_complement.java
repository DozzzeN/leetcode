package Bit;

//476
//����һ����������������Ĳ����������ǶԸ����Ķ����Ʊ�ʾȡ����
//ע��:
//	������������֤��32λ�����������ķ�Χ�ڡ�
//	����Լٶ���������������ǰ����λ��
//ʾ�� 1:
//����: 5
//���: 2
//����: 5�Ķ����Ʊ�ʾΪ101��û��ǰ����λ�����䲹��Ϊ010����������Ҫ���2��
//ʾ�� 2:
//����: 1
//���: 0
//����: 1�Ķ����Ʊ�ʾΪ1��û��ǰ����λ�����䲹��Ϊ0����������Ҫ���0��
public class number_complement {
    public static void main(String[] args) {
        System.out.println(new number_complement.Solution().findComplement(5));
    }

    static class Solution {
        public int findComplement(int num) {
            boolean flag = false;
            if (num < 0) {
                flag = true;
                num = -num;
            }
            int result = 0;
            int temp = num;
            int length = 0;
            for (; temp != 0; ) {
                temp >>= 1;
                length++;
            }
            for (int j = 0; j < length; j++) {
                result += (1 - ((num & (1 << j)) >> j)) << j;
            }
            return flag ? (1 + ~result) : result;
        }
    }
}
