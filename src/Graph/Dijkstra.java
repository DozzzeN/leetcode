package Graph;

import java.util.Arrays;

//�ڱ���ʱ��Bellman-Ford�죬���ǲ��ܽ���и��ߵ����
public class Dijkstra {
    //����https://blog.csdn.net/qq_38410730/article/details/79587768��ʵ��
    public static void main(String[] args) {
        int[][] times = new int[][]{
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 10, Integer.MAX_VALUE, 30, 100},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 50, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 10},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 20, Integer.MAX_VALUE, 60},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        new Dijkstra.Solution().Dijkstra(times, 6, 0);
    }

    //Dijkstra�㷨 �����ڽӾ���
    static class Solution {
        public void Dijkstra(int[][] times, int N, int K) {
            long[] d = new long[N];//��K���������
            for (int i = 0; i < N; i++) {
                d[i] = times[K][i];
            }
            d[K] = 0;
            boolean[] visit = new boolean[N];
            visit[K] = true;
            int v = 0;
            for (int i = 0; i < N; i++) {
                long temp = Integer.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (temp > d[j] && !visit[j]) {
                        temp = d[j];
                        v = j;
                    }
                }
                visit[v] = true;
                for (int j = 0; j < N; j++) {
                    if (!visit[j]) {
                        d[j] = Math.min(d[j], d[v] + times[v][j]);
                    }
                }
            }
            System.out.println(Arrays.toString(d));
        }
    }
}
