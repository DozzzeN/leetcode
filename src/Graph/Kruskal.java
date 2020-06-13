package Graph;

import UnionFindSet.UnionFindSet02;

import java.util.Arrays;
import java.util.Comparator;

//求最小生成树
public class Kruskal {
    int V = 5, E = 6;
    //邻接表
    Edge[] es = new Edge[]{
            new Edge(0, 1, 1),
            new Edge(0, 2, 3),
            new Edge(1, 3, 3),
            new Edge(1, 4, 2),
            new Edge(2, 4, 10),
            new Edge(3, 4, 5),
    };

    public static void main(String[] args) {
        System.out.println(new Kruskal().solve());
    }

    public int solve() {
        Arrays.sort(es, Comparator.comparingInt(o -> o.cost));
        UnionFindSet02 unionFindSet = new UnionFindSet02();
        unionFindSet.init(V);
        int res = 0;
        for (int i = 0; i < E; i++) {
            Edge e = es[i];
            if (!unionFindSet.same(e.u, e.v)) {
                unionFindSet.unite(e.u, e.v);
                res += e.cost;
            }
        }
        return res;
    }
}
