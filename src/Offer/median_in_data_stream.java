package Offer;

import java.util.PriorityQueue;
import java.util.Queue;

//https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&tqId=11216&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
//������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ������ʹ��Insert()������ȡ
//��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
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

    //������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
    //������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
    //С�����е�Ԫ�ض����ڵ��ڴ󶥶��е�Ԫ��
    //   4(С)  3(��)
    //  / \    / \
    // 5   6  1   2
    public static class Solution {
        private Queue<Integer> small = new PriorityQueue<>();//Ĭ��С����
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
