package String;

//696
//����һ���ַ��� s�����������ͬ����0��1�ķǿ�(����)���ַ�����������������Щ���ַ����е�����0������1���������һ��ġ�
//�ظ����ֵ��Ӵ�Ҫ�������ǳ��ֵĴ�����
//����: "00110011"
//���: 6
//����: ��6���Ӵ�������ͬ����������1��0����0011������01������1100������10������0011�� �� ��01����
//��ע�⣬һЩ�ظ����ֵ��Ӵ�Ҫ�������ǳ��ֵĴ�����
//���⣬��00110011��������Ч���Ӵ�����Ϊ���е�0����1��û�������һ��
public class count_binary_substrings02 {
    public static void main(String[] args) {
        String input = "00110011";
        System.out.println(new count_binary_substrings02.Solution().countBinarySubstrings(input));
    }

    //��curLen��¼��ǰ���ָ�����preLen��¼֮ǰһ�����ָ�����ֻҪ֮ǰ���ָ������ڵ����������ָ�����������ͬ�������Ӵ�
    //��0011 perLen=2 curLen=1��ʾ001 ����ͬ�������Ӵ�01
    //��0011 perLen=2 curLen=2��ʾ0011 ����ͬ�������Ӵ�0011
    static class Solution {
        public int countBinarySubstrings(String s) {
            int preLen = 0, curLen = 1, count = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    curLen++;
                } else {
                    preLen = curLen;
                    curLen = 1;
                }

                if (preLen >= curLen) {
                    count++;
                }
            }
            return count;
        }
    }
}
