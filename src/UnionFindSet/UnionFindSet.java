package UnionFindSet;

//���鼯
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

    //���Ⱥϲ��������ǽ���С�������������������
    //�������Ӽ��ϲ���ͬһ������
    public boolean Union(int u, int v) {
        int pu = Find(u);
        int pv = Find(v);
        if (pu == pv)
            //�Ѿ�����ͨ���ˣ���Ϊ���ڵ���ͬ
            return false;
        if (ranks[pv] > ranks[pu]) {
            //v����������ȸ���u��
            parents[pu] = pv;
        } else if (ranks[pu] > ranks[pv])
            parents[pv] = pu;
        else {
            //��������ͬΪr��������ʱ�����ǵ���r+1
            parents[pv] = pu;
            ranks[pu] += 1;
        }
        return true;
    }

    //·��ѹ������·���ϵ�ÿ���ڵ㶼����ֱ�����ӵ�����
    //ȷ��Ԫ��������һ���Ӽ������ȷ���������ǲ������ϲ����ҵ����ĸ��ڵ㣬�����Ա�����ȷ������Ԫ���Ƿ�����ͬһ�Ӽ�
    public int Find(int u) {
        while (parents[u] != u) {
            parents[u] = parents[parents[u]];
            u = parents[u];
        }
        return u;
    }

}