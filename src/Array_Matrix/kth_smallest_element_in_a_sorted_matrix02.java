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
            //第一行入队
            for(int j = 0; j < n; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
            //当循环k-1次后，堆顶元素即为所求
            for(int i = 0; i < k - 1; i++) { // 小顶堆，去掉 k - 1 个堆顶元素，此时堆顶元素就是第 k 的数
                //出队即最小元素：堆顶（第一行最小元素即整个矩阵最小元素）
                Tuple t = pq.poll();
                if(t.x == m - 1) continue;
                //下一行第一个元素入队（出队的元素的正下方元素入队）
                pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
            }
            return pq.poll().val;
        }

        class Tuple implements Comparable<Tuple> {
            int x, y, val;
            public Tuple(int x, int y, int val) {
                this.x = x; this.y = y; this.val = val;
            }

            //按照val值的大小在入队时排序
            @Override
            public int compareTo(Tuple that) {
                return this.val - that.val;
            }
        }
    }
}
