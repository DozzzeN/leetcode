package String;

//696
//����һ���ַ��� s�����������ͬ����0��1�ķǿ�(����)���ַ�����������������Щ���ַ����е�����0������1���������һ��ġ�
//�ظ����ֵ��Ӵ�Ҫ�������ǳ��ֵĴ�����
//����: "00110011"
//���: 6
//����: ��6���Ӵ�������ͬ����������1��0����0011������01������1100������10������0011�� �� ��01����
//��ע�⣬һЩ�ظ����ֵ��Ӵ�Ҫ�������ǳ��ֵĴ�����
//���⣬��00110011��������Ч���Ӵ�����Ϊ���е�0����1��û�������һ��
public class count_binary_substrings {
    public static void main(String[] args) {
        String input = "00110011";
        System.out.println(new count_binary_substrings.Solution().countBinarySubstrings(input));
    }

    //��ʱ
    //����������ַ����������ж��Ƿ��Ƕ��1+���0���߶��0+���1����ʽ
    static class Solution {
        public int countBinarySubstrings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            StringBuilder sb = new StringBuilder();
            int countOfZero = 0;
            int countOfOne = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    String temp = s.substring(j, i + 1);
                    for (int k = 0; k < temp.length(); k++) {
                        if (temp.charAt(k) == '0') {
                            sb.append(0);
                            countOfZero++;
                        }
                        if (temp.charAt(k) == '1') {
                            sb.append(1);
                            countOfOne++;
                        }
                        if (sb.length() == temp.length() && (countOfOne == countOfZero) &&
                                ((temp.matches("0+1+")) || (temp.matches("1+0+")))) {
                            count++;
                        }
                    }
                    countOfOne = 0;
                    countOfZero = 0;
                    sb.delete(0, sb.length());
                }
            }
            return count;
        }
    }
}
