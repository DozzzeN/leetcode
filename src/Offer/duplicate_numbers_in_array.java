package Offer;

//https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
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
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
        public boolean duplicate(int[] numbers, int length, int[] duplication) {
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
