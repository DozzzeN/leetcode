package Bit;

//405
//����һ����������дһ���㷨�������ת��Ϊʮ�������������ڸ�����������ͨ��ʹ�� �������� ������
//ע��:
//	ʮ��������������ĸ(a-f)��������Сд��
//	ʮ�������ַ����в��ܰ��������ǰ���㡣���Ҫת������Ϊ0����ô�Ե����ַ�'0'����ʾ���������������ʮ�������ַ����еĵ�һ���ַ���������0�ַ���
//	��������ȷ����32λ�з���������Χ�ڡ�
//	����ʹ���κ��ɿ��ṩ�Ľ�����ֱ��ת�����ʽ��Ϊʮ�����Ƶķ�����
//ʾ�� 1��
//����:
//26
//���:
//"1a"
//ʾ�� 2��
//����:
//-1
//���:
//"ffffffff"
public class convert_a_number_to_hexadecimal {
    public static void main(String[] args) {
        System.out.println(new convert_a_number_to_hexadecimal.Solution().toHex(0));
    }

    static class Solution {
        public String toHex(int num) {
            long positive = 0;
            if (num < 0) {
                positive = ((long) 1 << 32) + num;
            } else if (num > 0) {
                positive = num;
            } else {
                return "0";
            }
            StringBuilder result = new StringBuilder();
            while (positive != 0) {
                result.append(transfer(positive % 16));
                positive /= 16;
            }
            return result.reverse().toString();
        }

        public char transfer(long number) {
            switch ((int) number) {
                case 10:
                    return 'a';
                case 11:
                    return 'b';
                case 12:
                    return 'c';
                case 13:
                    return 'd';
                case 14:
                    return 'e';
                case 15:
                    return 'f';
                default:
                    return (char) (number + 48);
            }
        }
    }
}
