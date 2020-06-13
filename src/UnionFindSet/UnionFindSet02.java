package UnionFindSet;

public class UnionFindSet02 {
    private int[] par;
    private int[] rank;

    public void init(int n) {
        par = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    //��ѯ���ĸ�
    public int find(int x) {
        if (par[x] == x) {
            return x;
        } else {
            return par[x] = find(par[x]);
        }
    }

    //�ϲ�x��y�����ļ���
    public void unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (rank[x] < rank[y]) {
            par[x] = y;
        } else {
            par[y] = x;
            if (rank[x] == rank[y]) rank[x]++;
        }
    }

    //�ж�x��y�Ƿ�����ͬһ����
    public boolean same(int x, int y) {
        return find(x) == find(y);
    }
}
