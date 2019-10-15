package UnionFindSet;

//并查集
public class UnionFindSet {
    private int[] parents;
    private int[] ranks;

    public UnionFindSet(int n) {
        parents = new int[n + 1];
        ranks = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
            ranks[i] = i;
        }
    }

    //按秩合并：即总是将更小的树连接至更大的树上
    //将两个子集合并成同一个集合
    public boolean Union(int u, int v) {
        int pu = Find(u);
        int pv = Find(v);
        if (pu == pv)
            //已经是连通的了，因为根节点相同
            return false;
        if (ranks[pv] > ranks[pu]) {
            //v所在树的深度高于u的
            parents[pu] = pv;
        } else if (ranks[pu] > ranks[pv])
            parents[pv] = pu;
        else {
            //当两棵秩同为r的树联合时，它们的秩r+1
            parents[pv] = pu;
            ranks[pu] += 1;
        }
        return true;
    }

    //路径压缩：在路径上的每个节点都可以直接连接到根上
    //确定元素属于哪一个子集。这个确定方法就是不断向上查找找到它的根节点，它可以被用来确定两个元素是否属于同一子集
    public int Find(int u) {
        while (parents[u] != u) {
            parents[u] = parents[parents[u]];
            u = parents[u];
        }
        return u;
    }

}