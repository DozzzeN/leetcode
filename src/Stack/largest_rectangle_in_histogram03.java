package Stack;

import java.util.Arrays;
import java.util.Stack;

//84
//���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
//ʾ��:
//����: [2,1,5,6,2,3]
//���: 10
public class largest_rectangle_in_histogram03 {
    public static void main(String[] args) {
        System.out.println(new largest_rectangle_in_histogram03.Solution().largestRectangleArea(
                new int[]{2, 1, 5, 6, 2, 3}
        ));
    }

    //ջ O(n)
    //ά��һ��������ջ����ǰԪ��С��ջ��Ԫ������ջ��ǰԪ�ص����
    //����ϲ�ջ��Ԫ�أ�ֱ��ջ��Ԫ��С�ڵ�ǰԪ��
    //����2��1��5��6��2��3
    //ջ��Ԫ��Ϊ0 ��ʱheights[1] < heights[0] �����0�����ӵĵ���ǰԪ�ص���������2 ����1�����ӵ����
    //Ȼ��ϲ�ջ��ջ��Ԫ��Ϊ1
    //������ջ��ջ��Ԫ��Ϊ1��2��3 ��ʱheights[4] < heights[3] �����3�����ӵ���ǰԪ�ص���������6 ����3�����ӵ����
    //3��ջ��ջ��Ԫ��Ϊ1��2 ��ʱheights[4] < heights[3] �����2�����ӵ���ǰԪ�ص���������10 ���ӵ�2�����ӵ���ǰ���ӵ����
    //2��ջ��4��ջ��5��ջ
    //��ʱheights[5] < 0 �����5�����ӵ���ǰԪ�ص���������3 ����5�����ӵ����
    //Ȼ��������8
    //Ȼ��������6
    //������Ϊ10
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            //ʹ��ԭheightsĩβΪ0�����һ������Ҳ������
            int[] newHeights = new int[heights.length + 1];
            for (int i = 0; i < heights.length; i++) {
                newHeights[i] = heights[i];
            }
            newHeights[heights.length] = 0;
            int sum = 0;
            for (int i = 0; i < newHeights.length; i++) {
                if (stack.empty() || newHeights[i] > newHeights[stack.peek()]) stack.push(i);
                else {
                    int temp = stack.peek();
                    stack.pop();
                    sum = Math.max(sum, newHeights[temp] * (stack.empty() ? i : i - stack.peek() - 1));
                    i--;
                }
            }
            return sum;
        }
    }
}
