package DivideConquer;

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

    //���η� O(n*logn) ~ O(n*n)
    //ͨ���۲죬���Է��֣����������δ��������¼��������
    //ȷ����������Ժ󣬾��εĿ���������������
    //���������ߵ����������Σ������⣩
    //��������ұߵ����������Σ������⣩
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            return largestRectangleArea(heights, 0, heights.length - 1);
        }

        public int largestRectangleArea(int[] heights, int start, int end) {
            if (start > end) return 0;
            int minIndex = start;
            for (int i = start; i <= end; i++) {
                if (heights[i] < heights[minIndex]) minIndex = i;
            }
            return Math.max(heights[minIndex] * (end - start + 1),
                    Math.max(largestRectangleArea(heights, start, minIndex - 1),
                            largestRectangleArea(heights, minIndex + 1, end)));
        }
    }
}
