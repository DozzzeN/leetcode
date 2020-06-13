package Graph;

import java.util.Arrays;

public class BellmanFord {
    //对照https://blog.csdn.net/anlian523/article/details/80953767的实例
    public static void main(String[] args) {
        long[][] edge = new long[][]{
                {0, -1, 4, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, 3, 2, 2},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, -5, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 1, Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -3, 0}
        };
        new BellmanFord.Solution().BellmanFord(edge, 5, 0);
    }

    //Bellman-Ford算法 基于邻接矩阵
    static class Solution {
        public void BellmanFord(long[][] edge, int n, int original) {
            long[] dis = new long[n];
            int[] pre = new int[n];//代表该点在最短路径中的上一个顶点，用于路径还原
            Arrays.fill(dis, Integer.MAX_VALUE);
            Arrays.fill(pre, -1);
            dis[original] = 0;//源结点到自身距离为0
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[j] > edge[i][j] + dis[i]) {
                        dis[j] = edge[i][j] + dis[i];
                        pre[j] = i;
                    }
                }
                System.out.print("dis " + Arrays.toString(dis));
                System.out.println(" pre " + Arrays.toString(pre));
            }
            //有了负权环时，再循环一次从0到3的路径又会减一，因为绕了负权环一圈
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (dis[j] > edge[i][j] + dis[i]) {
//                        dis[j] = edge[i][j] + dis[i];
//                        pre[j] = i;
//                    }
//                }
//                System.out.print("dis " + Arrays.toString(dis));
//                System.out.println(" pre " + Arrays.toString(pre));
//            }
            boolean flag = false;//是否有负权环
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[j] > dis[i] + edge[i][j]) {
                        //更新了表示有负权环
                        flag = true;
                        break;
                    }
                }
            }
            System.out.println(flag);
        }
    }
}
