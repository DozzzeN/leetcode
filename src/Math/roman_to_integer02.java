package Math;

//13
//���磬 �������� 2 д�� II ����Ϊ�������е� 1��12 д�� XII ����Ϊ X + II �� 27 д��  XXVII, ��Ϊ XX + V + II ��
//ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������
//	I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
//	X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90��
//	C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
//����һ���������֣�����ת��������������ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
//ʾ�� 1:
//����: "III"
//���: 3
//ʾ�� 2:
//����: "IV"
//���: 4
//ʾ�� 3:
//����: "IX"
//���: 9
//ʾ�� 4:
//����: "LVIII"
//���: 58
//����: L = 50, V= 5, III = 3.
//ʾ�� 5:
//����: "MCMXCIV"
//���: 1994
//����: M = 1000, CM = 900, XC = 90, IV = 4.
public class roman_to_integer02 {
    public static void main(String[] args) {
        String input = "MCMXCIV";
        System.out.println(new roman_to_integer02.Solution().romanToInt(input));

    }

    static class Solution {
        public int romanToInt(String s) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i > 0 && c2n(s.charAt(i)) > c2n(s.charAt(i - 1))) {
                    result += (c2n(s.charAt(i)) - 2 * c2n(s.charAt(i - 1)));
                } else {
                    result += c2n(s.charAt(i));
                }
            }
            return result;
        }

        public int c2n(char c) {
            switch (c) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            }
        }
    }
}
