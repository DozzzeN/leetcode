package Array_Matrix;

import java.util.PriorityQueue;
//378
public class kth_smallest_element_in_a_sorted_matrix02 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(new kth_smallest_element_in_a_sorted_matrix02.Solution().kthSmallest(matrix, 20));
    }

    static class Solution {
        //1-4-7-11-15
        //4-7-11-15
        //2-4-7-11-15
        //4-7-11-15
        //3-4-7-11-15
        //4-7-11-15
        //4-7-10-11-15
        //7-10-11-15
        //5-7-10-11-15
        //7-10-11-15
        //6-7-10-11-15
        //7-10-11-15
        //7-10-11-13-15
        //10-11-13-15
        //8-10-11-13-15
        //10-11-13-15
        //9-10-11-13-15
        //10-11-13-15
        //10-11-13-14-15
        //11-13-14-15
        //11-13-14-15-18
        //13-14-15-18
        //12-13-14-15-18
        //13-14-15-18
        //13-14-15-16-18
        //14-15-16-18
        //14-15-16-18-21
        //15-16-18-21
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
            //��һ�����
            for(int j = 0; j < n; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
            //��ѭ��k-1�κ󣬶Ѷ�Ԫ�ؼ�Ϊ����
            for(int i = 0; i < k - 1; i++) { // С���ѣ�ȥ�� k - 1 ���Ѷ�Ԫ�أ���ʱ�Ѷ�Ԫ�ؾ��ǵ� k ����
                //���Ӽ���СԪ�أ��Ѷ�����һ����СԪ�ؼ�����������СԪ�أ�
                Tuple t = pq.poll();
                if(t.x == m - 1) continue;
                //��һ�е�һ��Ԫ����ӣ����ӵ�Ԫ�ص����·�Ԫ����ӣ�
                pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
            }
            return pq.poll().val;
        }

        class Tuple implements Comparable<Tuple> {
            int x, y, val;
            public Tuple(int x, int y, int val) {
                this.x = x; this.y = y; this.val = val;
            }

            //����valֵ�Ĵ�С�����ʱ����
            @Override
            public int compareTo(Tuple that) {
                return this.val - that.val;
            }
        }
    }
}
