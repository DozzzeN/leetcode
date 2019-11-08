package Graph;

import java.util.Arrays;

//743
//有 N 个网络节点，标记为 1 到 N。
//给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
//现在，我们向当前的节点 K 发送了一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
//注意:
//	N 的范围在 [1, 100] 之间。
//	K 的范围在 [1, N] 之间。
//	times 的长度在 [1, 6000] 之间。
//	所有的边 times[i] = (u, v, w) 都有 1 <= u, v <= N 且 0 <= w <= 100。
public class network_delay_time {
    public static void main(String[] args) {
        int[][] times = new int[][]{
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        System.out.println(new network_delay_time.Solution().networkDelayTime(times, 4, 2));
    }

    //Dijkstra算法 基于邻接表
    //求d[K]的最大值
    static class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {
            int[] d = new int[N + 1];//点K到各点距离
            Arrays.fill(d, 1000000000);//添入MAX_VALUE会在之后加法中溢出
            int[][] w = new int[N + 1][N + 1];
            for (int i = 0; i < N + 1; i++) {
                for (int j = 0; j < N + 1; j++) {
                    if (i == j) w[i][j] = 0;
                    else w[i][j] = 1000000000;
                }
            }
            for (int[] time : times) {
                w[time[0]][time[1]] = time[2];
            }

            for (int i = 0; i < N + 1; i++) {
                d[i] = w[K][i];
            }
            d[K] = 0;
            boolean[] visit = new boolean[N + 1];
            visit[K] = true;
            int v = 0;
            for (int i = 1; i < N + 1; i++) {
                long temp = 1000000000;
                for (int j = 1; j < N + 1; j++) {
                    if (temp > d[j] && !visit[j]) {
                        temp = d[j];
                        v = j;
                    }
                }
                visit[v] = true;
                for (int j = 1; j < N + 1; j++) {
                    if (!visit[j]) {
                        d[j] = Math.min(d[j], d[v] + w[v][j]);
                    }
                }
            }
            int result = 0;
            for (int i = 1; i < N + 1; i++) {
                result = Math.max(result, d[i]);
            }
            return result == 1000000000 ? -1 : result;
        }
    }
}
