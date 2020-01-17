package Stack;

//84
//���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��
//ʾ��:
//����: [2,1,5,6,2,3]
//���: 10
public class largest_rectangle_in_histogram {
    public static void main(String[] args) {
        System.out.println(new largest_rectangle_in_histogram.Solution().largestRectangleArea(
                new int[]{2, 1, 5, 6, 2, 3}
        ));
    }

    //������ O(n*n)
    //ÿһ��height������ǰ������height����ȡ������ֵ
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            int maxV = 0;
            for (int i = 0; i < heights.length; i++) {
                int minV = heights[i];
                for (int j = i; j >= 0; j--) {
                    minV = Math.min(minV, heights[j]);
                    maxV = Math.max(maxV, (i - j + 1) * minV);
                }
            }
            return maxV;
        }
    }
}
