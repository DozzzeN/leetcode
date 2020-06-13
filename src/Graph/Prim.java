package Graph;

import java.util.Arrays;

//求最小生成树
public class Prim {
    int V = 5;
    int[][] cost = new int[][]{
            {Integer.MAX_VALUE, 1, 3, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {1, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 2},
            {3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 10},
            {Integer.MAX_VALUE, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, 5},
            {Integer.MAX_VALUE, 2, 10, 5, Integer.MAX_VALUE}
    };
    int[] mincost = new int[V];//从集合出发的边到每个顶点的最小权值
    boolean[] used = new boolean[V];//顶点是否包含在集合中

    public static void main(String[] args) {
        System.out.println(new Prim().solve());
    }

    public int solve() {
        Arrays.fill(mincost, Integer.MAX_VALUE);
        Arrays.fill(used, false);
        mincost[0] = 0;
        int res = 0;//总权值

        while (true) {
            int v = -1;
            for (int u = 0; u < V; u++) {
                if (!used[u] && (v == -1 || mincost[u] < mincost[v])) v = u;
            }
            if (v == -1) break;
            used[v] = true;//把顶点v加入集合
            res += mincost[v];
            for (int u = 0; u < V; u++) {
                mincost[u] = Math.min(mincost[u], cost[v][u]);
            }
        }
        return res;
    }
}
