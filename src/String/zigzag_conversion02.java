package String;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
public class zigzag_conversion02 {
    public static void main(String[] args) {
        System.out.println(new zigzag_conversion02.Solution().convert("123456789", 3));
    }

    //���з��ʣ�ÿһ�ж�Ӧһ��list�������ַ��������ַ������Ӧ����һ��
    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;
            List<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < Math.min(numRows, s.length()); i++) {
                rows.add(new StringBuilder());
            }
            boolean flag = false;
            int curRow = 0;
            for (char c : s.toCharArray()) {
                rows.get(curRow).append(c);
                if (curRow == 0 || curRow == numRows - 1) {
                    flag = !flag;
                }
                //����flag�����Ƿ�ı䷽��
                curRow += flag ? 1 : -1;
            }
            //return String.join("", rows);
            return rows.parallelStream().collect(Collectors.joining());
        }
    }
}
