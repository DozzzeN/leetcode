package Offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
//那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
//{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
//{2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
public class maximum_value_of_sliding_window {
    public static void main(String[] args) {
        System.out.println(new maximum_value_of_sliding_window.Solution().maxInWindows(
                new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3
        ));
        System.out.println(new maximum_value_of_sliding_window.Solution().maxInWindows2(
                new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3
        ));
    }

    public static class Solution {
        //朴素的解法：遍历一次时求出结果
        public ArrayList<Integer> maxInWindows(int[] num, int size) {
            ArrayList<Integer> result = new ArrayList<>();
            if (num == null || num.length <= 0 || size <= 0 || size > num.length) return result;
            int max = num[0];
            for (int i = 1; i < size; i++) {
                max = Math.max(max, num[i]);
            }
            result.add(max);
            for (int i = size; i < num.length; i++) {
                //4-3-2-5的情况：直接放入5
                if (num[i] >= result.get(i - size)) {
                    result.add(num[i]);
                } else {
                    //4-2-2-3 4-3-2-1的情况：需要比较2-2-3和3-2-1
                    max = num[i - size + 1];
                    for (int j = i - size + 2; j <= i; j++) {
                        max = Math.max(max, num[j]);
                    }
                    result.add(max);
                }
            }
            return result;
        }

        //思路差不多
        public ArrayList<Integer> maxInWindows2(int[] num, int size) {
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);//大顶堆
            ArrayList<Integer> result = new ArrayList<>();//保存结果
            if (num == null || num.length <= 0 || size <= 0 || size > num.length) return result;
            int i = 0;
            for (; i < size; i++) {//初始化滑动窗口：第一个滑动窗口
                maxQueue.offer(num[i]);
            }
            while (i < num.length) {//对每次操作，找到最大值（用优先队列的大顶堆），然后向后滑动（出堆一个，入堆一个）
                result.add(maxQueue.peek());
                maxQueue.remove(num[i - size]);
                maxQueue.add(num[i]);
                i++;
            }
            result.add(maxQueue.peek());//最后一次入堆后没保存结果，这里额外做一次即可
            return result;
        }
    }
}
