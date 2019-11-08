package Offer;

//https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡� ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
public class duplicate_numbers_in_array {
    public static void main(String[] args) {
        System.out.println(new duplicate_numbers_in_array.Solution().duplicate(new int[]{2, 3, 1, 0, 2, 5, 3}, 7, new int[7]));
    }

    public static class Solution {
        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
        public boolean duplicate(int numbers[],int length,int [] duplication) {
            int[] hashtable = new int[length];
            for (int i = 0; i < length; i++) {
                if (hashtable[numbers[i]] == 0) {
                    hashtable[numbers[i]] = 1;
                } else {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
            return false;
        }
    }
}
