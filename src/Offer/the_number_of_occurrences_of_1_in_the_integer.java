package Offer;

//https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����Ϊ�����ر�����һ��1~13�а���1������
//��1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�ACMerϣ�����ǰ����,������������ձ黯,
//���Ժܿ���������Ǹ�����������1���ֵĴ�������1��n��1���ֵĴ�������
public class the_number_of_occurrences_of_1_in_the_integer {
    public static void main(String[] args) {
        System.out.println(new the_number_of_occurrences_of_1_in_the_integer.Solution().NumberOf1Between1AndN_Solution(12));
        System.out.println(new the_number_of_occurrences_of_1_in_the_integer.Solution().NumberOf1Between1AndN_Solution02(1410065408));
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

        //�趨�����㣨��1��10��100�ȵȣ���Ϊλ�õ�i����Ӧn�ĸ�λ��ʮλ����λ�ȵȣ����ֱ��ÿ����λ���ж��ٰ���1�ĵ���з�����
        //�����趨������λ�ã���n���зָ��Ϊ�����֣���λn/i����λn%i
        //��i��ʾ��λ���Ұ�λ��Ӧ����>=2,��n=31456,i=100����a=314,b=56����ʱ��λΪ1�Ĵ�����a/10+1=32�������λ0~31����
        //ÿһ�ζ�����100�������ĵ㣬������(a/10+1)*100����İ�λΪ1
        //��1__ 11__ 21__ ... 311__ ����__��ʾ0-99 һ��32*100��1
        //��i��ʾ��λ���Ұ�λ��Ӧ����Ϊ1����n=31156,i=100����a=311,b=56����ʱ��λ��Ӧ�ľ���1������a/10(�����λ0-30)���ǰ���100�������㣬
        //�������λΪ31����a=311��������ֻ��Ӧ�ֲ���00~56����b+1�Σ����е����������(a/10*100)+(b+1)����Щ���λ��ӦΪ1
        //��1__ 11__ 21__ ... 301__ 31100 31101 31102 ... 31156 һ��31*100+57��1
        //��i��ʾ��λ���Ұ�λ��Ӧ����Ϊ0,��n=31056,i=100����a=310,b=56����ʱ��λΪ1�Ĵ�����a/10=31�������λ0~30��
        //��1__ 11__ 21__ ... 301__ һ��31*100��1
        //�ۺ������������������λ��Ӧ0��>=2ʱ����(a+8)/10�ΰ�������100���㣬���е���λΪ1(a%10==1)����Ҫ���Ӿֲ���b+1
        //֮���Բ�8������Ϊ����λΪ0����a/10==(a+8)/10������λ>=2����8�������λλ��Ч����ͬ��(a/10+1)
        public int NumberOf1Between1AndN_Solution02(int n) {
            int counts = 0;
            for (long i = 1; i <= n; i *= 10) {
                long a = n / i, b = n % i;
                counts += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
            }
            return counts;
        }
    }
}
