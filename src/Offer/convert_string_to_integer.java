package Offer;

//https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��Ŀ����
//��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
//��������:
//����һ���ַ���,����������ĸ����,����Ϊ��
//�������:
//����ǺϷ�����ֵ����򷵻ظ����֣����򷵻�0
//ʾ��1
//����
//����
//+2147483647
//    1a33
//���
//����
//2147483647
//    0
public class convert_string_to_integer {
    public static void main(String[] args) {
        System.out.println(new convert_string_to_integer.Solution().StrToInt("-2147483649"));
    }

    public static class Solution {
        public int StrToInt(String str) {
            long result = 0;
            int temp = 1;
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '+') {
                    continue;
                } else if (sb.charAt(i) == '-') {
                    result *= -1;
                    continue;
                }
                int t = sb.charAt(i) - '0';
                if (0 <= t && t <= 9) {
                    result += (t * temp);
                    temp *= 10;
                } else {
                    return 0;
                }
            }
            return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
        }
    }
}
