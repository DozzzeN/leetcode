package Offer;

//https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
public class the_number_of_1s_in_binary {
    public static void main(String[] args) {
        System.out.println(new the_number_of_1s_in_binary.Solution().NumberOf1(-3));
        System.out.println(new the_number_of_1s_in_binary.Solution().NumberOf102(-3));
        System.out.println(new the_number_of_1s_in_binary.Solution().NumberOf103(-3));
    }

    public static class Solution {
        public int NumberOf1(int n) {
            int result = 0;
            //����Խ���˳�
            for (int i = 1; i != 0; i <<= 1) {
                if ((n & i) != 0) {
                    result++;
                }
            }
            return result;
        }

        //n&(n-1):��λ����ȥ��n��λ����ʾ����͵���һλ��
        //n:10110100  n-1:10110011 n&n-1:10110000 ��n����1ȥ����
        public int NumberOf102(int n) {
            int result = 0;
            while (n != 0) {
                result++;
                n &= (n - 1);
            }
            return result;
        }

        public int NumberOf103(int n) {
            return Integer.bitCount(n);
        }
    }
}
