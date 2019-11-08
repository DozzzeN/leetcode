package Graph;

import java.util.Arrays;

//743
//�� N ������ڵ㣬���Ϊ 1 �� N��
//����һ���б� times����ʾ�źž�������ߵĴ���ʱ�䡣 times[i] = (u, v, w)������ u ��Դ�ڵ㣬v ��Ŀ��ڵ㣬 w ��һ���źŴ�Դ�ڵ㴫�ݵ�Ŀ��ڵ��ʱ�䡣
//���ڣ�������ǰ�Ľڵ� K ������һ���źš���Ҫ��ò���ʹ���нڵ㶼�յ��źţ��������ʹ���нڵ��յ��źţ����� -1��
//ע��:
//	N �ķ�Χ�� [1, 100] ֮�䡣
//	K �ķ�Χ�� [1, N] ֮�䡣
//	times �ĳ����� [1, 6000] ֮�䡣
//	���еı� times[i] = (u, v, w) ���� 1 <= u, v <= N �� 0 <= w <= 100��
public class network_delay_time {
    public static void main(String[] args) {
        int[][] times = new int[][]{
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        System.out.println(new network_delay_time.Solution().networkDelayTime(times, 4, 2));
    }

    //Dijkstra�㷨 �����ڽӱ�
    //��d[K]�����ֵ
    static class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {
            int[] d = new int[N + 1];//��K���������
            Arrays.fill(d, 1000000000);//����MAX_VALUE����֮��ӷ������
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
