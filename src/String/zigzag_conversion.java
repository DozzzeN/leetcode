package String;

//6
//��һ�������ַ������ݸ������������Դ������¡������ҽ��� Z �������С�
//���������ַ���Ϊ "LEETCODEISHIRING" ����Ϊ 3 ʱ���������£�
//L   C   I   R
//E T O E S I I G
//E   D   H   N
//֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��
//����ʵ��������ַ�������ָ�������任�ĺ�����
//string convert(string s, int numRows);
//ʾ�� 1:
//����: s = "LEETCODEISHIRING", numRows = 3
//���: "LCIRETOESIIGEDHN"
//ʾ�� 2:
//����: s = "LEETCODEISHIRING", numRows = 4
//���: "LDREOEIIECIHNTSG"
//����:
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G
public class zigzag_conversion {
    public static void main(String[] args) {
        System.out.println(new zigzag_conversion.Solution().convert("123456789", 1));
    }

    //�۲�ÿ�����ֵĵ�������(�൱�ڹٷ����İ��з���)
    //numRows = 4 (step)
    //(6)    1    7      13
    //(4)(2) 2  6 8   12 14
    //(2)(4) 3 5  9 11   15
    //(6)    4   10      16
    static class Solution {
        public String convert(String s, int numRows) {
            StringBuilder result = new StringBuilder();
            int step = numRows == 1 ? 1 : numRows * 2 - 2;
            for (int i = 0; i < numRows; i++) {
                if (i == 0 || i == numRows - 1) {
                    for (int j = i; j < s.length(); j += step) {
                        result.append(s.charAt(j));
                    }
                } else {
                    boolean flag = true;
                    int partStep = step - i * 2;
                    for (int j = i; j < s.length(); ) {
                        result.append(s.charAt(j));
                        if (flag) {
                            j += partStep;
                        } else {
                            j += (step - partStep);
                        }
                        flag = !flag;
                    }
                }
            }
            return result.toString();
        }
    }
}
