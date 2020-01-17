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

        public int MoreThanHalfNum_Solution2(int[] array) {
            if (array == null || array.length == 0) return 0;
            int preValue = array[0];
            int count = 1;
            for (int i = 1; i < array.length; i++) {
                if (array[i] == preValue) {
                    count++;
                } else {
                    if (count-- == 0) {
                        preValue = array[i];
                        count = 1;
                    }
                }
            }
            int num = 0;
            //��Ҫ�ж��Ƿ�����Ǵ���1����
            for (int value : array)
                if (value == preValue)
                    num++;
            return (num > array.length / 2) ? preValue : 0;
        }
    }
}
