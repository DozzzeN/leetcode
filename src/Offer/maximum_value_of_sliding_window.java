package Offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=4&rp=4&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
//����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
//��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
//{[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
//{2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
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
        //���صĽⷨ������һ��ʱ������
        public ArrayList<Integer> maxInWindows(int[] num, int size) {
            ArrayList<Integer> result = new ArrayList<>();
            if (num == null || num.length <= 0 || size <= 0 || size > num.length) return result;
            int max = num[0];
            for (int i = 1; i < size; i++) {
                max = Math.max(max, num[i]);
            }
            result.add(max);
            for (int i = size; i < num.length; i++) {
                //4-3-2-5�������ֱ�ӷ���5
                if (num[i] >= result.get(i - size)) {
                    result.add(num[i]);
                } else {
                    //4-2-2-3 4-3-2-1���������Ҫ�Ƚ�2-2-3��3-2-1
                    max = num[i - size + 1];
                    for (int j = i - size + 2; j <= i; j++) {
                        max = Math.max(max, num[j]);
                    }
                    result.add(max);
                }
            }
            return result;
        }

        //˼·���
        public ArrayList<Integer> maxInWindows2(int[] num, int size) {
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);//�󶥶�
            ArrayList<Integer> result = new ArrayList<>();//������
            if (num == null || num.length <= 0 || size <= 0 || size > num.length) return result;
            int i = 0;
            for (; i < size; i++) {//��ʼ���������ڣ���һ����������
                maxQueue.offer(num[i]);
            }
            while (i < num.length) {//��ÿ�β������ҵ����ֵ�������ȶ��еĴ󶥶ѣ���Ȼ����󻬶�������һ�������һ����
                result.add(maxQueue.peek());
                maxQueue.remove(num[i - size]);
                maxQueue.add(num[i]);
                i++;
            }
            result.add(maxQueue.peek());//���һ����Ѻ�û�����������������һ�μ���
            return result;
        }
    }
}
