package Offer;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class the_minimum_number_of_K {
    public static void main(String[] args) {
        System.out.println(new the_minimum_number_of_K.Solution().GetLeastNumbers_Solution(
                new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 10
        ));
    }

    //快速排序的partition()方法，会返回一个整数j使得a[l..j-1]小于等于a[j]，且a[j+1..h]大于等于a[j]，
    //此时a[j]就是数组的第j大元素。可以利用这个特性找出数组的第K个元素，这种找第K个元素的算法称为快速选择算法。
    public static class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            ArrayList<Integer> result = new ArrayList<>();
            if (input == null || input.length == 0 || k <= 0 || k > input.length) return result;
            findKthSmallest(input, k - 1);
            for (int i = 0; i < k; i++) {
                result.add(input[i]);
            }
            return result;
        }

        public void findKthSmallest(int[] nums, int k) {
            int l = 0, h = nums.length - 1;
            while (l < h) {
                int j = partition(nums, l, h);
                if (j == k) break;//j就是第k个元素
                //以j开始二分
                if (j > k) h = j - 1;
                else l = j + 1;
            }
        }

        //快排中的partition算法
        private int partition(int[] nums, int l, int h) {
            int p = nums[l];
            int i = l, j = h + 1;
            while (true) {
                while (i != h && nums[++i] < p) ;
                while (j != l && nums[--j] > p) ;
                if (i >= j) break;
                swap(nums, i, j);
            }
            swap(nums, l, j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
