package Greedy;

//��n�����ÿ����ֱ���siʱ�俪ʼ����tiʱ�����������ÿ������㶼����ѡ��������
//���ѡ���˲��룬��ô��ʼ���ն�����ȫ�̲��롣���⣬���빤����ʱ��β����ص�(��ʹ�ǿ�ʼ��˲��ͽ�����˲����ص�Ҳ�ǲ������)��

//����
//n=5��s={1��2��4��6��8}��t={3��5��7��9��10}

import java.util.Arrays;
import java.util.Comparator;

//���
//3(ѡȡ����1��3��5)
public class ������� {
    int N = 5;
    int[] S = {1, 2, 4, 6, 8};
    int[] T = {3, 5, 7, 9, 10};
    Pair[] itv = new Pair[N];

    public static void main(String[] args) {
        new �������().solve();
    }

    public void solve() {
        //Ϊ���ý���ʱ����Ĺ�������ǰ��
        for (int i = 0; i < N; i++) {
            itv[i] = new Pair(S[i], T[i]);
        }
        Arrays.sort(itv, Comparator.comparingInt(o -> o.y));

        int ans = 0, t = 0;
        for (int i = 0; i < N; i++) {
            if (t < itv[i].x) {
                t = itv[i].y;
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
