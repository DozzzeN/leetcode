package Offer;

//https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
public class number_that_occurs_more_than_half_of_the_times_in_an_array {
    public static void main(String[] args) {
        System.out.println(new number_that_occurs_more_than_half_of_the_times_in_an_array.Solution().MoreThanHalfNum_Solution(
                new int[]{1, 1, 2, 2}
        ));
        System.out.println(new number_that_occurs_more_than_half_of_the_times_in_an_array.Solution().MoreThanHalfNum_Solution2(
                new int[]{1, 1, 2, 2}
        ));
    }

    public static class Solution {
        public int MoreThanHalfNum_Solution(int[] array) {
            if (array == null || array.length == 0) return 0;
            int[] hashtable = new int[10000];
            for (int value : array) {
                hashtable[value]++;
            }
            int result = 0;
            for (int i = 0; i < hashtable.length; i++) {
                if (hashtable[i] > array.length / 2) {
                    result = i;
                }
            }
            return result;
        }

        //����ͶƱ���⣬��������Boyer-Moore Majority Vote Algorithm�����������⣬ʹ��ʱ�临�Ӷ�ΪO(N)��
        //ʹ��cnt��ͳ��һ��Ԫ�س��ֵĴ���������������Ԫ�غ�ͳ��Ԫ�����ʱ����cnt++��������cnt--��
        //���ǰ�������i��Ԫ�أ���cnt==0��˵��ǰi��Ԫ��û��majority��������majority��
        //���ǳ��ֵĴ�������i/2����Ϊ�������i/2�Ļ�cnt��һ������Ϊ0����ʱʣ�µ�n-i��Ԫ���У�
        //majority����Ŀ��Ȼ����(n-i)/2����˼������Ҿ����ҳ�majority��
        public int MoreThanHalfNum_Solution2(int[] array) {
            if (array == null || array.length == 0) return 0;
            int majority = array[0];
            for (int i = 1, count = 1; i < array.length; i++) {
                count = array[0] == majority ? count + 1 : count - 1;
                if (count == 0) {
                    majority = array[i];
                    count = 1;
                }
            }
            int num = 0;
            //��Ҫ�ж��Ƿ�����Ǵ���1����
            for (int value : array)
                if (value == majority)
                    num++;
            return (num > array.length / 2) ? majority : 0;
        }
    }
}
