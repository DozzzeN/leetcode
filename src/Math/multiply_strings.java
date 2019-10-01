package Math;

import java.util.Arrays;

//43
//�����������ַ�����ʽ��ʾ�ķǸ����� num1 �� num2������ num1 �� num2 �ĳ˻������ǵĳ˻�Ҳ��ʾΪ�ַ�����ʽ��
//ʾ�� 1:
//����: num1 = "2", num2 = "3"
//���: "6"
//ʾ�� 2:
//����: num1 = "123", num2 = "456"
//���: "56088"
//˵����
//	num1 �� num2 �ĳ���С��110��
//	num1 �� num2 ֻ�������� 0-9��
//	num1 �� num2 �������㿪ͷ������������ 0 ����
//	����ʹ���κα�׼��Ĵ������ͣ����� BigInteger����ֱ�ӽ�����ת��Ϊ����������
public class multiply_strings {
    public static void main(String[] args) {
        System.out.println(new multiply_strings.Solution().multiply("9220", "0"));
    }

    static class Solution {
        public String multiply(String num1, String num2) {
            if (num1.length() == 0 || num2.length() == 0) return "0";
            StringBuilder s1 = new StringBuilder().append(num1).reverse();
            StringBuilder s2 = new StringBuilder().append(num2).reverse();
            int[] result = new int[num1.length() + num2.length() + 1];
            for (int i = 0; i < s1.length(); i++) {
                int dig1 = s1.charAt(i) - '0';
                int carry = 0;
                for (int j = 0; j < s2.length(); j++) {
                    int dig2 = s2.charAt(j) - '0';
                    int exist = result[i + j];
                    result[i + j] = ((exist + dig1 * dig2 + carry) % 10);
                    carry = (exist + dig1 * dig2 + carry) / 10;
                }
                if (carry > 0) {
                    result[i + num2.length()] += carry;
                }
            }
            int count = 0;
            for (int i = result.length - 1; i >=0; i--) {
                if (result[i] == 0) {
                    count++;
                } else break;
            }
            if (count == result.length) return "0";
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < result.length - count; i++) {
                res.append(result[i]);
            }
            return res.reverse().toString();
        }
    }
}
