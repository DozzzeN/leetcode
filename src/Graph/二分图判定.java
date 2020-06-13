package Graph;

import java.util.ArrayList;
import java.util.List;

//����һ������n�������ͼ��Ҫ��ͼ��ÿ������Ⱦɫ������Ҫʹ���ڵĶ�����ɫ��ͬ������
//���������2����ɫ����Ⱦɫ?��Ŀ��֤û���رߺ��Ի���
public class ����ͼ�ж� {
    //      1
    //    /   \
    //  0       3
    //    \   /
    //      2
    static List<List<Integer>> G = new ArrayList<>();
    int V = 4;//������
    int[] color = new int[V];//�������ɫ��1��-1

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
        new ����ͼ�ж�().solve();
    }

    //�Ѷ���Ⱦ��1��-1
    public boolean dfs(int v, int c) {
        color[v] = c;
        for (int i = 0; i < G.get(v).size(); i++) {
            //���ڵĶ���ͬɫ
            if (color[G.get(v).get(i)] == c) return false;
            //���ڵĶ��㻹û��Ⱦɫ
            if (color[G.get(v).get(i)] == 0 && !dfs(G.get(v).get(i), -c)) return false;
        }
        //���ж���Ⱦ��ɫ
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
