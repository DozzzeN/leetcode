package Offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
public class the_minimum_number_of_K02 {
    public static void main(String[] args) {
        System.out.println(new the_minimum_number_of_K02.Solution().GetLeastNumbers_Solution(
                new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 10
        ));
    }

    //Ӧ��ʹ�ô󶥶���ά����С�ѣ�������ֱ�Ӵ���һ��С���Ѳ�����һ����С����ͼ��С�����е�Ԫ�ض�����СԪ�ء�
    //ά��һ����СΪK����С�ѹ������£������һ��Ԫ��֮������󶥶ѵĴ�С����K����ô��Ҫ���󶥶ѵĶѶ�Ԫ��ȥ����
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
