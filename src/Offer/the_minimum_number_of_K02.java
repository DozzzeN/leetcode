package Offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class the_minimum_number_of_K02 {
    public static void main(String[] args) {
        System.out.println(new the_minimum_number_of_K02.Solution().GetLeastNumbers_Solution(
                new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 10
        ));
    }

    //应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
    //维护一个大小为K的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于K，那么需要将大顶堆的堆顶元素去除。
    public static class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            if (k > input.length || k <= 0) return new ArrayList<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int num : input) {
                maxHeap.add(num);
                if (maxHeap.size() > k) maxHeap.poll();
            }
            return new ArrayList<>(maxHeap);
        }
    }
}
