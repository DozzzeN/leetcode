package Offer;

//https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����Ϊ�����ر�����һ��1~13�а���1������
//��1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�ACMerϣ�����ǰ����,������������ձ黯,
//���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�������
public class the_number_of_occurrences_of_1_in_the_integer {
    public static void main(String[] args) {
        System.out.println(new the_number_of_occurrences_of_1_in_the_integer.Solution().NumberOf1Between1AndN_Solution(13));
    }

    public static class Solution {
        public int NumberOf1Between1AndN_Solution(int n) {
            int result = 0;
            for (int i = 0; i <= n; i++) {
                result += count(i);
            }
            return result;
        }

        public int count(int n) {
            int result = 0;
            while (n != 0) {
                int single = n % 10;
                if (single == 1) result++;
                n /= 10;
            }
            return result;
        }
    }
}
