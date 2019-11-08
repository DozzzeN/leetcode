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
public class network_delay_time02 {
    public static void main(String[] args) {
        int[][] times = new int[][]{
                {4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47}, {1, 5, 61}, {1, 4, 99}, {3, 4, 68}, {3, 5, 46}, {4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19}, {2, 3, 13}, {3, 2, 18}, {1, 2, 0}, {5, 1, 25}, {2, 5, 58}, {2, 4, 77}, {5, 2, 74}};
        System.out.println(new network_delay_time02.Solution().networkDelayTime(times, 5, 3));
    }

    //Bellman-Ford�㷨 �����ڽӱ�
    //��d[K]�����ֵ
    static class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {
            int[] d = new int[N + 1];//��K���������
            Arrays.fill(d, 1000000000);//����MAX_VALUE����֮��ӷ������
            d[K] = 0;
            for (int i = 0; i < N + 1; i++) {
                for (int j = 0; j < times.length; j++) {
                    int u = times[j][0];
                    int v = times[j][1];
                    int w = times[j][2];
                    if (d[v] > d[u] + w) {
                        d[v] = d[u] + w;
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
