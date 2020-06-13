package Graph;

import java.util.ArrayList;
import java.util.List;

//给定一个具有n个顶点的图。要给图上每个顶点染色，并且要使相邻的顶点颜色不同。问是
//否能最多用2种颜色进行染色?题目保证没有重边和自环。
public class 二分图判定 {
    //      1
    //    /   \
    //  0       3
    //    \   /
    //      2
    static List<List<Integer>> G = new ArrayList<>();
    int V = 4;//顶点数
    int[] color = new int[V];//顶点的颜色，1或-1

    public static void main(String[] args) {
        List<Integer> v0 = new ArrayList<>();
        v0.add(1);
        v0.add(2);
        G.add(0, v0);

        List<Integer> v1 = new ArrayList<>();
        v1.add(0);
        v1.add(3);
        G.add(1, v1);

        List<Integer> v2 = new ArrayList<>();
        v2.add(0);
        v2.add(3);
        G.add(2, v2);

        List<Integer> v3 = new ArrayList<>();
        v3.add(1);
        v3.add(2);
        G.add(3, v3);
        new 二分图判定().solve();
    }

    //把顶点染成1或-1
    public boolean dfs(int v, int c) {
        color[v] = c;
        for (int i = 0; i < G.get(v).size(); i++) {
            //相邻的顶点同色
            if (color[G.get(v).get(i)] == c) return false;
            //相邻的顶点还没被染色
            if (color[G.get(v).get(i)] == 0 && !dfs(G.get(v).get(i), -c)) return false;
        }
        //所有顶点染过色
        return true;
    }

    public void solve() {
        for (int i = 0; i < V; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}
