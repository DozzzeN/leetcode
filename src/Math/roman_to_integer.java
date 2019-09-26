package Math;

import java.util.LinkedHashMap;
import java.util.Map;
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
public class roman_to_integer {
    public static void main(String[] args) {
        String input = "LVIII";
        System.out.println(new roman_to_integer.Solution().romanToInt(input));

    }

    static class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> charSet = new LinkedHashMap<>();
            charSet.put('I', 1);//
            charSet.put('V', 5);
            charSet.put('X', 10);//
            charSet.put('L', 50);
            charSet.put('C', 100);//
            charSet.put('D', 500);
            charSet.put('M', 1000);

            char[] romanChar = s.toCharArray();
            int result = 0;
            for (int i = 0; i < romanChar.length; i++) {
                boolean flag = false;
                for (char roman : charSet.keySet()) {
                    if (romanChar[i] == roman) {
                        result += charSet.get(roman);
                    }

                    if (i == 0 || flag == true) {
                        continue;
                    }

                    switch (romanChar[i]) {
                        case 'V': {
                            if (romanChar[i - 1] == 'I') result -= 2;
                            flag = true;
                            break;
                        }
                        case 'X': {
                            if (romanChar[i - 1] == 'I') result -= 2;
                            flag = true;
                            break;
                        }
                        case 'L': {
                            if (romanChar[i - 1] == 'X') result -= 20;
                            flag = true;
                            break;
                        }
                        case 'C': {
                            if (romanChar[i - 1] == 'X') result -= 20;
                            flag = true;
                            break;
                        }
                        case 'D': {
                            if (romanChar[i - 1] == 'C') result -= 200;
                            flag = true;
                            break;
                        }
                        case 'M': {
                            if (romanChar[i - 1] == 'C') result -= 200;
                            flag = true;
                            break;
                        }
                    }
                }
            }

            if (result < 1 || result > 3999) {
                result = -1;
            }

            return result;
        }
    }
}
