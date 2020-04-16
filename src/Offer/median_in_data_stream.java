package Offer;

import java.util.PriorityQueue;
import java.util.Queue;

//https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&tqId=11216&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
//如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取
//数据流，使用GetMedian()方法获取当前读取数据的中位数。
public class median_in_data_stream {
    public static void main(String[] args) {
        median_in_data_stream.Solution solution = new median_in_data_stream.Solution();
        solution.Insert(2);
        solution.Insert(3);
        solution.Insert(1);
        solution.Insert(4);
        solution.Insert(6);
        solution.Insert(5);
        System.out.println(solution.GetMedian());
    }

    //如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
    //如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
    //小顶堆中的元素都大于等于大顶堆中的元素
    //   4(小)  3(大)
    //  / \    / \
    // 5   6  1   2
    public static class Solution {
        private Queue<Integer> small = new PriorityQueue<>();//默认小顶堆
        private Queue<Integer> big = new PriorityQueue<>((o1, o2) -> o2 - o1);
        private int count = 0;

        public void Insert(Integer num) {
            if (count % 2 == 0) {
                big.offer(num);
                small.offer(big.poll());
            } else {
                small.offer(num);
                big.offer(small.poll());
            }
            count++;
        }

        public Double GetMedian() {
            if (count % 2 == 0) return (double) (big.peek() + small.peek()) / 2;
            else return (double) small.peek();
        }
    }
}
