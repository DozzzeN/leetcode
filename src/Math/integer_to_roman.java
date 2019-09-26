package Math;

//12
//�������ְ������������ַ��� I�� V�� X�� L��C��D �� M��
//�ַ�          ��ֵ
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//���磬 �������� 2 д�� II ����Ϊ�������е� 1��12 д�� XII ����Ϊ X + II �� 27 д��  XXVII, ��Ϊ XX + V + II ��
//ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������
//	I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
//	X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90��
//	C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
//����һ������������תΪ�������֡�����ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
//ʾ�� 1:
//����: 3
//���: "III"
//ʾ�� 2:
//����: 4
//���: "IV"
//ʾ�� 3:
//����: 9
//���: "IX"
//ʾ�� 4:
//����: 58
//���: "LVIII"
//����: L = 50, V = 5, III = 3.
//ʾ�� 5:
//����: 1994
//���: "MCMXCIV"
//����: M = 1000, CM = 900, XC = 90, IV = 4.
public class integer_to_roman {
    public static void main(String[] args) {
        System.out.println(new integer_to_roman.Solution().intToRoman(68));
    }

    static class Solution {
        public String intToRoman(int num) {
            char[] symbols = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
            StringBuilder result = new StringBuilder();
            int scale = 1000;
            for (int i = symbols.length - 1; i >= 0; i -= 2) {
                int digit = num / scale;
                if (digit != 0) {
                    if (digit <= 3) {
                        while (digit > 0) {
                            result.append(symbols[i]);
                            digit--;
                        }
                    } else if (digit == 4) {
                        result.append(symbols[i]).append(symbols[i + 1]);
                    } else if (digit == 5) {
                        result.append(symbols[i + 1]);
                    } else if (digit <= 8) {
                        result.append(symbols[i + 1]);
                        while (digit > 5) {
                            result.append(symbols[i]);
                            digit--;
                        }
                    } else if (digit == 9) {
                        result.append(symbols[i]).append(symbols[i + 2]);
                    }
                }
                num %= scale;
                scale /= 10;
            }
            return result.toString();
        }
    }
}
