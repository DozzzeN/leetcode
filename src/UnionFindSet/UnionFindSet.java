package UnionFindSet;

//并查集
public class UnionFindSet {
    private int[] parents_;
    private int[] ranks_;

    public UnionFindSet(int n) {
        parents_ = new int[n + 1];
        ranks_ = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents_[i] = i;
            ranks_[i] = i;
        }
    }

    //将两个子集合并成同一个集合
    public boolean Union(int u, int v) {
        int pu = Find(u);
        int pv = Find(v);
        if (pu == pv)
            //已经是连通的了，因为根节点相同
            return false;
        if (ranks_[pv] > ranks_[pu]) {
            //v所在树的深度高于u的
            parents_[pu] = pv;
        } else if (ranks_[pu] > ranks_[pv])
            parents_[pv] = pu;
        else {
            parents_[pv] = pu;
            ranks_[pu] += 1;
        }
        return true;
    }

    //确定元素属于哪一个子集。这个确定方法就是不断向上查找找到它的根节点，它可以被用来确定两个元素是否属于同一子集
    public int Find(int u) {
        while (parents_[u] != u) {
            parents_[u] = parents_[parents_[u]];
            u = parents_[u];
        }
        return u;
    }

}