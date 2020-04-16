package Offer;

//https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//统计一个数字在排序数组中出现的次数。
public class the_number_of_times_the_number_appears_in_the_sorted_array02 {
    public static void main(String[] args) {
        System.out.println(new the_number_of_times_the_number_appears_in_the_sorted_array02.Solution().GetNumberOfK(
                new int[]{1, 2, 3, 6, 8, 8, 8, 9}, 8
        ));
    }

    public static class Solution {
        public int GetNumberOfK(int[] array, int k) {
            int first = binarySearch(array, k);
            int last = binarySearch(array, k + 1);
            return (first == array.length || array[first] != k) ? 0 : last - first;
        }

        //注意原本的写法
        //int low = 0;
        //int high = nums.length - 1;
        //while (low <= high) {
        //    int mid = (low + high) >>> 1;
        //    if (nums[mid] < key)
        //        low = mid + 1;
        //    else if (nums[mid] > key)
        //        high = mid - 1;
        //    else
        //        return mid;
        //}
        private int binarySearch(int[] nums, int K) {
            //1, 2, 3, 6, 8, 8, 8, 9里面找8第一次出现的位置
            //0-7 m=3 nums[m]=6
            //4-7 m=5 nums[5]=8
            //4-5 m=4 nums[4]=8
            //4-4 => return m=4
            int l = 0, h = nums.length;
            while (l < h) {
                int m = l + (h - l) / 2;
                if (nums[m] >= K)
                    h = m;
                else
                    l = m + 1;
            }
            return l;
        }
    }
}
